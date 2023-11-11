package fr.soft64.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.soft64.model.Account;
import fr.soft64.model.User_role;

import fr.soft64.repository.AccountRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public final UserDetails loadUserByUsername(final String userEmail) throws UsernameNotFoundException {
		final Optional<Account> account = accountRepository.findByEmail(userEmail);

		if (account.isEmpty())
			throw new UsernameNotFoundException(userEmail + " not found");
		return new org.springframework.security.core.userdetails.User(account.get().getEmail(),
				account.get().getAccountpassword(), getGrantedAuthorities(account.get().getUserroleuuid()));
	}

	private List<GrantedAuthority> getGrantedAuthorities(User_role role) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		// Spring Security automatically prefix role with ROLE_
		// so if the role name in database isn't prefix with ROLE_
		// we have to it
		authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getUserrolename()));
		return authorities;
	}

}