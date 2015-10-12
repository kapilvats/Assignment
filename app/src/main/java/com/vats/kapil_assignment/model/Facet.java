package com.vats.kapil_assignment.model;

import java.util.List;

/**
 * Created by Kapil on 10/12/2015.
 */
public class Facet {
    private String code;
    private List<FacetResultEntry> facetResultEntries;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<FacetResultEntry> getFacetResultEntries() {
        return facetResultEntries;
    }

    public void setFacetResultEntries(List<FacetResultEntry> facetResultEntries) {
        this.facetResultEntries = facetResultEntries;
    }

    @Override
    public String toString() {
        return "Facet{" +
                "code='" + code + '\'' +
                ", facetResultEntries=" + facetResultEntries +
                '}';
    }
}
