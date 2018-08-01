$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/Authoring.feature");
formatter.feature({
  "line": 1,
  "name": "The automation practice login test",
  "description": "",
  "id": "the-automation-practice-login-test",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 19,
  "name": "Test login with valid credentials",
  "description": "",
  "id": "the-automation-practice-login-test;test-login-with-valid-credentials",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 18,
      "name": "@Invalid"
    }
  ]
});
formatter.step({
  "line": 20,
  "name": "Opne chrome and start app",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "User clicks on signin button",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "User provides valid email \"\u003cemail\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 23,
  "name": "User provides valid password \"\u003cpassword\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "User clicks on submit button",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "User did not log in successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 27,
  "name": "",
  "description": "",
  "id": "the-automation-practice-login-test;test-login-with-valid-credentials;",
  "rows": [
    {
      "cells": [
        "email",
        "password"
      ],
      "line": 28,
      "id": "the-automation-practice-login-test;test-login-with-valid-credentials;;1"
    },
    {
      "cells": [
        "ashish@gmail.com",
        "ashish"
      ],
      "line": 29,
      "id": "the-automation-practice-login-test;test-login-with-valid-credentials;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 19849923492,
  "status": "passed"
});
formatter.scenario({
  "line": 29,
  "name": "Test login with valid credentials",
  "description": "",
  "id": "the-automation-practice-login-test;test-login-with-valid-credentials;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 18,
      "name": "@Invalid"
    }
  ]
});
formatter.step({
  "line": 20,
  "name": "Opne chrome and start app",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "User clicks on signin button",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "User provides valid email \"ashish@gmail.com\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 23,
  "name": "User provides valid password \"ashish\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "User clicks on submit button",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "User did not log in successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "AuthoringStepDefinitions.opne_chrome_and_start_app()"
});
formatter.result({
  "duration": 20203380104,
  "status": "passed"
});
formatter.match({
  "location": "AuthoringStepDefinitions.user_clicks_on_signin_button()"
});
formatter.result({
  "duration": 7284976329,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ashish@gmail.com",
      "offset": 27
    }
  ],
  "location": "AuthoringStepDefinitions.user_provides_valid_email(String)"
});
formatter.result({
  "duration": 2448610112,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ashish",
      "offset": 30
    }
  ],
  "location": "AuthoringStepDefinitions.user_provides_valid_password(String)"
});
formatter.result({
  "duration": 1690928393,
  "status": "passed"
});
formatter.match({
  "location": "AuthoringStepDefinitions.user_clicks_on_submit_button()"
});
formatter.result({
  "duration": 4552765205,
  "status": "passed"
});
formatter.match({
  "location": "AuthoringStepDefinitions.user_didnot_log_in_successfully()"
});
formatter.result({
  "duration": 21296448,
  "error_message": "java.lang.AssertionError: null got logged in so failing this step.. expected [true] but found [false]\r\n\tat org.testng.Assert.fail(Assert.java:93)\r\n\tat org.testng.Assert.failNotEquals(Assert.java:512)\r\n\tat org.testng.Assert.assertTrue(Assert.java:41)\r\n\tat stepDefinitions.AuthoringStepDefinitions.user_didnot_log_in_successfully(AuthoringStepDefinitions.java:119)\r\n\tat ✽.Then User did not log in successfully(features/Authoring.feature:25)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 7467487930,
  "status": "passed"
});
});