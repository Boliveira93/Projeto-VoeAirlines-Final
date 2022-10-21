package br.com.voeairlines.controller;

import java.util.ArrayList;

import br.com.voeairlines.dao.ExceptionDAO;
import br.com.voeairlines.model.AeronaveModel;
import br.com.voeairlines.model.UsuarioModel;


public class AeronaveController {
	
	public boolean cadastrarAeronave(String fabricante, String modelo, String codigo) throws ExceptionDAO {
		if(fabricante != null && fabricante.length() > 0 && modelo != null && modelo.length() > 0 && codigo != null && codigo.length() > 0) {
			AeronaveModel us = new AeronaveModel(fabricante, modelo, codigo);
			us.cadastrarAeronave(us);
			return true;
		}
		return false;
	}
	
	public boolean selecionarAeronave(Integer id, String fabricante, String modelo, String codigo ) throws ExceptionDAO {
		if(id != null && id > 0 && fabricante != null && fabricante.length() > 0 && modelo != null && modelo.length() > 0 && codigo != null && codigo.length() > 0) {
			AeronaveModel us = new AeronaveModel(id,fabricante, modelo, codigo);
			us.selecionarAeronave(us);
			return true;
		}
		return false;
	}
	
	public boolean atualizaDados(Integer id, String fabricante, String modelo, String codigo) throws ExceptionDAO{
		AeronaveModel us = new AeronaveModel(id, fabricante,modelo, codigo);
		us.setId(id);
		us.atualizaDados(us); 
		return true;
	}
	
	public boolean deletarAeronave(Integer id) throws ExceptionDAO {
		AeronaveModel us = new AeronaveModel(id);
		us.deletarAeronave(us);
		return true;
	}
	
	public ArrayList<AeronaveModel> listarDados()throws ExceptionDAO {
		return new AeronaveModel().listarDados();
	}
	
	public ArrayList<AeronaveModel> pesquisaAeronave(Integer idAeronave)throws ExceptionDAO {
		return new AeronaveModel().pesquisaAeronave(idAeronave); 	
	}
	
	

}
