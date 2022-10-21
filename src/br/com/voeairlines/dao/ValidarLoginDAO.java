package br.com.voeairlines.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.voeairlines.model.UsuarioModel;
import br.com.voeairlines.view.TelaDeConsulta;
import br.com.voeairlines.view.TelaLogin;
import br.com.voeairlines.view.TelaDeConsulta;
import br.com.voeairlines.view.TelaLogin;

public class ValidarLoginDAO {

	public void validarLogin(UsuarioModel usuario) throws ExceptionDAO {

		String sql = "select * from usuario where usuario=? and senha=?";

		PreparedStatement stmt = null;

		Connection con = null;
		
		ResultSet rs = null;

		try {

			con = new Conexao().getConnection();

			stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getSenha());
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "Acesso Confirmado");
				TelaDeConsulta exibir = new TelaDeConsulta();
				
				
				TelaLogin telalogin = new TelaLogin();
				
				exibir.setVisible(true);
				telalogin.setVisible(false);
			}else {
				JOptionPane.showMessageDialog(null, "Acesso Invalido");
			}
			
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao Cadastrar: " + e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				throw new ExceptionDAO("Erro ao Fechar o Stmt " + e);
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new ExceptionDAO("Erro ao Fechar Conexão" + e);
			}
		}
	}
}
