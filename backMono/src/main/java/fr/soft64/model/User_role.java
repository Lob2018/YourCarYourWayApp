package fr.soft64.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user_role")
@Getter
@Setter
@ToString
public class User_role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID user_roleuuid;
    
	@Size(max = 128)
    private String user_role_name; 
	
    // Getters and setters with Lombock
}

