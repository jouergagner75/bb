
# IdentificationDocument

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**encodedKey** | **String** | The encoded key of the document, generated, unique |  [optional]
**clientKey** | **String** | The encoded key of the client that owns this document |  [optional]
**documentType** | **String** | The type of the document, Passport, Id card Drivers license, etc. | 
**documentId** | **String** | The id of the document | 
**issuingAuthority** | **String** | Authority that issued the document, eg. Police |  [optional]
**validUntil** | [**LocalDate**](LocalDate.md) | Date when the validity of the document ends |  [optional]
**indexInList** | **Integer** | This document&#39;s index in the list of documents |  [optional]
**identificationDocumentTemplateKey** | **String** | Encoded key of the template used for this document |  [optional]
**attachments** | [**List&lt;Document&gt;**](Document.md) | A list containing information about the attached files for this document |  [optional]



