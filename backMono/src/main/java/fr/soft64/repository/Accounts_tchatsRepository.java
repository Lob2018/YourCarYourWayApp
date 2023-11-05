package fr.soft64.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.soft64.model.Account;
import fr.soft64.model.Accounts_tchats;
import fr.soft64.model.User_role;

@Repository
public interface Accounts_tchatsRepository extends JpaRepository<Accounts_tchats, UUID> {

//    @Query("SELECT p FROM Accounts_tchats p WHERE p.account_useruuid = :account_useruuid")
//    List<Accounts_tchats> findByAccount_useruuid(@Param("account_useruuid") Account account_useruuid);
    
    @Query("SELECT p.account_useruuid, p.tchat_tchatuuid FROM Accounts_tchats p WHERE p.account_useruuid = :account_useruuid")
    List<Accounts_tchats> findByAccount_useruuid(@Param("account_useruuid") UUID account_useruuid);
    
}