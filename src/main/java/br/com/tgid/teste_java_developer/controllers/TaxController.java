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

import br.com.tgid.teste_java_developer.dto.TaxDTO;
import br.com.tgid.teste_java_developer.models.Tax;
import br.com.tgid.teste_java_developer.services.TaxService;

@RestController
@RequestMapping("/api/taxes")
public class TaxController {
    @Autowired
    private TaxService taxService;

    @GetMapping("/{id}")
    public ResponseEntity<Tax> getTax(@PathVariable Long id) {
        Tax tax = this.taxService.getTaxById(id);
        if (tax == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<Tax>(tax, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Tax> createTax(@Valid @RequestBody TaxDTO taxDTO) {
        Tax tax = taxDTO.toTax();
        Tax newTax = this.taxService.createTax(tax);

        return new ResponseEntity<Tax>(newTax, HttpStatus.CREATED);
    }
}
