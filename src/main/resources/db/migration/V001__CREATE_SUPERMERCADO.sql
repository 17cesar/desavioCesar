CREATE TABLE supermercado (
	id bigserial NOT NULL,
	endereco varchar(255) NULL,
	nome varchar(255) NULL,
	telefone varchar(255) NULL,
	CONSTRAINT supermercado_pkey PRIMARY KEY (id)
);
