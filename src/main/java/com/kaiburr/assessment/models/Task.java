package com.kaiburr.assessment.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
public class Task {
    private String name;
    private String id;
    private String assignee;
    private String project;
    private String startTime;
    private String arunGovindProperty;

    public Task() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getArunGovindProperty() {
        return arunGovindProperty;
    }

    public void setArunGovindProperty(String property) {
        this.arunGovindProperty = property;
    }

    @Override
    public String toString() {
        return "{" +
                "\"name\":\"" + name + '\"' +
                ", \"id\":\"" + id + '\"' +
                ", \"assignee\":\"" + assignee + '\"' +
                ", \"project\":\"" + project + '\"' +
                ", \"startTime\":\"" + startTime + '\"' +
                ", \"arunGovindProperty\":\"" + arunGovindProperty + '\"' +
                '}';
    }
}
