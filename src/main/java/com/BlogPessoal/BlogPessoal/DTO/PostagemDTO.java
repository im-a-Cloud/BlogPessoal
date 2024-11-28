package com.BlogPessoal.BlogPessoal.DTO;

import com.BlogPessoal.BlogPessoal.Entidades.CategoriaClasse;

import java.util.List;

public record PostagemDTO(String tituloPostagem, CategoriaClasse categoriaClasse, String conteudoPostagem) {
}
