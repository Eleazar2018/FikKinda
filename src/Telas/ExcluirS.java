package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BD.PessoaBD4;
import Dados.Pessoa4;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;

public class ExcluirS extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;

	
	public ExcluirS() {
		setResizable(false);
		setTitle("Excluir Servi\u00E7o prestado ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 200, 405, 278);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Excluir por Funcion\u00E1rio executou o servi\u00E7o");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(33, 44, 314, 20);
		contentPane.add(lblNewLabel);
		
		campoNome = new JTextField();
		campoNome.setBounds(83, 111, 188, 20);
		contentPane.add(campoNome);
		campoNome.setColumns(10);
		
		JButton btnProcurar = new JButton("Excluir");
		btnProcurar.setForeground(new Color(0, 0, 0));
		btnProcurar.setBackground(Color.WHITE);
		btnProcurar.setIcon(new ImageIcon(ExcluirS.class.getResource("/Imagens/pesquisa.png")));
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome;
				
				PessoaBD4 pessoaBD4 = new PessoaBD4();
				Pessoa4 pessoa4 = new Pessoa4();
				
				nome = campoNome.getText();
				
				pessoa4.setExecutante(nome);
				
				if(pessoaBD4.excluirPessoa(pessoa4) == true)
				{
					JOptionPane.showMessageDialog(null, "Pessoa excluída com sucesso!!!", "Exclusão",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Pessoa não excluída!!!", "Erro",JOptionPane.ERROR_MESSAGE);
				}				
				
			}
		});
		btnProcurar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnProcurar.setBounds(33, 188, 124, 40);
		contentPane.add(btnProcurar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(ExcluirS.class.getResource("/Imagens/sair.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBounds(210, 188, 137, 40);
		contentPane.add(btnCancelar);
	}
	
}
