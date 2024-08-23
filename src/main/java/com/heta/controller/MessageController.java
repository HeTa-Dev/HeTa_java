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

    @GetMapping("/getMessageByReceiverId/{receiverId}/{offset}/{limit}")
    public List<Message> getMessageByReceiverId(
            @PathVariable("receiverId") int receiverId,
            @PathVariable("offset") int offset,
            @PathVariable("limit") int limit){
        return messageService.getMessagesByReceiverId(receiverId,offset,limit);
    }
}