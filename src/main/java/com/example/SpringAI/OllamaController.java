package com.example.SpringAI;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ollama")
@CrossOrigin
public class OllamaController {

    private ChatClient chatModel;

    public OllamaController(OllamaChatModel openAiChatModel){
        this.chatModel= ChatClient.create(openAiChatModel);
    }

    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message){
        ChatResponse chatResponse = chatModel.prompt(message).call().chatResponse();

        String response = chatResponse.getResult().getOutput().getText();
        return ResponseEntity.ok(response);
    }
}


