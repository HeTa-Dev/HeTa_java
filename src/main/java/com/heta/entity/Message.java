package com.heta.entity;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class Message {
    private Integer id;
    private Integer senderId;
    private String senderName;
    private Integer receiverId;
    private String content;
    private Timestamp timestamp;
    private String senderAvatarPath;
}