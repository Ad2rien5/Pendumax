#!/usr/bin/env bash

URL1="https://download2.gluonhq.com/openjfx/25/openjfx-25_linux-x64_bin-sdk.zip"
URL2="https://search.maven.org/remotecontent?filepath=com/googlecode/json-simple/json-simple/1.1.1/json-simple-1.1.1.jar"
SAVE_PATH="./lib/"

function private_download() {
    # $1 = URL
    # $2 = Chemin d'accès au fichier
    if [ "$(command -v wget)" ]; then
        echo "Téléchargement à l'aide de wget"
        wget -O "$2" "$1"
    elif [ "$(command -v curl)" ]; then
        echo "Téléchargement à l'aide de curl"
        curl "$1" --output "$2"
    else
        echo "Échec de la recherche de wget ou de curl"
        exit 1
    fi
}
# Télécharger le fichier
private_download "${URL1}" "${SAVE_PATH}"
private_download "${URL2}" "${SAVE_PATH}"

# Unzip
apt install unzip
unzip "./lib/openjfx-25_linux-x64_bin-sdk.zip"
rm "./lib/openjfx-25_linux-x64_bin-sdk.zip"