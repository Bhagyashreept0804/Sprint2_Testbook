##Author : bhagyashree-jagannath.patil@capgemini.com

@livecourses
Feature: live classes and courses 
  I want to see all the live classes available on the site to attend

	@livedisp
	Scenario: live classes are displayed
			Given user on home page
			Then live classes displayed on right

	@liveattend
	Scenario: attends live classes
			Given user on home page
			When click on live classes
			Then live classes are shown

	@liveaccess
	Scenario: Access live classes
			Given user in live classes tab
			When click on one live class
			Then user can attend live class
 
   