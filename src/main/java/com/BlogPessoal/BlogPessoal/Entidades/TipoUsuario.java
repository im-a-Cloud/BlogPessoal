package com.BlogPessoal.BlogPessoal.Entidades;

public enum TipoUsuario {
    ADMIN("admin")

    ,PADRAO("user");

    private String tipo;

    TipoUsuario(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
