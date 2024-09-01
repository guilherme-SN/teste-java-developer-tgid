package br.com.tgid.teste_java_developer.controllers;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tgid.teste_java_developer.dto.CompanyDTO;
import br.com.tgid.teste_java_developer.models.Company;
import br.com.tgid.teste_java_developer.services.CompanyService;
import br.com.tgid.teste_java_developer.services.TaxService;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private TaxService taxService;

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id) {
        Company company = this.companyService.getCompanyById(id);
        if (company == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<Company>(company , HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Company> createCompany(@Valid @RequestBody CompanyDTO companyDTO) {
        Company company = companyDTO.toCompany(this.taxService);
        Company newCompany = this.companyService.createCompany(company);

        return new ResponseEntity<Company>(newCompany, HttpStatus.CREATED);
    }
}
