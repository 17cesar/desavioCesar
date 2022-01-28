package com.bentoTech.desavioCesar.model.VH;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoVH {
	private String nome;
	private String codigoBarra;
	private String categoria;
	private BigDecimal preco;
	
}
