Feature: Login

  Scenario Outline: Successful login with valid credentials
    Given I am on the login page
    When I enter username "<username>" and password "<password>"
    And I click the login button
    Then I should be redirected to product page

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: Failed login with invalid credentials
    Given I am on the login page
    When I enter username "<username>" and password "<password>"
    And I click the login button
    Then Alert with message "<error_message>" will appear

    Examples:
      | username        | password     | error_message                                               |
      |                 | secret_sauce | Username is required                                        |
      | standard_user   |              | Password is required                                        |
      | invalid         | invalid      | Username and password do not match any user in this service |
      | locked_out_user | secret_sauce | Sorry, this user has been locked out.                       |