@book @RunAll
Feature: Verifying adactin hotel Booking

  Scenario Outline: Verify Book A hotel with all valid details
    Given User is on adactin Hotel page
    When User perform login "<userName>" , "<Password>"
    Then User verify success message after login "Hello Muthumani!"
    And User should search and enter the all fields"<location>","<hotel>","<roomType>","<roomNo>","<dateIn>","<dateOut>","<adultroom>"and"<childroom>"
    Then User should verify message after search "Select Hotel"
    And User should select the hotel and continue
    Then User verify message after select "Book A Hotel"
    And User should enter all the fields and click Book Now "<firstname>","<lastname>","<address>" and save generated orderID
      | CreditCardType   | CreditCardNo     | ExpMonth | ExpYear | CVVNumber |
      | VISA             | 1928374567839283 | November |    2022 |      2343 |
      | American Express | 3745619287839283 | November |    2022 |      2343 |
      | Master Card      | 7839192837456283 | November |    2022 |      2343 |
    Then User should verify message after click Book Now "Booking Confirmation"

    Examples: 
      | userName  | Password | location  | hotel          | roomType | roomNo | dateIn     | dateOut    | adultroom | childroom | firstname | lastname | address     |
      | Muthumani | V45952   | Melbourne | Hotel Sunshine | Double   |      2 | 22/05/2022 | 23/05/2022 |         3 |         3 | suriya    | muthu    | omr,chennai |

  Scenario Outline: Verify Book A hotel without entering fields
    Given User is on adactin Hotel page
    When User perform login "<userName>" , "<Password>"
    Then User verify success message after login "Hello Muthumani!"
    And User should search and enter the all fields"<location>","<hotel>","<roomType>","<roomNo>","<dateIn>","<dateOut>","<adultroom>"and"<childroom>"
    Then User should verify message after search "Select Hotel"
    And User should select the hotel and continue
    Then User verify message after select "Book A Hotel"
    And User not enter all the fields and click Book Now "<firstname>","<lastname>", "<address>" and save generated orderID
      | CreditCardType | CreditCardNo | ExpMonth | ExpYear | CVVNumber |
    Then User should verify error message after click Book Now "Please Enter your First Name", "Please Enter you Last Name", "Please Enter your Address", "Please Enter your 16 Digit Credit Card Number", "Please Select your Credit Card Type", "Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | userName  | Password | location  | hotel          | roomType | roomNo | dateIn     | dateOut    | adultroom | childroom | firstName | lastName | address |
      | Muthumani | V45952   | Melbourne | Hotel Sunshine | Double   |      2 | 22/05/2022 | 23/05/2022 |         3 |         3 |           |          |         |
