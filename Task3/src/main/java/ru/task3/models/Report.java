package ru.task3.models;

import java.util.List;

public class Report {
    private Long id;
    private String title;
    private String value;
    private List<Value> values;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    public Report(Long id, String title, String value, List<Value> values) {
        this.id = id;
        this.title = title;
        this.value = value;
        this.values = values;
    }

    public Report() {

    }
}
