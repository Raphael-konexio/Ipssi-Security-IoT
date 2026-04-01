# Sécurité IoT - TP mTLS MQTT

Ce projet présente la mise en place d'une authentification mutuelle (mTLS) sur un broker Mosquitto.

## Objectifs du TP
- [cite_start]Création d'une Autorité de Certification (CA) racine.
- [cite_start]Génération et signature de certificats X.509 pour le broker et les clients[cite: 5, 6].
- [cite_start]Sécurisation du broker MQTT sur le port 8883.

## Architecture des fichiers
- [cite_start]`ca.crt` : Certificat racine de confiance.
- [cite_start]`broker.crt/key` : Identité du serveur Mosquitto.
- [cite_start]`client.crt/key` : Identité de l'objet IoT.
- [cite_start]`mtls.conf` : Configuration du listener sécurisé .

## Tests de validation
- [cite_start]**Succès** : Connexion avec certificat client valide (mTLS OK) .
- [cite_start]**Échec** : Rejet des connexions anonymes ou sans certificat.
