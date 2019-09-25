
# AuthorizationHold

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**encodedKey** | **String** | The internal ID of the authorization hold, auto generated, unique. |  [optional]
**cardToken** | **String** | The reference token of the card. |  [optional]
**externalReferenceId** | **String** | The external reference ID to be used to reference the account hold in subsequent requests. | 
**advice** | **Boolean** | Whether the given request should be accepted without balance validations. | 
**amount** | [**BigDecimal**](BigDecimal.md) | The amount of money to be held as a result of the authorization hold request. | 
**currencyCode** | **String** | The ISO currency code in which the hold was created. The amounts are stored in the base currency, but the user could have enter it in a foreign currency. |  [optional]
**cardAcceptor** | [**CardAcceptor**](CardAcceptor.md) | The card acceptor details. |  [optional]
**userTransactionTime** | **String** | The formatted time at which the user made this authorization hold. |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | The authorization hold status. |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
PENDING | &quot;PENDING&quot;
REVERSED | &quot;REVERSED&quot;
SETTLED | &quot;SETTLED&quot;
EXPIRED | &quot;EXPIRED&quot;



