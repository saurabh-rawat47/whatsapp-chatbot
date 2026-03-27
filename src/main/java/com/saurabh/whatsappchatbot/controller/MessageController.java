package com.saurabh.whatsappchatbot.controller;

import com.saurabh.whatsappchatbot.model.Message;
import com.saurabh.whatsappchatbot.dto.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.saurabh.whatsappchatbot.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/webhook")
public class MessageController {

    private final MessageService messageService;

    Logger logger = LoggerFactory.getLogger(MessageController.class);

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public ResponseEntity<ResponseMessage> sendMessage(@RequestBody Message message) {

        if (message.getMessage() == null) {
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseMessage("Invalid input"));
        }

        logger.info("Message: {}", message.getMessage());

        String reply = messageService.getReply(message.getMessage());

        return ResponseEntity
                .ok(new ResponseMessage(reply));
    }

    @GetMapping
    public ResponseEntity<List<String>> getAllMessages() {
        List<String> allMessages = messageService.getAllMessages();
        if (allMessages.isEmpty()) {
            return ResponseEntity
                    .noContent()
                    .build();
        }
        return ResponseEntity.ok(allMessages);
    }
}
