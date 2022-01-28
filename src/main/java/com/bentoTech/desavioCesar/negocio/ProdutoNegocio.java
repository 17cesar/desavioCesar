package com.bentoTech.desavioCesar.negocio;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bentoTech.desavioCesar.interfaces.ProdutoInterfacesService;
import com.bentoTech.desavioCesar.model.Produto;
import com.bentoTech.desavioCesar.model.VH.ProdutoVH;
import com.bentoTech.desavioCesar.repository.ProdutoRepository;

@Service
public class ProdutoNegocio implements ProdutoInterfacesService{

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Produto salvar(Produto produto) throws Exception {
		produto = produtoRepository.save(produto);
		return produto;
	}

	@Override
	public List<Produto> listarTodos() throws Exception {
		return produtoRepository.findAll();
	}

	@Override
	public void deletar(Long idProduto) throws Exception {
		Produto produto = produtoRepository.getById(idProduto);
		produtoRepository.delete(produto);
	}

	@Override
	public List<Produto> consultaPorNome(String nome) throws Exception {
		return produtoRepository.findConsultarByNomeContainingIgnoreCase(nome);
	}
	
	@Override
	public Produto editar(Long idProduto, ProdutoVH produtoVH) throws Exception {
		Produto produtoBanco = produtoRepository.getById(idProduto);
		copyToDomainObject(produtoVH, produtoBanco);
		produtoBanco = produtoRepository.save(produtoBanco);
		return produtoBanco;
	}
	
	
	public void copyToDomainObject(ProdutoVH produtoVH, Produto produtoBanco) {
		modelMapper.map(produtoVH, produtoBanco);
	}

	
}
