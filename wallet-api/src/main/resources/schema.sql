CREATE SEQUENCE IF NOT EXISTS wallet_id_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS wallet_transaction_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS wallet(
    "id" BIGINT PRIMARY KEY,
    fk_user BIGINT NOT NULL,
    amount NUMERIC(10,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS wallet_transaction(
    "id" BIGINT PRIMARY KEY,
    fk_wallet BIGINT NOT NULL,
    fk_payer BIGINT NOT NULL,
    fk_payee BIGINT NOT NULL,
    amount NUMERIC(10,2) NOT NULL
);