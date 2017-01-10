package com.example.helloworld.api;

import com.google.common.base.MoreObjects;

public class TensorConfiguration {
    private long id;
    private int numAtoms;
    private String projectData;
    private String results;
    private String status;

    public TensorConfiguration() {
        this.status = "NOT_STARTED";
    }

    public TensorConfiguration(long id,
                               int numAtoms,
                               String projectData,
                               String results,
                               String status) {
        this.id = id;
        this.numAtoms = numAtoms;
        this.projectData = projectData;
        this.results = results;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumAtoms() {
        return numAtoms;
    }

    public void setNumAtoms(int numAtoms) {
        this.numAtoms = numAtoms;
    }

    public String getProjectData() {
        return projectData;
    }

    public void setProjectData(String projectData) {
        this.projectData = projectData;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("numAtoms", numAtoms)
                .add("projectData", projectData)
                .add("results", results)
                .add("status", status)
                .toString();
    }
}
