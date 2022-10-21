package br.com.voeairlines.model;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.voeairlines.dao.ExceptionDAO;
import br.com.voeairlines.dao.UsuarioDAO;
import br.com.voeairlines.dao.ValidarLoginDAO;

public class UsuarioModel {

	private Integer id;
	private String usuario;
	private String senha;
	
	public UsuarioModel() {
		
	}
	
	public UsuarioModel(Integer id) {
		this.id = id;
	}
	
	public UsuarioModel(Integer id, String usuario, String senha) {
		this.id = id;
		this.usuario = usuario;
		this.senha = senha; 
	}

	public UsuarioModel(String usuario, String senha) {
		this.usuario = usuario; 
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void cadastrarUsuario(UsuarioModel usuario) throws ExceptionDAO {
		
		new UsuarioDAO().cadastrarUsuario(usuario);

	}
	
	public void validarLogin(UsuarioModel usuario) throws ExceptionDAO{
		new ValidarLoginDAO().validarLogin(usuario);
	}
	
	public ArrayList<UsuarioModel> pesquisaUsuario(Integer idUsuario) throws ExceptionDAO {
		return new  UsuarioDAO().pesquisaUsuario(idUsuario);
	}
	
	public void atualizaDados(UsuarioModel usuario) throws ExceptionDAO {
		new UsuarioDAO().atualizaDados(usuario); 
	}
	
	public ArrayList<UsuarioModel> listaDados() throws ExceptionDAO {
		return new  UsuarioDAO().listaDados();
	}
	
	public void deletarUsuario(UsuarioModel usuario)throws ExceptionDAO {
		new UsuarioDAO().deletarUsuario(usuario);
	}

}
