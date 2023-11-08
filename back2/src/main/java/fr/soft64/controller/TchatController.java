package fr.soft64.controller;

import java.time.Clock;
import java.time.Instant;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import fr.soft64.model.InputMessage;
import fr.soft64.model.OutputMessage;
import lombok.extern.slf4j.Slf4j;

@Controller
public class TchatController {
		@MessageMapping("/chat")
		@SendTo("/topic/messages")
		public OutputMessage message(InputMessage message) {
			System.out.println("message : "+message);
			return OutputMessage.builder().time(Instant.now(Clock.systemDefaultZone())).content(message.getContent()).build();
		}
	}
