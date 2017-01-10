package com.example.helloworld.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import org.hibernate.validator.constraints.Length;

public class TensorConfiguration {
    private long id;

    @Length(max = 3)
    private String content;

    public TensorConfiguration() {
        // Jackson deserialization
    }

    public TensorConfiguration(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("content", content)
                .toString();
    }
}
