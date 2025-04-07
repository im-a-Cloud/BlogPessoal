package com.BlogPessoal.BlogPessoal.Repository;

import com.BlogPessoal.BlogPessoal.Entidades.UsuarioClasse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<UsuarioClasse,String> {
    UserDetails findByEmailUsuario(String emailUsuario);
}
