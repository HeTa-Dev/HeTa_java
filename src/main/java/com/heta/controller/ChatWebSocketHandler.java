package com.heta.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heta.entity.Message;
import com.heta.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ChatWebSocketHandler extends TextWebSocketHandler {

    @Autowired
    private MessageService messageService;

    private final List<WebSocketSession> sessions = new ArrayList<>();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 解析消息
        Map<String, Object> receivedMessage = objectMapper.readValue(message.getPayload(), Map.class);
        Message chatMessage = objectMapper.convertValue(receivedMessage, Message.class);
        // 将消息存入MySQL
        System.out.println(chatMessage.toString());
        messageService.saveMessage(chatMessage);
        // 将消息格式化为JSON
        String formattedMessage = objectMapper.writeValueAsString(chatMessage);
        // 将消息发送给所有连接的客户端
        for (WebSocketSession webSocketSession : sessions) {
            webSocketSession.sendMessage(new TextMessage(formattedMessage));
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
    }
}