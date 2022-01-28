CREATE TABLE produto (
	id bigserial NOT NULL,
	categoria varchar(255) NULL,
	codigo_barra varchar(255) NULL,
	nome varchar(255) NULL,
	preco numeric(19,2) NULL,
	CONSTRAINT produto_pkey PRIMARY KEY (id)
);
