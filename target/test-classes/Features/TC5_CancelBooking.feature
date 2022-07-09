@RunAll
Feature: Verifying adactin hotel Booking OrderId cancel

  @cancel
  Scenario Outline: Verify Booking OrderId cancel
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
    And User should cancel the generated order Id
    Then User should verify the cancel message "The booking has been cancelled."

    Examples: 
      | userName  | Password | location  | hotel          | roomType | roomNo | dateIn     | dateOut    | adultroom | childroom | firstname | lastname | address     |
      | Muthumani | V45952   | Melbourne | Hotel Sunshine | Double   |      2 | 22/05/2022 | 23/05/2022 |         3 |         3 | suriya    | muthu    | omr,chennai |

  Scenario Outline: Verify Booking OrderId cancel after login
    Given User is on adactin Hotel page
    When User perform login "<userName>" , "<Password>"
    Then User verify success message after login "Hello Muthumani!"
    And User should cancel the existing orderID "<order_Id>"
    Then User should verify the cancel message "The booking has been cancelled."

    Examples: 
      | userName  | Password | order_Id   |
      | Muthumani | V45952   | II421OR745 |
 # Muthumani V45952 Hello Muthumani!
 # 0Y5QUF0H58
 # 26L0R65G8K
 # 0JQ9668H93
 # 93B44YGFW0
