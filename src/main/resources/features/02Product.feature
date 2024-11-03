Feature: Product

  Scenario: Add product to cart
    Given I am logged in
    And I am on the product page
    When I click add to cart button for three product
    And I click cart button
    Then There will be three products in the cart
