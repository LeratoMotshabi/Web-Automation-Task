# Selenium Test Automation Framework

## Overview

This project is a Selenium-based test automation framework designed to automate web applications using Java. The framework integrates with TestNG for test execution and ExtentReports for generating comprehensive HTML reports.

## Features

- Cross-browser Testing: Supports Chrome, Firefox, and Edge browsers.
- Data-driven Testing: Utilizes TestNG's DataProvider for feeding test data.
- Custom Reporting: Generates detailed HTML reports with ExtentReports.
- Page Object Model (POM): Implements POM to enhance test maintenance and readability.
- Listeners: Utilizes TestNG listeners for customized logging and reporting.

## Project Structure

selenium-test-automation-framework/
|-- src/
|   |-- test/
|   |   `-- java
|	|		|--actionDriver
|	|		|	`--ActionDriver
|   |       |-- baseClass/
|   |       |   `-- BaseClass.java
|   |       |-- listeners/
|   |       |   `-- Listerners.java
|   |       |-- POM/
|   |       |   `-- webTable.java
|	|		|-- testCases
|	|			`-- UserListTableTestCase
|   | |-- Utilities/
|   |       |   `-- extentManager.java
|	|		|	`-- DataProviders
|   |-- src/
|   |   -- test/
|   		-- resources/
|      			 -- propertiesFiles/
|	|           	|`-- config.properties
|           		|`-- locator.properties
|      			 -- reports/
|	|           	|`extentreport.html
|				|`-- testng.xml

|-- README.md
|-- pom.xml


