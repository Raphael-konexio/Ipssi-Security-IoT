1. Analyse du Manifest (Composants Exportés)
L'extraction du fichier AndroidManifest.xml a révélé plusieurs activités (écrans) et récepteurs exportés sans restriction de permissions (android:exported="true"). Un attaquant ou une application malveillante présente sur le même téléphone peut les invoquer directement pour contourner les écrans de connexion.
Activités vulnérables identifiées : b3nac.injuredandroid.b25lActivity, b3nac.injuredandroid.QXV0aA, b3nac.injuredandroid.ExportedProtectedIntent, ainsi que le receiver FlagFiveReceiver.

2. Découverte de secrets en dur (Hardcoded Secrets)
L'analyse du code source Java et des ressources compilées (R.java) via des recherches de chaînes de caractères a mis en évidence des fuites de données critiques directement intégrées par les développeurs :

Présence de clés d'infrastructure Cloud : AWS_SECRET, google_api_key, google_crash_reporting_api_key.

Découverte de l'algorithme de chiffrement : Le fichier b3nac/injuredandroid/k.java révèle l'utilisation de la classe SecretKeyFactory.getInstance("DES"). Le Data Encryption Standard (DES) est un algorithme obsolète et hautement vulnérable au cassage par force brute.

Présence des marqueurs de validation (Flags) codés en clair dans les ressources XML (ex: FlagOneText).

