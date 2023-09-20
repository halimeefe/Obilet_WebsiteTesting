

@MyTag
  Feature: Bus Category

    Scenario: Exporting Available Bus Seat Info to Excel

      Given Navigate to website
      And Click on the member login
      And Write a valid email
      And Write a valid password
      And Click on the login button
      When  Verify you are on the site
      And Click on the bus category
      And Select departure point
      And Choose a destination
      And Choose your travel date
      And Click to find bus ticket
      And Click to sort by price
      And Click on all filters and select by company
      And Choose the first company
      And Export only vacant seat numbers to Excel file
      When Log out succesfully
      Then Verify that you are the logout