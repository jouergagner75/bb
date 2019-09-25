/*
 * deposits
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

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * A card which can be associated to an account (deposit / loan). Cards consist only in card references (tokens). Card details are not stored by Mambu.
 */
@ApiModel(description = "A card which can be associated to an account (deposit / loan). Cards consist only in card references (tokens). Card details are not stored by Mambu.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-17T14:24:31.447Z")
public class Card {
    @SerializedName("referenceToken")
    private String referenceToken = null;

    public Card referenceToken(String referenceToken) {
        this.referenceToken = referenceToken;
        return this;
    }

    /**
     * The reference token of the card
     *
     * @return referenceToken
     **/
    @ApiModelProperty(required = true, value = "The reference token of the card")
    public String getReferenceToken() {
        return referenceToken;
    }

    public void setReferenceToken(String referenceToken) {
        this.referenceToken = referenceToken;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Card card = (Card) o;
        return Objects.equals(this.referenceToken, card.referenceToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(referenceToken);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Card {\n");

        sb.append("    referenceToken: ").append(toIndentedString(referenceToken)).append("\n");
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

}

