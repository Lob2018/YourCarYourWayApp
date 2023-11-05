package fr.soft64.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tchat")
public class TchatServiceController {

	@GetMapping("")
	public String retrieveLimits() {
		return "OK";
	}
}