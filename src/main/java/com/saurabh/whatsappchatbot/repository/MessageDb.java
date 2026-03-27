package com.saurabh.whatsappchatbot.repository;


import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MessageDb {

    Map<String, String> reply = new HashMap<>();

    List<String> allMessages = new ArrayList<>();

    public MessageDb() {
        addData();
    }

    public void addData() {
        reply.put("Hi", "Hello");
        reply.put("Bye", "Goodbye");
    }

    public String getReplyFromDb(String key) {
        return reply.getOrDefault(key, "I don't understand");
    }

    public List<String> getAllMessages() {
        Set<Map.Entry<String, String>> entries = reply.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            allMessages.add(entry.getValue());
        }
        return allMessages;
    }
}
