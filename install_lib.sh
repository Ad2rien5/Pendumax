#!/usr/bin/env bash

URL="https://download2.gluonhq.com/openjfx/25/openjfx-25_linux-x64_bin-sdk.zip"
SAVE_PATH="./lib/openjfx-25_linux-x64_bin-sdk.zip"

# Télécharger le fichier
if [ "$(command -v wget)" ]; then
	echo "wget"
	wget -O "${SAVE_PATH}" "${URL}"
elif [ "$(command -v curl)" ]; then
	echo "curl"
	curl "${URL}" --output "${SAVE_PATH}"
else
	echo "échec"
	exit 1
fi

# Unzip
apt install unzip
unzip "./lib/openjfx-25_linux-x64_bin-sdk.zip" -d "./lib/"
rm "./lib/openjfx-25_linux-x64_bin-sdk.zip"
