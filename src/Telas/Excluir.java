package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BD.PessoaBD;
import Dados.Pessoa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class Excluir extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;

	
	public Excluir() {
		setResizable(false);
		setTitle("Excluir Clientes do Banco de dados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 200, 405, 278);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escolher o nome da Tabela Consulta para excluir");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(33, 29, 323, 14);
		contentPane.add(lblNewLabel);
		
		campoNome = new JTextField();
		campoNome.setBounds(84, 93, 188, 33);
		contentPane.add(campoNome);
		campoNome.setColumns(10);
		
		JButton btnProcurar = new JButton("Excluir Cliente");
		btnProcurar.setIcon(new ImageIcon(Excluir.class.getResource("/Imagens/bin.png")));
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome;
				
				PessoaBD pessoaBD = new PessoaBD();
				Pessoa pessoa = new Pessoa();
				
				nome = campoNome.getText();
				
				pessoa.setNome(nome);
				
				if(pessoaBD.excluirPessoa(pessoa) == true)
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
		btnProcurar.setBounds(33, 188, 170, 33);
		contentPane.add(btnProcurar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(Excluir.class.getResource("/Imagens/sair.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBounds(222, 188, 134, 33);
		contentPane.add(btnCancelar);
	}
	
}
