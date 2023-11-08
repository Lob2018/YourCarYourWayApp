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
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID useruuid;

	@ManyToOne
	@JoinColumn(name = "addressaddressuuid")
	private Address addressuuid;

	@ManyToOne
	@JoinColumn(name = "companycompanyuuid")
	private Company companyuuid;

	@ManyToOne
	@JoinColumn(name = "userroleroleuuid")
	private User_role userroleuuid;

	@ManyToOne
	@JoinColumn(name = "languagelanguageuuid")
	private User_language languageuuid;

	@NotNull
	@Size(max = 384)
	private String email;

	@NotNull
	@Size(max = 80)
	private String accountpassword;
	@Size(max = 256)
	private String accountname;
	@Size(max = 256)
	private String surname;
	@Size(max = 20)
	private String phone;
	@NotNull
	private LocalDateTime updatedat;
	@NotNull
	private LocalDateTime createdat;
	private final boolean active = true;
}
