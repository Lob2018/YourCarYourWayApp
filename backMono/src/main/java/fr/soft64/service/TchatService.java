package fr.soft64.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.soft64.model.Account;
import fr.soft64.model.Accounts_tchats;
import fr.soft64.model.Tchat;
import fr.soft64.repository.Accounts_tchatsRepository;
import fr.soft64.repository.TchatRepository;

@Service
public class TchatService {

	@Autowired
	private TchatRepository tchatRepository;

	@Autowired
	private Accounts_tchatsRepository accounts_tchatsRepository;

//	public final List<Tchat> findByAccount_senderuuid(Account account_senderuuid) {
//		if (account_senderuuid == null) {
//			throw new Error();
//		}
//		return tchatRepository.findByAccount_senderuuid(account_senderuuid);
//	}

	public final List<Accounts_tchats> findByAccount_useruuid(Account uuid) {
		if (uuid == null) {
			throw new Error();
		}
		return accounts_tchatsRepository.findByAccount_useruuid(uuid);
	}

}
