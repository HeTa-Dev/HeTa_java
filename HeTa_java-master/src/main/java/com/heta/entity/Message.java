package com.heta.entity;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class Message {
    private int id;
    private int senderId;
    private String senderName;
    private int receiverId;
    private String content;
    private Timestamp timestamp;
    private String senderAvatarPath;
}