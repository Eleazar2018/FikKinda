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
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Cadastrar extends JFrame {

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
	private JTextField textField_2;
	private JTextField textField_3;
	

	public Cadastrar() {
		setResizable(false);
		setTitle("Cadastro de Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 150, 540, 441);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(96, 35, 68, 14);
		contentPane.add(lblNewLabel);
		
		campoNome = new JTextField();
		campoNome.setBounds(96, 67, 185, 20);
		contentPane.add(campoNome);
		campoNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Endere\u00E7o:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(37, 210, 95, 14);
		contentPane.add(lblNewLabel_1);
		
		campoEndereco = new JTextField();
		campoEndereco.setBounds(37, 235, 185, 20);
		contentPane.add(campoEndereco);
		campoEndereco.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(303, 124, 83, 14);
		contentPane.add(lblNewLabel_2);
		
		campoTelefone = new JTextField();
		campoTelefone.setBounds(303, 149, 195, 20);
		contentPane.add(campoTelefone);
		campoTelefone.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(303, 193, 68, 14);
		contentPane.add(lblNewLabel_3);
		
		campoEmail = new JTextField();
		campoEmail.setBounds(303, 234, 195, 20);
		contentPane.add(campoEmail);
		campoEmail.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon(Cadastrar.class.getResource("/Imagens/editar.png")));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Pessoa pessoa = new Pessoa();//acesso aos dados
				PessoaBD pessoaBD = new PessoaBD(); //acesso ao BD
				
				nome = campoNome.getText();
				endereco = campoEndereco.getText();
				telefone = campoTelefone.getText();
				email = campoEmail.getText();

				pessoa.setNome(nome);
				pessoa.setEndereco(endereco);
				pessoa.setTelefone(telefone);
				pessoa.setEmail(email);
				
				if(pessoaBD.inserirPessoa(pessoa) == true)
				{
					JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso!!!", "Cadastro",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Erro no cadastro", "Erro",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCadastrar.setBounds(37, 336, 146, 33);
		contentPane.add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(Cadastrar.class.getResource("/Imagens/editar.png")));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoNome.setText("");
				campoEndereco.setText("");
				campoTelefone.setText("");
				campoEmail.setText("");
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLimpar.setBounds(210, 336, 139, 33);
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
		lblCdigo.setBounds(37, 35, 68, 14);
		contentPane.add(lblCdigo);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(37, 67, 49, 20);
		contentPane.add(textField);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblData.setBounds(307, 35, 68, 14);
		contentPane.add(lblData);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(310, 67, 188, 20);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("CPF:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(166, 124, 95, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(161, 149, 116, 20);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("RG:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(37, 126, 95, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(37, 149, 95, 20);
		contentPane.add(textField_3);
		
		JButton btnSair_1 = new JButton("Sair");
		btnSair_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnSair_1.setIcon(new ImageIcon(Cadastrar.class.getResource("/Imagens/sair.png")));
		btnSair_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSair_1.setBounds(374, 336, 124, 33);
		contentPane.add(btnSair_1);
	}
}
