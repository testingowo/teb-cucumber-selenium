$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/demo.feature");
formatter.feature({
  "name": "Is it Summer?",
  "description": "  Everybody likes Summer",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Check the wsb page",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I navigate to \"demoPage\" page",
  "keyword": "Given "
});
formatter.match({
  "location": "StepsDefinition.\u003cinit\u003e(StepsDefinition.java:19)"
});
formatter.result({
  "status": "passed"
});
});