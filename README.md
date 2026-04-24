# java-api-testautomation
Java-based API test automation framework using BDD (Cucumber) and Rest Assured.

## Tech stack
- Java 17
- Maven
- Cucumber (BDD)
- Rest Assured
- JUnit 4

## Project structure
- `src/test/resources/features/sample_api.feature` - BDD scenarios
- `src/test/java/com/example/api/steps/ApiStepDefinitions.java` - Step definitions and API calls
- `src/test/java/com/example/api/runner/TestRunner.java` - Cucumber runner

## Run tests
```bash
mvn test
```

## Generate reports
- Cucumber HTML report:
  - `target/cucumber-reports/cucumber.html`
- Cucumber JSON report:
  - `target/cucumber-reports/cucumber.json`
- Run tests first:
  - `mvn test`
