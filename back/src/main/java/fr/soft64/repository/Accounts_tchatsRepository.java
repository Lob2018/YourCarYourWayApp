package fr.soft64.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.soft64.model.Account;
import fr.soft64.model.Accounts_tchats;

@Repository
public interface Accounts_tchatsRepository extends JpaRepository<Accounts_tchats, UUID> {

	List<Accounts_tchats> findByUseruuid(Account useruuid);
}