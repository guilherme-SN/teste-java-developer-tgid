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

import br.com.tgid.teste_java_developer.dto.TransactionRequest;
import br.com.tgid.teste_java_developer.models.Transaction;
import br.com.tgid.teste_java_developer.services.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransaction(@PathVariable Long id) {
        Transaction transaction = this.transactionService.getTransactionById(id);
        if (transaction == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Transaction> createTransaction(@Valid @RequestBody TransactionRequest transactionRequest) {
        Transaction newTransaction = this.transactionService.makeTransaction(transactionRequest);
        if (newTransaction == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<Transaction>(newTransaction, HttpStatus.OK);
    }
}
