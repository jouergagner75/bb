/*
 * clients
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v2
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.mambu.sdk.model.v2;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A person that uses the services of the bank. Clients may have associated information such as their address, custom fields or identification documents
 */
@ApiModel(description = "A person that uses the services of the bank. Clients may have associated information such as their address, custom fields or identification documents")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-17T14:40:27.775Z")
public class Client {
    @SerializedName("encodedKey")
    private String encodedKey = null;

    @SerializedName("id")
    private String id = null;
    @SerializedName("state")
    private StateEnum state = null;
    @SerializedName("creationDate")
    private OffsetDateTime creationDate = null;
    @SerializedName("lastModifiedDate")
    private OffsetDateTime lastModifiedDate = null;
    @SerializedName("activationDate")
    private OffsetDateTime activationDate = null;
    @SerializedName("approvedDate")
    private OffsetDateTime approvedDate = null;
    @SerializedName("closedDate")
    private OffsetDateTime closedDate = null;
    @SerializedName("firstName")
    private String firstName = null;
    @SerializedName("lastName")
    private String lastName = null;
    @SerializedName("middleName")
    private String middleName = null;
    @SerializedName("homePhone")
    private String homePhone = null;
    @SerializedName("mobilePhone")
    private String mobilePhone = null;
    @SerializedName("emailAddress")
    private String emailAddress = null;
    @SerializedName("preferredLanguage")
    private PreferredLanguageEnum preferredLanguage = null;
    @SerializedName("birthDate")
    private LocalDate birthDate = null;
    @SerializedName("gender")
    private GenderEnum gender = null;
    @SerializedName("notes")
    private String notes = null;
    @SerializedName("assignedBranchKey")
    private String assignedBranchKey = null;
    @SerializedName("assignedCentreKey")
    private String assignedCentreKey = null;
    @SerializedName("assignedUserKey")
    private String assignedUserKey = null;
    @SerializedName("profilePictureKey")
    private String profilePictureKey = null;
    @SerializedName("profileSignatureKey")
    private String profileSignatureKey = null;
    @SerializedName("clientRoleKey")
    private String clientRoleKey = null;
    @SerializedName("loanCycle")
    private Integer loanCycle = null;
    @SerializedName("groupLoanCycle")
    private Integer groupLoanCycle = null;
    @SerializedName("migrationEventKey")
    private String migrationEventKey = null;
    @SerializedName("groupKeys")
    private List<String> groupKeys = null;
    @SerializedName("addresses")
    private List<Address> addresses = null;
    @SerializedName("portalSettings")
    private PortalSettings portalSettings = null;
    @SerializedName("idDocuments")
    private List<IdentificationDocument> idDocuments = null;

    /**
     * The encoded key of the client, auto generated, unique
     *
     * @return encodedKey
     **/
    @ApiModelProperty(value = "The encoded key of the client, auto generated, unique")
    public String getEncodedKey() {
        return encodedKey;
    }

    public Client id(String id) {
        this.id = id;
        return this;
    }

    /**
     * The id of the client, can be generated and customized, unique
     *
     * @return id
     **/
    @ApiModelProperty(value = "The id of the client, can be generated and customized, unique")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Client state(StateEnum state) {
        this.state = state;
        return this;
    }

    /**
     * The state of a client shows his workflow status, if he is waiting approval or is rejected or blacklisted
     *
     * @return state
     **/
    @ApiModelProperty(value = "The state of a client shows his workflow status, if he is waiting approval or is rejected or blacklisted")
    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    /**
     * The date this client was created
     *
     * @return creationDate
     **/
    @ApiModelProperty(example = "2016-09-06T13:37:50+03:00", value = "The date this client was created")
    public OffsetDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * The last date this client was modified
     *
     * @return lastModifiedDate
     **/
    @ApiModelProperty(example = "2016-09-06T13:37:50+03:00", value = "The last date this client was modified")
    public OffsetDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * The date when client was set as active for the first time
     *
     * @return activationDate
     **/
    @ApiModelProperty(example = "2016-09-06T13:37:50+03:00", value = "The date when client was set as active for the first time")
    public OffsetDateTime getActivationDate() {
        return activationDate;
    }

