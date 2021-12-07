package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import BD.PessoaBD3;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class ConsultarP extends JFrame {

	private JPanel contentPane;

	
	public ConsultarP() {
		setResizable(false);
		setTitle("Consulta de Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(700, 100, 619, 473);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Produtos em estoque");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(36, 35, 361, 14);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 82, 544, 285);
		contentPane.add(scrollPane);
		
		JTextArea campoTexto = new JTextArea();
		campoTexto.setEditable(false);
		scrollPane.setColumnHeaderView(campoTexto);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setIcon(new ImageIcon(ConsultarP.class.getResource("/Imagens/pesquisa.png")));
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				PessoaBD3 pessoaBD3 = new PessoaBD3();
				
				String dados3 = pessoaBD3.relatorioPessoas();
				
				campoTexto.setText(dados3);
				
			}
			
		});
		btnConsultar.setBounds(36, 388, 150, 33);
		contentPane.add(btnConsultar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(ConsultarP.class.getResource("/Imagens/editar.png")));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoTexto.setText("");
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLimpar.setBounds(253, 388, 124, 33);
		contentPane.add(btnLimpar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(ConsultarP.class.getResource("/Imagens/sair.png")));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSair.setBounds(456, 388, 124, 33);
		contentPane.add(btnSair);
	}
}
