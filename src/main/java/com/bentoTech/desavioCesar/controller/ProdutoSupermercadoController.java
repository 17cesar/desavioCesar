package com.bentoTech.desavioCesar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebInputException;

import com.bentoTech.desavioCesar.model.ProdutoSupermercado;
import com.bentoTech.desavioCesar.model.VH.ProdutoSupermercadoVH;
import com.bentoTech.desavioCesar.model.VH.ProdutoVH;
import com.bentoTech.desavioCesar.negocio.ProdutoSupermercadoNegocio;

@RestController
@RequestMapping("/api/produtoSupermercado")
public class ProdutoSupermercadoController {

	@Autowired
	private ProdutoSupermercadoNegocio produtoSupermercadoNegocio;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> cadastrar(@RequestBody ProdutoSupermercado produtoSupermercado){
		try {
			return ResponseEntity.ok().body(produtoSupermercadoNegocio.salvar(produtoSupermercado));
		} catch (Exception e) {
			throw new ServerWebInputException(e.getMessage());
		}  
	}
	
	@PutMapping("/{idSupermercado}/{idProduto}")
	public ResponseEntity<?> editar(@PathVariable Long idProduto,@PathVariable Long idSupermercado,@RequestBody ProdutoSupermercadoVH produtoSupermercadooVH) {
		try {
		  return ResponseEntity.ok(produtoSupermercadoNegocio.editar(idProduto,idSupermercado,produtoSupermercadooVH));
		} catch (Exception e) {
			throw new ServerWebInputException(e.getMessage());
		}
	}
	
	
	@GetMapping("/{idSupermercado}")
	public ResponseEntity<List<ProdutoSupermercado>> listarPorIdSupermercado(@PathVariable Long idSupermercado){
		try {
			return ResponseEntity.ok().body(produtoSupermercadoNegocio.listarTodosSupermercado(idSupermercado));
		} catch (Exception e) {
			throw new ServerWebInputException(e.getMessage());
		}
	}
	
	@GetMapping("/produto/{idSupermercado}")
	public ResponseEntity<List<ProdutoSupermercado>> listarPorNomeProduto(@PathVariable Long idSupermercado , String nome){
		try {
			return ResponseEntity.ok().body(produtoSupermercadoNegocio.listarProdutoSupermercadoPorNome(idSupermercado, nome) );
		} catch (Exception e) {
			throw new ServerWebInputException(e.getMessage());
		}
	}
	 
}
