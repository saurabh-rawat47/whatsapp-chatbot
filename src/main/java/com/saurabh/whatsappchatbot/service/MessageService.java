package com.saurabh.whatsappchatbot.service;

import org.springframework.stereotype.Service;
import com.saurabh.whatsappchatbot.repository.MessageDb;

import java.util.List;

@Service
public class MessageService {

    private final MessageDb messageDb;

    public MessageService(MessageDb messageDb) {
        this.messageDb = messageDb;
    }

    public String getReply(String message) {
        return messageDb.getReplyFromDb(message);
    }


    public List<String> getAllMessages() {
        return messageDb.getAllMessages();
    }
}
