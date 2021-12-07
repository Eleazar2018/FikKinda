package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BD.PessoaBD;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import javax.swing.JOptionPane;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class Consultar extends JFrame {

	private JPanel contentPane;

	
	public Consultar() {
		setResizable(false);
		setTitle("Consulta de clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(700, 100, 620, 480);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dados existentes na tabela");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(36, 35, 361, 14);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 82, 544, 257);
		contentPane.add(scrollPane);
		
		JTextArea campoTexto = new JTextArea();
		campoTexto.setEditable(false);
		scrollPane.setColumnHeaderView(campoTexto);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setIcon(new ImageIcon(Consultar.class.getResource("/Imagens/pesquisa.png")));
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				PessoaBD pessoaBD = new PessoaBD();
				
				String dados = pessoaBD.relatorioPessoas();//variavel auxiliar			
				
				campoTexto.setText(dados);
				
			}
			
		});
		btnConsultar.setBounds(36, 371, 141, 33);
		contentPane.add(btnConsultar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(Consultar.class.getResource("/Imagens/editar.png")));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoTexto.setText("");
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLimpar.setBounds(253, 371, 124, 33);
		contentPane.add(btnLimpar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(Consultar.class.getResource("/Imagens/sair.png")));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSair.setBounds(456, 371, 124, 33);
		contentPane.add(btnSair);
	}
}
