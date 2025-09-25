package com.Ai.Summary_Assistant;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;
import java.util.Objects;

@Service
public class ResearchService {

    @Value("${gemini.api.url}")
    String url;

    @Value("${gemini.api.key}")
    String  key;

    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    public ResearchService(WebClient.Builder webClientBuilder, ObjectMapper objectMapper) {
        this.webClient = webClientBuilder.build();
        this.objectMapper = objectMapper;
    }

    public  String  ProcessContent(ResearchRequest request){

        //build the  prompt
         String prompt= buildPrompt(request);

         //Query For Ai

        Map<String , Object> requestBody= Map.of(
                "contents", new Object[]{
                        Map.of(
                                "parts", new Object[]{

                                        Map.of("text",prompt)
                                }
                        )
                }

        );

        //call the api

        String response = webClient.post().uri(url + key).bodyValue(requestBody).retrieve()
                .bodyToMono(String.class)
                .block();
        return  extractResponse(response);

    }

    private String extractResponse(String response) {

        try {
            GeminiResponse geminiResponse = objectMapper.readValue(response, GeminiResponse.class);
            if (geminiResponse.getCandidates() != null && !geminiResponse.getCandidates().isEmpty()) {
                GeminiResponse.Candidate firstCandidate = geminiResponse.getCandidates().get(0);
                if (firstCandidate.getContent() != null &&
                        firstCandidate.getContent().getParts() != null &&
                        !firstCandidate.getContent().getParts().isEmpty()) {
                    return firstCandidate.getContent().getParts().get(0).getText();
                }
            }
            return "No content found in response";
        } catch (Exception e) {
            return "Error Parsing: " + e.getMessage();
        }
    }


    private String buildPrompt(ResearchRequest request) {

        StringBuilder prompt= new StringBuilder();

        switch (request.getOperation()){

            case "summarize":
                prompt.append("Provide a clear and concise summary of the following text in a few sentences with bullet point :\n\n");
                break;
            case "suggest":
                prompt.append("Based on the following content: suggest related topics and further reading. Format the response with clear headings and bullet points:\n\n");
                break;
            default:
                throw new IllegalArgumentException("Unknown Operation: " + request.getOperation());
        }
        prompt.append(request.getContent());
return  prompt.toString();


    }
}
