CREATE TABLE tb_usuario(
    idUsuario TEXT PRIMARY KEY UNIQUE NOT NULL,
    nomeUsuario TEXT NOT NULL,
    emailUsuario TEXT UNIQUE NOT NULL,
    senhaUsuario TEXT NOT NULL,
    tipoUsuario TEXT NOT NULL
);