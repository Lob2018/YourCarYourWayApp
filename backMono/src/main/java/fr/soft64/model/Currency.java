package fr.soft64.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "currency")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Currency {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID currencyuuid;
	@NotNull
	@Size(max = 3)
	private String currencyiso;
}
