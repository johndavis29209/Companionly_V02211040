package com.companionly.prototype.controllers;

import com.companionly.prototype.models.Response;
import com.companionly.prototype.services.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class QuestionnaireController {

    @Autowired
    private ResponseService responseService;

    @PostMapping("/submit-responses")
    public Map<String, Object> submitResponses(@RequestBody Map<String, Object> payload,
                                               @RequestParam String username) {
        List<Map<String, Object>> responsesData = (List<Map<String, Object>>) payload.get("responses");
        int totalScore = (int) payload.get("totalScore");

        // Convert JSON data into Response objects
        List<Response> responses = responsesData.stream().map(data ->
                new Response(Long.parseLong(data.get("questionIndex").toString()),
                        (int) data.get("score"),
                        username)
        ).collect(Collectors.toList());

        // Save responses
        responseService.saveResponses(responses);

        return Map.of("status", "success", "totalScore", totalScore);
    }
}
