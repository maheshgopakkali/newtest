Feature: Selection of product and adding to cart

Scenario: selecting Tshirt and adding to cart
Given Opne chrome and start app
When User clicks on Tshirt tab
Then Tshirt tab successfully opens
Then User clicks on available item
Then fadedShirtPage tab successfully opens
Then User selects size of the item
Then User click on addToCart