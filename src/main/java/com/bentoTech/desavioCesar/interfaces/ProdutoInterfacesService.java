package com.bentoTech.desavioCesar.interfaces;

import java.util.List;

import com.bentoTech.desavioCesar.model.Produto;
import com.bentoTech.desavioCesar.model.VH.ProdutoVH;

public interface ProdutoInterfacesService {

	public Produto salvar(Produto produto) throws Exception;
	
	public Produto editar(Long idProduto, ProdutoVH produtoVH) throws Exception;
	
	public List<Produto> listarTodos() throws Exception;
	
	public void deletar(Long idProduto) throws Exception;
	
	public List<Produto> consultaPorNome(String nome) throws Exception;
	
}
