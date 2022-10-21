package br.com.voeairlines.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.voeairlines.model.UsuarioModel;
import br.com.voeairlines.view.TelaCadastroUsuario;
import br.com.voeairlines.view.TelaLogin;

public class UsuarioDAO {

	public void cadastrarUsuario(UsuarioModel usuario) throws ExceptionDAO {
		String sql = "insert into usuario(usuario, senha) values(?,?)";

		PreparedStatement stmt = null;

		Connection con = null;

		try {

			con = new Conexao().getConnection();

			stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getSenha());

			stmt.execute();
			
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

	public ArrayList<UsuarioModel> pesquisaUsuario(Integer idAeronave) throws ExceptionDAO {

		String sql = "select *from usuario where id like " + idAeronave;
		Connection con = new Conexao().getConnection();
		ArrayList<UsuarioModel> usuarios = null;

		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			if (rs != null) {
				usuarios = new ArrayList<UsuarioModel>();
				while (rs.next()) {
					UsuarioModel um = new UsuarioModel();
					um.setId(rs.getInt("id"));

					um.setUsuario(rs.getString("usuario"));
					um.setSenha(rs.getString("senha"));

					usuarios.add(um);
				}
			}

			stmt.close();
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return usuarios;
	}

	public void atualizaDados(UsuarioModel usuario) throws ExceptionDAO  {
		String sql = "update usuario set usuario=?, senha=? where id=?";
		
		PreparedStatement stmt = null;
		Connection con = null; 
		
	
		try {
			con = new Conexao().getConnection();
			 stmt = con.prepareStatement(sql);

			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getSenha());
			stmt.setInt(3, usuario.getId());
			stmt.execute();

		} catch (Exception e) {
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<UsuarioModel> listaDados() throws ExceptionDAO {

		String sql = "select *from usuario ";
		Connection con = new Conexao().getConnection();
		ArrayList<UsuarioModel> usuarios = null;

		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			if (rs != null) {
				usuarios = new ArrayList<UsuarioModel>();
				while (rs.next()) {
					UsuarioModel um = new UsuarioModel();
					um.setId(rs.getInt("id"));

					um.setUsuario(rs.getString("usuario"));
					um.setSenha(rs.getString("senha"));

					usuarios.add(um);
				}
			}

			stmt.close();
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return usuarios;
	}

	public void deletarUsuario(UsuarioModel usuario) throws ExceptionDAO {
		String sql = "delete from usuario where id=?";
		
		Connection con = new Conexao().getConnection();
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, usuario.getId());
			
			
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

