CREATE SEQUENCE IF NOT EXISTS user_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS "user"(
    "id" BIGINT PRIMARY KEY,
    "name" VARCHAR(255) NOT NULL,
    cpf VARCHAR(255),
    cnpj VARCHAR(255),
    email VARCHAR(255) NOT NULL,
    "password" VARCHAR(255) NOT NULL
);