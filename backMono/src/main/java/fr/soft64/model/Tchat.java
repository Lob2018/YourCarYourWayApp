package fr.soft64.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tchat")
@Getter
@Setter
@ToString
public class Tchat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID tchatuuid;
	
	@NotNull
	@ManyToOne
    @JoinColumn(name = "useruuid")
	private Account account_senderuuid;
	
	@NotNull
	private LocalDateTime createdat;
	@NotNull
	private LocalDateTime updatedat;
	private boolean active = true;
	@Size(max = 2048)
	private String content;

	// Getters and setters with Lombock
}