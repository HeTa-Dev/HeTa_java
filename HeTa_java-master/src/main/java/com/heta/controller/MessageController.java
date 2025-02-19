package com.heta.controller;

import com.heta.entity.Message;
import com.heta.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heta/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;
    @GetMapping("/history")
    public ResponseEntity<List<Message>> getHistoryMessages(
            @RequestParam("offset") int offset,
            @RequestParam("limit") int limit) {
        List<Message> messages = messageService.getAllMessage(offset, limit);
        return ResponseEntity.ok(messages);
    }

    @GetMapping("/getMessageById/{senderId}/{receiverId}/{offset}/{limit}")
    public List<Message> getMessageById(
            @PathVariable("senderId") int senderId,
            @PathVariable("receiverId") int receiverId,
            @PathVariable("offset") int offset,
            @PathVariable("limit") int limit){
        return messageService.getMessagesById(senderId, receiverId,offset,limit);
    }

    // 新增接口：获取私信消息
    @GetMapping("/getPrivateMessages/{senderId}/{receiverId}/{offset}/{limit}")
    public List<Message> getPrivateMessages(
            @PathVariable("senderId") int senderId,
            @PathVariable("receiverId") int receiverId,
            @PathVariable("offset") int offset,
            @PathVariable("limit") int limit) {
        return messageService.getPrivateMessages(senderId, receiverId, offset, limit);
    }
}