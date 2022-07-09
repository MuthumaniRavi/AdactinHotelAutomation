@RunAll
Feature: Verifying adactin Select Hotel

  @select
  Scenario Outline: Verify select the hotel
    Given User is on adactin Hotel page
    When User perform login "<userName>" , "<Password>"
    Then User verify success message after login "Hello Muthumani!"
    And User should search and enter the all fields"<location>","<hotel>","<roomType>","<roomNo>","<dateIn>","<dateOut>","<adultroom>"and"<childroom>"
    Then User should verify message after search "Select Hotel"
    And User should select the hotel and continue
    Then User verify message after select "Book A Hotel"

    Examples: 
      | userName  | Password | location  | hotel          | roomType | roomNo | dateIn     | dateOut    | adultroom | childroom |
      | Muthumani | V45952   | Melbourne | Hotel Sunshine | Double   |      2 | 22/05/2022 | 23/05/2022 |         3 |         3 |

  Scenario Outline: Verify select the hotel
    Given User is on adactin Hotel page
    When User perform login "<userName>" , "<Password>"
    Then User verify success message after login "Hello Muthumani!"
    And User should search and enter the all fields"<location>","<hotel>","<roomType>","<roomNo>","<dateIn>","<dateOut>","<adultroom>"and"<childroom>"
    Then User should verify message after search "Select Hotel"
    And User click Continue without select
    Then User verify error message of without select the hotel "Please Select a Hotel"

    Examples: 
      | userName  | Password | location  | hotel          | roomType | roomNo | dateIn     | dateOut    | adultroom | childroom |
      | Muthumani | V45952   | Melbourne | Hotel Sunshine | Double   |      2 | 22/05/2022 | 23/05/2022 |         3 |         3 |
