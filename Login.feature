
Feature: Login Action

Description: This feature will test a LogIn and LogOut functionality

Scenario: Login with valid and Invalid Credentials

    Given User is on Home Page

    When User navigate to Login Page

    And User enters "<username>" and "<password>"

    When Keeping "<case>" as "Valid"

    Then User should get logged in

    Then Message "My Account" is displayed

    But Keeping "<case>" as not "Valid"

    Then user will be asked to go back to login page

    Then Provide correct credentials

Examples:

        |username|password|case|

        |abc@gmail.com|12345|Valid|      

        |abc1@gmail.com|dfsd2|InValid|


        