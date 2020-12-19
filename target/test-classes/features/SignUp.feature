@Search
Feature: Sign up Functionality in Swiggy website

  @Sanity
  Scenario: Provide the SignUp Functions to Swiggy Users
    Given The user is on the Swiggy Home Page
    When User click on SignUp
    Then User should be redirected to SignUp Page

	@Sanity
  Scenario Outline: Provide the SignUp Functions to Swiggy Users
    Given The user is already on the Signup page
    When User enters "<Phone>" "<Name>" "<Email>" and "<Password>"
    And User Click Continue button
    Then User should be able to SignUp

    Examples: 
      | Phone      | Name | Email       | Password |
      | 8888888888 | Jon  | Jon@xyz.com | abc123   |
