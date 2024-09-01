package br.com.tgid.teste_java_developer.dto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import br.com.tgid.teste_java_developer.models.Company;
import br.com.tgid.teste_java_developer.models.Tax;
import br.com.tgid.teste_java_developer.services.TaxService;

public class CompanyDTO {
    @NotNull
    @Pattern(regexp = "^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$", message = "Invalid CNPJ!")
    private String cnpj;
    @NotBlank
    private String name;
    private BigDecimal balance;

    private Set<Long> taxesId;

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

	public Set<Long> getTaxesId() {
		return taxesId;
	}

	public void setTaxesId(Set<Long> taxesId) {
		this.taxesId = taxesId;
	}

    public Company toCompany(TaxService taxService) {
        Set<Tax> taxes = new HashSet<>();

        for (Long taxId : this.taxesId) {
            Tax tax = taxService.getTaxById(taxId);
            if (tax != null) {
                taxes.add(tax);
            }
        }

        return new Company(this.cnpj, this.name, this.balance, taxes);
    }
}
