package com.BlogPessoal.BlogPessoal.Repository;

import com.BlogPessoal.BlogPessoal.Entidades.PostagemClasse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository extends JpaRepository<PostagemClasse,Long> {
}
