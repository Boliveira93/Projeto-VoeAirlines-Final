package br.com.voeairlines.model;

import java.util.ArrayList;

import br.com.voeairlines.dao.AeronaveDAO;
import br.com.voeairlines.dao.ExceptionDAO;
import br.com.voeairlines.dao.UsuarioDAO;

public class AeronaveModel {

	private Integer id;
	private Integer idTipo;
	private String fabricante;
	private String modelo;
	private String codigo;

	public AeronaveModel() {

	}

	public AeronaveModel(Integer id) {
		this.id = id;
	}

	public AeronaveModel(Integer id, String fabricante, String modelo, String codigo) {
		super();
		this.id = id;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.codigo = codigo;
	}

	public AeronaveModel(String fabricante, String modelo, String codigo) {

		this.fabricante = fabricante;
		this.modelo = modelo;
		this.codigo = codigo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void cadastrarAeronave(AeronaveModel aeronave) throws ExceptionDAO {
		new AeronaveDAO().cadastrarAeronave(aeronave);
	}

	public void selecionarAeronave(AeronaveModel aeronave) throws ExceptionDAO {
		new AeronaveDAO().selecionarAeronave(aeronave);
	}

	public void atualizaDados(AeronaveModel aeronave) throws ExceptionDAO {
		new AeronaveDAO().atualizaDados(aeronave);
	}

	public void deletarAeronave(AeronaveModel aeronave) throws ExceptionDAO {
		new AeronaveDAO().deletarAeronave(aeronave);
	}

	public ArrayList<AeronaveModel> listarDados() throws ExceptionDAO {
		return new AeronaveDAO().listarDados();
	}
	
	public ArrayList<AeronaveModel> pesquisaAeronave(Integer idAeronave) throws ExceptionDAO {
		return new  AeronaveDAO().pesquisaAeronave(idAeronave);
	}

}
