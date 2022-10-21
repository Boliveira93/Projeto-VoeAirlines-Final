package br.com.voeairlines.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class TelaCadastrarTipoAeronave extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtDescricao;
	private JTextField txtID;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarTipoAeronave frame = new TelaCadastrarTipoAeronave();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace(); 
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public TelaCadastrarTipoAeronave() {
		setTitle("Cadastro Tipo Aeronave");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setText("");
		txtId.setBounds(88, 8, 86, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Descrição:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 78, 70, 14);
		contentPane.add(lblNewLabel_1);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(88, 76, 86, 20);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(10, 227, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(109, 227, 89, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(208, 227, 89, 23);
		contentPane.add(btnDeletar);
		
		JLabel lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(314, 231, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtID = new JTextField();
		txtID.setBounds(340, 228, 46, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquiar");
		btnPesquisar.setBounds(416, 227, 89, 23);
		contentPane.add(btnPesquisar);
	}

}
