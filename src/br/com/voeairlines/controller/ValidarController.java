
package br.com.voeairlines.controller;

import br.com.voeairlines.dao.ExceptionDAO;
import br.com.voeairlines.model.UsuarioModel;

public class ValidarController {
	
	public boolean validarLogin(String usuario, String senha) throws ExceptionDAO {
		if(usuario != null && usuario.length() > 0 && senha != null && senha.length() > 0) {
			UsuarioModel us = new UsuarioModel(usuario, senha);
			us.validarLogin(us);
			return true;
		}
		return false;
	}

}
