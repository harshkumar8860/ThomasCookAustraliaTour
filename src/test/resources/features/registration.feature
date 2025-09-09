Feature: User Registration on Thomas Cook website

  @Negative
  Scenario Outline: Register with invalid details
    Given I open the Thomas Cook website
    And I navigate to the registration page
    When I select title "<title>"
    And I enter first name "<firstName>"
    And I enter last name "<lastName>"
    And I enter email "<email>"
    And I enter password "<password>"
    And I enter confirm password "<confirmPassword>"
    And I enter mobile number "<mobile>"
   #And I accept the privacy policy
    And I click on Register button
    Then I should see error messages for invalid inputs

    Examples:
      | title | firstName | lastName | email             | password  | confirmPassword | mobile     |
      | Mr    |  Honey    |          | invalidEmail      | Honey@123 | Honey@1234      | 784218     |

  @Positive
  Scenario Outline: Register with valid details
    Given I open the Thomas Cook website
    And I navigate to the registration page
    When I select title "<title>"
    And I enter first name "<firstName>"
    And I enter last name "<lastName>"
    And I enter email "<email>"
    And I enter password "<password>"
    And I enter confirm password "<confirmPassword>"
    And I enter mobile number "<mobile>"
   #And I accept the privacy policy
    And I click on Register button
    Then I should be redirected to the home page without error

    Examples:
      | title | firstName | lastName | email                   | password    | confirmPassword | mobile      |
      | Mr    |   Def     |    Ghi   | hurikefu4@cyclelove.cc   | biwin91898  | biwin91898      | 9464108206  |

  #  Examples:
   #   | title | firstName | lastName | email                   | password    | confirmPassword | mobile      |
    #  | Mr    |   Def     |    Ghi   | biwin91898@mirarmax.com | biwin91898  | biwin91898      | 9824394355  |
     