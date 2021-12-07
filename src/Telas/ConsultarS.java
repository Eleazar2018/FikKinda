package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BD.PessoaBD4;

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

public class ConsultarS extends JFrame {

	private JPanel contentPane;

	
	public ConsultarS() {
		setResizable(false);
		setTitle("Consultar por servi\u00E7os prestados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(700, 100, 619, 463);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Servi\u00E7os prestados pela FikLinda");
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
		btnConsultar.setIcon(new ImageIcon(ConsultarS.class.getResource("/Imagens/pesquisa.png")));
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				PessoaBD4 pessoaBD4 = new PessoaBD4();
				
				String dados = pessoaBD4.relatorioPessoas();
				
				campoTexto.setText(dados);
				
			}
			
		});
		btnConsultar.setBounds(36, 388, 138, 33);
		contentPane.add(btnConsultar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(ConsultarS.class.getResource("/Imagens/editar.png")));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoTexto.setText("");
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLimpar.setBounds(253, 388, 124, 33);
		contentPane.add(btnLimpar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(ConsultarS.class.getResource("/Imagens/sair.png")));
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
