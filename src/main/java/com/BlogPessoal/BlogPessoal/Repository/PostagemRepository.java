package com.BlogPessoal.BlogPessoal.Repository;

import com.BlogPessoal.BlogPessoal.Entidades.PostagemClasse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<PostagemClasse,Long> {
}
