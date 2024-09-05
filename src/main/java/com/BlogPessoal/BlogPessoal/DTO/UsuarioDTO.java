package com.BlogPessoal.BlogPessoal.DTO;

import com.BlogPessoal.BlogPessoal.Entidades.TipoUsuario;

public record UsuarioDTO(String nomeUsuario, String senhaUsuario, TipoUsuario tipoUsuario) {
}
