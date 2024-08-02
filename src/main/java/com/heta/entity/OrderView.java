package com.heta.entity;

import lombok.Data;

import java.util.List;

@Data
public class OrderView {
    private int id;
    private int sellerId;
    private String sellerName;
    private String title;
    private String text;
    private double price;
    private String coverImagePath;
    private List<String> imagePathList;
    private List<String> tagList;
}
