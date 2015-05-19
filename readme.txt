Checkout Readme.docx for most updated comments.

Recipe Maker Program
This program is a standalone java program which makes use of Apache CSV parser and GSON library to parse JSON string.
The program is pretty simple to use, Simply download the JAR file RecipeMakerByAjitabh.jar and run it from the command line using following command:
?	java –jar RecipeMakerByAjitabh.jar c:\\aj\\pactera\\fridge.csv c:\\aj\\pactera\\recipes.json
Before running the program ensure you have download all three CSV files and 1 JSON file and placed them in the directory “c:\aj\pactera”
Change the path in above command as applicable to your folder hierarchy.

The program has been tested using JUnit and the tests can be run from the command line by providing third argument “test”to the above command as follows:
?	java –jar RecipeMakerByAjitabh.jar c:\\aj\\pactera\\fridge.csv c:\\aj\\pactera\\recipes.json test
The screenshot for the sample test runs is attached:
?	java –jar RecipeMakerByAjitabh.jar c:\\aj\\pactera\\fridge.csv c:\\aj\\pactera\\recipes.json
