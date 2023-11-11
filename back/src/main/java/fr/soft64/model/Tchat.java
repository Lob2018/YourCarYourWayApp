package fr.soft64.model;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tchat")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tchat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID tchatuuid;

	@ManyToOne
	@JoinColumn(name = "accountsenderuuid")
	private Account useruuid;

	@NotNull
	private LocalDateTime createdat;
	@NotNull
	private LocalDateTime updatedat;
	private final boolean active = true;
	@Size(max = 2048)
	private String content;
}