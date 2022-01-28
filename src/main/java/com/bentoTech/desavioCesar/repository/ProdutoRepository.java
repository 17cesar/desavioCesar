package com.bentoTech.desavioCesar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bentoTech.desavioCesar.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	List<Produto> findConsultarByNomeContainingIgnoreCase(String nome);
}
