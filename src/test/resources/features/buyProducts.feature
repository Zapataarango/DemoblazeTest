Feature: Purchase of a Samsung Galaxy S6 in Demoblaze web

  Me as a normal user
  want to buy a cellphone in demoblaze
  to verify the correct functioning

  Scenario: buySamsung
    Given "userAntonio" logs with credentials
    When buys a list "productsPepe"
    When "userAntonio" shoulds see the product in the cart
    Then shoulds see message indicating the purchase is done