package com.arijeet.graphql.filter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorFilter {
    private String nameContains;

    @JsonProperty("name_contains")
    public String getNameContains(){
        return nameContains;
    }

    public void setNameContains(){
        this.nameContains = nameContains;
    }
}
