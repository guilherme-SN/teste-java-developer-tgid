package br.com.tgid.teste_java_developer.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tgid.teste_java_developer.enums.TransactionType;
import br.com.tgid.teste_java_developer.models.Company;
import br.com.tgid.teste_java_developer.models.Tax;
import br.com.tgid.teste_java_developer.repositories.CompanyRepository;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private TaxService taxService;

    public Company getCompanyById(Long id) {
        return this.companyRepository.findById(id).orElse(null);
    }

    public Company createCompany(Company company) {
        return this.companyRepository.save(company);
    }

    public BigDecimal discountTaxes(Company company, BigDecimal amount) {
        for (Tax tax : company.getTaxes()) {
            amount = amount.subtract(taxService.getTaxValue(tax, amount));
        }

        return amount;
    }

    public void updateBalance(Company company, BigDecimal amount, TransactionType type) {
        if ("DEPOSIT".equals(type.name())) {
            company.setBalance(company.getBalance().add(this.discountTaxes(company, amount)));
        } else if ("WITHDRAWAL".equals(type.name())) {
            company.setBalance(company.getBalance().subtract(this.discountTaxes(company, amount)));
        }
        
        this.companyRepository.save(company);
    }
}
