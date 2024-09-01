package br.com.tgid.teste_java_developer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tgid.teste_java_developer.models.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
