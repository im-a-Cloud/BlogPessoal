package com.BlogPessoal.BlogPessoal.DTO;

import com.BlogPessoal.BlogPessoal.Entidades.TipoUsuario;

public record UsuarioDTO(String nomeUsuario, String emailUsuario, String senhaUsuario, TipoUsuario tipoUsuario) {
}
