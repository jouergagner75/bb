
package com.backbase.training.beans;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "is_alias"
})
public class Holder_ {

    @JsonProperty("name")
    private String name;
    @JsonProperty("is_alias")
    private Boolean isAlias;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("is_alias")
    public Boolean getIsAlias() {
        return isAlias;
    }

    @JsonProperty("is_alias")
    public void setIsAlias(Boolean isAlias) {
        this.isAlias = isAlias;
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
        return new ToStringBuilder(this).append("name", name).append("isAlias", isAlias).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(name).append(isAlias).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Holder_) == false) {
            return false;
        }
        Holder_ rhs = ((Holder_) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(name, rhs.name).append(isAlias, rhs.isAlias).isEquals();
    }

}
