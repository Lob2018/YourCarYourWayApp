package fr.soft64.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.soft64.model.Account;
import fr.soft64.model.Tchat;

@Repository
public interface TchatRepository extends JpaRepository<Tchat, UUID> {
	
//	List<Tchat> findByAccount_senderuuid(Account account_senderuuid);

//	@Query("SELECT p FROM Tchat p WHERE p.account_senderuuid = :account_senderuuid")
//	List<Tchat> findByAccount_senderuuid(@Param("account_senderuuid") UUID account_senderuuid);

}