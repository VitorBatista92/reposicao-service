
CREATE TABLE reposicao
(
    id              BIGSERIAL PRIMARY KEY NOT NULL,
    sku             varchar(255),
    status          varchar(255),
    laboratorio_id  BIGINT,
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at      TIMESTAMP,
    deleted_tmsp    TIMESTAMP
);
CREATE SEQUENCE IF NOT EXISTS reposicao_id_seq START WITH 1 INCREMENT BY 1;


