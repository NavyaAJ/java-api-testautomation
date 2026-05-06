package com.example.api.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ApiStepDefinitions {

    private Response response;
    private String requestBody;

    @Given("the API base URL is {string}")
    public void theApiBaseUrlIs(String baseUrl) {
        RestAssured.baseURI = baseUrl;
    }

    @Given("I set request body:")
    public void iSetRequestBody(String body) {
        this.requestBody = body;
    }

    @When("I send a GET request to {string}")
    public void iSendAGetRequestTo(String endpoint) {
        response = RestAssured
                .given()
                .header("Accept", "application/json")
                .when()
                .get(endpoint);
    }

    //with wiremock
    @When("I send a GET request to {string}")
public void iSendAGetRequestTo(String endpoint) {
    // Note: Use http://localhost:8080 as the base URI
    response = RestAssured
            .given()
            .baseUri("http://localhost:8080") 
            .header("Accept", "application/json")
            .when()
            .get(endpoint);
}
    @Then("the response status code should be 200")
public void verifyStatusCode() {
    response.then().statusCode(200);
}

@Then("the response should contain {string}")
public void verifyResponseContent(String expectedKey) {
    response.then().body("[0]", org.hamcrest.Matchers.hasKey(expectedKey));
}

    @When("I send a POST request to {string}")
    public void iSendAPostRequestTo(String endpoint) {
        response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(requestBody)
                .when()
                .post(endpoint);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        assertNotNull("Response was null. Did the API request run?", response);
        assertEquals("Unexpected HTTP status code", expectedStatusCode, response.getStatusCode());
    }

    @And("the response should contain {string}")
    public void theResponseShouldContain(String expectedField) {
        assertNotNull("Response body was null", response.getBody());
        String responseBody = response.getBody().asString();
        assertTrue(
                "Expected field not found in response: " + expectedField + "\nBody: " + responseBody,
                responseBody.contains(expectedField)
        );
    }
}
