package br.com.tgid.teste_java_developer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tgid.teste_java_developer.models.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
