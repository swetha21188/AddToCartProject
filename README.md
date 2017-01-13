#AddToCartProject

This project is written on java (jdk 1.8) on Mac.

Import the project to Eclipse.

Please download the latest chromedriver from https://chromedriver.storage.googleapis.com/index.html?path=2.27/ 

Please update the path of your chromedriver (driverPath) to the downloaded path in the resources/config.properties file.

Also if yor are Running on windows, Please go to src>Tests>BaseTest and add .exe extension at the end of chromedriver(Line 39). 

Right click on the pom.xml file and click on Run As-> Maven Clean and then Maven Install.

Right click on testng.xml and Run as-> testNG Test to run the test.
