Feature: Customer

  Background: Steps common for all scenario
    Given User launches Chrome browser
    When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And User enters username as "Admin" and password as "admin123"
    And User clicks on Login button
    Then User should see home page url as "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"
    When User navigates to the PIM module

  @Regression
  Scenario: Add New Employee
    And User clicks on the Add Employee button
    When User enters employee details
    And User clicks on the Save button
    Then close browser

  @Sanity
  Scenario: Search Customer by
    And user enter employee Name
    When user click on search button
    And close browser
