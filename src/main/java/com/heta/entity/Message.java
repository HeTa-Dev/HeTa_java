package com.heta.entity;

import lombok.Data;

@Data
public class Message {
    private int id;
    private int senderId;
    private String senderName;
    private String content;
    private int receiverId;
}
