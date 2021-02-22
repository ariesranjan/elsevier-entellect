Feature: Get group using group ID
	
	@entellectTestPositive
	Scenario: Verify that Get Group API is giving 200 response with correct info
		Given base uri sets for Get Group api
		When a user retrieves the group by group id
		Then the status code is 200
		Then validates get group API response schema
		Then response includes the following
			| guid							| Bl2h8zwUMEf			|
			| organization_guid | Ol2h8tyuLvm 		|
			| name 							| ankitranjan4488 |
			
	@entellectTestNegative
	Scenario: Verify that Get Group API is giving 403 response when auth token is not valid
		Given base uri sets for Get Group Invalid Token api
		When a user retrieves the group by group id
		Then the status code is 403
		Then response includes the following
			| message							| FORBIDDEN			|
			
	@entellectTestNegative
	Scenario: Verify that Get Group API is giving 403 response when group id is not valid
		Given base uri sets for Get Invalid Group api
		When a user retrieves the group by group id
		Then the status code is 403
		Then response includes the following
			| message							| FORBIDDEN			|
			| description					| You are currently forbidden to access this resource. |
			
	@entellectTestNegative
	Scenario: Verify that Get Group API is giving 404 response API endpoint is invalid
		Given base uri sets for Get Group Invalid endpoint api
		When a user retrieves the group by group id
		Then the status code is 404
			