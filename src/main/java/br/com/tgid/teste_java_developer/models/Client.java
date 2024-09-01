package br.com.tgid.teste_java_developer.models;

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
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String cpf;
    private String name;

    @ManyToMany
    @JoinTable(
        name = "clients_companies",
        joinColumns = @JoinColumn(name = "client_fk"),
        inverseJoinColumns = @JoinColumn(name = "company_fk")
    )
    @JsonIgnoreProperties("clients")
    private Set<Company> companies;

    @Deprecated
    public Client() { }

    public Client(String cpf, String name, Set<Company> companies) {
        this.cpf = cpf;
        this.name = name;
        this.companies = companies;
    }

	public Long getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}
}
