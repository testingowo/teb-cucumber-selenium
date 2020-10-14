$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/demo.feature");
formatter.feature({
  "name": "Is it Summer?",
  "description": "  Everybody likes Summer",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Check the wsb page",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I navigate to \"demoPage\" page",
  "keyword": "Given "
});
formatter.step({
  "name": "I click random post",
  "keyword": "When "
});
formatter.step({
  "name": "I verify post form \u003clabels\u003e",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "labels"
      ]
    },
    {
      "cells": [
        "Comment"
      ]
    },
    {
      "cells": [
        "Name"
      ]
    },
    {
      "cells": [
        "Email"
      ]
    },
    {
      "cells": [
        "Website"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Check the wsb page",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I navigate to \"demoPage\" page",
  "keyword": "Given "
});
formatter.match({
  "location": "StepsDefinition.\u003cinit\u003e(StepsDefinition.java:24)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click random post",
  "keyword": "When "
});
formatter.match({
  "location": "StepsDefinition.\u003cinit\u003e(StepsDefinition.java:66)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify post form Comment",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "Check the wsb page",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I navigate to \"demoPage\" page",
  "keyword": "Given "
});
formatter.match({
  "location": "StepsDefinition.\u003cinit\u003e(StepsDefinition.java:24)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click random post",
  "keyword": "When "
});
formatter.match({
  "location": "StepsDefinition.\u003cinit\u003e(StepsDefinition.java:66)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify post form Name",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "Check the wsb page",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I navigate to \"demoPage\" page",
  "keyword": "Given "
});
formatter.match({
  "location": "StepsDefinition.\u003cinit\u003e(StepsDefinition.java:24)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click random post",
  "keyword": "When "
});
formatter.match({
  "location": "StepsDefinition.\u003cinit\u003e(StepsDefinition.java:66)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify post form Email",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "Check the wsb page",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I navigate to \"demoPage\" page",
  "keyword": "Given "
});
formatter.match({
  "location": "StepsDefinition.\u003cinit\u003e(StepsDefinition.java:24)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click random post",
  "keyword": "When "
});
formatter.match({
  "location": "StepsDefinition.\u003cinit\u003e(StepsDefinition.java:66)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify post form Website",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});