package com.bentoTech.desavioCesar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebInputException;

import com.bentoTech.desavioCesar.model.Produto;
import com.bentoTech.desavioCesar.model.VH.ProdutoVH;
import com.bentoTech.desavioCesar.model.VH.SupermercadoVH;
import com.bentoTech.desavioCesar.negocio.ProdutoNegocio;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	@Autowired
	private ProdutoNegocio produtoNegocio;
	
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody Produto produto){
		try {
			return ResponseEntity.ok().body(produtoNegocio.salvar(produto));
		} catch (Exception e) {
			throw new ServerWebInputException(e.getMessage());
		}  
	}
	
	@PutMapping("/{idProduto}")
	public ResponseEntity<?> editar(@PathVariable Long idProduto,@RequestBody ProdutoVH produtoVH) {
		try {
		  return ResponseEntity.ok(produtoNegocio.editar(idProduto,produtoVH));
		} catch (Exception e) {
			throw new ServerWebInputException(e.getMessage());
		}
	}
	
	
	@GetMapping(value = "/listarTodos")
	public ResponseEntity<List<Produto>> listarTodos(){
		try {
			return ResponseEntity.ok().body(produtoNegocio.listarTodos());
		} catch (Exception e) {
			throw new ServerWebInputException(e.getMessage());
		}
	}
	
	@GetMapping(value = "/por-nome")
	public ResponseEntity<List<Produto>> consultarNome(String nome){
		try {
			return ResponseEntity.ok().body(produtoNegocio.consultaPorNome(nome));
		} catch (Exception e) {
			throw new ServerWebInputException(e.getMessage());
		}
	}
	
	@DeleteMapping("/{idProduto}")
	public void excluir(@PathVariable Long idProduto) {
		try {
			produtoNegocio.deletar(idProduto);
		} catch (Exception e) {
			throw new ServerWebInputException(e.getMessage());
		}
	}
	
}
