package Telas;

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
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class AlterarF extends JFrame {

	private JPanel contentPane;
	private JTextField campoNomeConsulta;
	private JLabel lblEndereo;
	private JTextField campoNovoEndereco;
	private JLabel lblTelefone;
	private JTextField campoNovoTelefone;
	private JLabel lblEmail;
	private JTextField campoNovoEmail;
	private JButton btnConfirma;
	private JButton btnLimpa;
	private JButton btnCancela;
	private JLabel lblNomeNome;
	private JTextField campoNovoNome;
	private JButton btnProcura;

	
	//private String nomeAtual, enderecoAtual, telefoneAtual, emailAtual;
	private String novoNome;
	private String novoEndereco;
	private String novoTelefone;
	private String novoEmail;
	private String nomeConsulta = "";
	
	private Pessoa pessoa;
    private PessoaBD pessoaBD;
	
	public AlterarF() {
		setResizable(false);
		
		pessoa = new Pessoa();
		pessoaBD = new PessoaBD();
		
		//nomeAtual = "";
		//enderecoAtual = "";
		//telefoneAtual = "";
		//emailAtual = "";
		novoNome = "";
		novoEndereco = "";
		novoTelefone = "";
		novoEmail = "";	
		nomeConsulta = "";
		
		setTitle("Altera\u00E7\u00E3o dos dados dados do Funcion\u00E1rio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(50, 150, 620, 480);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome do funcion\u00E1rio:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(44, 26, 407, 25);
		contentPane.add(lblNewLabel);
		
		campoNomeConsulta = new JTextField();
		campoNomeConsulta.setBounds(44, 62, 237, 20);
		contentPane.add(campoNomeConsulta);
		campoNomeConsulta.setColumns(10);
		
		lblEndereo = new JLabel("Alterar o endere\u00E7o:");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEndereo.setBounds(44, 185, 407, 25);
		contentPane.add(lblEndereo);
		
		campoNovoEndereco = new JTextField();
		campoNovoEndereco.setColumns(10);
		campoNovoEndereco.setBounds(44, 210, 237, 20);
		contentPane.add(campoNovoEndereco);
		
		lblTelefone = new JLabel("Alterar o telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefone.setBounds(44, 241, 407, 14);
		contentPane.add(lblTelefone);
		
		campoNovoTelefone = new JTextField();
		campoNovoTelefone.setColumns(10);
		campoNovoTelefone.setBounds(44, 266, 109, 20);
		contentPane.add(campoNovoTelefone);
		
		lblEmail = new JLabel("Alterar o email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(44, 297, 407, 14);
		contentPane.add(lblEmail);
		
		campoNovoEmail = new JTextField();
		campoNovoEmail.setColumns(10);
		campoNovoEmail.setBounds(44, 322, 237, 20);
		contentPane.add(campoNovoEmail);
		
		btnConfirma = new JButton("Confirmar");
		btnConfirma.setIcon(new ImageIcon(AlterarF.class.getResource("/Imagens/salve-.png")));
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
	            novoNome = campoNovoNome.getText();
	            novoEndereco = campoNovoEndereco.getText();
	            novoTelefone = campoNovoTelefone.getText();
	            novoEmail = campoNovoEmail.getText();
	            
	                      
	            pessoa.setNome(novoNome);
	            pessoa.setEndereco(novoEndereco);
	            pessoa.setTelefone(novoTelefone);
	            pessoa.setEmail(novoEmail);
	            
	            if(pessoaBD.atualizarPessoa(pessoa, nomeConsulta))
	            {
	            	JOptionPane.showMessageDialog(null,"Dados atualizados com sucesso","Sucesso!!!",JOptionPane.INFORMATION_MESSAGE);
	            }
	            else
	            {
	            	JOptionPane.showMessageDialog(null,"Dados não atualizados","Erro",JOptionPane.ERROR_MESSAGE);
	            }
	            	
	          
			}
				
		});
		btnConfirma.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConfirma.setBounds(50, 377, 145, 33);
		contentPane.add(btnConfirma);
		
		btnLimpa = new JButton("Limpar");
		btnLimpa.setIcon(new ImageIcon(AlterarF.class.getResource("/Imagens/editar.png")));
		btnLimpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoNomeConsulta.setText("");
				campoNovoNome.setText("");
				campoNovoEndereco.setText("");
				campoNovoTelefone.setText("");
				campoNovoEmail.setText("");
			}
		});
		btnLimpa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLimpa.setBounds(245, 377, 128, 33);
		contentPane.add(btnLimpa);
		
		btnCancela = new JButton("Cancelar");
		btnCancela.setIcon(new ImageIcon(AlterarF.class.getResource("/Imagens/botao-cancelar.png")));
		btnCancela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancela.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancela.setBounds(423, 377, 128, 33);
		contentPane.add(btnCancela);
		
		lblNomeNome = new JLabel("Alterar nome:");
		lblNomeNome.setBackground(SystemColor.activeCaption);
		lblNomeNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNomeNome.setBounds(44, 129, 407, 14);
		contentPane.add(lblNomeNome);
		
		campoNovoNome = new JTextField();
		campoNovoNome.setColumns(10);
		campoNovoNome.setBounds(44, 154, 237, 20);
		contentPane.add(campoNovoNome);
		
		btnProcura = new JButton("Procurar");
		btnProcura.setIcon(new ImageIcon(AlterarF.class.getResource("/Imagens/pesquisa.png")));
		btnProcura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			   			    
				nomeConsulta = campoNomeConsulta.getText();
				
				if(pessoaBD.procuraPessoa(pessoa, nomeConsulta))
				{
					campoNovoEndereco.setText(pessoa.getEndereco());
					campoNovoTelefone.setText(pessoa.getTelefone());
					campoNovoEmail.setText(pessoa.getEmail());
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Nome: "+nomeConsulta+" não encontrado!!!","Erro",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnProcura.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnProcura.setBounds(423, 54, 128, 33);
		contentPane.add(btnProcura);
	}

}
