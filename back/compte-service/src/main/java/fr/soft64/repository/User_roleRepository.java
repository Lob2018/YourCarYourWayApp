package fr.soft64.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.soft64.model.User_role;

@Repository
public interface User_roleRepository extends JpaRepository<User_role, UUID> {
	
	@Query("SELECT ur FROM User_role ur WHERE ur.user_role_name = :user_role_name")
    Optional<User_role> findUser_roleByUser_role_name(@Param("user_role_name") String user_role_name);
    
}