    /**
     * date when client was approved
     *
     * @return approvedDate
     **/
    @ApiModelProperty(example = "2016-09-06T13:37:50+03:00", value = "date when client was approved")
    public OffsetDateTime getApprovedDate() {
        return approvedDate;
    }

    /**
     * date when client was closed
     *
     * @return closedDate
     **/
    @ApiModelProperty(example = "2016-09-06T13:37:50+03:00", value = "date when client was closed")
    public OffsetDateTime getClosedDate() {
        return closedDate;
    }

    public Client firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * The first name, personal name, given name or forename of the client
     *
     * @return firstName
     **/
    @ApiModelProperty(required = true, value = "The first name, personal name, given name or forename of the client")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Client lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * The last name, surname or family name of the client
     *
     * @return lastName
     **/
    @ApiModelProperty(required = true, value = "The last name, surname or family name of the client")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Client middleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    /**
     * The middle name of the client, if she/he has one
     *
     * @return middleName
     **/
    @ApiModelProperty(value = "The middle name of the client, if she/he has one")
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Client homePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    /**
     * The client&#39;s home phone number
     *
     * @return homePhone
     **/
    @ApiModelProperty(value = "The client's home phone number")
    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public Client mobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    /**
     * The client&#39;s mobile phone number
     *
     * @return mobilePhone
     **/
    @ApiModelProperty(value = "The client's mobile phone number")
    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Client emailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    /**
     * The client&#39;s email address
     *
     * @return emailAddress
     **/
    @ApiModelProperty(value = "The client's email address")
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Client preferredLanguage(PreferredLanguageEnum preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
        return this;
    }

