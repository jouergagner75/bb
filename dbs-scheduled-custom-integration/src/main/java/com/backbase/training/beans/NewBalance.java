
package com.backbase.training.beans;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "currency",
    "amount"
})
public class NewBalance {

    @JsonProperty("currency")
    private String currency;
    @JsonProperty("amount")
    private Object amount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("amount")
    public Object getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Object amount) {
        this.amount = amount;
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
        return new ToStringBuilder(this).append("currency", currency).append("amount", amount).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(amount).append(additionalProperties).append(currency).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NewBalance) == false) {
            return false;
        }
        NewBalance rhs = ((NewBalance) other);
        return new EqualsBuilder().append(amount, rhs.amount).append(additionalProperties, rhs.additionalProperties).append(currency, rhs.currency).isEquals();
    }

}
