package fr.soft64.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.soft64.model.Account;
import fr.soft64.model.Tchat;

@Repository
public interface TchatRepository extends JpaRepository<Tchat, UUID> {

	List<Tchat> findByUseruuid(Account useruuid);

}