package com.capgemini.genai.clinicaldecision.controller;

import com.capgemini.genai.clinicaldecision.service.ChatGptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class DiagnosisController {

    @Autowired
    private ChatGptService chatGptService;

    @PostMapping("/suggest-diagnosis")
    public ResponseEntity<String> suggestDiagnosis(@RequestBody Map<String, String> request) {
        String prompt = request.get("prompt");
        String response = chatGptService.getChatGptResponse(prompt);
        return ResponseEntity.ok(response);
    }
}
