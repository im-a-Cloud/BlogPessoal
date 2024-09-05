package com.BlogPessoal.BlogPessoal.Entidades;

import com.BlogPessoal.BlogPessoal.DTO.UsuarioDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "tb_Usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class UsuarioClasse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String nomeUsuario;

    private String senhaUsuario;
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    public UsuarioClasse(UsuarioDTO usuarioDTO){
        this.nomeUsuario = usuarioDTO.nomeUsuario();
        this.senhaUsuario = usuarioDTO.senhaUsuario();
        this.tipoUsuario = usuarioDTO.tipoUsuario();
    }
}

