package com.saurabh.whatsappchatbot.dto;

public class ResponseMessage {
    private final String reply;

    public ResponseMessage(String reply) {
        this.reply = reply;
    }

    public String getReply() {
        return reply;
    }
}
