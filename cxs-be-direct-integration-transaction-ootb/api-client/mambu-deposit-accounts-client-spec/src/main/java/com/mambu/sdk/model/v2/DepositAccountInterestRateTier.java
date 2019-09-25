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

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Used or TIERED interest rates, holds the values to define how the interest is computed
 */
@ApiModel(description = "Used or TIERED interest rates, holds the values to define how the interest is computed")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-17T14:24:31.447Z")
public class DepositAccountInterestRateTier {
    @SerializedName("encodedKey")
    private String encodedKey = null;

    @SerializedName("endingBalance")
    private BigDecimal endingBalance = null;

    @SerializedName("interestRate")
    private BigDecimal interestRate = null;

    @SerializedName("endingDay")
    private Integer endingDay = null;

    /**
     * The encoded key of the interest rate tier, auto generated, unique
     *
     * @return encodedKey
     **/
    @ApiModelProperty(value = "The encoded key of the interest rate tier, auto generated, unique")
    public String getEncodedKey() {
        return encodedKey;
    }

    public DepositAccountInterestRateTier endingBalance(BigDecimal endingBalance) {
        this.endingBalance = endingBalance;
        return this;
    }

    /**
     * The top-limit value for the account balance in order to determine if this tier is used or not
     *
     * @return endingBalance
     **/
    @ApiModelProperty(required = true, value = "The top-limit value for the account balance in order to determine if this tier is used or not")
    public BigDecimal getEndingBalance() {
        return endingBalance;
    }

    public void setEndingBalance(BigDecimal endingBalance) {
        this.endingBalance = endingBalance;
    }

    public DepositAccountInterestRateTier interestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
        return this;
    }

    /**
     * The rate used for computing the interest for an account which has the balance less than the ending balance
     *
     * @return interestRate
     **/
    @ApiModelProperty(required = true, value = "The rate used for computing the interest for an account which has the balance less than the ending balance")
    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public DepositAccountInterestRateTier endingDay(Integer endingDay) {
        this.endingDay = endingDay;
        return this;
    }

    /**
     * The top-limit value for the account period since activation in order to determine if this tier is used or not
     *
     * @return endingDay
     **/
    @ApiModelProperty(value = "The top-limit value for the account period since activation in order to determine if this tier is used or not")
    public Integer getEndingDay() {
        return endingDay;
    }

    public void setEndingDay(Integer endingDay) {
        this.endingDay = endingDay;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DepositAccountInterestRateTier depositAccountInterestRateTier = (DepositAccountInterestRateTier) o;
        return Objects.equals(this.encodedKey, depositAccountInterestRateTier.encodedKey) &&
                Objects.equals(this.endingBalance, depositAccountInterestRateTier.endingBalance) &&
                Objects.equals(this.interestRate, depositAccountInterestRateTier.interestRate) &&
                Objects.equals(this.endingDay, depositAccountInterestRateTier.endingDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(encodedKey, endingBalance, interestRate, endingDay);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DepositAccountInterestRateTier {\n");

        sb.append("    encodedKey: ").append(toIndentedString(encodedKey)).append("\n");
        sb.append("    endingBalance: ").append(toIndentedString(endingBalance)).append("\n");
        sb.append("    interestRate: ").append(toIndentedString(interestRate)).append("\n");
        sb.append("    endingDay: ").append(toIndentedString(endingDay)).append("\n");
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

