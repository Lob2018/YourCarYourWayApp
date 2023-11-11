package fr.soft64.controller;

import java.time.Clock;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import fr.soft64.dto.TchatUserDto;
import fr.soft64.model.Account;
import fr.soft64.model.InputMessage;
import fr.soft64.model.OutputMessage;
import fr.soft64.service.CompteService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TchatWSController {

	/**
	 * Send a message
	 * @param inputMessage
	 * @return The WebSocket STOMP response
	 */
	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public OutputMessage message(InputMessage inputMessage) {
		return OutputMessage.builder()
				.time(Instant.now(Clock.systemDefaultZone()))
				.username(inputMessage.getUsername())
				.companyname(inputMessage.getCompanyname())
				.content(inputMessage.getContent())
				.build();
	}
}
