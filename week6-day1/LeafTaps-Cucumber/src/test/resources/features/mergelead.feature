Feature: Leaf Taps Merge Leads Functionality
Scenario Outline: Merge Two Leads
Given The User enters <username> and <password> 
When The User clicks Login 
When The User clicks 'CRM' 
And The User clicks 'Leads' 
When The User clicks 'Merge Leads'
When The User enters to From Leads Window
When The User enters the <firstName1>
When The User enters to To Leads Window
And The User enters the <firstName2>
When The User clicks 'Merge' button
And The Alert is Handled
Then The Merge of Leads is Verified
Examples:
|username|password|firstName1|firstName2|
|'demosalesmanager'|'crmsfa'|'Walter'|'Gus'|