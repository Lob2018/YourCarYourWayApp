package fr.soft64.model;

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
@Table(name = "country")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID countryuuid;
	
	@ManyToOne
	@JoinColumn(name = "currencycurrencyuuid")	
	private Currency currencyuuid;
	
	@NotNull
	@Size(max = 3)
	private String countryiso;
	@Size(max = 128)
	private String country;
}
