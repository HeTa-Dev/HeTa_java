package com.heta.repo;

import com.heta.entity.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MessageRepository {
    void insertMessage(Message message);
    List<Message> getMessagesById(int senderId,int receiverId,int offset,int limit);
    List<Message> getAllMessage(int offset,int limit);
    // 新增方法：查询私信消息
    List<Message> getPrivateMessages(int senderId, int receiverId, int offset, int limit);
}