package com.bentoTech.desavioCesar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bentoTech.desavioCesar.model.ProdutoSupermercado;

@Repository
public interface ProdutoSupermercadoRepository extends JpaRepository<ProdutoSupermercado, Long>{

	List<ProdutoSupermercado> findConsultarBySupermercadoId(Long idSupermercado);

	List<ProdutoSupermercado> findConsultarByProdutoNomeContainingIgnoreCaseAndSupermercadoId(String nomeProduto , Long idSupermercado);
	
	List<ProdutoSupermercado> findConsultarBySupermercadoIdAndProdutoId(Long idSupermercado , Long idProduto);
	
	ProdutoSupermercado findConsultarProdutoSupermercadoBySupermercadoIdAndProdutoId(Long idSupermercado , Long idProduto);
	
}
