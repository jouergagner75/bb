
package com.backbase.training.beans;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "public_alias",
    "private_alias",
    "more_info",
    "URL",
    "image_URL",
    "open_corporates_URL",
    "corporate_location",
    "physical_location"
})
public class Metadata {

    @JsonProperty("public_alias")
    private Object publicAlias;
    @JsonProperty("private_alias")
    private Object privateAlias;
    @JsonProperty("more_info")
    private Object moreInfo;
    @JsonProperty("URL")
    private Object uRL;
    @JsonProperty("image_URL")
    private Object imageURL;
    @JsonProperty("open_corporates_URL")
    private Object openCorporatesURL;
    @JsonProperty("corporate_location")
    private Object corporateLocation;
    @JsonProperty("physical_location")
    private Object physicalLocation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("public_alias")
    public Object getPublicAlias() {
        return publicAlias;
    }

    @JsonProperty("public_alias")
    public void setPublicAlias(Object publicAlias) {
        this.publicAlias = publicAlias;
    }

    @JsonProperty("private_alias")
    public Object getPrivateAlias() {
        return privateAlias;
    }

    @JsonProperty("private_alias")
    public void setPrivateAlias(Object privateAlias) {
        this.privateAlias = privateAlias;
    }

    @JsonProperty("more_info")
    public Object getMoreInfo() {
        return moreInfo;
    }

    @JsonProperty("more_info")
    public void setMoreInfo(Object moreInfo) {
        this.moreInfo = moreInfo;
    }

    @JsonProperty("URL")
    public Object getURL() {
        return uRL;
    }

    @JsonProperty("URL")
    public void setURL(Object uRL) {
        this.uRL = uRL;
    }

    @JsonProperty("image_URL")
    public Object getImageURL() {
        return imageURL;
    }

    @JsonProperty("image_URL")
    public void setImageURL(Object imageURL) {
        this.imageURL = imageURL;
    }

    @JsonProperty("open_corporates_URL")
    public Object getOpenCorporatesURL() {
        return openCorporatesURL;
    }

    @JsonProperty("open_corporates_URL")
    public void setOpenCorporatesURL(Object openCorporatesURL) {
        this.openCorporatesURL = openCorporatesURL;
    }

    @JsonProperty("corporate_location")
    public Object getCorporateLocation() {
        return corporateLocation;
    }

    @JsonProperty("corporate_location")
    public void setCorporateLocation(Object corporateLocation) {
        this.corporateLocation = corporateLocation;
    }

    @JsonProperty("physical_location")
    public Object getPhysicalLocation() {
        return physicalLocation;
    }

    @JsonProperty("physical_location")
    public void setPhysicalLocation(Object physicalLocation) {
        this.physicalLocation = physicalLocation;
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
        return new ToStringBuilder(this).append("publicAlias", publicAlias).append("privateAlias", privateAlias).append("moreInfo", moreInfo).append("uRL", uRL).append("imageURL", imageURL).append("openCorporatesURL", openCorporatesURL).append("corporateLocation", corporateLocation).append("physicalLocation", physicalLocation).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(openCorporatesURL).append(publicAlias).append(additionalProperties).append(uRL).append(privateAlias).append(corporateLocation).append(moreInfo).append(imageURL).append(physicalLocation).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Metadata) == false) {
            return false;
        }
        Metadata rhs = ((Metadata) other);
        return new EqualsBuilder().append(openCorporatesURL, rhs.openCorporatesURL).append(publicAlias, rhs.publicAlias).append(additionalProperties, rhs.additionalProperties).append(uRL, rhs.uRL).append(privateAlias, rhs.privateAlias).append(corporateLocation, rhs.corporateLocation).append(moreInfo, rhs.moreInfo).append(imageURL, rhs.imageURL).append(physicalLocation, rhs.physicalLocation).isEquals();
    }

}
