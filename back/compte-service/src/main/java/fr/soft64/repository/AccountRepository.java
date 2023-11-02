package fr.soft64.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.soft64.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {

	Optional<Account> findByEmail(String email);

}
