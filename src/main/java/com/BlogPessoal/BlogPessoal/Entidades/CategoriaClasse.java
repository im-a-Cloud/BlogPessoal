package com.BlogPessoal.BlogPessoal.Entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_categoria_posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idCategoria") // Corrigido para idCategoria
public class CategoriaClasse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    private String nomeCategoria;
}
