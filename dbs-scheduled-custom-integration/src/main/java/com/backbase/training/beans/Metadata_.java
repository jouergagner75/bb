
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
    "narrative",
    "comments",
    "tags",
    "images",
    "where"
})
public class Metadata_ {

    @JsonProperty("narrative")
    private Object narrative;
    @JsonProperty("comments")
    private List<Object> comments = null;
    @JsonProperty("tags")
    private List<Object> tags = null;
    @JsonProperty("images")
    private List<Object> images = null;
    @JsonProperty("where")
    private Object where;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("narrative")
    public Object getNarrative() {
        return narrative;
    }

    @JsonProperty("narrative")
    public void setNarrative(Object narrative) {
        this.narrative = narrative;
    }

    @JsonProperty("comments")
    public List<Object> getComments() {
        return comments;
    }

    @JsonProperty("comments")
    public void setComments(List<Object> comments) {
        this.comments = comments;
    }

    @JsonProperty("tags")
    public List<Object> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    @JsonProperty("images")
    public List<Object> getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(List<Object> images) {
        this.images = images;
    }

    @JsonProperty("where")
    public Object getWhere() {
        return where;
    }

    @JsonProperty("where")
    public void setWhere(Object where) {
        this.where = where;
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
        return new ToStringBuilder(this).append("narrative", narrative).append("comments", comments).append("tags", tags).append("images", images).append("where", where).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(tags).append(additionalProperties).append(narrative).append(images).append(where).append(comments).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Metadata_) == false) {
            return false;
        }
        Metadata_ rhs = ((Metadata_) other);
        return new EqualsBuilder().append(tags, rhs.tags).append(additionalProperties, rhs.additionalProperties).append(narrative, rhs.narrative).append(images, rhs.images).append(where, rhs.where).append(comments, rhs.comments).isEquals();
    }

}
