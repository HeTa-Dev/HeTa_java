package com.heta.entity;

import lombok.Data;

import java.util.List;

@Data
public class PostView {
    private int id;
    private int userId;
    private String userName;
    private String userType;
    private String title;
    private String text;
    private String coverImagePath;
    private List<String> imagePathList;
    private int coverHeight;
    private int coverWidth;
    private int likeCount;
    private int dislikeCount;
    private boolean reported;
    private List<Comment> comments;
}
