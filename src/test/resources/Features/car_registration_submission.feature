#Author: chouliaras1996@gmail.com
#Keywords Summary: CarRegistration, FormSubmission
@SmokeTests
Feature: Car registration form. User wants to use the car registration form to submit their application.

  Background:
    Given user navigates to the car registration webpage

  @ValidCarRegWithYear
  Scenario Outline: Successful form submission with valid car registration number and with year selection
    When user enters a valid car registration number "<carRegistrationNumber>"
    And user selects a year "<year>"
    And user clicks on the Submit button
    Then a success message is displayed saying "Success! Selected <carRegistrationNumber> with year <year>"

    Examples:
      | carRegistrationNumber | year  |
      | ABC1234               | 2016  |

  @EmptyCarRegWithYear
  Scenario Outline: Form submission with empty car registration number and with year selection
    When user selects one year "<year>"
    And user clicks on the Submit button
    Then an error message is displayed saying "There was an error!"

    Examples:
      | year  |
      | 2016  |

  @InvalidCarRegWithYear
  Scenario Outline: Form submission with wrong car registration number and with year selection
    When user enters an invalid car registration number "<carRegistrationNumber>"
    And user selects a year "<year>"
    And user clicks on the Submit button
    Then an error message is displayed saying "There was an error!"
    
# Wrong car registration (CaseSensitivity check) with year selected
# Wrong car registration (SQL Injection check) with year selected
    Examples:
      | carRegistrationNumber | year  |
      | abc12                 | 2015  |
      | ABc1234               | 2016  | 
      | '' OR '1'='1'         | 2017  | 


  @ValidCarRegNoYear
  Scenario Outline: Form submission with valid car registration number and no year selection
    When user enters a valid car registration number "<carRegistrationNumber>"
    And user clicks on the Submit button
    Then an error message is displayed saying "There was an error!"

    Examples:
      | carRegistrationNumber |
      | ABC1234               |

  @EmptyCarRegNoYear
  Scenario Outline: Form submission with empty car registration number and no year selection
    When user clicks on the Submit button
    Then an error message is displayed saying "There was an error!"

    #Examples:
      #| carRegistrationNumber |
      #|                       |

  @InvalidCarRegNoYear
  Scenario Outline: Form submission with wrong car registration number and no year selection
    When user enters an invalid car registration number "<carRegistrationNumber>"
    And user clicks on the Submit button
    Then an error message is displayed saying "There was an error!"

# Wrong car registration (CaseSensitivity check) no year selected
# Wrong car registration (SQL Injection check) no year selected
    Examples:
      | carRegistrationNumber |
      | ABC123                |
      | ABc1234               | 
      | '' OR '1'='1'         | 