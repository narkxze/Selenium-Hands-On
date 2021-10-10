Feature: Leaf Taps Delete Leads Functionality
Scenario Outline: Delete Lead
Given The User enters <username> and <password> 
When The User clicks Login 
When The User clicks 'CRM' 
And The User clicks 'Leads' 
And The User clicks 'Find Leads' 
When The User enters <firstName>
And The ID Information is Extracted
And The User clicks 'Delete'
Then Deletion of Lead is Verified
Examples:
|username|password|firstName|
|'demosalesmanager'|'crmsfa'|'Gus'|