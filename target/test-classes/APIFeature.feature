@E2E
Feature: Testing all API request methods of Reverb APIs

Background: 

Given I added baseuri and RequestSpec

@get
Scenario: Testing the GET request method

When I send the "GET" request with "getRequest" endpoint

Then I verify "GET" request response is 200


@post
Scenario: Testing the POST request method

When I send the "POST" request with "createListing" endpoint

Then I verify "POST" request response is 201


@put
Scenario: Testing the PUT request method

When I send the "PUT" request with "updateListing" endpoint

Then I verify "PUT" request response is 200

@delete
Scenario: Testing the DELETE request method

When I send the "DELETE" request with "deleteDraft" endpoint

Then I verify "DELETE" request response is 200
