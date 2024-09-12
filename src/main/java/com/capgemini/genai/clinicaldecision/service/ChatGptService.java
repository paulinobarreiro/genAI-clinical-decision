package com.capgemini.genai.clinicaldecision.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChatGptService {

    private final WebClient webClient;

    @Autowired
    public ChatGptService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.openai.com/v1").build();
    }

    public String getChatGptResponse(String prompt) {
        String apiKey = "YOUR_API_KEY";
        Map<String, Object> request = new HashMap<>();
        request.put("prompt", prompt);
        request.put("max_tokens", 100);

        return this.webClient.post()
                .uri("/completions")
                .header("Authorization", "Bearer " + apiKey)
                .body(BodyInserters.fromValue(request))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
