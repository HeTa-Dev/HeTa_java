package com.heta.entity;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class Comment {
    // 评论的唯一标识
    private int id;
    // 评论者的用户 ID
    private int userId;
    // 评论者的用户名
    private String userName;
    // 评论所属帖子的 ID
    private int postId;
    // 评论内容
    private String content;
    // 评论发布时间
    private Timestamp createdAt;
    // 评论者的头像路径
    private String avatarPath;
}