Feature: Validating Social Media API for Comment Creation 


@Comment	
Scenario: Verify if Comment is successfully created using Comment Creation API
	Given Create Comment Payload is ready
	When User calls "CreateCommentAPI" with "POST" http request
	Then the API call is successful with status code 201
	And Post "id" is 501
	And Post "Server" is "cloudflare"
	
	
@Comment	
Scenario Outline: Verify if Comment is successfully created using Comment Creation API with multiple set of data
	Given Create Comment Payload with <PostId> <Id> "<Name>" "<Email>" "<Body>"
	When User calls "CreateCommentAPI" with "POST" http request
	Then the API call is successful with status code 201
	And Post "id" is 501
	And Post "Server" is "cloudflare"
	
Examples:
	|PostId	|Id		|Name		|Email					|Text				|
	|31		|310	|User@310	|user310@test.email.com	|Test Comment 31	|
	|41		|410	|User@410	|user410@test.email.com	|Test Comment 41	|
	|51		|510	|User@510	|user510@test.email.com	|Test Comment 51	|
	
@Comment	
Scenario: Verify if Comment is not created successfully using Comment Creation API with incorrect resource
	Given Create Comment Payload is ready
	When User calls "CreateCommentAPI" with "POST" http request and invalid resource
	Then the API call is unsuccessful with status code 404
	

