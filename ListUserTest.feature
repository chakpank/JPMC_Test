Feature: Validating Social Media API for User Listing 


Scenario: Verify if users are getting listed successfully using the GetUsersAPI
	Given Setup is ready to list users
	When User calls "GetUsersAPI" with "GET" http request
	Then the API call is successful with status code 200
	And Post "Server" is "cloudflare"

Scenario: Verify if users are not getting listed successfully using the GetUsersAPI with incorrect resource
	Given Setup is ready to list users
	When User calls "GetUsersAPI" with "GET" http request and invalid resource
	Then the API call is unsuccessful with status code 404
	
