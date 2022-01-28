package com.bentoTech.desavioCesar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bentoTech.desavioCesar.model.Supermercado;

@Repository
public interface SupermercadoRepository extends JpaRepository<Supermercado, Long>{

	List<Supermercado> findConsultarByNomeContainingIgnoreCase(String nome);
	
}
