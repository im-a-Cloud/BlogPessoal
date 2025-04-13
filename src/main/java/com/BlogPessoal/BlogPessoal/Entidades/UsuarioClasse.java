package com.BlogPessoal.BlogPessoal.Entidades;

import com.BlogPessoal.BlogPessoal.DTO.UsuarioDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "idUsuario")
public class UsuarioClasse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "UUID")

    private UUID idUsuario;

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

