package fr.soft64.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "company")
@Getter
@Setter
@ToString
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID companyuuid;
    
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_addressuuid")
    private Address address;
    
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
    private boolean active = true;
    
    // Getters and setters with Lombock
}