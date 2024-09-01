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

import br.com.tgid.teste_java_developer.dto.ClientDTO;
import br.com.tgid.teste_java_developer.models.Client;
import br.com.tgid.teste_java_developer.services.ClientService;
import br.com.tgid.teste_java_developer.services.CompanyService;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private CompanyService companyService;

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id) {
        Client client = this.clientService.getCompanyById(id);
        if (client == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Client> createClient(@Valid @RequestBody ClientDTO clientDTO) {
        Client client = clientDTO.toClient(this.companyService);
        Client newClient = this.clientService.createClient(client);

        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }
}
