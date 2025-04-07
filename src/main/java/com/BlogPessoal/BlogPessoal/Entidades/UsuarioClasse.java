package com.BlogPessoal.BlogPessoal.Entidades;

import com.BlogPessoal.BlogPessoal.DTO.UsuarioDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity(name = "usuario")
@Table(name = "tb_usuario")
@EqualsAndHashCode(of = "idUsuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"senhaUsuario"})
public class UsuarioClasse implements UserDetails {
    @Id
    private String idUsuario = UUID.randomUUID().toString();

    private String nomeUsuario;

    private String emailUsuario;

    private String senhaUsuario;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    public UsuarioClasse(String nomeUsuario, String emailUsuario, String senhaUsuario, TipoUsuario tipoUsuario){
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
        this.tipoUsuario = tipoUsuario;
    }
    // Construtor personalizado para UsuarioDTO
    public UsuarioClasse(UsuarioDTO usuarioDTO) {
        this.nomeUsuario = usuarioDTO.nomeUsuario();
        this.emailUsuario = usuarioDTO.emailUsuario();
        this.senhaUsuario = usuarioDTO.senhaUsuario();
        this.tipoUsuario = usuarioDTO.tipoUsuario();
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.tipoUsuario == TipoUsuario.ADMIN) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    public String getPassword() {
        return senhaUsuario;
    }

    public String getUsername() {
        return emailUsuario;
    }
    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }
}