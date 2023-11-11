package fr.soft64.model;

import java.math.BigDecimal;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID addressuuid;

	@ManyToOne
	@JoinColumn(name = "countrycountryuuid")
	private Country countryuuid;

	@Size(max = 2048)
	private String address;
	@Size(max = 128)
	private String zipcode;
	@Size(max = 256)
	private String town;
	@DecimalMin("-90.0")
	@DecimalMax("90.0")
	@Digits(integer = 3, fraction = 6)
	private BigDecimal latitude;
	@DecimalMin("-180.0")
	@DecimalMax("180.0")
	@Digits(integer = 3, fraction = 6)
	private BigDecimal longitude;
}
