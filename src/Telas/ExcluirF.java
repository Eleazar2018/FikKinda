package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BD.PessoaBD2;
import Dados.Pessoa2;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class ExcluirF extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;

	
	public ExcluirF() {
		setResizable(false);
		setTitle("Excluir Funcion\u00E1rio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 200, 405, 278);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Excluir por Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(84, 66, 295, 14);
		contentPane.add(lblNewLabel);
		
		campoNome = new JTextField();
		campoNome.setBounds(84, 93, 188, 20);
		contentPane.add(campoNome);
		campoNome.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome;
				
				PessoaBD2 pessoaBD2 = new PessoaBD2();
				Pessoa2 pessoa = new Pessoa2();
				
				nome = campoNome.getText();
				
				pessoa.setNome(nome);
				
				if(pessoaBD2.excluirPessoa(pessoa) == true)
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
		btnProcurar.setBounds(33, 188, 124, 23);
		contentPane.add(btnProcurar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBounds(223, 188, 124, 23);
		contentPane.add(btnCancelar);
	}
	
}
