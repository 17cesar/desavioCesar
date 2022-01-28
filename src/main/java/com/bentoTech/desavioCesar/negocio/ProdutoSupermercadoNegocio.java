package com.bentoTech.desavioCesar.negocio;

import java.math.BigDecimal;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bentoTech.desavioCesar.interfaces.ProdutoSupermercadoInterfacesService;
import com.bentoTech.desavioCesar.model.Produto;
import com.bentoTech.desavioCesar.model.ProdutoSupermercado;
import com.bentoTech.desavioCesar.model.VH.ProdutoSupermercadoVH;
import com.bentoTech.desavioCesar.model.VH.ProdutoVH;
import com.bentoTech.desavioCesar.repository.ProdutoSupermercadoRepository;

@Service
public class ProdutoSupermercadoNegocio implements ProdutoSupermercadoInterfacesService{

	@Autowired
	private ProdutoSupermercadoRepository produtoSupermercadoRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<ProdutoSupermercado> listarTodosSupermercado(Long idSupermercado) throws Exception {
		return produtoSupermercadoRepository.findConsultarBySupermercadoId(idSupermercado);
	}

	@Override
	public List<ProdutoSupermercado> listarProdutoSupermercadoPorNome(Long idSupermercado, String nomeProduto) throws Exception {
		return produtoSupermercadoRepository.findConsultarByProdutoNomeContainingIgnoreCaseAndSupermercadoId(nomeProduto , idSupermercado);
	}

	@Override
	public ProdutoSupermercado salvar(ProdutoSupermercado produtoSupermercado) throws Exception {
		validarProduto(produtoSupermercado);
		return produtoSupermercadoRepository.save(produtoSupermercado);
	}
	
	@Override
	public ProdutoSupermercado editar(Long idProduto,Long idSupermercado, ProdutoSupermercadoVH produtoSupermercadoVH) throws Exception {
		ProdutoSupermercado produtoSupermercadoBanco = produtoSupermercadoRepository.findConsultarProdutoSupermercadoBySupermercadoIdAndProdutoId(idProduto,idSupermercado);
		copyToDomainObject(produtoSupermercadoVH, produtoSupermercadoBanco);
		validarProduto(produtoSupermercadoBanco);
		produtoSupermercadoBanco = produtoSupermercadoRepository.save(produtoSupermercadoBanco);
		return produtoSupermercadoBanco;
	}
	
	
	public void copyToDomainObject(ProdutoSupermercadoVH produtoSupermercadoVH, ProdutoSupermercado produtoSupermercadoBanco) {
		modelMapper.map(produtoSupermercadoVH, produtoSupermercadoBanco);
	}
	
	public Boolean produtoJaIncluidoSupermercado(ProdutoSupermercado produtoSupermercado) {
		List<ProdutoSupermercado> listProduto =	produtoSupermercadoRepository.findConsultarBySupermercadoIdAndProdutoId(produtoSupermercado.getSupermercado().getId(), produtoSupermercado.getProduto().getId());
	   return !listProduto.isEmpty();
	}

	private void validarProduto(ProdutoSupermercado produtoSupermercado) throws Exception {
		
		if(produtoSupermercado.getPreco() == null || (produtoSupermercado.getPreco().compareTo(BigDecimal.ZERO) <= 0)) {
			throw new Exception("Valor do produto não pode ser igual ou menor que zero.");
		}
		if(produtoJaIncluidoSupermercado(produtoSupermercado) && produtoSupermercado.getId() == null) {
			throw new Exception("Produto já incluido no supermercado.");
		}
	}
	
}
