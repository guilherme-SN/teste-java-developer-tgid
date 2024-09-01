package br.com.tgid.teste_java_developer.dto;

import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import br.com.tgid.teste_java_developer.models.Client;
import br.com.tgid.teste_java_developer.models.Company;
import br.com.tgid.teste_java_developer.services.CompanyService;

public class ClientDTO {
    @NotNull
    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$", message = "Invalid CPF!")
    private String cpf;
    @NotBlank
    private String name;
    private Set<Long> companiesId;

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

	public Set<Long> getCompaniesId() {
		return companiesId;
	}

	public void setCompaniesId(Set<Long> companiesId) {
		this.companiesId = companiesId;
	}

    public Client toClient(CompanyService companyService) {
        Set<Company> companies = new HashSet<>();

        for (Long companyId : this.companiesId) {
            Company company = companyService.getCompanyById(companyId);
            if (company != null) {
                companies.add(company);
            }
        }

        return new Client(this.cpf, this.name, companies);
    }
}
