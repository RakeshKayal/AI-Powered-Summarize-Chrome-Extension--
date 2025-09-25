package com.Ai.Summary_Assistant;

import lombok.Data;


public class ResearchRequest {
    public String content;
    public String operation;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public ResearchRequest(String content, String operation) {
        this.content = content;
        this.operation = operation;
    }

    public ResearchRequest() {
    }
}
