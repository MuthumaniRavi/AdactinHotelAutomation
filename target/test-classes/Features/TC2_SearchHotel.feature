@search @RunAll
Feature: Verifying adactin Search Hotel

  Scenario Outline: Verify By select all fields
    Given User is on adactin Hotel page
    When User perform login "<userName>" , "<Password>"
    Then User verify success message after login "Hello Muthumani!"
    And User should search and enter the all fields"<location>","<hotel>","<roomType>","<roomNo>","<dateIn>","<dateOut>","<adultroom>"and"<childroom>"
    Then User should verify message after search "Select Hotel"

    
    Examples: 
      | userName  | Password | location  | hotel          | roomType | roomNo | dateIn     | dateOut    | adultroom | childroom |
      | Muthumani | V45952   | Melbourne | Hotel Sunshine | Double   |      2 | 22/05/2022 | 23/05/2022 |         3 |         3 |

  Scenario Outline: Verify By select manatory fields
    Given User is on adactin Hotel page
    When User perform login "<userName>" , "<Password>"
    Then User verify success message after login "Hello Muthumani!"
    And User should search and enter the fields"<location>","<hotel>","<roomType>","<roomNo>","<dateIn>","<dateOut>","<adultroom>"and"<childroom>"
    Then User should verify message after search "Select Hotel"

    Examples: 
      | userName  | Password | location  | hotel | roomType | roomNo | dateIn     | dateOut    | adultroom | childroom |
      | Muthumani | V45952   | Melbourne |       |          |      2 | 22/05/2022 | 23/05/2022 |         3 |         3 |

  Scenario Outline: Verify By enter valid date field
    Given User is on adactin Hotel page
    When User perform login "<userName>" , "<Password>"
    Then User verify success message after login "Hello Muthumani!"
    And User should search and enter the all fields with existing date"<location>","<hotel>","<roomType>","<roomNo>","<dateIn>","<dateOut>","<adultroom>"and"<childroom>"
    Then User verify error message dateCheckingIn Out after search "Check-In Date shall be before than Check-Out Date","Check-Out Date shall be after than Check-In Date"

    Examples: 
      | userName  | Password | location  | hotel          | roomType | roomNo | dateIn     | dateOut    | adultroom | childroom |
      | Muthumani | V45952   | Melbourne | Hotel Sunshine | Double   |      2 | 22/05/2024 | 23/05/2022 |         3 |         3 |

  Scenario Outline: Verify without entering fields
    Given User is on adactin Hotel page
    When User perform login "<userName>" , "<Password>"
    Then User verify success message after login "Hello Muthumani!"
    # And User should search and enter the all fields"<location>","<hotel>","<roomType>","<roomNo>","<dateIn>","<dateOut>","<adultroom>"and"<childroom>"
    Then User verify error message after search "Please Select a Location"

    Examples: 
      | userName  | Password | location | hotel | roomType | roomNo | dateIn | dateOut | adultroom | childroom |
      | Muthumani | V45952   |          |       |          |        |        |         |           |           |
