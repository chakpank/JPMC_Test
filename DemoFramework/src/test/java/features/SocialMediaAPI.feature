Feature: Validating Social Media API 


@Post
Scenario: Verify if Post is successfully created using Post Creation API
	Given Create Post Payload
	When User calls "CreatePostAPI" with "POST" http request
	Then the API call is successful with status code 201
	And Post "id" is 101
	And Post "Server" is "cloudflare"
	
@Post	
Scenario: Verify if Post is not created successfully using Post Creation API with incorrect resource
	Given Create Post Payload
	When User calls "CreatePostAPI" with "POST" http request and invalid resource
	Then the API call is unsuccessful with status code 404

	
@Post
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
	

@ListUser	
Scenario: Verify if users are getting listed successfully using the GetUsersAPI
	Given Setup is ready to list users
	When User calls "GetUsersAPI" with "GET" http request
	Then the API call is successful with status code 200
	And Post "Server" is "cloudflare"
	
@ListUser
Scenario: Verify if users are not getting listed successfully using the GetUsersAPI with incorrect resource
	Given Setup is ready to list users
	When User calls "GetUsersAPI" with "GET" http request and invalid resource
	Then the API call is unsuccessful with status code 404
	

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
	

