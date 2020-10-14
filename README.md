# teb-cucumber-selenium 
#description
The framework is written using Java + Selenium + Cucumber

#environments
in src/env.json there are links to the environments
These links are parsed using json parser in java/parser/Utils.java

#configure test runner
to run the tests navigate to /teb-edu-project/src/test/java/TestRunner.java
to run the wsb tests modify the 7th line like this: features = {"src/test/resources/wsb.feature"}
to run the demo page tests modify the line: features like this = {"src/test/resources/demo.feature"}

