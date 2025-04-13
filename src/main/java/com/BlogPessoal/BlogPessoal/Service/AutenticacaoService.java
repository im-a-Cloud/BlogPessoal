package com.BlogPessoal.BlogPessoal.Service;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService {
    private JwtService jwtService;

    public AutenticacaoService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public String autenticar(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new AuthenticationCredentialsNotFoundException("Credenciais inválidas");
        }
        return jwtService.generateToken(authentication);
    }
}
