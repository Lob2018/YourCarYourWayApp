package fr.soft64.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.soft64.model.User_language;

@Repository
public interface User_languageRepository extends JpaRepository<User_language, UUID> {

}