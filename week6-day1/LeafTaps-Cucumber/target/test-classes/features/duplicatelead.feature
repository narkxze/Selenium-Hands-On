Feature: Leaf Taps Duplicate Leads Functionality
Scenario Outline: Duplicate Lead
Given The User enters <username> and <password> 
When The User clicks Login 
When The User clicks 'CRM' 
And The User clicks 'Leads' 
And The User clicks 'Find Leads' 
When The User enters <firstName>
And The User clicks 'Duplicate Lead'
When The User clicks Submit
Then Verification of Duplication Lead <firstName>
Examples:
|username|password|firstName|
|'demosalesmanager'|'crmsfa'|'Gus'|
