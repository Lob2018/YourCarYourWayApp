package fr.soft64.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.soft64.configuration.SecurityConfig;
import fr.soft64.model.Account;
import fr.soft64.model.User_role;
import fr.soft64.repository.AccountRepository;
import fr.soft64.repository.User_roleRepository;

@Service
public class CompteService {	

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private User_roleRepository user_roleRepository;

	@Autowired
	private SecurityConfig securityConfig;
	
	private final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,254}$";
	private final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
	
	public final Account createAccount(final Account account) {
		if (accountPropertyIsNull(account) )//|| !accountPasswordIsStrong(account)
			throw new Error();
		account.setAccountpassword(securityConfig.bCryptPasswordEncoder().encode(account.getAccountpassword()));
		account.setCreatedat(LocalDateTime.now());
		account.setUpdatedat(LocalDateTime.now());
		return accountRepository.save(account);
	}
	
	public final Optional<Account> findByEmail(final String email) {
		if (email == null || email.trim().length() == 0) {
			throw new Error();
		}
		return accountRepository.findByEmail(email);
	}
	
	public final boolean accountPropertyIsNull(final Account account) {
		return account == null || account.getEmail().trim().length() == 0 || account.getAccountname().trim().length() == 0
				|| account.getAccountpassword().trim().length() == 0;
	}
	
	public final Optional<User_role> findByUserrolename (final String role) {
		if (role == null || role.trim().length() == 0) {
			throw new Error();
		}
		return user_roleRepository.findByUserrolename(role);
	}

	public final boolean accountPasswordIsStrong(final Account account) {
		return (isValid(account.getAccountpassword()));
	}

	/**
	 * <p>
	 * Indicates whether the password is strong enough (8-254 characters, with at
	 * least : 1 number, 1 lowercase letter, 1 uppercase letter, 1 special
	 * character)
	 * </p>
	 * REGEX explanation :<br>
	 * ^ # start of line<br>
	 * (?=.*[0-9]) # positive lookahead, digit [0-9]<br>
	 * (?=.*[a-z]) # positive lookahead, one lowercase character [a-z]<br>
	 * (?=.*[A-Z]) # positive lookahead, one uppercase character [A-Z]<br>
	 * {@code(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]) # positive lookahead, one of the
	 * special} character in this [..]<br>
	 * . # matches anything #<br>
	 * {8,254} # length at least 8 characters and maximum of 254 characters<br>
	 * $ # end of line<br>
	 * 
	 * @param password the tested password
	 * @return if it is a strong password or not
	 */
	public final boolean isValid(final String password) {
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}

}
