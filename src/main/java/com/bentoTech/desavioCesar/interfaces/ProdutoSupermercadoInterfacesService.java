package com.bentoTech.desavioCesar.interfaces;

import java.util.List;

import com.bentoTech.desavioCesar.model.ProdutoSupermercado;
import com.bentoTech.desavioCesar.model.VH.ProdutoSupermercadoVH;

public interface ProdutoSupermercadoInterfacesService {

	public List<ProdutoSupermercado> listarTodosSupermercado(Long idSupermercado) throws Exception;

	public List<ProdutoSupermercado> listarProdutoSupermercadoPorNome(Long idSupermercado , String nomeProduto) throws Exception;
	
	public ProdutoSupermercado salvar(ProdutoSupermercado produtoSupermercado) throws Exception;
	
	public ProdutoSupermercado editar(Long idProduto,Long idSupermercado, ProdutoSupermercadoVH produtoSupermercadoVH) throws Exception;
	
}
