Feature: Leaf Taps Edit Lead Functionality
Scenario Outline: Edit Lead 
Given The User enters <username> and <password> 
When The User clicks Login 
When The User clicks 'CRM' 
And The User clicks 'Leads' 
And The User clicks 'Find Leads' 
When The User enters <firstName>
And The User clicks 'Edit'
When The User updates to <newCompanyName>
And The User clicks Update
Then The Update of Lead is Verified <newCompanyName>
Examples:
|username|password|firstName|newCompanyName|
|'demosalesmanager'|'crmsfa'|'Walter'|'Heisenberg Inc.'|