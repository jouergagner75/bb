
package com.backbase.training.beans;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "this_account",
    "other_account",
    "details",
    "metadata"
})
public class Transaction {

    @JsonProperty("id")
    private String id;
    @JsonProperty("this_account")
    private ThisAccount thisAccount;
    @JsonProperty("other_account")
    private OtherAccount otherAccount;
    @JsonProperty("details")
    private Details details;
    @JsonProperty("metadata")
    private Metadata_ metadata;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("this_account")
    public ThisAccount getThisAccount() {
        return thisAccount;
    }

    @JsonProperty("this_account")
    public void setThisAccount(ThisAccount thisAccount) {
        this.thisAccount = thisAccount;
    }

    @JsonProperty("other_account")
    public OtherAccount getOtherAccount() {
        return otherAccount;
    }

    @JsonProperty("other_account")
    public void setOtherAccount(OtherAccount otherAccount) {
        this.otherAccount = otherAccount;
    }

    @JsonProperty("details")
    public Details getDetails() {
        return details;
    }

    @JsonProperty("details")
    public void setDetails(Details details) {
        this.details = details;
    }

    @JsonProperty("metadata")
    public Metadata_ getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Metadata_ metadata) {
        this.metadata = metadata;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("thisAccount", thisAccount).append("otherAccount", otherAccount).append("details", details).append("metadata", metadata).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(thisAccount).append(id).append(details).append(otherAccount).append(additionalProperties).append(metadata).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Transaction) == false) {
            return false;
        }
        Transaction rhs = ((Transaction) other);
        return new EqualsBuilder().append(thisAccount, rhs.thisAccount).append(id, rhs.id).append(details, rhs.details).append(otherAccount, rhs.otherAccount).append(additionalProperties, rhs.additionalProperties).append(metadata, rhs.metadata).isEquals();
    }

}
