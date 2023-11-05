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
import fr.soft64.model.Accounts_tchats;
import fr.soft64.model.Tchat;
import fr.soft64.service.CompteService;
import fr.soft64.service.TchatService;

@RestController
@RequestMapping("/tchat")
public class TchatServiceController {

	@Autowired
	private CompteService compteService;

	@Autowired
	private TchatService tchatService;

	@Autowired
	private ModelMapper modelMapper;

	private final TchatUserDto convertAccountToDto(final Account account) {
		final TchatUserDto tchatUserDto = modelMapper.map(account, TchatUserDto.class);
		return tchatUserDto;
	}

//	private final SubjectDtoWithSubscribeOrNot convertSubjectToSubscribeDto(final Subject subject,
//			final boolean subscribe) {
//		SubjectDtoWithSubscribeOrNot subjecSubscribetDto = new SubjectDtoWithSubscribeOrNot();
//		subjecSubscribetDto.setDescription(subject.getDescription());
//		subjecSubscribetDto.setId(subject.getId());
//		subjecSubscribetDto.setSubscribe(subscribe);
//		subjecSubscribetDto.setTopic(subject.getTopic());
//		return subjecSubscribetDto;
//	}

	/**
	 * Get all the tchat for this user
	 * 
	 * @return The HTTP response
	 */
	@GetMapping("")
	public final ResponseEntity<Object> findAll() {

		final String mail = SecurityContextHolder.getContext().getAuthentication().getName();
		final Account user = compteService.findByEmail(mail).get();

		// user's dto data
		final TchatUserDto tchatUserDto = convertAccountToDto(user);

//		// les messages reçus avec les id des expéditeurs
//		final List<Accounts_tchats> accountsChats = tchatService.findByAccount_useruuid(user.getUseruuid());

		// mes messages envoyés
//		final List<Tchat> tchat = tchatService.findByAccount_senderuuid(user);

		// people who send him messages
//		final Optional<Accounts_tchats> accountsTchats = tchatService.findByAccount(user);
//		System.out.println("####APRES#####"+tchatUserDto.getUseruuid());

//		final List<SubjectDto> subjectsDtoList = ((Collection<Subject>) subjectService.getAllSubjects()).stream()
//				.map(this::convertSubjectToDto).collect(Collectors.toList());
//		
//		final List<PostDto> postsDtoList = ((Collection<Post>) postService.getAllPosts()).stream()
//				.map(this::convertPostToDto).collect(Collectors.toList());
//		final HashMap<String, List<PostDto>> map = new HashMap<>();
		final HashMap<String, List<Tchat>> map = new HashMap<>();

//		map.put("posts", tchat);
		return ResponseEntity.ok().body(map);

	}

}