package br.com.tgid.teste_java_developer.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tgid.teste_java_developer.models.Tax;
import br.com.tgid.teste_java_developer.repositories.TaxRepository;

@Service
public class TaxService {
    @Autowired
    private TaxRepository taxRepository;

    public Tax getTaxById(Long id) {
        return this.taxRepository.findById(id).orElse(null);
    }

    public Tax createTax(Tax tax) {
        return this.taxRepository.save(tax);
    }

    public BigDecimal getTaxValue(Tax tax, BigDecimal amount) {
        return amount.multiply(tax.getPercentual());
    }
}
