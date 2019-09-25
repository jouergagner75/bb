
# DepositAccount

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**encodedKey** | **String** | The encoded key of the deposit account, auto generated, unique |  [optional]
**creationDate** | [**OffsetDateTime**](OffsetDateTime.md) | The date this deposit account was created (as UTC) |  [optional]
**lastModifiedDate** | [**OffsetDateTime**](OffsetDateTime.md) | The last date the deposit account was updated (as UTC) |  [optional]
**id** | **String** | The id of the deposit account, can be generated and customized, unique |  [optional]
**name** | **String** | The name of the deposit account | 
**notes** | **String** | Extra notes about this deposit account |  [optional]
**accountHolderType** | [**AccountHolderTypeEnum**](#AccountHolderTypeEnum) | The type of the account holder (i.e CLIENT or GROUP) | 
**accountHolderKey** | **String** | The encodedKey of the client or group (a.k.a account holder) | 
**accountState** | [**AccountStateEnum**](#AccountStateEnum) | The state of the deposit account |  [optional]
**productTypeKey** | **String** | The key to the type of product that this account is based on | 
**accountType** | [**AccountTypeEnum**](#AccountTypeEnum) | Indicates the type of the deposit account and the product that it belongs to |  [optional]
**creditArrangementKey** | **String** | The key to the credit arrangement where this account is registered to |  [optional]
**approvedDate** | [**OffsetDateTime**](OffsetDateTime.md) | The date this deposit account was approved (as Organization Time) |  [optional]
**activationDate** | [**OffsetDateTime**](OffsetDateTime.md) | The date this deposit account was activated (as Organization Time) |  [optional]
**lockedDate** | [**OffsetDateTime**](OffsetDateTime.md) | The date this deposit account was locked (as Organization Time) |  [optional]
**maturityDate** | [**OffsetDateTime**](OffsetDateTime.md) | For fixed or compulsory savings plans, this is when the account matures (as Organization Time) |  [optional]
**closedDate** | [**OffsetDateTime**](OffsetDateTime.md) | The date this deposit account was closed (as UTC) |  [optional]
**lastInterestCalculationDate** | [**OffsetDateTime**](OffsetDateTime.md) | When/if the account had the interest last calculated (as Organization Time) |  [optional]
**lastInterestStoredDate** | [**OffsetDateTime**](OffsetDateTime.md) | When/if the account had last interest applied (stored to balance) (as Organization Time) |  [optional]
**lastOverdraftInterestReviewDate** | [**OffsetDateTime**](OffsetDateTime.md) | When the overdraft interest was last time reviewed |  [optional]
**lastAccountAppraisalDate** | [**OffsetDateTime**](OffsetDateTime.md) | When/if the account had last been evaluated for interest calculations/maturity (as Organization Time) |  [optional]
**lastSetToArrearsDate** | [**OffsetDateTime**](OffsetDateTime.md) | Date when the deposit account was set to In Arrears state, or null if the account is not In Arrears state (as Organization Time) |  [optional]
**currencyCode** | **String** | The currency code |  [optional]
**assignedBranchKey** | **String** | Key of the branch this deposit account is assigned to |  [optional]
**assignedCentreKey** | **String** | Key of the centre this account is assigned to |  [optional]
**assignedUserKey** | **String** | Key of the user this deposit is assigned to |  [optional]
**migrationEventKey** | **String** | The migration event encoded key associated with this deposit account. If this account was imported, track which &#39;migration event&#39; they came from. |  [optional]
**withholdingTaxSourceKey** | **String** | The tax source from where the account withholding taxes will be updated |  [optional]
**internalControls** | [**DepositAccountInternalControls**](DepositAccountInternalControls.md) | Groups all fields related to internal controls |  [optional]
**overdraftSettings** | [**DepositAccountOverdraftSettings**](DepositAccountOverdraftSettings.md) | Groups all fields related to overdraft settings |  [optional]
**interestSettings** | [**DepositAccountInterestSettings**](DepositAccountInterestSettings.md) | Groups all fields related to interest settings |  [optional]
**overdraftInterestSettings** | [**DepositAccountOverdraftInterestSettings**](DepositAccountOverdraftInterestSettings.md) | Groups all fields related to overdraft interest settings |  [optional]
**balances** | [**DepositAccountBalances**](DepositAccountBalances.md) | Groups all fields related to a deposit account&#39;s balances |  [optional]
**accruedAmounts** | [**DepositAccountAccruedAmounts**](DepositAccountAccruedAmounts.md) | Groups all fields related to a deposit account&#39;s accrued amounts |  [optional]
**linkedSettlementAccountKeys** | **List&lt;String&gt;** | Lists all loan&#39;s keys on which the deposit is used as a settlement account. |  [optional]


<a name="AccountHolderTypeEnum"></a>
## Enum: AccountHolderTypeEnum
Name | Value
---- | -----
CLIENT | &quot;CLIENT&quot;
GROUP | &quot;GROUP&quot;


<a name="AccountStateEnum"></a>
## Enum: AccountStateEnum
Name | Value
---- | -----
PENDING_APPROVAL | &quot;PENDING_APPROVAL&quot;
APPROVED | &quot;APPROVED&quot;
ACTIVE | &quot;ACTIVE&quot;
ACTIVE_IN_ARREARS | &quot;ACTIVE_IN_ARREARS&quot;
MATURED | &quot;MATURED&quot;
LOCKED | &quot;LOCKED&quot;
DORMANT | &quot;DORMANT&quot;
CLOSED | &quot;CLOSED&quot;
CLOSED_WRITTEN_OFF | &quot;CLOSED_WRITTEN_OFF&quot;
WITHDRAWN | &quot;WITHDRAWN&quot;
CLOSED_REJECTED | &quot;CLOSED_REJECTED&quot;


<a name="AccountTypeEnum"></a>
## Enum: AccountTypeEnum
Name | Value
---- | -----
CURRENT_ACCOUNT | &quot;CURRENT_ACCOUNT&quot;
REGULAR_SAVINGS | &quot;REGULAR_SAVINGS&quot;
FIXED_DEPOSIT | &quot;FIXED_DEPOSIT&quot;
SAVINGS_PLAN | &quot;SAVINGS_PLAN&quot;
INVESTOR_ACCOUNT | &quot;INVESTOR_ACCOUNT&quot;



