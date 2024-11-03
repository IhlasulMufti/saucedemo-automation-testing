Feature: Checkout
  # logout need in all scenario on this feature to change user
  # because some negative test just can be done with specific user
  Scenario Outline: Successful to complete checkout process
    Given I am logged in with username "<username>"
    And I click cart button
    And There will be two products in the cart
    When I click checkout button
    And I enter firstname "<firstname>", lastname "<lastname>" and postal code "<postalcode>"
    And I click continue button
    And I am on the overview page
    And I click finish button
    Then Checkout process complete
    And I am logout

    Examples:
      | username      | firstname | lastname | postalcode |
      | standard_user | Juara     | Coding   | 21505      |

  Scenario Outline: Failed to finish checkout process
    Given I am logged in with username "<username>"
    # Add product again because it's empty (from last scenario)
    And I click add to cart button for two product
    And I click cart button
    And There will be two products in the cart
    When I click checkout button
    And I enter firstname "<firstname>", lastname "<lastname>" and postal code "<postalcode>"
    And I click continue button
    And I am on the overview page
    And I click finish button
    Then Finish button is not clickable
    And I am logout

    Examples:
      | username   | firstname | lastname | postalcode |
      | error_user | Juara     | Coding   | 21505      |

  Scenario Outline: Forget to fill all identity requirement
    Given I am logged in with username "<username>"
    And I click cart button
    And There will be two products in the cart
    When I click checkout button
    And I enter firstname "<firstname>", lastname "<lastname>" and postal code "<postalcode>"
    And I click continue button
    Then Alert with message "<error_message>" will appear
    And I am logout

    Examples:
      | username      | firstname | lastname | postalcode | error_message           |
      | standard_user |           | Coding   | 21505      | First Name is required  |
      | standard_user | Juara     |          | 21505      | Last Name is required   |
      | standard_user | Juara     | Coding   |            | Postal Code is required |