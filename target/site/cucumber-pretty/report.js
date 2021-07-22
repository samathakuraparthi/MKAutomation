$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/countryCurrencies.feature");
formatter.feature({
  "line": 1,
  "name": "Country Currencies verification",
  "description": "As a user I should able to select countries and output their currencies",
  "id": "country-currencies-verification",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 5,
  "name": "Display of currencies for selected country",
  "description": "",
  "id": "country-currencies-verification;display-of-currencies-for-selected-country",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@sam"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "user clicks on UK flag on homepage header",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user gets list of countries for region \"\u003cregion\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user prints currency for each country",
  "keyword": "Then "
});
formatter.examples({
  "line": 9,
  "name": "",
  "description": "",
  "id": "country-currencies-verification;display-of-currencies-for-selected-country;",
  "rows": [
    {
      "cells": [
        "region"
      ],
      "line": 10,
      "id": "country-currencies-verification;display-of-currencies-for-selected-country;;1"
    },
    {
      "cells": [
        "Europe"
      ],
      "line": 11,
      "id": "country-currencies-verification;display-of-currencies-for-selected-country;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5709456200,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Display of currencies for selected country",
  "description": "",
  "id": "country-currencies-verification;display-of-currencies-for-selected-country;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@sam"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "user clicks on UK flag on homepage header",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user gets list of countries for region \"Europe\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user prints currency for each country",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePageSteps.clicksOnUKFlagOnHomepageHeader()"
});
formatter.result({
  "duration": 11446391200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Europe",
      "offset": 40
    }
  ],
  "location": "HomePageSteps.userGetsListOfCountriesForRegion(String)"
});
formatter.result({
  "duration": 275437800,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.userPrintsCurrencyForEachCountry()"
});
formatter.result({
  "duration": 23448640800,
  "error_message": "org.openqa.selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document\n  (Session info: chrome\u003d91.0.4472.164)\nFor documentation on this error, please visit: https://selenium.dev/exceptions/#stale_element_reference\nBuild info: version: \u00274.0.0-beta-4\u0027, revision: \u002729f46d02dd\u0027\nSystem info: host: \u0027TR-6C9GZY2\u0027, ip: \u0027192.168.0.14\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002711\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCommand: [b3dd98a0867deb32f408e01308b628ec, executeScript {script\u003darguments[0].click();, args\u003d[{ELEMENT\u003d1a9b82eb-b38b-4ac6-955f-391e7f2ba2b1, element-6066-11e4-a52e-4f735466cecf\u003d1a9b82eb-b38b-4ac6-955f-391e7f2ba2b1}]}]\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 91.0.4472.164, chrome: {chromedriverVersion: 91.0.4472.101 (af52a90bf870..., userDataDir: C:\\Users\\u0171402\\AppData\\L...}, goog:chromeOptions: {debuggerAddress: localhost:58377}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), se:cdp: ws://localhost:58377/devtoo..., se:cdpVersion: 91.0.4472.164, setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:largeBlob: true, webauthn:virtualAuthenticators: true}\nSession ID: b3dd98a0867deb32f408e01308b628ec\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:490)\r\n\tat org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:200)\r\n\tat org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:133)\r\n\tat org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:53)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:184)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.invokeExecute(DriverCommandExecutor.java:162)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:137)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:612)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.executeScript(RemoteWebDriver.java:546)\r\n\tat com.mk.pageObjects.HomePage.getCountryCurrencies(HomePage.java:118)\r\n\tat com.mk.stepDefinitions.HomePageSteps.userPrintsCurrencyForEachCountry(HomePageSteps.java:62)\r\n\tat ✽.Then user prints currency for each country(features/countryCurrencies.feature:8)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 239048400,
  "status": "passed"
});
formatter.after({
  "duration": 1175284400,
  "status": "passed"
});
});