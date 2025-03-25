package com.BlogPessoal.BlogPessoal.Entidades;

import com.BlogPessoal.BlogPessoal.DTO.UsuarioDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_Usuario")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "idUsuario")
public class UsuarioClasse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String nomeUsuario;

    private String emailUsuario;

    private String senhaUsuario;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    // Construtor padrão sem parâmetros
    public UsuarioClasse() {
    }

    // Construtor personalizado para UsuarioDTO
    public UsuarioClasse(UsuarioDTO usuarioDTO) {
        this.nomeUsuario = usuarioDTO.nomeUsuario();
        this.emailUsuario = usuarioDTO.emailUsuario();
        this.senhaUsuario = usuarioDTO.senhaUsuario();
        this.tipoUsuario = usuarioDTO.tipoUsuario();
    }
}

