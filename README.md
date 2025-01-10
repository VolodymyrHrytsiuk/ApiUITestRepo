# Automated Testing Framework for API and UI

This project contains automated tests for web applications and APIs using Java, Selenide, TestNG and other tools. 

---

## Description

Tests check basic operations (get, put) via the API and title check in UI.

---

## Tools and Libraries

- **Java** – is the main programming language.
- **TestNG**  – a framework for organizing tests.
- **Rest Assured** - to automate API testing.
- **Lombok** – for code generation (for example, constructors, getter/setter, pattern builder).
- **Allure** – to create test reports.
- **Maven** – for managing dependencies and building a project.

## Run tests

### Launch via Suite

To run tests through XML Suite, use the command:

```bash
mvn test -DsuiteXmlFile=apiAndUiSuites.xml
```

## Generating an Allure report

Allure is a powerful test reporting tool that allows you to conveniently view test results with
a detailed description of the tests performed.

### Steps to generate an Allure report

* **Run tests and generate results**

  You can run the tests either through the interface of your development environment or through the command specified above.
  After running the tests, you can generate a report using the Allure plugin. To do this, run the report generation using
  Maven:

    ```bash
    mvn allure:serve
    ```

  After running the tests, the results will be saved in the directory `target/allure-results`.

  This command:
    - Generates a report based on the test results saved in the `target/allure-results` directory.
    - Opens a web browser with the generated Allure report.

  After running the command `mvn allure:serve`, Allure will open a local server (by default on
  port `127.0.0.1:8080`), where you can view the report. The report will contain:
    - General test statistics (how many tests passed, how many failed).
    - More detailed information about each test: execution time, result, logging, errors, etc.