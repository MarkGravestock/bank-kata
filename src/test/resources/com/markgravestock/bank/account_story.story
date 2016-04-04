Scenario: Deposit in account
Given a customer deposits GBP 100 on 10/03/2015
When they print their statement
Then they would see
| Date | Transaction | Balance |
| 10/03/2015 | 100 CR | 100 CR |