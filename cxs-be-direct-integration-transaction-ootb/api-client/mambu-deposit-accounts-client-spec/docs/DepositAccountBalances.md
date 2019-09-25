
# DepositAccountBalances

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**totalBalance** | [**BigDecimal**](BigDecimal.md) | The current balance of the account |  [optional]
**overdraftAmount** | [**BigDecimal**](BigDecimal.md) | How much money has been taken out in overdraft |  [optional]
**technicalOverdraftAmount** | [**BigDecimal**](BigDecimal.md) | How much money has been taken out as unplanned overdraft |  [optional]
**lockedBalance** | [**BigDecimal**](BigDecimal.md) | No operation can modify the balance of the account and get it lower than this locked balance |  [optional]
**availableBalance** | [**BigDecimal**](BigDecimal.md) | The current available balance for deposit transactions |  [optional]
**holdBalance** | [**BigDecimal**](BigDecimal.md) | The sum of all the authorization hold amounts on this account |  [optional]
**overdraftInterestDue** | [**BigDecimal**](BigDecimal.md) | How much interest is due to be paid on this account as a result of the authorized overdraft |  [optional]
**technicalOverdraftInterestDue** | [**BigDecimal**](BigDecimal.md) | How much interest is due to be paid on this account as a result of the technical overdraft |  [optional]
**feesDue** | [**BigDecimal**](BigDecimal.md) | How much fees is due to be paid on this account |  [optional]



