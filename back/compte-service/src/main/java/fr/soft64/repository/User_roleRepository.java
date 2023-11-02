package fr.soft64.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.soft64.model.User_role;

@Repository
public interface User_roleRepository extends JpaRepository<User_role, UUID> {

}