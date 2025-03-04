package com.heta.service;

import com.heta.entity.Contact;
import com.heta.entity.Message;
import com.heta.entity.User;
import com.heta.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ContactService contactService;

    public void saveMessage(Message message) {
        // 保存消息
        messageRepository.insertMessage(message);

//        // 获取或创建 Contact
//        User sender = new User(); // 假设通过 UserService 获取
//        sender.setId(message.getSenderId());
//
//        User receiver = new User(); // 假设通过 UserService 获取
//        receiver.setId(message.getReceiverId());
//
//        Contact contact = contactService.getOrCreateContact(sender, receiver);
//
//        // 将消息关联到 Contact
//        contact.addMessage(message);
//        contactService.saveContact(contact);
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