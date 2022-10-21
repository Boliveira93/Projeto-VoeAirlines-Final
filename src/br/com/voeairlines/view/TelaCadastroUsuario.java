package br.com.voeairlines.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.voeairlines.controller.UsuarioController;
import br.com.voeairlines.dao.ExceptionDAO;
import br.com.voeairlines.model.UsuarioModel;

public class TelaCadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtUsuario;
	private JTextField txtSenha;
	private JTextField txtPesquisa;
	private Integer id = 0;
	private JTable tbDados;

	public void buscarUsuario(Integer id, String usuario, String senha) {
		this.id = id;
		this.txtUsuario.setText(usuario);
		this.txtSenha.setText(senha);
	}

	public TelaCadastroUsuario() {
		setResizable(false);
		initComponents();
	}
	
	public void initComponents() {
		setTitle("Cadastro VoeAirlines");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 577);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(198, 236, 244));
		contentPane.setForeground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(new Color(0, 0, 0));
		lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblId.setBounds(57, 129, 46, 14);
		contentPane.add(lblId);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(113, 127, 86, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuário:");
		lblUsuario.setForeground(new Color(0, 0, 0));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsuario.setBounds(237, 129, 61, 14);
		contentPane.add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(333, 127, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblSenha = new JLabel("Senha: ");
		lblSenha.setForeground(new Color(0, 0, 0));
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSenha.setBounds(446, 129, 86, 14);
		contentPane.add(lblSenha);

		txtSenha = new JTextField();
		txtSenha.setBounds(517, 127, 86, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (txtUsuario.getText().equals("") && txtSenha.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Preencha o Campo Usuário e/ou Senha");
					} else {
						UsuarioController usuarioController = new UsuarioController();
						usuarioController.cadastrarUsuario(txtUsuario.getText(), txtSenha.getText());
						JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso");

						txtUsuario.setText("");
						txtSenha.setText("");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Erro: " + e2);
				}
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCadastrar.setBounds(22, 186, 116, 23);
		contentPane.add(btnCadastrar);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean sucesso;

				try {
					UsuarioController usuarioController = new UsuarioController();
					sucesso = usuarioController.atualizaDados(Integer.parseInt(txtId.getText()), txtUsuario.getText(),
							txtSenha.getText());

					if (sucesso == true) {
						JOptionPane.showMessageDialog(null, "O cadastro foi alterado com sucesso");
						txtUsuario.setText("");
						txtSenha.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "Os campos não estão preenchidos corretamente.");
					}
				} catch (Exception e2) {
					
				}
			}

		});
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAtualizar.setBounds(267, 186, 89, 23);
		contentPane.add(btnAtualizar);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = "Deseja realmente apagar o usuario?";
				String title = "Confirmação";
				// Exibe caixa de dialogo (veja figura) solicitando confirmação ou não.
				// Se o usuário clicar em "Sim" retorna 0 pra variavel reply, se informado não
				// retorna 1
				int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {

					UsuarioController usuarioController = new UsuarioController();
					try {

						usuarioController.deletarUsuarios(Integer.parseInt(txtId.getText()));
						JOptionPane.showMessageDialog(null, "Usuario Deletado");
					} catch (NumberFormatException | ExceptionDAO e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				txtUsuario.setText("");
				txtSenha.setText("");
				txtId.setText("");
			}
		});
		btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeletar.setBounds(517, 186, 89, 23);
		contentPane.add(btnDeletar);

		JLabel lblNewLabel_3 = new JLabel("ID:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(57, 391, 46, 14);
		contentPane.add(lblNewLabel_3);

		txtPesquisa = new JTextField();
		txtPesquisa.setBounds(83, 389, 31, 20);
		contentPane.add(txtPesquisa);
		txtPesquisa.setColumns(10);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtPesquisa.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID");
				} else {

					Integer idUsuario = Integer.parseInt(txtPesquisa.getText());

					UsuarioController usuariocontroller = new UsuarioController();
					try {
						ArrayList<UsuarioModel> usuarios = usuariocontroller.pesquisaUsuario(idUsuario);
						usuarios.forEach((UsuarioModel usuario) -> {
							txtId.setText(Integer.toString(usuario.getId()));
						});
						usuarios.forEach((UsuarioModel usuario) -> {
							txtSenha.setText(usuario.getSenha());
						});
						usuarios.forEach((UsuarioModel usuario) -> {
							txtUsuario.setText(usuario.getUsuario());
						});

					} catch (ExceptionDAO e2) {
						Logger.getLogger(TelaCadastroUsuario.class.getName()).log(Level.SEVERE, null, e);
					}
				}

			}
		});
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPesquisar.setBounds(129, 387, 103, 23);
		contentPane.add(btnPesquisar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(267, 314, 385, 213);
		contentPane.add(scrollPane);

		tbDados = new JTable();
		tbDados.setForeground(new Color(64, 0, 64));
		tbDados.addMouseListener(new MouseAdapter() {
			
		});
		tbDados.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, },
				new String[] { "id", "usuario", "Senha" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tbDados);

		JButton btnNewButton = new JButton("Lista Dados");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel modelo = (DefaultTableModel) tbDados.getModel();
				modelo.setRowCount(0);
				UsuarioController usuarioController = new UsuarioController();
				try {
					ArrayList<UsuarioModel> usuarios = usuarioController.listaDados();

					usuarios.forEach((UsuarioModel usuario) -> {
						modelo.addRow(new Object[] { usuario.getId(), usuario.getUsuario(), usuario.getSenha() });
					});
					tbDados.setModel(modelo);

				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(399, 280, 116, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("CADASTRO USUÁRIO");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(220, 33, 246, 38);
		contentPane.add(lblNewLabel);
	}
}
