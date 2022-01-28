package com.bentoTech.desavioCesar.interfaces;

import java.util.List;

import com.bentoTech.desavioCesar.model.Supermercado;
import com.bentoTech.desavioCesar.model.VH.SupermercadoVH;

public interface SupermercadoInterfacesService {

	public Supermercado salvar(Supermercado supermercado) throws Exception;

	public Supermercado editar(Long idSupermercado, SupermercadoVH supermercadoVH) throws Exception;
	
	public List<Supermercado> listarTodos() throws Exception;
	
	public void deletar(Long idSupermercado) throws Exception;
	
	public List<Supermercado> consultaPorNome(String nome) throws Exception;
	
}
