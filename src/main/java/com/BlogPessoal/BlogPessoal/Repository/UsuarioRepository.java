package com.BlogPessoal.BlogPessoal.Repository;

import com.BlogPessoal.BlogPessoal.Entidades.UsuarioClasse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioClasse,Long> {
}
