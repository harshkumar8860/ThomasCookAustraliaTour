Feature: ThomasCook Australia Tour Booking

  Scenario Outline: Book Amazing Australia - Winter and verify Payment Failed
    Given I am on the ThomasCook login page
    When I enter login details "<email>" and send OTP
    And I click on the login button
    When I hover on Holidays and open "Australia Tour Packages"
    And I open package "Amazing Australia - Winter"
    # And I scroll to Calculate Price and select Tour Type "<tourType>" and Adults "<adult>"
    And I select Date of Travel
    # And I fill Contact Details "<mobileNo>" and "<email>"
    # And contact details are already filled
    And I click Calculate Package Price
    And I choose Pay Full Amount and Continue
    Then I am redirected to BookingSummary, I again click continue, and continue
    And I fill Traveller 1 details "<title1>", "<firstName1>", "<lastName1>", "<dob1>", "<meal1>"
    And I fill Traveller 2 details "<title2>", "<firstName2>", "<lastName2>", "<dob2>", "<meal2>"
    And I fill Address details "<titleAdd>", "<firstNameAdd>", "<lastNameAdd>", "<address>", "<state>", "<city>", "<pincode>", "<emailAdd>", "<mobileAdd>"
    And I select Credit Card and pay "<cardNo>", "<expMonth>", "<expYear>", "<cvv>", "<cardName>"
    Then Payment Failed message should be displayed

  Examples:
    | tourType | mobileNo   | email                   | title1 | firstName1 | lastName1 | dob1       | meal1   | title2 | firstName2 | lastName2 | dob2       | meal2   | titleAdd | firstNameAdd | lastNameAdd | address  | state   | city      | pincode | emailAdd               | mobileAdd  | cardNo           | expMonth | expYear | cvv | cardName |
    | Standard | 9824394355 | biwin91898@mirarmax.com | Mr     | Def        | Ghi       | 02-10-2002 | Veg     | Ms     | Mary       | Jane      | 06-05-2004 | Non-Veg | Mr       | Def          | Ghi         | Street1 | Haryana | Faridabad | 121001  | biwin91898@mirarmax.com | 9824394355 | 6222222222222244 | 11       | 2030    | 321 | Def Ghi  |

#  Examples:
#    | tourType | adult | travelDate | mobileNo   | email                     | title1 | firstName1 | lastName1 | dob1       | meal1   | title2 | firstName2 | lastName2 | dob2       | meal2   | titleAdd | firstNameAdd | lastNameAdd | address  | state   | city      | pincode | emailAdd                  | mobileAdd  | cardNo             | expMonth | expYear | cvv | cardName |
#    | Standard | 2     | 18-09-2025 | 9824394355 | biwin91898@mirarmax.com   | Mr     | Def        | Ghi       | 02-10-2002 | Veg     | Ms     | Mary       | Jane      | 06-05-2004 | Non-Veg | Mr       | Def          | Ghi         | Street1 | Haryana | Faridabad | 121001  | biwin91898@mirarmax.com   | 9824394355 | 6222222222222244   | 11       | 2030    | 321 | Def Ghi  |
