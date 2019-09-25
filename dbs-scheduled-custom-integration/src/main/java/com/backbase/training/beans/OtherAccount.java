
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
    "holder",
    "number",
    "kind",
    "IBAN",
    "swift_bic",
    "bank",
    "metadata"
})
public class OtherAccount {

    @JsonProperty("id")
    private String id;
    @JsonProperty("holder")
    private Holder_ holder;
    @JsonProperty("number")
    private String number;
    @JsonProperty("kind")
    private Object kind;
    @JsonProperty("IBAN")
    private Object iBAN;
    @JsonProperty("swift_bic")
    private Object swiftBic;
    @JsonProperty("bank")
    private Bank_ bank;
    @JsonProperty("metadata")
    private Metadata metadata;
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

    @JsonProperty("holder")
    public Holder_ getHolder() {
        return holder;
    }

    @JsonProperty("holder")
    public void setHolder(Holder_ holder) {
        this.holder = holder;
    }

    @JsonProperty("number")
    public String getNumber() {
        return number;
    }

    @JsonProperty("number")
    public void setNumber(String number) {
        this.number = number;
    }

    @JsonProperty("kind")
    public Object getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(Object kind) {
        this.kind = kind;
    }

    @JsonProperty("IBAN")
    public Object getIBAN() {
        return iBAN;
    }

    @JsonProperty("IBAN")
    public void setIBAN(Object iBAN) {
        this.iBAN = iBAN;
    }

    @JsonProperty("swift_bic")
    public Object getSwiftBic() {
        return swiftBic;
    }

    @JsonProperty("swift_bic")
    public void setSwiftBic(Object swiftBic) {
        this.swiftBic = swiftBic;
    }

    @JsonProperty("bank")
    public Bank_ getBank() {
        return bank;
    }

    @JsonProperty("bank")
    public void setBank(Bank_ bank) {
        this.bank = bank;
    }

    @JsonProperty("metadata")
    public Metadata getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Metadata metadata) {
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
        return new ToStringBuilder(this).append("id", id).append("holder", holder).append("number", number).append("kind", kind).append("iBAN", iBAN).append("swiftBic", swiftBic).append("bank", bank).append("metadata", metadata).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(swiftBic).append(id).append(holder).append(iBAN).append(additionalProperties).append(bank).append(number).append(kind).append(metadata).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OtherAccount) == false) {
            return false;
        }
        OtherAccount rhs = ((OtherAccount) other);
        return new EqualsBuilder().append(swiftBic, rhs.swiftBic).append(id, rhs.id).append(holder, rhs.holder).append(iBAN, rhs.iBAN).append(additionalProperties, rhs.additionalProperties).append(bank, rhs.bank).append(number, rhs.number).append(kind, rhs.kind).append(metadata, rhs.metadata).isEquals();
    }

}
