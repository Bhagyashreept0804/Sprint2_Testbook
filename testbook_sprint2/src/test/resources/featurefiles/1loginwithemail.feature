##Author : bhagyashree-jagannath.patil@capgemini.com

@login
Feature: login

	@login
	Scenario: Login with email
		Given user on login page
		When enter valid email and valid password
		Then Testbook home page display

#Examples:
#|email             |password         |
#|bpt0804@gmail.com | StepupTest@3248 |
 

























  @tag2
  Scenario Outline: Login with invalid passsword and valid email
Given user on login page
When enter valid email and invalid password <email> <password>
Then Error message is displayed

Examples:
|email             | password|
|bpt0804@gmail.com | abc123  |
