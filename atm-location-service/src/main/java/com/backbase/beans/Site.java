package com.backbase.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Alejandro Aguirre
 * @since 24-06-2019
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
