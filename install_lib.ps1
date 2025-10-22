$url = "https://download2.gluonhq.com/openjfx/25/openjfx-25_linux-x64_bin-sdk.zip"
$save_path = ".\lib\openjfx-25_linux-x64_bin-sdk.zip"

Invoke-WebRequest -Uri $url -OutFile $save_path
Expand-Archive -LiteralPath $save_path -DestinationPath ".\lib
rm $save_path
