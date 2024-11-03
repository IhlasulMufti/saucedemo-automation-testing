Feature: Product

  Scenario Outline: Add product to cart
    Given I am logged in with username "<username>"
    And I am on the product page
    When I click add to cart button for two product
    And I click cart button
    Then There will be two products in the cart
    # Need logout to change user for some error scenario
    And I am logout

    Examples:
      | username      |
      | standard_user |