    /**
     * The client&#39;s language of use in Mambu
     *
     * @return preferredLanguage
     **/
    @ApiModelProperty(value = "The client's language of use in Mambu")
    public PreferredLanguageEnum getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(PreferredLanguageEnum preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public Client birthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    /**
     * The date when this client was born
     *
     * @return birthDate
     **/
    @ApiModelProperty(example = "1987-04-26", value = "The date when this client was born")
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Client gender(GenderEnum gender) {
        this.gender = gender;
        return this;
    }

    /**
     * Gender of the person, male or female
     *
     * @return gender
     **/
    @ApiModelProperty(value = "Gender of the person, male or female")
    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public Client notes(String notes) {
        this.notes = notes;
        return this;
    }

    /**
     * Extra notes about this client
     *
     * @return notes
     **/
    @ApiModelProperty(value = "Extra notes about this client")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Client assignedBranchKey(String assignedBranchKey) {
        this.assignedBranchKey = assignedBranchKey;
        return this;
    }

    /**
     * Encoded key of the branch this client is assigned to
     *
     * @return assignedBranchKey
     **/
    @ApiModelProperty(value = "Encoded key of the branch this client is assigned to")
    public String getAssignedBranchKey() {
        return assignedBranchKey;
    }

    public void setAssignedBranchKey(String assignedBranchKey) {
        this.assignedBranchKey = assignedBranchKey;
    }

    public Client assignedCentreKey(String assignedCentreKey) {
        this.assignedCentreKey = assignedCentreKey;
        return this;
    }

    /**
     * Encoded key of the centre this client is assigned to
     *
     * @return assignedCentreKey
     **/
    @ApiModelProperty(value = "Encoded key of the centre this client is assigned to")
    public String getAssignedCentreKey() {
        return assignedCentreKey;
    }

    public void setAssignedCentreKey(String assignedCentreKey) {
        this.assignedCentreKey = assignedCentreKey;
    }

    public Client assignedUserKey(String assignedUserKey) {
        this.assignedUserKey = assignedUserKey;
        return this;
    }

    /**
     * Encoded key of the user this client is assigned to
     *
     * @return assignedUserKey
     **/
    @ApiModelProperty(value = "Encoded key of the user this client is assigned to")
    public String getAssignedUserKey() {
        return assignedUserKey;
    }

    public void setAssignedUserKey(String assignedUserKey) {
        this.assignedUserKey = assignedUserKey;
    }

    /**
     * Encoded key of this clients profile picture
     *
     * @return profilePictureKey
     **/
    @ApiModelProperty(value = "Encoded key of this clients profile picture")
    public String getProfilePictureKey() {
        return profilePictureKey;
    }

    /**
     * Encoded key of the users profile signature
     *
     * @return profileSignatureKey
     **/
    @ApiModelProperty(value = "Encoded key of the users profile signature")
    public String getProfileSignatureKey() {
        return profileSignatureKey;
    }

    public Client clientRoleKey(String clientRoleKey) {
        this.clientRoleKey = clientRoleKey;
        return this;
    }

    /**
     * A role which describes the intended use of a client in the system
     *
     * @return clientRoleKey
     **/
    @ApiModelProperty(value = "A role which describes the intended use of a client in the system")
    public String getClientRoleKey() {
        return clientRoleKey;
    }

    public void setClientRoleKey(String clientRoleKey) {
        this.clientRoleKey = clientRoleKey;
    }

    /**
     * Number of paid and closed (with &#39;obligations met&#39;) accounts for this client, when the closing operation is reverted, this is reduced
     *
     * @return loanCycle
     **/
    @ApiModelProperty(value = "Number of paid and closed (with 'obligations met') accounts for this client, when the closing operation is reverted, this is reduced")
    public Integer getLoanCycle() {
        return loanCycle;
    }

    /**
     * Number of paid and closed (with &#39;obligations met&#39;) accounts for this client&#39;s group, when the closing operation is reverted, this is reduced
     *
     * @return groupLoanCycle
     **/
    @ApiModelProperty(value = "Number of paid and closed (with 'obligations met') accounts for this client's group, when the closing operation is reverted, this is reduced")
    public Integer getGroupLoanCycle() {
        return groupLoanCycle;
    }

    /**
     * The migration event encoded key associated with this client.
     *
     * @return migrationEventKey
     **/
    @ApiModelProperty(value = "The migration event encoded key associated with this client.")
    public String getMigrationEventKey() {
        return migrationEventKey;
    }

    public Client groupKeys(List<String> groupKeys) {
        this.groupKeys = groupKeys;
        return this;
    }

    public Client addGroupKeysItem(String groupKeysItem) {
        if (this.groupKeys == null) {
            this.groupKeys = new ArrayList<String>();
        }
        this.groupKeys.add(groupKeysItem);
        return this;
    }

    /**
     * The groups to which this client belongs
     *
     * @return groupKeys
     **/
    @ApiModelProperty(value = "The groups to which this client belongs")
    public List<String> getGroupKeys() {
        return groupKeys;
    }

    public void setGroupKeys(List<String> groupKeys) {
        this.groupKeys = groupKeys;
    }

    public Client addresses(List<Address> addresses) {
        this.addresses = addresses;
        return this;
    }

    public Client addAddressesItem(Address addressesItem) {
        if (this.addresses == null) {
            this.addresses = new ArrayList<Address>();
        }
        this.addresses.add(addressesItem);
        return this;
    }

    /**
     * The addresses associated with this client information like street, city etc.
     *
     * @return addresses
     **/
    @ApiModelProperty(value = "The addresses associated with this client information like street, city etc.")
    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Client portalSettings(PortalSettings portalSettings) {
        this.portalSettings = portalSettings;
        return this;
    }

    /**
     * The portal settings for this client
     *
     * @return portalSettings
     **/
    @ApiModelProperty(value = "The portal settings for this client")
    public PortalSettings getPortalSettings() {
        return portalSettings;
    }

    public void setPortalSettings(PortalSettings portalSettings) {
        this.portalSettings = portalSettings;
    }

    public Client idDocuments(List<IdentificationDocument> idDocuments) {
        this.idDocuments = idDocuments;
        return this;
    }

    public Client addIdDocumentsItem(IdentificationDocument idDocumentsItem) {
        if (this.idDocuments == null) {
            this.idDocuments = new ArrayList<IdentificationDocument>();
        }
        this.idDocuments.add(idDocumentsItem);
        return this;
    }

    /**
     * The identification documents of this person
     *
     * @return idDocuments
     **/
    @ApiModelProperty(value = "The identification documents of this person")
    public List<IdentificationDocument> getIdDocuments() {
        return idDocuments;
    }

    public void setIdDocuments(List<IdentificationDocument> idDocuments) {
        this.idDocuments = idDocuments;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Client client = (Client) o;
        return Objects.equals(this.encodedKey, client.encodedKey) &&
                Objects.equals(this.id, client.id) &&
                Objects.equals(this.state, client.state) &&
                Objects.equals(this.creationDate, client.creationDate) &&
                Objects.equals(this.lastModifiedDate, client.lastModifiedDate) &&
                Objects.equals(this.activationDate, client.activationDate) &&
                Objects.equals(this.approvedDate, client.approvedDate) &&
                Objects.equals(this.closedDate, client.closedDate) &&
                Objects.equals(this.firstName, client.firstName) &&
                Objects.equals(this.lastName, client.lastName) &&
                Objects.equals(this.middleName, client.middleName) &&
                Objects.equals(this.homePhone, client.homePhone) &&
                Objects.equals(this.mobilePhone, client.mobilePhone) &&
                Objects.equals(this.emailAddress, client.emailAddress) &&
                Objects.equals(this.preferredLanguage, client.preferredLanguage) &&
                Objects.equals(this.birthDate, client.birthDate) &&
                Objects.equals(this.gender, client.gender) &&
                Objects.equals(this.notes, client.notes) &&
                Objects.equals(this.assignedBranchKey, client.assignedBranchKey) &&
                Objects.equals(this.assignedCentreKey, client.assignedCentreKey) &&
                Objects.equals(this.assignedUserKey, client.assignedUserKey) &&
                Objects.equals(this.profilePictureKey, client.profilePictureKey) &&
                Objects.equals(this.profileSignatureKey, client.profileSignatureKey) &&
                Objects.equals(this.clientRoleKey, client.clientRoleKey) &&
                Objects.equals(this.loanCycle, client.loanCycle) &&
                Objects.equals(this.groupLoanCycle, client.groupLoanCycle) &&
                Objects.equals(this.migrationEventKey, client.migrationEventKey) &&
                Objects.equals(this.groupKeys, client.groupKeys) &&
                Objects.equals(this.addresses, client.addresses) &&
                Objects.equals(this.portalSettings, client.portalSettings) &&
                Objects.equals(this.idDocuments, client.idDocuments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(encodedKey, id, state, creationDate, lastModifiedDate, activationDate, approvedDate, closedDate, firstName, lastName, middleName, homePhone, mobilePhone, emailAddress, preferredLanguage, birthDate, gender, notes, assignedBranchKey, assignedCentreKey, assignedUserKey, profilePictureKey, profileSignatureKey, clientRoleKey, loanCycle, groupLoanCycle, migrationEventKey, groupKeys, addresses, portalSettings, idDocuments);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Client {\n");

        sb.append("    encodedKey: ").append(toIndentedString(encodedKey)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
        sb.append("    lastModifiedDate: ").append(toIndentedString(lastModifiedDate)).append("\n");
        sb.append("    activationDate: ").append(toIndentedString(activationDate)).append("\n");
        sb.append("    approvedDate: ").append(toIndentedString(approvedDate)).append("\n");
        sb.append("    closedDate: ").append(toIndentedString(closedDate)).append("\n");
        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
        sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
        sb.append("    homePhone: ").append(toIndentedString(homePhone)).append("\n");
        sb.append("    mobilePhone: ").append(toIndentedString(mobilePhone)).append("\n");
        sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
        sb.append("    preferredLanguage: ").append(toIndentedString(preferredLanguage)).append("\n");
        sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
        sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
        sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
        sb.append("    assignedBranchKey: ").append(toIndentedString(assignedBranchKey)).append("\n");
        sb.append("    assignedCentreKey: ").append(toIndentedString(assignedCentreKey)).append("\n");
        sb.append("    assignedUserKey: ").append(toIndentedString(assignedUserKey)).append("\n");
        sb.append("    profilePictureKey: ").append(toIndentedString(profilePictureKey)).append("\n");
        sb.append("    profileSignatureKey: ").append(toIndentedString(profileSignatureKey)).append("\n");
        sb.append("    clientRoleKey: ").append(toIndentedString(clientRoleKey)).append("\n");
        sb.append("    loanCycle: ").append(toIndentedString(loanCycle)).append("\n");
        sb.append("    groupLoanCycle: ").append(toIndentedString(groupLoanCycle)).append("\n");
        sb.append("    migrationEventKey: ").append(toIndentedString(migrationEventKey)).append("\n");
        sb.append("    groupKeys: ").append(toIndentedString(groupKeys)).append("\n");
        sb.append("    addresses: ").append(toIndentedString(addresses)).append("\n");
        sb.append("    portalSettings: ").append(toIndentedString(portalSettings)).append("\n");
        sb.append("    idDocuments: ").append(toIndentedString(idDocuments)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    /**
     * The state of a client shows his workflow status, if he is waiting approval or is rejected or blacklisted
     */
    @JsonAdapter(StateEnum.Adapter.class)
    public enum StateEnum {
        PENDING_APPROVAL("PENDING_APPROVAL"),

        INACTIVE("INACTIVE"),

        ACTIVE("ACTIVE"),

        EXITED("EXITED"),

        BLACKLISTED("BLACKLISTED"),

        REJECTED("REJECTED");

        private String value;

        StateEnum(String value) {
            this.value = value;
        }

        public static StateEnum fromValue(String text) {
            for (StateEnum b : StateEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static class Adapter extends TypeAdapter<StateEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final StateEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public StateEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return StateEnum.fromValue(String.valueOf(value));
            }
        }
    }


    /**
     * The client&#39;s language of use in Mambu
     */
    @JsonAdapter(PreferredLanguageEnum.Adapter.class)
    public enum PreferredLanguageEnum {
        ENGLISH("ENGLISH"),

        PORTUGESE("PORTUGESE"),

        SPANISH("SPANISH"),

        RUSSIAN("RUSSIAN"),

        FRENCH("FRENCH"),

        GEORGIAN("GEORGIAN"),

        CHINESE("CHINESE"),

        INDONESIAN("INDONESIAN"),

        ROMANIAN("ROMANIAN"),

        BURMESE("BURMESE"),

        PHRASE("PHRASE");

        private String value;

        PreferredLanguageEnum(String value) {
            this.value = value;
        }

        public static PreferredLanguageEnum fromValue(String text) {
            for (PreferredLanguageEnum b : PreferredLanguageEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static class Adapter extends TypeAdapter<PreferredLanguageEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final PreferredLanguageEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public PreferredLanguageEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return PreferredLanguageEnum.fromValue(String.valueOf(value));
            }
        }
    }

    /**
     * Gender of the person, male or female
     */
    @JsonAdapter(GenderEnum.Adapter.class)
    public enum GenderEnum {
        MALE("MALE"),

        FEMALE("FEMALE");

        private String value;

        GenderEnum(String value) {
            this.value = value;
        }

        public static GenderEnum fromValue(String text) {
            for (GenderEnum b : GenderEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static class Adapter extends TypeAdapter<GenderEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final GenderEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public GenderEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return GenderEnum.fromValue(String.valueOf(value));
            }
        }
    }

}
