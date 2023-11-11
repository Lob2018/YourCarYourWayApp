package fr.soft64.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.soft64.dto.TchatUserDto;
import fr.soft64.model.Account;
import fr.soft64.service.CompteService;

@RestController
@RequestMapping("/tchat")
public class TchatRESTController {

	@Autowired
	private CompteService compteService;

	private final TchatUserDto convertAccountCreateMiniDtoToTchatUserDto(Account user) {
		TchatUserDto tchatUserDto = TchatUserDto.builder().build();
		tchatUserDto.setUsername(user.getAccountname());
		if (user.getCompanyuuid() == null) {
			tchatUserDto.setCompanyname("");
		} else
			tchatUserDto.setCompanyname(user.getCompanyuuid().getCompanyname());
		return tchatUserDto;
	}

	/**
	 * Get user's info for tchat
	 * 
	 * @return The HTTP response
	 */
	@GetMapping("")
	public final ResponseEntity<Object> findAll() {
		final String mail = SecurityContextHolder.getContext().getAuthentication().getName();
		final Account user = compteService.findByEmail(mail).get();
		// user's dto data
		final TchatUserDto tchatUserDto = convertAccountCreateMiniDtoToTchatUserDto(user);
		final HashMap<String, TchatUserDto> map = new HashMap<>();
		map.put("user", tchatUserDto);
		return ResponseEntity.ok().body(map);
	}

}
