package br.com.voeairlines.controller;

import java.util.ArrayList;

import br.com.voeairlines.dao.ExceptionDAO;
import br.com.voeairlines.model.UsuarioModel;

public class UsuarioController {
	
	public boolean cadastrarUsuario(String usuario, String senha) throws ExceptionDAO {
		if(usuario != null && usuario.length() > 0 && senha != null && senha.length() > 0) {
			UsuarioModel us = new UsuarioModel(usuario, senha);
			us.cadastrarUsuario(us);
			return true;
		}
		return false;
		
	}
	
	public ArrayList<UsuarioModel> pesquisaUsuario(Integer idUsuario)throws ExceptionDAO {
		return new UsuarioModel().pesquisaUsuario(idUsuario); 
		
	}
	
	public boolean atualizaDados(Integer id, String usuario, String senha)throws ExceptionDAO {
		UsuarioModel us = new UsuarioModel(id, usuario, senha);
		us.setId(id);
		us.atualizaDados(us); 
		return true;
		
	}
	
	public ArrayList<UsuarioModel> listaDados()throws ExceptionDAO {
		return new UsuarioModel().listaDados();
		
	}
	
	public boolean deletarUsuarios(Integer id) throws ExceptionDAO {
		UsuarioModel us = new UsuarioModel(id);
		us.deletarUsuario(us);
		return true;
	}
	
}
