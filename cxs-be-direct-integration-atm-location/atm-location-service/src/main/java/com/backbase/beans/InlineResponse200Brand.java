package com.backbase.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Alejandro Aguirre
 **/
public class InlineResponse200Brand {
    @JsonProperty("BrandName")
    private String brandName = null;

    @JsonProperty("ATM")
    private List<InlineResponse200ATM> ATM = null;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<InlineResponse200ATM> getATM() {
        return ATM;
    }

    public void setATM(List<InlineResponse200ATM> ATM) {
        this.ATM = ATM;
    }


}
