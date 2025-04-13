package com.BlogPessoal.BlogPessoal.Seguranca;

import com.BlogPessoal.BlogPessoal.Entidades.UsuarioClasse;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserAutenticated implements UserDetails {

    private final UsuarioClasse usuarioClasse;

    public UserAutenticated(UsuarioClasse usuarioClasse){
        this.usuarioClasse = usuarioClasse;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roleUsuario = "ROLE_" + usuarioClasse.getTipoUsuario();
        return List.of(new SimpleGrantedAuthority(roleUsuario));
    }

    @Override
    public String getPassword() {
        return usuarioClasse.getSenhaUsuario();
    }

    @Override
    public String getUsername() {
        return usuarioClasse.getEmailUsuario();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
