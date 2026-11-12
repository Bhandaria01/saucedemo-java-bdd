Feature: Login
    As a registered customer
    I want to log in to SauceDemo
    So that I can browse and buy products

    Background:
        Given I am on the login page
    @smoke
    Scenario: Successful login with credentials
        When I log in as "standard_user" and password "secret_sauce"
        Then I should land on product page

    Scenario Outline: Login is rejected for invalid credentials
        When I log in as "<username>" and password "<password>"
        Then I should see the error "<error>"
        And I should stay on the login page

    Examples:
      | username        | password     | error                         |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out. |
      | standard_user   | wrong_pass   | Epic sadface: Username and password do not match any user in this service |
      |                 | secret_sauce | Epic sadface: Username is required |
      | standard_user   |              | Epic sadface: Password is required |