INSERT INTO tb_usuario (
    id_Usuario,
    nome_Usuario,
    email_Usuario,
    senha_Usuario,
    tipo_Usuario
) VALUES (
    gen_random_uuid(), -- Gera um UUID automático (PostgreSQL)
    'Cloud Strife',
    'nuvemzinha.com',
    '$2a$10$XptfskLsT1l/bRTLRiiCgekzq5XG5/g2Q9bBSjHRZ4dcvIiM7SvQa', -- Senha criptografada (ex: "senha123")
    'ADMIN' -- Tipo de usuário (ex: 'admin', 'user')
);