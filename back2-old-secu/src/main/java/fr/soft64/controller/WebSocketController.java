package fr.soft64.controller;

import java.security.Principal;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import fr.soft64.dto.TchatMessageDto;


@Controller
public class WebSocketController {


    @MessageMapping("/chat")
    public void processMessage(@Payload String chatMessage) {
        var chatId = 1;      
    }


}
