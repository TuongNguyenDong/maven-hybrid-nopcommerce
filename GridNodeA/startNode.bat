set ProjectPath=%~dp0
java -jar webdrivermanager-5.5.3-fat.jar resolveDriverFor chrome
java -jar webdrivermanager-5.5.3-fat.jar resolveDriverFor firefox
java -jar -Dwebdriver.chrome.driver="%ProjectPath%chromedriver.exe" -Dwebdriver.gecko.driver="%ProjectPath%geckodriver.exe" selenium-server-standalone-3.141.59.jar -role node -nodeConfig nodeAConfig.json

