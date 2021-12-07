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
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;


public class CadastrarS extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoEndereco;
	private JTextField campoTelefone;
	private JTextField campoEmail;
	//private JTextField campoData;
//	private JTextField campoRG;
//	private JTextField campoCPF;
	
	private String nome,endereco,telefone,email;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_4;
	

	public CadastrarS() {
		setResizable(false);
		setTitle("Cadastro de Servi\u00E7os");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 100, 486, 556);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Funcion\u00E1rio que executou");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(153, 195, 185, 21);
		contentPane.add(lblNewLabel);
		
		campoNome = new JTextField();
		campoNome.setBounds(153, 227, 185, 20);
		contentPane.add(campoNome);
		campoNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Quantidade");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(153, 329, 95, 14);
		contentPane.add(lblNewLabel_1);
		
		campoEndereco = new JTextField();
		campoEndereco.setBounds(153, 354, 185, 20);
		contentPane.add(campoEndereco);
		campoEndereco.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Descri\u00E7\u00E3o do servi\u00E7o");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(153, 258, 185, 29);
		contentPane.add(lblNewLabel_2);
		
		campoTelefone = new JTextField();
		campoTelefone.setBounds(153, 298, 185, 20);
		contentPane.add(campoTelefone);
		campoTelefone.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Pre\u00E7o Unit\u00E1rio");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(153, 385, 119, 30);
		contentPane.add(lblNewLabel_3);
		
		campoEmail = new JTextField();
		campoEmail.setBounds(153, 426, 68, 20);
		contentPane.add(campoEmail);
		campoEmail.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon(CadastrarS.class.getResource("/Imagens/adicionar.png")));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Pessoa4 pessoa4 = new Pessoa4();
				PessoaBD4 pessoaBD4 = new PessoaBD4();
				
				nome = campoNome.getText();
				endereco = campoEndereco.getText();
				telefone = campoTelefone.getText();
				email = campoEmail.getText();
				//data = campoData.getText();
			//	RG = campoRG.getText();
			//	CPF = campoCPF.getText();
				
				pessoa4.setExecutante(nome);
				pessoa4.setServico(endereco);
				pessoa4.setQuantidade(telefone);
				pessoa4.setPreco(email);
				
				if(pessoaBD4.inserirPessoa(pessoa4) == true)
				{
					JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso!!!", "Cadastro",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Erro no cadastro", "Erro",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCadastrar.setBounds(53, 468, 149, 33);
		contentPane.add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(CadastrarS.class.getResource("/Imagens/editar.png")));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoNome.setText("");
				campoEndereco.setText("");
				campoTelefone.setText("");
				campoEmail.setText("");
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLimpar.setBounds(313, 468, 139, 33);
		contentPane.add(btnLimpar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSair.setBounds(523, 450, 139, 23);
		contentPane.add(btnSair);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCdigo.setBounds(153, 28, 68, 21);
		contentPane.add(lblCdigo);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(153, 67, 68, 20);
		contentPane.add(textField);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblData.setBounds(153, 117, 68, 14);
		contentPane.add(lblData);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(156, 149, 185, 20);
		contentPane.add(textField_1);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(Color.GRAY);
		lblNewLabel_4.setBackground(Color.yellow);
		lblNewLabel_4.setBounds(332, 426, 77, 17);
		contentPane.add(lblNewLabel_4);
	}
}
