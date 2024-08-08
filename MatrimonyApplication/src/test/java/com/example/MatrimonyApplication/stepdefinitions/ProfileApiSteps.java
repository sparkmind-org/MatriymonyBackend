package com.example.MatrimonyApplication.stepdefinitions;


import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;

public class ProfileApiSteps {

    private Response response;
    private String profileId;

    @Given("the profile API is available")
    public void profileApiAvailable() {
        RestAssured.baseURI = "http://localhost:8080";  // Base URI for your API
    }

    @When("I send a POST request to \"/profiles\" with the following data:")
    public void sendPostRequest(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("active", Boolean.parseBoolean(data.get("active")));
        requestBody.put("lastSeen", LocalDateTime.parse(data.get("lastSeen")));
        requestBody.put("lastLoggedIn", LocalDateTime.parse(data.get("lastLoggedIn")));
        requestBody.put("createdOn", LocalDateTime.now());
        requestBody.put("updatedOn", LocalDateTime.now());

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/profiles");

        profileId = response.jsonPath().getString("profileId");
    }

    @When("I send a GET request to \"/profiles/{profileId}\"")
    public void sendGetRequest() {
        response = RestAssured.get("/profiles/" + profileId);
    }

    @When("I send a PUT request to \"/profiles/{profileId}\" with the following data:")
    public void sendPutRequest(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("active", Boolean.parseBoolean(data.get("active")));
        requestBody.put("lastSeen", LocalDateTime.parse(data.get("lastSeen")));
        requestBody.put("lastLoggedIn", LocalDateTime.parse(data.get("lastLoggedIn")));
        requestBody.put("updatedOn", LocalDateTime.now());

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .put("/profiles/" + profileId);
    }

    @When("I send a DELETE request to \"/profiles/{profileId}\"")
    public void sendDeleteRequest() {
        response = RestAssured.delete("/profiles/" + profileId);
    }

    @Then("the response status code should be {int}")
    public void validateStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the response should contain the profile ID")
    public void validateProfileId() {
        response.then().body("profileId", notNullValue());
    }

    @Then("the response should contain profile details")
    public void validateProfileDetails() {
        response.then().body("profileId", equalTo(profileId))
                .body("active", notNullValue())
                .body("lastSeen", notNullValue())
                .body("lastLoggedIn", notNullValue());
    }

    @Then("the response should reflect the updated details")
    public void validateUpdatedDetails() {
        response.then().body("active", equalTo(false))
                .body("lastSeen", notNullValue())
                .body("lastLoggedIn", notNullValue());
    }
}
