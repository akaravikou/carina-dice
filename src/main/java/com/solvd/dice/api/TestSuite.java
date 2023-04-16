package com.solvd.dice.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public final class TestSuite {
    public final Integer id;
    public final String title;
    public final TestCase[] testCases;

    @JsonCreator
    public TestSuite(@JsonProperty("id") Integer id,@JsonProperty("title") String title,@JsonProperty("childTestCases") TestCase[] testCases) {
        this.id = id;
        this.title = title;
        this.testCases = testCases;
    }
}