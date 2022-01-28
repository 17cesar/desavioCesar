package com.bentoTech.desavioCesar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebInputException;

import com.bentoTech.desavioCesar.model.Supermercado;
import com.bentoTech.desavioCesar.model.VH.SupermercadoVH;
import com.bentoTech.desavioCesar.negocio.SupermercadoNegocio;

@RestController
@RequestMapping(value = "/api/supermercado", produces = MediaType.APPLICATION_JSON_VALUE)
public class SupermercadoController {

	@Autowired
	private SupermercadoNegocio supermercadoNegocio;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> cadastrar(@RequestBody Supermercado supermercado) {
		try {
		  return ResponseEntity.ok(supermercadoNegocio.salvar(supermercado));
		} catch (Exception e) {
			throw new ServerWebInputException(e.getMessage());
		}
	}
	
	@PutMapping("/{idSupermercado}")
	public ResponseEntity<?> editar(@PathVariable Long idSupermercado,@RequestBody SupermercadoVH supermercadoVH) {
		try {
		  return ResponseEntity.ok(supermercadoNegocio.editar(idSupermercado,supermercadoVH));
		} catch (Exception e) {
			throw new ServerWebInputException(e.getMessage());
		}
	}
	
	@GetMapping(value = "/listarTodos")
	public ResponseEntity<List<Supermercado>> listarTodos(){
		try {
			return ResponseEntity.ok().body(supermercadoNegocio.listarTodos());
		} catch (Exception e) {
			throw new ServerWebInputException(e.getMessage());
		}
	}
	
	@GetMapping(value = "/por-nome")
	public ResponseEntity<List<Supermercado>> consultarNome(String nome){
		try {
			return ResponseEntity.ok().body(supermercadoNegocio.consultaPorNome(nome));
		} catch (Exception e) {
			throw new ServerWebInputException(e.getMessage());
		}
	}
	
	@DeleteMapping("/{idSupermercado}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> excluir(@PathVariable Long idSupermercado) {
		try {
			supermercadoNegocio.deletar(idSupermercado);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			throw new ServerWebInputException(e.getMessage());
		}	
	}
	
}
