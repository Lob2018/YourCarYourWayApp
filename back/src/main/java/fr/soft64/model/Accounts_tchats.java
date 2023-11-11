package fr.soft64.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "accounts_tchats")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Accounts_tchats {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID accountstchatsuuid;
	
	@ManyToOne
	@JoinColumn(name = "tchattchatuuid")
	private Tchat tchatuuid;
	
    @ManyToOne
    @JoinColumn(name = "accountuseruuid")
    private Account useruuid;
}
