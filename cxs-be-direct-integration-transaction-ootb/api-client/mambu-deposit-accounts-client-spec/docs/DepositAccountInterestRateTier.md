
# DepositAccountInterestRateTier

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**encodedKey** | **String** | The encoded key of the interest rate tier, auto generated, unique |  [optional]
**endingBalance** | [**BigDecimal**](BigDecimal.md) | The top-limit value for the account balance in order to determine if this tier is used or not | 
**interestRate** | [**BigDecimal**](BigDecimal.md) | The rate used for computing the interest for an account which has the balance less than the ending balance | 
**endingDay** | **Integer** | The top-limit value for the account period since activation in order to determine if this tier is used or not |  [optional]



