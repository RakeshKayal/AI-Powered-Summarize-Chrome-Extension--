package com.Ai.Summary_Assistant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class GeminiResponse {
    private List<Candidate> candidates;

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public GeminiResponse(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public GeminiResponse() {
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Candidate {
        private Content content;

        public Content getContent() {
            return content;
        }

        public void setContent(Content content) {
            this.content = content;
        }

        public Candidate(Content content) {
            this.content = content;
        }

        public Candidate() {
        }
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Content {
        private List<Part> parts;

        public List<Part> getParts() {
            return parts;
        }

        public void setParts(List<Part> parts) {
            this.parts = parts;
        }

        public Content(List<Part> parts) {
            this.parts = parts;
        }

        public Content() {
        }
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Part {
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Part(String text) {
            this.text = text;
        }

        public Part() {
        }
    }
}
