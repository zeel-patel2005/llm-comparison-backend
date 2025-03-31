package com.example.SpringAI;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/openai")
@CrossOrigin
public class OpenAIController {


    private OpenAiChatModel chatModel;

    public OpenAIController(OpenAiChatModel openAiChatModel){
        this.chatModel=openAiChatModel;
    }

    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message){
        String response = chatModel.call(message);
        return ResponseEntity.ok(response);
    }
}
