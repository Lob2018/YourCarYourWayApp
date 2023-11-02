package fr.soft64.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.soft64.configuration.Configuration;
import fr.soft64.dto.AccountLoginDto;
import fr.soft64.dto.AccountRegisterDto;
import fr.soft64.model.Account;
import fr.soft64.model.User_role;
import fr.soft64.security.JwtTokenUtil;
import fr.soft64.service.CompteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/compte")
public class CompteServiceController {
	
	@Autowired
	private CompteService compteService;
	@Autowired
	private Configuration configuration;
	@Autowired
	private AuthenticationManager authenticationManager;	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private ModelMapper modelMapper;
	
	private Account convertToEntity(final AccountRegisterDto accountRegisterDto) {
		return modelMapper.map(accountRegisterDto, Account.class);
	}
	
	@GetMapping("/endpoint")
	public String retrieveLimits() {
		return configuration.getdatasourceURL();
	}	
		
	/**
	 * Register a new user
	 * 
	 * @param user  The user credentials to register
	 * @param token The corresponding token
	 * @return The HTTP response
	 * @throws MethodArgumentNotValidException Exception for invalid username
	 */
	@PostMapping("/register")
	public final ResponseEntity<Object> register(@RequestBody @Valid AccountRegisterDto accountRegistering) {
		final HashMap<String, String> map = new HashMap<>();
		try {
			final Account account = convertToEntity(accountRegistering);
			final String plainPassword = account.getAccountpassword();
			Optional<User_role> role= compteService.findByUser_role_name("USER");
			if (!role.isPresent())throw new Error();
			account.setUser_role(role.get());			
			compteService.createAccount(account);
			// Get and return the new token
			final Authentication authenticate = authenticationManager					
					.authenticate(new UsernamePasswordAuthenticationToken(account.getEmail(), plainPassword));	
			final User autendicatedUser = (User) authenticate.getPrincipal();
			final String token = jwtTokenUtil.generateAccessToken(autendicatedUser);
			map.put("token", token);
			return ResponseEntity.status(HttpStatus.CREATED).body(map);
		} catch (DataIntegrityViolationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HashMap<>());
		}
	}
	
	

	/**
	 * User login
	 * 
	 * @param user User login data
	 * @return The HTTP response
	 * @throws MethodArgumentNotValidException
	 */
	@PostMapping("/login")
	public final ResponseEntity<Object> login(@RequestBody @Valid AccountLoginDto accountLoginDto) {
		final HashMap<String, String> map = new HashMap<>();
		try {
			// Get and return the new token
			final Authentication authenticate = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(accountLoginDto.getEmail(), accountLoginDto.getPassword()));
			final User autendicatedUser = (User) authenticate.getPrincipal();
			final String token = jwtTokenUtil.generateAccessToken(autendicatedUser);
			map.put("token", token);
			return ResponseEntity.ok().body(map);
		} catch (BadCredentialsException ex) {
			map.put("message", "Error on login process");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(map);
		}
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	/**
	 * Handles @Valid Exceptions (ex. empty email or password)
	 * 
	 * @param ex Spring Boot throwned exception, when the target argument
	 *           annotated @Valid fails to pass the Hibernate Validator
	 * @return Empty JSON
	 */
	public final Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		return new HashMap<>();
	}

}
