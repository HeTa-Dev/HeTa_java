package com.heta.service;

import com.heta.entity.Message;
import com.heta.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public void saveMessage(Message message) {
        messageRepository.insertMessage(message);
    }

    public List<Message> getMessagesById(int senderId, int receiverId, int offset, int limit) {
        return messageRepository.getMessagesById(senderId, receiverId, offset, limit);
    }

    public List<Message> getAllMessage(int offset, int limit){
        return messageRepository.getAllMessage(offset,limit);
    }

    // 新增方法：获取私信消息
    public List<Message> getPrivateMessages(int senderId, int receiverId, int offset, int limit) {
        return messageRepository.getPrivateMessages(senderId, receiverId, offset, limit);
    }
}