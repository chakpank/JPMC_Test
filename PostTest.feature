Feature: Validating Social Media API for Post Creation


Scenario: Verify if Post is successfully created using Post Creation API
	Given Create Post Payload
	When User calls "CreatePostAPI" with "POST" http request
	Then the API call is successful with status code 201
	And Post "id" is 101
	And Post "Server" is "cloudflare"
	

Scenario: Verify if Post is not created successfully using Post Creation API with incorrect resource
	Given Create Post Payload
	When User calls "CreatePostAPI" with "POST" http request and invalid resource
	Then the API call is unsuccessful with status code 404

	
Scenario Outline: Verify if Post is successfully created using Post Creation API with multiple set of data
	Given Create Post Payload with <UserId> <Id> "<Title>" "<Body>"
	When User calls "CreatePostAPI" with "POST" http request
	Then the API call is successful with status code 201
	And Post "id" is 101
	And Post "Server" is "cloudflare"
	And Verify content of Post matches with "<Body>"
	
Examples:
	|UserId	|Id		|Title			   |Body				|
	|31		|310	|Title for Post 310|Body for Post 310	|
	|41		|410	|Title for Post 410|Body for Post 410	|
	|51		|510	|Title for Post 510|Body for Post 510	|
	

