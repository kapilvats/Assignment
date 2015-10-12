package com.vats.kapil_assignment.model;

/**
 * Created by Kapil on 10/12/2015.
 */
public class FacetResultEntry {
    private String term;
    private int count;

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "FacetResultEntry{" +
                "term='" + term + '\'' +
                ", count=" + count +
                '}';
    }
}
