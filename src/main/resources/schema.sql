CREATE TABLE IF NOT EXISTS tb_usuario{
    idUsuario UUID PRIMARY KEY UNIQUE NOT NULL,
    nomeUsuario TEXT NOT NULL,
    emailUsuario TEXT NOT NULL UNIQUE,
    senhaUsuario TEXT NOT NULL,
    tipoUsuario TEXT NOT NULL
}