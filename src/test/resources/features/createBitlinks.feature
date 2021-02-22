Feature: Create Bitlinks
	
	@entellectTestPositive
	Scenario: Verify that bitlinks are being created using post bitlink API with status code 200
		Given base uri sets for Create Bitlinks api
		When a user creates bitlink using post method
		Then the status code is 200