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

## Wire mock details 
Setting up WireMock with RestAssured is a classic move for stable integration testing.
Steps:
1.Dependency Setup
2. Configure the WireMock Server
3. Update Your Step Definition
Note:
Port Matching: Ensure the port in new WireMockServer(8080) matches the port in your RestAssured .baseUri().

Lifecycle: In a real Cucumber framework, you would typically put MockSetup.startServer() in a @Before hook and stopServer() in an @After hook.

Verification: You can also verify that the request actually hit the mock by using:
verify(getRequestedFor(urlEqualTo("/users")));
Quick Tip: If you want to simulate a failure (like a 500 error or a timeout) to see how your code handles it, just change the .withStatus(200) in your stub to .withStatus(500)
