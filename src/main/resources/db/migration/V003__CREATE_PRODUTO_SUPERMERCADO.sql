CREATE TABLE produto_supermercado (
	id bigserial NOT NULL,
	preco numeric(19,2) NULL,
	produto_id int8 NULL,
	supermercado_id int8 NULL,
	CONSTRAINT produto_supermercado_pkey PRIMARY KEY (id),
	CONSTRAINT produto_id FOREIGN KEY (produto_id) REFERENCES produto(id),
	CONSTRAINT supermercado_id FOREIGN KEY (supermercado_id) REFERENCES supermercado(id)
);