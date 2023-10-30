package fr.soft64.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.soft64.configuration.Configuration;

@RestController
public class CompteServiceController {
	   @Autowired
	    Configuration configuration;

	    @GetMapping("/endpoint")
	    public String retrieveLimits(){
	        return configuration.getTokenExpirationMsec();
	    }
}
