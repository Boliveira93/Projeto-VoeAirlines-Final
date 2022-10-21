package br.com.voeairlines.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.voeairlines.model.AeronaveModel;
import br.com.voeairlines.model.UsuarioModel;

public class AeronaveDAO {

	public void cadastrarAeronave(AeronaveModel aeronave) throws ExceptionDAO {
		
		String sql = "insert into aeronave(fabricante, modelo, codigo) values(?,?,?)";

		PreparedStatement stmt = null;

		Connection con = null;

		try {

			con = new Conexao().getConnection();

			stmt = con.prepareStatement(sql);
			stmt.setString(1, aeronave.getFabricante());
			stmt.setString(2, aeronave.getModelo());
			stmt.setString(3, aeronave.getCodigo());

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

	public void selecionarAeronave(AeronaveModel aeronave) throws ExceptionDAO {
		String sql = "select *from aeronave where fabricante = ? and  modelo = ? and codigo=?";

		PreparedStatement stmt = null;
		Connection con = null;

		try {
			
			con = new Conexao().getConnection();
			
			stmt = con.prepareStatement(sql);
			stmt.setString(2, aeronave.getFabricante());
			stmt.setString(3, aeronave.getModelo());
			stmt.setString(4, aeronave.getCodigo());

			stmt.execute();

		} catch (Exception e) {
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
	
	public void atualizaDados(AeronaveModel aeronave) throws ExceptionDAO  {
		String sql = "update aeronave set fabricante=?, modelo=?, codigo=? where id=?";
		
		PreparedStatement stmt = null;
		Connection con = null; 
		
	
		try {
			con = new Conexao().getConnection();
			 stmt = con.prepareStatement(sql);

			stmt.setString(1, aeronave.getFabricante());
			stmt.setString(2, aeronave.getModelo());
			stmt.setString(3, aeronave.getCodigo());
			stmt.setInt(4, aeronave.getId());
			stmt.execute();

		} catch (Exception e) {
			
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletarAeronave(AeronaveModel aeronave) throws ExceptionDAO {
		String sql = "delete from aeronave where id=?";
		
		Connection con = new Conexao().getConnection();
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, aeronave.getId());
			
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<AeronaveModel> listarDados() throws ExceptionDAO {
		String sql = "select *from aeronave ";
		Connection con = new Conexao().getConnection();
		ArrayList<AeronaveModel> aeronaves = null;
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			
			if (rs != null) {
				aeronaves = new ArrayList<AeronaveModel>();
				while (rs.next()) {
					AeronaveModel um = new AeronaveModel();
					um.setId(rs.getInt("id"));

					um.setFabricante(rs.getString("fabricante"));
					um.setModelo(rs.getString("modelo"));
					um.setCodigo(rs.getString("codigo"));

					aeronaves.add(um);
				}
			}
			
			stmt.close();
			con.close();
		} catch (Exception e) {
		}
		
		return aeronaves;
	}
	
	public ArrayList<AeronaveModel> pesquisaAeronave(Integer idAeronave) throws ExceptionDAO {

		String sql = "select *from aeronave where id like " + idAeronave;
		Connection con = new Conexao().getConnection();
		ArrayList<AeronaveModel> usuarios = null;

		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			if (rs != null) {
				usuarios = new ArrayList<AeronaveModel>();
				while (rs.next()) {
					AeronaveModel um = new AeronaveModel();
					um.setId(rs.getInt("id"));

					um.setFabricante(rs.getString("fabricante"));
					um.setModelo(rs.getString("modelo"));
					um.setCodigo(rs.getString("codigo"));
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
	
	

}
