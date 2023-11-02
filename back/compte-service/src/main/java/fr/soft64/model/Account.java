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
@Table(name = "account")
@Getter
@Setter
@ToString
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID useruuid;
    
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_addressuuid")
    private Address address;
    
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_companyuuid")
    private Company company;
    
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_role_roleuuid")
    private User_role user_role;
    
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "language_languageuuid")
    private User_language language;
   
	@NotNull
	@Size(max = 384)
    @Column(nullable = false, unique = true)
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
    private boolean active = true;
    
    // Getters and setters with Lombock
}

