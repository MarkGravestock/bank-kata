Scenario: Deposit in new account
Given a customer deposits GBP 100 on 10/03/15
When they print their statement
Then they would see
| Date | Transaction | Balance |
| 10/03/15 | GBP 100.00 CR | GBP 100.00 CR |

Scenario: Multiple Deposits in new account
Given a customer deposits GBP 200 on 20/03/15
And a customer deposits GBP 300 on 21/03/15
When they print their statement
Then they would see
| Date | Transaction | Balance |
| 20/03/15 | GBP 200.00 CR | GBP 200.00 CR |
| 21/03/15 | GBP 300.00 CR | GBP 500.00 CR |