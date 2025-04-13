package com.BlogPessoal.BlogPessoal.Repository;

import com.BlogPessoal.BlogPessoal.Entidades.CategoriaClasse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaClasse, Long> {
}
