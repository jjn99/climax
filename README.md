## Climax Application
Cette application permet de générer des rapports statistiques sur les clients de la société Climax.
Les données sont obtenues à partir de fichiers texte, csv, xml ou json fournis par les partenaires.

## Configurations
Ce projet a été construit en utilisant ces technologies :
- Java17
- Spring 3.2.3
- commons-io
- jackson-databind

## Fonctionnalités
- Lecture de fichiers texte, csv, xml ou json
- Calcul de la moyenne des salaires par profession


## Configuration
 Avant d'utiliser l'application, vous devez configurer les informations suivantes :

- Le traitement des données s'effectue sur les fichiers présents dans le dossier "resources/data".
- Le format des fichiers sources : L'application est capable de lire les fichiers csv, xml ou json. 


## Utilisation
 Pour lancer l'application, exécutez la classe "Main" située dans le dossier "src/main/java".
 Les rapports statistiques générés sont disponibles dans le dossier "output" à la racine du projet.

# Architecture

    1. Controller
    2. Entity
    3. Service
    4. resources/Data
