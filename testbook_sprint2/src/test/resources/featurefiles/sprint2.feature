
@tag
Feature: Transactions
  I want to transaction details after payment.

  @tag1
  Scenario: Transaction option is display
    Given user is on home page
    When click on actor profile
    Then transactions option is display

  @tag2
  Scenario: Transaction Details are display
    Given transactions option clicked
    Then Transaction details are displayed

  @tag3
  Scenario Outline: Search for Billing details
   Given user is on transaction page
    When Search by name <plan>
    Then plans details should be displayed
   Examples:
   | Weekly |
   |Monthly |
   |Yearly |
