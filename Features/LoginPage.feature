Feature: OrangeHRM Login and Logout

   @Sanity
  Scenario: Successful Login with Valid Credentials
    Given User launches Chrome browser
    When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When User enters username as "Admin" and password as "admin123"
    And User clicks on Login button
    Then User should see home page url as "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"
    When User clicks on Logout link
    And close browser

  @Regression
  Scenario Outline: Login with multiple data DDT
    Given User launches Chrome browser
    When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When User enters username as "<username>" and password as "<password>"
    And User clicks on Login button
    Then User should see home page url as "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"
    When User clicks on Logout link
    Then close browser

    Examples: 
      | username | password |
      | Admin    | admin123 |
     #| user     | .com     |
