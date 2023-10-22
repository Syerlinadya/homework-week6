Feature: Login Page Swag Labs

  @Regression @Positive
  Scenario: Success Login
    Given Halaman login swag labs
    When Input username
    And Input password
    And click login button
    Then User in on products page

  @Regression @Negative
  Scenario: Failed Login
    Given Halaman login swag labs
    When Input username
    And Input Invalid Password
    And click login button
    Then user get error message

  @Regression @Product
    Scenario: Add to Cart
    Given Halaman login swag labs
    When Input username
    And Input password
    And click login button
    Then User in on products page
    When user add product to cart
    Then Product should be in cart

  @Regression @checkout
  Scenario: Checkout without add product
    Given Halaman login swag labs
    When Input username
    And Input password
    And click login button
    Then User in on products page
    Then Product should be in cart
    Then user click checkout

