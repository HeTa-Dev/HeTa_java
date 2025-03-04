package com.heta.entity;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class Contact {
    private int id;
    private int chatter1_id;
    private int chatter2_id;
    private String chatter1_username;
    private String chatter2_username;
    private String chatter1_avatarPath;
    private String chatter2_avatarPath;
}