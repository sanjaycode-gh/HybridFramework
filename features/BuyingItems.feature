Feature: Purchasing items from swaglabs

  Scenario: Testing the purchase of one Sauce Labs Backpack
    Given User navigates to swaglabs website
    And User enters valid credentials and enter login
    When User add backpack item to cart
    And User proceed to checkout and place the order
    Then Order has placed successfully