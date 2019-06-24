package com.backbase.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alejandro Aguirre
 * @since 24-06-2019
 **/
public class InlineResponse200Data {
    @JsonProperty("Brand")
    private List<InlineResponse200Brand> brand = new ArrayList<>();

    public List<InlineResponse200Brand> getBrand() {
        return brand;
    }

    public void setBrand(List<InlineResponse200Brand> brand) {
        this.brand = brand;
    }
}
