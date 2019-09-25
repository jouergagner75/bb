
# Document

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**encodedKey** | **String** | The document encodedKey |  [optional]
**id** | **Long** | The document id | 
**creationDate** | [**OffsetDateTime**](OffsetDateTime.md) | The creation date of the document, stored as UTC |  [optional]
**lastModifiedDate** | [**OffsetDateTime**](OffsetDateTime.md) | The last modified date of the document, stored as UTC |  [optional]
**ownerKey** | **String** | Represents the holder of this document. If null, means nobody is the owner of this document |  [optional]
**ownerType** | [**OwnerTypeEnum**](#OwnerTypeEnum) | Determines the owner type of the document |  [optional]
**name** | **String** | The name of the document | 
**type** | **String** | The extension of the document | 
**fileSize** | **Long** | The file size of the document |  [optional]
**fileName** | **String** | The original file name of the document |  [optional]
**location** | **String** | Location where the document can be found, eg /myfiles/mypicture.jpeg |  [optional]
**notes** | **String** | Detailed notes about the document |  [optional]


<a name="OwnerTypeEnum"></a>
## Enum: OwnerTypeEnum
Name | Value
---- | -----
CLIENT | &quot;CLIENT&quot;
GROUP | &quot;GROUP&quot;
LOAN_PRODUCT | &quot;LOAN_PRODUCT&quot;
SAVINGS_PRODUCT | &quot;SAVINGS_PRODUCT&quot;
CENTRE | &quot;CENTRE&quot;
BRANCH | &quot;BRANCH&quot;
USER | &quot;USER&quot;
LOAN_ACCOUNT | &quot;LOAN_ACCOUNT&quot;
DEPOSIT_ACCOUNT | &quot;DEPOSIT_ACCOUNT&quot;
ID_DOCUMENT | &quot;ID_DOCUMENT&quot;
LINE_OF_CREDIT | &quot;LINE_OF_CREDIT&quot;
GL_JOURNAL_ENTRY | &quot;GL_JOURNAL_ENTRY&quot;



