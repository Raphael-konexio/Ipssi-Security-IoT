jadx -d injured_out/ InjuredAndroid.apk

cat injured_out/resources/AndroidManifest.xml | grep -A3 'activity'

grep -B2 'exported.*true' injured_out/resources/AndroidManifest.xml

grep -rn -i 'api_key\|password\|secret\|token\|flag' injured_out/sources/


1. Analyse du Manifest (Composants Exportés)
L'extraction du fichier AndroidManifest.xml a révélé plusieurs activités (écrans) et récepteurs exportés sans restriction de permissions (android:exported="true"). Un attaquant ou une application malveillante présente sur le même téléphone peut les invoquer directement pour contourner les écrans de connexion.
Activités vulnérables identifiées : b3nac.injuredandroid.b25lActivity, b3nac.injuredandroid.QXV0aA, b3nac.injuredandroid.ExportedProtectedIntent, ainsi que le receiver FlagFiveReceiver.

2. Découverte de secrets en dur (Hardcoded Secrets)
L'analyse du code source Java et des ressources compilées (R.java) via des recherches de chaînes de caractères a mis en évidence des fuites de données critiques directement intégrées par les développeurs :

Présence de clés d'infrastructure Cloud : AWS_SECRET, google_api_key, google_crash_reporting_api_key.

Découverte de l'algorithme de chiffrement : Le fichier b3nac/injuredandroid/k.java révèle l'utilisation de la classe SecretKeyFactory.getInstance("DES"). Le Data Encryption Standard (DES) est un algorithme obsolète et hautement vulnérable au cassage par force brute.

Présence des marqueurs de validation (Flags) codés en clair dans les ressources XML (ex: FlagOneText).

Flag 1 compromis : L'inspection du fichier de ressources /res/values/strings.xml a permis d'extraire la valeur du premier flag (F1ag_0n3), stockée en clair sous la balise flagOneText.

3. Déploiement de l'environnement dynamique et résolution d'incidents
Le déploiement de l'émulateur Android (AVD) a nécessité des ajustements d'infrastructure :

Bypass de création AVD : Face à une défaillance silencieuse de l'outil avdmanager (impossibilité de générer les fichiers .ini de l'appareil virtuel), une création manuelle de l'arborescence et des fichiers de configuration (Pixel_4_API_30.ini et config.ini) a été réalisée pour forcer la reconnaissance de l'image système android-30.

Contournement de la virtualisation imbriquée : L'hyperviseur hébergeant la machine d'audit Kali Linux bloquant les instructions KVM (VT-x/AMD-V), l'émulateur a été basculé en mode d'exécution logiciel (-accel off). Cela permet de maintenir l'analyse dynamique au prix d'une dégradation des performances d'émulation.


emulator -avd Pixel_4_API_30 & adb install InjuredAndroid.apk


# 1. Création des dossiers de l'appareil virtuel
mkdir -p ~/.android/avd/Pixel_4_API_30.avd

# 2. Création du fichier de pointage principal
cat <<EOF > ~/.android/avd/Pixel_4_API_30.ini
avd.ini.encoding=UTF-8
path=/home/$USER/.android/avd/Pixel_4_API_30.avd
path.rel=avd/Pixel_4_API_30.avd
target=android-30
EOF

# 3. Création du fichier de configuration matériel
cat <<EOF > ~/.android/avd/Pixel_4_API_30.avd/config.ini
AvdId=Pixel_4_API_30
PlayStore.enabled=false
abi.type=x86_64
avd.ini.encoding=UTF-8
hw.cpu.arch=x86_64
hw.lcd.density=440
hw.lcd.height=2280
hw.lcd.width=1080
hw.ramSize=2048
image.sysdir.1=system-images/android-30/google_apis/x86_64/
tag.display=Google APIs
tag.id=google_apis
disk.dataPartition.size=2G
EOF


export ANDROID_SDK_ROOT=/usr/lib/android-sdk
/usr/lib/android-sdk/emulator/emulator -avd Pixel_4_API_30 -no-snapshot -gpu swiftshader_indirect -no-audio -no-boot-anim -accel off &


