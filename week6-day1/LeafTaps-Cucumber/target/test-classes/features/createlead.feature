Feature: Leaf Taps Create Lead Functionality

Scenario Outline: Create Lead with Positive Credential
Given The User enters <username> and <password> 
When The User clicks Login 
When The User clicks 'CRM'
And The User clicks 'Leads'
And The User clicks 'Create'
And The User enters Mandatory Credentials <companyName> <firstName> <lastName>
When The User clicks Submit 
Then Lead Creation is verified <companyName>
Examples:
|username|password|companyName|firstName|lastName|
|'demosalesmanager'|'crmsfa'|'Los Pollos Hermanos'|'Gus'|'Fring'|
|'demosalesmanager'|'crmsfa'|'Vamanos Pest'|'Walter'|'White'|



