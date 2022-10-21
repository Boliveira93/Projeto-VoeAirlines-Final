package br.com.voeairlines.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaDeConsulta extends JFrame {

	private JPanel contentPane;

	public TelaDeConsulta() {
		setTitle("Menu VoeAilines");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 427);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(198, 236, 244));
		contentPane.setForeground(new Color(0, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu VoeAirlines");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(118, 11, 234, 105);
		contentPane.add(lblNewLabel);
		
		JButton btncadastroAeronave = new JButton("Cadastrar Aeronave");
		btncadastroAeronave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaCadastrarAeronave exibir = new TelaCadastrarAeronave();
				exibir.setVisible(true);
			}
		});
		btncadastroAeronave.setFont(new Font("Tahoma", Font.BOLD, 12));
		btncadastroAeronave.setBounds(118, 249, 177, 56);
		contentPane.add(btncadastroAeronave);
		
		JButton btncadastroUsuario_1 = new JButton("Cadastrar Usuário");
		btncadastroUsuario_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaCadastroUsuario exibir = new TelaCadastroUsuario();
				
				exibir.setVisible(true);
			}
		});
		btncadastroUsuario_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btncadastroUsuario_1.setBounds(118, 151, 183, 56);
		contentPane.add(btncadastroUsuario_1);
	}
}
