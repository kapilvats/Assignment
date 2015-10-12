package com.vats.kapil_assignment.model;

import java.util.List;

/**
 * Created by Kapil on 10/12/2015.
 */
public class ProductResponse {
    private int totalCount;
    private List<Facet> facets;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<Facet> getFacets() {
        return facets;
    }

    public void setFacets(List<Facet> facets) {
        this.facets = facets;
    }

    @Override
    public String toString() {
        return "ProductResponse{" +
                "totalCount=" + totalCount +
                ", facets=" + facets +
                '}';
    }
}
