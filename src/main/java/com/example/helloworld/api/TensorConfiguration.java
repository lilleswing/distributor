package com.example.helloworld.api;

import com.google.common.base.MoreObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tensor_configuration")
@NamedQueries(
    {
        @NamedQuery(
            name = "com.example.helloworld.core.api.TensorConfiguration.findAll",
            query = "SELECT c FROM TensorConfiguration c"
        )
    }
)
public class TensorConfiguration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "numAtoms")
    private int numAtoms;

    @Column(name = "projectData")
    private String projectData;

    @Column(name = "results")
    private String results;

    @Column(name = "status")
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
