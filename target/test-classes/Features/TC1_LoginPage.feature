@login @RunAll
Feature: Verifying adactin hotel login

  Scenario Outline: Verify Hello.. after adactin hotel login with
    Given User is on adactin Hotel page
    When User perform login "<userName>" , "<Password>"
    Then User verify success message after login "Hello Muthumani!"

    Examples: 
      | userName  | Password |
      | Muthumani | V45952   |

  Scenario Outline: Valid adactin hotel login with keys
    Given User is on adactin Hotel page
    When User perform login with keys "<userName>" , "<Password>"
    Then User verify success message after login "Hello Muthumani!"

    Examples: 
      | userName  | Password |
      | Muthumani | V45952   |

  Scenario Outline: Valid adactin hotel login
    Given User is on adactin Hotel page
    When User perform login "<userName>" , "<Password>"
    Then User verify error contains after login"Invalid Login details or Your Password might have expired."

    Examples: 
      | userName  | Password |
      | ShafiDemo | V45952   |
