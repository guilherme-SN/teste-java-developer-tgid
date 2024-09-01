package br.com.tgid.teste_java_developer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tgid.teste_java_developer.dto.TransactionRequest;
import br.com.tgid.teste_java_developer.models.Client;
import br.com.tgid.teste_java_developer.models.Company;
import br.com.tgid.teste_java_developer.models.Transaction;
import br.com.tgid.teste_java_developer.repositories.ClientRepository;
import br.com.tgid.teste_java_developer.repositories.CompanyRepository;
import br.com.tgid.teste_java_developer.repositories.TransactionRepository;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CompanyService companyService;

    public Transaction getTransactionById(Long id) {
        return this.transactionRepository.findById(id).orElse(null);
    }

    public Transaction makeTransaction(TransactionRequest transactionRequest) {
        Client client = this.clientRepository.findById(transactionRequest.getClientId()).orElse(null);
        Company company = this.companyRepository.findById(transactionRequest.getCompanyId()).orElse(null);

        if ((client == null || company == null)
            || !client.getCompanies().contains(company)) return null;

        this.companyService.updateBalance(company, transactionRequest.getAmount(), transactionRequest.getType());

        return this.transactionRepository.save(new Transaction(transactionRequest.getType(), 
                                                               transactionRequest.getAmount()));
    }
}
