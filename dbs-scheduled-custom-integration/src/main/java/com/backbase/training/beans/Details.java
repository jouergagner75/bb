
package com.backbase.training.beans;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "description",
    "posted",
    "completed",
    "new_balance",
    "value"
})
public class Details {

    @JsonProperty("type")
    private String type;
    @JsonProperty("description")
    private String description;
    @JsonProperty("posted")
    private String posted;
    @JsonProperty("completed")
    private String completed;
    @JsonProperty("new_balance")
    private NewBalance newBalance;
    @JsonProperty("value")
    private Value value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("posted")
    public String getPosted() {
        return posted;
    }

    @JsonProperty("posted")
    public void setPosted(String posted) {
        this.posted = posted;
    }

    @JsonProperty("completed")
    public String getCompleted() {
        return completed;
    }

    @JsonProperty("completed")
    public void setCompleted(String completed) {
        this.completed = completed;
    }

    @JsonProperty("new_balance")
    public NewBalance getNewBalance() {
        return newBalance;
    }

    @JsonProperty("new_balance")
    public void setNewBalance(NewBalance newBalance) {
        this.newBalance = newBalance;
    }

    @JsonProperty("value")
    public Value getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(Value value) {
        this.value = value;
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
        return new ToStringBuilder(this).append("type", type).append("description", description).append("posted", posted).append("completed", completed).append("newBalance", newBalance).append("value", value).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(description).append(value).append(newBalance).append(type).append(posted).append(completed).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Details) == false) {
            return false;
        }
        Details rhs = ((Details) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(description, rhs.description).append(value, rhs.value).append(newBalance, rhs.newBalance).append(type, rhs.type).append(posted, rhs.posted).append(completed, rhs.completed).isEquals();
    }

}
