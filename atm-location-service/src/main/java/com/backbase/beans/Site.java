package com.backbase.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Alejandro Aguirre
 **/
public class Site {
    @JsonProperty("Name")
    private String name = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
