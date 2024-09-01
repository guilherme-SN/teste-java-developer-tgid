package br.com.tgid.teste_java_developer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tgid.teste_java_developer.models.Client;
import br.com.tgid.teste_java_developer.repositories.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client getCompanyById(Long id) {
        return this.clientRepository.findById(id).orElse(null);
    }

    public Client createClient(Client client) {
        return this.clientRepository.save(client);
    }
}
