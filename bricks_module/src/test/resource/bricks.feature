Feature: Demo Feature

Scenario: customer buys bricks

Given A customer wants to buy any number of bricks
When  A "Create Order" request for a number of bricks is submitted
Then  An Order reference is returned
And   The Order reference is unique to the submission


Scenario : As a Rest Client I want to retrieve orders, So I can display simple customers’ orders

 Given A customer has submitted an order for some bricks
 When A "Get Order" request is submitted with a valid Order reference
 Then  The order details are returned
 And    The order details contains the Order reference and the number of bricks ordered

 When A "Get Order" request is submitted with an invalid Order reference
 Then  No order details are returned

 Given Many customers have submitted orders for bricks
 When A "Get Orders" request is submitted
 Then  All the orders details are returned
 And   The order details contains the Order reference and the number of bricks ordered