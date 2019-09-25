# DepositAccountsApi

All URIs are relative to *https://localhost:8889/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**changeState**](DepositAccountsApi.md#changeState) | **POST** /deposits/{depositAccountId}:changeState | Allows posting an action such as approve deposit account
[**create**](DepositAccountsApi.md#create) | **POST** /deposits | Creates a new deposit account
[**createCard**](DepositAccountsApi.md#createCard) | **POST** /deposits/{depositAccountId}/cards | Create and associate a new card to the provided account
[**delete**](DepositAccountsApi.md#delete) | **DELETE** /deposits/{depositAccountId} | Delete an inactive deposit account via id or encoded key
[**deleteCard**](DepositAccountsApi.md#deleteCard) | **DELETE** /deposits/{depositAccountId}/cards/{cardReferenceToken} | Delete a card associated to the provided account via its reference token
[**getAll**](DepositAccountsApi.md#getAll) | **GET** /deposits | Allows retrieval of deposit accounts using various query parameters. It&#39;s possible to look up deposits by their state, branch, centre or by a credit officer to which the deposits are assigned.
[**getAllAuthorizationHolds**](DepositAccountsApi.md#getAllAuthorizationHolds) | **GET** /deposits/{depositAccountId}/authorizationholds | Retrieves the authorization holds related to a deposit account, ordered from newest to oldest by creation date
[**getAllCards**](DepositAccountsApi.md#getAllCards) | **GET** /deposits/{depositAccountId}/cards | Allows retrieval of all cards associated with the account
[**getById**](DepositAccountsApi.md#getById) | **GET** /deposits/{depositAccountId} | Allows retrieval of a single deposit account via id or encoded key
[**patch**](DepositAccountsApi.md#patch) | **PATCH** /deposits/{depositAccountId} | Partially update a deposit account
[**update**](DepositAccountsApi.md#update) | **PUT** /deposits/{depositAccountId} | Update an existing deposit account


<a name="changeState"></a>
# **changeState**
> DepositAccount changeState(depositAccountId, body, idempotencyKey)

Allows posting an action such as approve deposit account



### Example
```java
// Import classes:
//import com.mambu.sdk.api.ApiClient;
//import com.mambu.sdk.api.ApiException;
//import com.mambu.sdk.api.Configuration;
//import com.mambu.sdk.api.auth.*;
//import com.mambu.sdk.api.v2.DepositAccountsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basic
HttpBasicAuth basic = (HttpBasicAuth) defaultClient.getAuthentication("basic");
basic.setUsername("YOUR USERNAME");
basic.setPassword("YOUR PASSWORD");

DepositAccountsApi apiInstance = new DepositAccountsApi();
String depositAccountId = "depositAccountId_example"; // String | The id or encoded key of the deposit account
DepositAccountAction body = new DepositAccountAction(); // DepositAccountAction | Allows specifying the action details for a deposit account
String idempotencyKey = "idempotencyKey_example"; // String | Key that can be used to support idempotency on this POST. Must be a valid UUID(version 4 is recommended) string and can only be used with the exact same request. Can be used in retry mechanisms to prevent double posting.
try {
    DepositAccount result = apiInstance.changeState(depositAccountId, body, idempotencyKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DepositAccountsApi#changeState");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **depositAccountId** | **String**| The id or encoded key of the deposit account |
 **body** | [**DepositAccountAction**](DepositAccountAction.md)| Allows specifying the action details for a deposit account |
 **idempotencyKey** | **String**| Key that can be used to support idempotency on this POST. Must be a valid UUID(version 4 is recommended) string and can only be used with the exact same request. Can be used in retry mechanisms to prevent double posting. | [optional]

### Return type

[**DepositAccount**](DepositAccount.md)

### Authorization

[basic](../README.md#basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/vnd.mambu.v2+json

<a name="create"></a>
# **create**
> DepositAccount create(body, idempotencyKey)

Creates a new deposit account



### Example
```java
// Import classes:
//import com.mambu.sdk.api.ApiClient;
//import com.mambu.sdk.api.ApiException;
//import com.mambu.sdk.api.Configuration;
//import com.mambu.sdk.api.auth.*;
//import com.mambu.sdk.api.v2.DepositAccountsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basic
HttpBasicAuth basic = (HttpBasicAuth) defaultClient.getAuthentication("basic");
basic.setUsername("YOUR USERNAME");
basic.setPassword("YOUR PASSWORD");

DepositAccountsApi apiInstance = new DepositAccountsApi();
DepositAccount body = new DepositAccount(); // DepositAccount | Deposit account to be created
String idempotencyKey = "idempotencyKey_example"; // String | Key that can be used to support idempotency on this POST. Must be a valid UUID(version 4 is recommended) string and can only be used with the exact same request. Can be used in retry mechanisms to prevent double posting.
try {
    DepositAccount result = apiInstance.create(body, idempotencyKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DepositAccountsApi#create");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**DepositAccount**](DepositAccount.md)| Deposit account to be created |
 **idempotencyKey** | **String**| Key that can be used to support idempotency on this POST. Must be a valid UUID(version 4 is recommended) string and can only be used with the exact same request. Can be used in retry mechanisms to prevent double posting. | [optional]

### Return type

[**DepositAccount**](DepositAccount.md)

### Authorization

[basic](../README.md#basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/vnd.mambu.v2+json

<a name="createCard"></a>
# **createCard**
> createCard(depositAccountId, body, idempotencyKey)

Create and associate a new card to the provided account



### Example
```java
// Import classes:
//import com.mambu.sdk.api.ApiClient;
//import com.mambu.sdk.api.ApiException;
//import com.mambu.sdk.api.Configuration;
//import com.mambu.sdk.api.auth.*;
//import com.mambu.sdk.api.v2.DepositAccountsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basic
HttpBasicAuth basic = (HttpBasicAuth) defaultClient.getAuthentication("basic");
basic.setUsername("YOUR USERNAME");
basic.setPassword("YOUR PASSWORD");

DepositAccountsApi apiInstance = new DepositAccountsApi();
String depositAccountId = "depositAccountId_example"; // String | The id or encoded key of the deposit account
Card body = new Card(); // Card | Card to be created
String idempotencyKey = "idempotencyKey_example"; // String | Key that can be used to support idempotency on this POST. Must be a valid UUID(version 4 is recommended) string and can only be used with the exact same request. Can be used in retry mechanisms to prevent double posting.
try {
    apiInstance.createCard(depositAccountId, body, idempotencyKey);
} catch (ApiException e) {
    System.err.println("Exception when calling DepositAccountsApi#createCard");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **depositAccountId** | **String**| The id or encoded key of the deposit account |
 **body** | [**Card**](Card.md)| Card to be created |
 **idempotencyKey** | **String**| Key that can be used to support idempotency on this POST. Must be a valid UUID(version 4 is recommended) string and can only be used with the exact same request. Can be used in retry mechanisms to prevent double posting. | [optional]

### Return type

null (empty response body)

### Authorization

[basic](../README.md#basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/vnd.mambu.v2+json

<a name="delete"></a>
# **delete**
> delete(depositAccountId)

Delete an inactive deposit account via id or encoded key



### Example
```java
// Import classes:
//import com.mambu.sdk.api.ApiClient;
//import com.mambu.sdk.api.ApiException;
//import com.mambu.sdk.api.Configuration;
//import com.mambu.sdk.api.auth.*;
//import com.mambu.sdk.api.v2.DepositAccountsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basic
HttpBasicAuth basic = (HttpBasicAuth) defaultClient.getAuthentication("basic");
basic.setUsername("YOUR USERNAME");
basic.setPassword("YOUR PASSWORD");

DepositAccountsApi apiInstance = new DepositAccountsApi();
String depositAccountId = "depositAccountId_example"; // String | The id or encoded key of the deposit account
try {
    apiInstance.delete(depositAccountId);
} catch (ApiException e) {
    System.err.println("Exception when calling DepositAccountsApi#delete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **depositAccountId** | **String**| The id or encoded key of the deposit account |

### Return type

null (empty response body)

### Authorization

[basic](../README.md#basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/vnd.mambu.v2+json

<a name="deleteCard"></a>
# **deleteCard**
> deleteCard(depositAccountId, cardReferenceToken)

Delete a card associated to the provided account via its reference token



### Example
```java
// Import classes:
//import com.mambu.sdk.api.ApiClient;
//import com.mambu.sdk.api.ApiException;
//import com.mambu.sdk.api.Configuration;
//import com.mambu.sdk.api.auth.*;
//import com.mambu.sdk.api.v2.DepositAccountsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basic
HttpBasicAuth basic = (HttpBasicAuth) defaultClient.getAuthentication("basic");
basic.setUsername("YOUR USERNAME");
basic.setPassword("YOUR PASSWORD");

DepositAccountsApi apiInstance = new DepositAccountsApi();
String depositAccountId = "depositAccountId_example"; // String | The id or encoded key of the deposit account
String cardReferenceToken = "cardReferenceToken_example"; // String | Reference token of the card to be retrieved
try {
    apiInstance.deleteCard(depositAccountId, cardReferenceToken);
} catch (ApiException e) {
    System.err.println("Exception when calling DepositAccountsApi#deleteCard");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **depositAccountId** | **String**| The id or encoded key of the deposit account |
 **cardReferenceToken** | **String**| Reference token of the card to be retrieved |

### Return type

null (empty response body)

### Authorization

[basic](../README.md#basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/vnd.mambu.v2+json

<a name="getAll"></a>
# **getAll**
> List&lt;DepositAccount&gt; getAll(offset, limit, paginationDetails, detailsLevel, creditOfficerUsername, branchId, centreId, accountState, accountHolderType, accountHolderId)

Allows retrieval of deposit accounts using various query parameters. It&#39;s possible to look up deposits by their state, branch, centre or by a credit officer to which the deposits are assigned.



### Example
```java
// Import classes:
//import com.mambu.sdk.api.ApiClient;
//import com.mambu.sdk.api.ApiException;
//import com.mambu.sdk.api.Configuration;
//import com.mambu.sdk.api.auth.*;
//import com.mambu.sdk.api.v2.DepositAccountsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basic
HttpBasicAuth basic = (HttpBasicAuth) defaultClient.getAuthentication("basic");
basic.setUsername("YOUR USERNAME");
basic.setPassword("YOUR PASSWORD");

DepositAccountsApi apiInstance = new DepositAccountsApi();
Integer offset = 56; // Integer | Pagination, index to start searching at when retrieving elements, used in combination with limit to paginate results
Integer limit = 56; // Integer | Pagination, the number of elements to retrieve, used in combination with offset to paginate results
String paginationDetails = "OFF"; // String | Flag specifying whether the pagination should be enabled or not. Please note that by default it is disabled (OFF), in order to improve the performance of the APIs
String detailsLevel = "detailsLevel_example"; // String | The level of details to retrieve, FULL means the full details of the object will be retrieved (custom fields, address, contact info or any other related object), BASIC will return only the first level elements of the object
String creditOfficerUsername = "creditOfficerUsername_example"; // String | The username of the credit officer to whom the deposit accounts are assigned to
String branchId = "branchId_example"; // String | The id/encodedKey of the branch to which the deposit accounts are assigned to
String centreId = "centreId_example"; // String | The id/encodedKey of the centre to which the deposit accounts are assigned to
String accountState = "accountState_example"; // String | The state of the deposit accounts to filter on
String accountHolderType = "accountHolderType_example"; // String | The type of the account holder: CLIENT/GROUP
String accountHolderId = "accountHolderId_example"; // String | The id of the account holder
try {
    List<DepositAccount> result = apiInstance.getAll(offset, limit, paginationDetails, detailsLevel, creditOfficerUsername, branchId, centreId, accountState, accountHolderType, accountHolderId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DepositAccountsApi#getAll");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **offset** | **Integer**| Pagination, index to start searching at when retrieving elements, used in combination with limit to paginate results | [optional]
 **limit** | **Integer**| Pagination, the number of elements to retrieve, used in combination with offset to paginate results | [optional]
 **paginationDetails** | **String**| Flag specifying whether the pagination should be enabled or not. Please note that by default it is disabled (OFF), in order to improve the performance of the APIs | [optional] [default to OFF] [enum: ON, OFF]
 **detailsLevel** | **String**| The level of details to retrieve, FULL means the full details of the object will be retrieved (custom fields, address, contact info or any other related object), BASIC will return only the first level elements of the object | [optional] [enum: BASIC, FULL]
 **creditOfficerUsername** | **String**| The username of the credit officer to whom the deposit accounts are assigned to | [optional]
 **branchId** | **String**| The id/encodedKey of the branch to which the deposit accounts are assigned to | [optional]
 **centreId** | **String**| The id/encodedKey of the centre to which the deposit accounts are assigned to | [optional]
 **accountState** | **String**| The state of the deposit accounts to filter on | [optional] [enum: PENDING_APPROVAL, APPROVED, ACTIVE, ACTIVE_IN_ARREARS, MATURED, LOCKED, DORMANT, CLOSED, CLOSED_WRITTEN_OFF, WITHDRAWN, CLOSED_REJECTED]
 **accountHolderType** | **String**| The type of the account holder: CLIENT/GROUP | [optional] [enum: CLIENT, GROUP]
 **accountHolderId** | **String**| The id of the account holder | [optional]

### Return type

[**List&lt;DepositAccount&gt;**](DepositAccount.md)

### Authorization

[basic](../README.md#basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/vnd.mambu.v2+json

<a name="getAllAuthorizationHolds"></a>
# **getAllAuthorizationHolds**
> List&lt;AuthorizationHold&gt; getAllAuthorizationHolds(depositAccountId, offset, limit, paginationDetails, status)

Retrieves the authorization holds related to a deposit account, ordered from newest to oldest by creation date



### Example
```java
// Import classes:
//import com.mambu.sdk.api.ApiClient;
//import com.mambu.sdk.api.ApiException;
//import com.mambu.sdk.api.Configuration;
//import com.mambu.sdk.api.auth.*;
//import com.mambu.sdk.api.v2.DepositAccountsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basic
HttpBasicAuth basic = (HttpBasicAuth) defaultClient.getAuthentication("basic");
basic.setUsername("YOUR USERNAME");
basic.setPassword("YOUR PASSWORD");

DepositAccountsApi apiInstance = new DepositAccountsApi();
String depositAccountId = "depositAccountId_example"; // String | The id or encoded key of the deposit account
Integer offset = 56; // Integer | Pagination, index to start searching at when retrieving elements, used in combination with limit to paginate results
Integer limit = 56; // Integer | Pagination, the number of elements to retrieve, used in combination with offset to paginate results
String paginationDetails = "OFF"; // String | Flag specifying whether the pagination should be enabled or not. Please note that by default it is disabled (OFF), in order to improve the performance of the APIs
String status = "status_example"; // String | The status of the authorization holds to filter on
try {
    List<AuthorizationHold> result = apiInstance.getAllAuthorizationHolds(depositAccountId, offset, limit, paginationDetails, status);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DepositAccountsApi#getAllAuthorizationHolds");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **depositAccountId** | **String**| The id or encoded key of the deposit account |
 **offset** | **Integer**| Pagination, index to start searching at when retrieving elements, used in combination with limit to paginate results | [optional]
 **limit** | **Integer**| Pagination, the number of elements to retrieve, used in combination with offset to paginate results | [optional]
 **paginationDetails** | **String**| Flag specifying whether the pagination should be enabled or not. Please note that by default it is disabled (OFF), in order to improve the performance of the APIs | [optional] [default to OFF] [enum: ON, OFF]
 **status** | **String**| The status of the authorization holds to filter on | [optional] [enum: PENDING, REVERSED, SETTLED, EXPIRED]

### Return type

[**List&lt;AuthorizationHold&gt;**](AuthorizationHold.md)

### Authorization

[basic](../README.md#basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/vnd.mambu.v2+json

<a name="getAllCards"></a>
# **getAllCards**
> List&lt;Card&gt; getAllCards(depositAccountId)

Allows retrieval of all cards associated with the account



### Example
```java
// Import classes:
//import com.mambu.sdk.api.ApiClient;
//import com.mambu.sdk.api.ApiException;
//import com.mambu.sdk.api.Configuration;
//import com.mambu.sdk.api.auth.*;
//import com.mambu.sdk.api.v2.DepositAccountsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basic
HttpBasicAuth basic = (HttpBasicAuth) defaultClient.getAuthentication("basic");
basic.setUsername("YOUR USERNAME");
basic.setPassword("YOUR PASSWORD");

DepositAccountsApi apiInstance = new DepositAccountsApi();
String depositAccountId = "depositAccountId_example"; // String | The id or encoded key of the deposit account
try {
    List<Card> result = apiInstance.getAllCards(depositAccountId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DepositAccountsApi#getAllCards");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **depositAccountId** | **String**| The id or encoded key of the deposit account |

### Return type

[**List&lt;Card&gt;**](Card.md)

### Authorization

[basic](../README.md#basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/vnd.mambu.v2+json

<a name="getById"></a>
# **getById**
> DepositAccount getById(depositAccountId, detailsLevel)

Allows retrieval of a single deposit account via id or encoded key



### Example
```java
// Import classes:
//import com.mambu.sdk.api.ApiClient;
//import com.mambu.sdk.api.ApiException;
//import com.mambu.sdk.api.Configuration;
//import com.mambu.sdk.api.auth.*;
//import com.mambu.sdk.api.v2.DepositAccountsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basic
HttpBasicAuth basic = (HttpBasicAuth) defaultClient.getAuthentication("basic");
basic.setUsername("YOUR USERNAME");
basic.setPassword("YOUR PASSWORD");

DepositAccountsApi apiInstance = new DepositAccountsApi();
String depositAccountId = "depositAccountId_example"; // String | The id or encoded key of the deposit account
String detailsLevel = "detailsLevel_example"; // String | The level of details to retrieve, FULL means the full details of the object will be retrieved (custom fields, address, contact info or any other related object), BASIC will return only the first level elements of the object
try {
    DepositAccount result = apiInstance.getById(depositAccountId, detailsLevel);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DepositAccountsApi#getById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **depositAccountId** | **String**| The id or encoded key of the deposit account |
 **detailsLevel** | **String**| The level of details to retrieve, FULL means the full details of the object will be retrieved (custom fields, address, contact info or any other related object), BASIC will return only the first level elements of the object | [optional] [enum: BASIC, FULL]

### Return type

[**DepositAccount**](DepositAccount.md)

### Authorization

[basic](../README.md#basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/vnd.mambu.v2+json

<a name="patch"></a>
# **patch**
> patch(depositAccountId, body)

Partially update a deposit account



### Example
```java
// Import classes:
//import com.mambu.sdk.api.ApiClient;
//import com.mambu.sdk.api.ApiException;
//import com.mambu.sdk.api.Configuration;
//import com.mambu.sdk.api.auth.*;
//import com.mambu.sdk.api.v2.DepositAccountsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basic
HttpBasicAuth basic = (HttpBasicAuth) defaultClient.getAuthentication("basic");
basic.setUsername("YOUR USERNAME");
basic.setPassword("YOUR PASSWORD");

DepositAccountsApi apiInstance = new DepositAccountsApi();
String depositAccountId = "depositAccountId_example"; // String | The id or encoded key of the deposit account
List<PatchOperation> body = Arrays.asList(new PatchOperation()); // List<PatchOperation> | Patch operations to be applied to a resource
try {
    apiInstance.patch(depositAccountId, body);
} catch (ApiException e) {
    System.err.println("Exception when calling DepositAccountsApi#patch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **depositAccountId** | **String**| The id or encoded key of the deposit account |
 **body** | [**List&lt;PatchOperation&gt;**](PatchOperation.md)| Patch operations to be applied to a resource |

### Return type

null (empty response body)

### Authorization

[basic](../README.md#basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/vnd.mambu.v2+json

<a name="update"></a>
# **update**
> DepositAccount update(depositAccountId, body)

Update an existing deposit account



### Example
```java
// Import classes:
//import com.mambu.sdk.api.ApiClient;
//import com.mambu.sdk.api.ApiException;
//import com.mambu.sdk.api.Configuration;
//import com.mambu.sdk.api.auth.*;
//import com.mambu.sdk.api.v2.DepositAccountsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basic
HttpBasicAuth basic = (HttpBasicAuth) defaultClient.getAuthentication("basic");
basic.setUsername("YOUR USERNAME");
basic.setPassword("YOUR PASSWORD");

DepositAccountsApi apiInstance = new DepositAccountsApi();
String depositAccountId = "depositAccountId_example"; // String | The id or encoded key of the deposit account
DepositAccount body = new DepositAccount(); // DepositAccount | 
try {
    DepositAccount result = apiInstance.update(depositAccountId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DepositAccountsApi#update");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **depositAccountId** | **String**| The id or encoded key of the deposit account |
 **body** | [**DepositAccount**](DepositAccount.md)|  | [optional]

### Return type

[**DepositAccount**](DepositAccount.md)

### Authorization

[basic](../README.md#basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/vnd.mambu.v2+json

