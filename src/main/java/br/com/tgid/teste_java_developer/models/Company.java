package br.com.tgid.teste_java_developer.models;

import java.math.BigDecimal;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String cnpj;
    private String name;
    private BigDecimal balance;

    @ManyToMany
    @JoinTable(
        name = "companies_taxes",
        joinColumns = @JoinColumn(name = "company_fk"),
        inverseJoinColumns = @JoinColumn(name = "tax_fk")
    )
    private Set<Tax> taxes;

    @ManyToMany(mappedBy = "companies")
    @JsonIgnoreProperties("companies")
    private Set<Client> clients;

    @Deprecated
    public Company() { }

    public Company(String cnpj, String name, BigDecimal balance, Set<Tax> taxes) {
        this.cnpj = cnpj;
        this.name = name;
        this.balance = balance;
        this.taxes = taxes;
    }

	public Long getId() {
		return id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Set<Tax> getTaxes() {
		return taxes;
	}

	public void setTaxes(Set<Tax> taxes) {
		this.taxes = taxes;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
}
