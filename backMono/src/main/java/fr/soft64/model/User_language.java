package fr.soft64.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user_language")
@Getter
@Setter
@ToString
public class User_language {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID languageuuid;

	@NotNull
	@Size(max = 3)
	private String language_code;
	@Size(max = 128)
	private String language_name;

    // Getters and setters with Lombock
}
