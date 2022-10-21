package br.com.voeairlines.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.voeairlines.controller.AeronaveController;
import br.com.voeairlines.controller.UsuarioController;
import br.com.voeairlines.dao.ExceptionDAO;
import br.com.voeairlines.model.AeronaveModel;
import br.com.voeairlines.model.UsuarioModel;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class TelaCadastrarAeronave extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtIdTipo;
	private JTextField txtFabricante;
	private JTextField txtModelo;
	private JTextField txtCodigo;
	private JTextField txtIdPesquisa;
	private JTable tbDados;

	public TelaCadastrarAeronave() {
		setResizable(false);
		setTitle("Cadastro Aeronave");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 560);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(198, 236, 244));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(new Color(0, 0, 0));
		lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblId.setBounds(10, 74, 46, 14);
		contentPane.add(lblId);

		JLabel lblIdTipo = new JLabel("IdTipo: ");
		lblIdTipo.setForeground(new Color(0, 0, 0));
		lblIdTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIdTipo.setBounds(132, 74, 56, 14);
		contentPane.add(lblIdTipo);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(36, 72, 86, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);

		txtIdTipo = new JTextField();
		txtIdTipo.setEditable(false);
		txtIdTipo.setBounds(181, 72, 86, 20);
		contentPane.add(txtIdTipo);
		txtIdTipo.setColumns(10);

		JLabel lblFabricante = new JLabel("Fabricante: ");
		lblFabricante.setForeground(new Color(0, 0, 0));
		lblFabricante.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFabricante.setBounds(277, 74, 86, 14);
		contentPane.add(lblFabricante);

		txtFabricante = new JTextField();
		txtFabricante.setText("");
		txtFabricante.setBounds(355, 72, 86, 20);
		contentPane.add(txtFabricante);
		txtFabricante.setColumns(10);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setForeground(new Color(0, 0, 0));
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblModelo.setBounds(451, 74, 56, 14);
		contentPane.add(lblModelo);

		txtModelo = new JTextField();
		txtModelo.setBounds(507, 72, 86, 20);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);

		JLabel lblCodigo = new JLabel("Código:");
		lblCodigo.setForeground(new Color(0, 0, 0));
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCodigo.setBounds(603, 74, 56, 14);
		contentPane.add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(656, 72, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtFabricante.equals("") && txtModelo.getText().equals("") && txtCodigo.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Preencha os Campos Corretamente");
					} else {
						AeronaveController aeronaveController = new AeronaveController();
						aeronaveController.cadastrarAeronave(txtFabricante.getText(), txtModelo.getText(),
								txtCodigo.getText());
						JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso");

						txtFabricante.setText("");
						txtModelo.setText("");
						txtCodigo.setText("");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Erro: " + e2);
				}
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCadastrar.setBounds(87, 151, 101, 37);
		contentPane.add(btnCadastrar);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean sucesso;
				try {
					AeronaveController aeronaveController = new AeronaveController();
					sucesso = aeronaveController.atualizaDados(Integer.parseInt(txtId.getText()),
							txtFabricante.getText(), txtModelo.getText(), txtCodigo.getText());

					if (sucesso == true) {
						JOptionPane.showMessageDialog(null, "O cadastro foi alterado com sucesso");
						txtFabricante.setText("");
						txtModelo.setText("");
						txtCodigo.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "Os campos não estão preenchidos corretamente.");
					}
				} catch (Exception e2) {
					
				}

			}
		});
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAtualizar.setBounds(305, 151, 89, 37);
		contentPane.add(btnAtualizar);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String message = "Deseja realmente apagar o usuario?";
				String title = "Confirmação";
				
				int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {

					AeronaveController aeronaveController = new AeronaveController();
					try {

						aeronaveController.deletarAeronave(Integer.parseInt(txtId.getText()));
						JOptionPane.showMessageDialog(null, "Usuario Deletado");
					} catch (NumberFormatException | ExceptionDAO e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				txtId.setText("");
			}
		});
		btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeletar.setBounds(504, 151, 89, 37);
		contentPane.add(btnDeletar);

		JLabel lblIdPesquisa = new JLabel("ID:");
		lblIdPesquisa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIdPesquisa.setBounds(21, 353, 46, 14);
		contentPane.add(lblIdPesquisa);

		txtIdPesquisa = new JTextField();
		txtIdPesquisa.setBounds(47, 351, 46, 20);
		contentPane.add(txtIdPesquisa);
		txtIdPesquisa.setColumns(10);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtIdPesquisa.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID");
				} else {

					Integer idAeronave = Integer.parseInt(txtIdPesquisa.getText());

					AeronaveController aeronaveController = new AeronaveController();
					try {
						ArrayList<AeronaveModel> aeronaves = aeronaveController.pesquisaAeronave(idAeronave);
						aeronaves.forEach((AeronaveModel aeronave) -> {
							txtId.setText(Integer.toString(aeronave.getId()));
						});
						aeronaves.forEach((AeronaveModel aeronave) -> {
							txtFabricante.setText(aeronave.getFabricante());
						});
						aeronaves.forEach((AeronaveModel aeronave) -> {
							txtModelo.setText(aeronave.getModelo());
						});
						aeronaves.forEach((AeronaveModel aeronave) -> {
							txtCodigo.setText(aeronave.getCodigo());
							});
						
					} catch (ExceptionDAO e2) {
						Logger.getLogger(TelaCadastroUsuario.class.getName()).log(Level.SEVERE, null, e);
					}

				}
			}
		});
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPesquisar.setBounds(21, 378, 101, 46);
		contentPane.add(btnPesquisar);

		JButton btnListarDados = new JButton("Listar Dados");
		btnListarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel modelo = (DefaultTableModel) tbDados.getModel();
				modelo.setRowCount(0);
				AeronaveController aeronaveController = new AeronaveController();

				try {
					ArrayList<AeronaveModel> aeronaves = aeronaveController.listarDados();

					aeronaves.forEach((AeronaveModel aeronave) -> {
						modelo.addRow(
								new Object[] { aeronave.getFabricante(), aeronave.getModelo(), aeronave.getCodigo() });
					});
					tbDados.setModel(modelo);

				} catch (Exception e2) {
					
				}
			}
		});
		btnListarDados.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnListarDados.setBounds(288, 221, 150, 37);
		contentPane.add(btnListarDados);

		JLabel lblNewLabel_6 = new JLabel("Cadastrar Aeronave");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6.setBounds(277, 11, 216, 37);
		contentPane.add(lblNewLabel_6);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(132, 285, 556, 225);
		contentPane.add(scrollPane);

		tbDados = new JTable();
		tbDados.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Fabricante", "Modelo", "C\u00F3digo" }));
		scrollPane.setViewportView(tbDados);
	}
}
