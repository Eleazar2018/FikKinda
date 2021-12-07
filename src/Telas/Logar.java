package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import BD.AcessoBD;
import Dados.Login;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Color;

public class Logar extends JFrame {

	private JPanel contentPane;
	private JTextField campoLogin;
	private JPasswordField campoSenha;
	
	private Principal p;
	//private Principal2 p2;

	
	
	public Logar() {
		setResizable(false);
		//p2 = new Principal2();
		p = new Principal();
		
		setTitle("Acesso ao sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 170, 431, 338);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConfirma = new JButton("Confirmar");
		btnConfirma.setIcon(new ImageIcon(Logar.class.getResource("/Imagens/adicionar.png")));
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome;
				String senha;
				
				AcessoBD acesso = new AcessoBD();//verifica acesso da tela Login
				Login login = new Login();
				
				nome = campoLogin.getText();
				senha = campoSenha.getText();
				
				login.setNome(nome);
				login.setSenha(senha);
				
				if(acesso.verificaAcesso(login) == true)
				{
					p.setVisible(true);// abre a tela principal
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Erro nos dados informados", "Erro", JOptionPane.ERROR_MESSAGE);
				}
								
			}
		});
		btnConfirma.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConfirma.setBounds(229, 173, 153, 33);
		contentPane.add(btnConfirma);
		
		JButton btnCancela = new JButton("Cancelar");
		btnCancela.setIcon(new ImageIcon(Logar.class.getResource("/Imagens/botao-cancelar.png")));
		btnCancela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		btnCancela.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancela.setBounds(229, 221, 153, 33);
		contentPane.add(btnCancela);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(229, 11, 176, 25);
		contentPane.add(lblNewLabel);
		
		campoLogin = new JTextField();
		campoLogin.setBounds(229, 47, 153, 20);
		contentPane.add(campoLogin);
		campoLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSenha.setBounds(229, 78, 176, 25);
		contentPane.add(lblSenha);
		
		campoSenha = new JPasswordField();
		campoSenha.setBounds(229, 114, 153, 20);
		contentPane.add(campoSenha);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBackground(SystemColor.inactiveCaption);
		lblNewLabel_1.setIcon(new ImageIcon(Logar.class.getResource("/Imagens/FikLinda.png")));
		lblNewLabel_1.setBounds(20, 20, 188, 277);
		contentPane.add(lblNewLabel_1);
	}
}
