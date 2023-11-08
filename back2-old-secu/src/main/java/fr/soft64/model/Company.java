package fr.soft64.model;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.Column;
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
@Table(name = "company")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID companyuuid;

	@ManyToOne
	@JoinColumn(name = "addressaddressuuid")
	private Address addressuuid;

	@NotNull
	@Size(max = 384)
	@Column(nullable = false, unique = true)
	private String email;
	@NotNull
	@Size(max = 256)
	@Column(nullable = false)
	private String companyname;
	@Size(max = 20)
	private String phone;
	@NotNull
	private LocalDateTime createdat;
	@NotNull
	private LocalDateTime updatedat;
	private final boolean active = true;
}
