package com.example.SpringAI;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/openai")
@CrossOrigin
public class OpenAIController {


    private ChatClient chatModel;

    public OpenAIController(OpenAiChatModel openAiChatModel){
        this.chatModel= ChatClient.create(openAiChatModel);
    }

    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message){
        String response = chatModel.prompt(message).call().content();
        return ResponseEntity.ok(response);
    }
}
