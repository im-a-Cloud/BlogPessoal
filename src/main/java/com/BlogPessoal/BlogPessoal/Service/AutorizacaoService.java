package com.BlogPessoal.BlogPessoal.Service;

import com.BlogPessoal.BlogPessoal.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AutorizacaoService implements UserDetailsService {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String emailUsuario) throws UsernameNotFoundException {
        return usuarioRepository.findByEmailUsuario(emailUsuario);
    }
}
