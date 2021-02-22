Feature: Get sorted bitlinks for Group
	
	@entellectTestPositive
	Scenario: Verify that sorted bitlinks API is giving 200 response with correct response
		Given base uri sets for Sorted Bitlinks api
		When a user retrieves sorted Bitlinks for Group
		Then the status code is 200
		Then validates get sorted bitlinks for group API response schema
		Then response includes the following
			| sorted_links[0].id 			| bit.ly/3seer5h |
			|	sorted_links[0].clicks 	| 2 						 |
			|	sorted_links[1].id 			| bit.ly/3bg4VHB |
			|	sorted_links[1].clicks 	| 1 						 |
			
	@entellectTestNegative
	Scenario: Verify that Get Group API is giving 403 response when auth token is not valid
		Given base uri sets for Get Sorted Bitlinks Invalid Token api
		When a user retrieves sorted Bitlinks for Group
		Then the status code is 403
		Then response includes the following
			| message							| FORBIDDEN			|
			
	@entellectTestNegative
	Scenario: Verify that Get Group API is giving 403 response when group id is not valid
		Given base uri sets for Get Sorted Bitlinks For Invalid Group api
		When a user retrieves the group by group id
		Then the status code is 403
		Then response includes the following
			| message							| FORBIDDEN			|
			| description					| You are currently forbidden to access this resource. |
			
	@entellectTestNegative
	Scenario: Verify that Get Group API is giving 404 response when API endpoint is invalid
		Given base uri sets for Get Sorted Bitlinks Invalid endpoint api
		When a user retrieves the group by group id
		Then the status code is 404
		
	@entellectTestNegative
	Scenario: Verify that Get Group API is giving 400 response when request parameters are not right
		Given base uri sets for Get Sorted Bitlinks Invalid Params api
		When a user retrieves the group by group id
		Then the status code is 400
		Then response includes the following
			| message 						 | INVALID_ARG_UNIT |
			|	description 				 | The value provided is invalid. 						 |
			| errors[0].field 		 | unit |
			| errors[0].error_code | invalid |
			