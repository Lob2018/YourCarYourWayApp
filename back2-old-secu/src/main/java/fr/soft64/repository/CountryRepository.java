package fr.soft64.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.soft64.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, UUID> {

}