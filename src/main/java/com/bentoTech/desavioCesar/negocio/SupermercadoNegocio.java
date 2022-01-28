package com.bentoTech.desavioCesar.negocio;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bentoTech.desavioCesar.interfaces.SupermercadoInterfacesService;
import com.bentoTech.desavioCesar.model.Supermercado;
import com.bentoTech.desavioCesar.model.VH.SupermercadoVH;
import com.bentoTech.desavioCesar.repository.SupermercadoRepository;


@Service
public class SupermercadoNegocio implements SupermercadoInterfacesService{

	@Autowired
	private SupermercadoRepository supermercadoRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Supermercado salvar(Supermercado supermercado) throws Exception {
		supermercado = supermercadoRepository.save(supermercado);
		return supermercado;
	}

	@Override
	public List<Supermercado> listarTodos() throws Exception {
		return supermercadoRepository.findAll();
	}

	@Override
	public void deletar(Long idSupermercado) throws Exception {
		Supermercado supermercado = supermercadoRepository.getById(idSupermercado);
		supermercadoRepository.delete(supermercado);
	}

	@Override
	public List<Supermercado> consultaPorNome(String nome) throws Exception {
		return supermercadoRepository.findConsultarByNomeContainingIgnoreCase(nome);
	}

	@Override
	public Supermercado editar(Long idSupermercado, SupermercadoVH supermercadoVH) throws Exception {
		Supermercado supermercadoBanco = supermercadoRepository.getById(idSupermercado);
		copyToDomainObject(supermercadoVH, supermercadoBanco);
		supermercadoBanco = supermercadoRepository.save(supermercadoBanco);
		return supermercadoBanco;
	}
	
	
	public void copyToDomainObject(SupermercadoVH supermercadoVH, Supermercado supermercadoBanco) {
		modelMapper.map(supermercadoVH, supermercadoBanco);
	}
}
