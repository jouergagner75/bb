
package com.backbase.training.beans;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "holders",
    "number",
    "kind",
    "IBAN",
    "swift_bic",
    "bank"
})
public class ThisAccount {

    @JsonProperty("id")
    private String id;
    @JsonProperty("holders")
    private List<Holder> holders = null;
    @JsonProperty("number")
    private String number;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("IBAN")
    private Object iBAN;
    @JsonProperty("swift_bic")
    private Object swiftBic;
    @JsonProperty("bank")
    private Bank bank;
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

    @JsonProperty("holders")
    public List<Holder> getHolders() {
        return holders;
    }

    @JsonProperty("holders")
    public void setHolders(List<Holder> holders) {
        this.holders = holders;
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
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
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
    public Bank getBank() {
        return bank;
    }

    @JsonProperty("bank")
    public void setBank(Bank bank) {
        this.bank = bank;
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
        return new ToStringBuilder(this).append("id", id).append("holders", holders).append("number", number).append("kind", kind).append("iBAN", iBAN).append("swiftBic", swiftBic).append("bank", bank).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(swiftBic).append(id).append(iBAN).append(holders).append(additionalProperties).append(bank).append(number).append(kind).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ThisAccount) == false) {
            return false;
        }
        ThisAccount rhs = ((ThisAccount) other);
        return new EqualsBuilder().append(swiftBic, rhs.swiftBic).append(id, rhs.id).append(iBAN, rhs.iBAN).append(holders, rhs.holders).append(additionalProperties, rhs.additionalProperties).append(bank, rhs.bank).append(number, rhs.number).append(kind, rhs.kind).isEquals();
    }

}
