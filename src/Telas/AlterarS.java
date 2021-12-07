package Telas;

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
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class AlterarS extends JFrame {

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
	private String novoExecutante;
	private String novoServico;
	private String novoQuantidade;
	private String novoPreco;
	private String nomeConsulta = "";
	
	private Pessoa4 pessoa4;
    private PessoaBD4 pessoaBD4;
	
	public AlterarS() {
		setResizable(false);
		setFont(new Font("Arial", Font.PLAIN, 16));
		
		pessoa4 = new Pessoa4();
		pessoaBD4 = new PessoaBD4();
		
		//nomeAtual = "";
		//enderecoAtual = "";
		//telefoneAtual = "";
		//emailAtual = "";
		novoExecutante = "";
		novoServico = "";
		novoQuantidade = "";
		novoPreco = "";	
		nomeConsulta = "";
		
		setTitle("Altera\u00E7\u00E3o dos dados do servi\u00E7o prestado");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(50, 100, 619, 463);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consulta por nome funcion\u00E1rio");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(44, 26, 407, 18);
		contentPane.add(lblNewLabel);
		
		campoNomeConsulta = new JTextField();
		campoNomeConsulta.setBounds(44, 62, 237, 20);
		contentPane.add(campoNomeConsulta);
		campoNomeConsulta.setColumns(10);
		
		lblEndereo = new JLabel("Alterar a descri\u00E7\u00E3o do servi\u00E7o");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEndereo.setBounds(44, 185, 407, 18);
		contentPane.add(lblEndereo);
		
		campoNovoEndereco = new JTextField();
		campoNovoEndereco.setColumns(10);
		campoNovoEndereco.setBounds(44, 210, 237, 20);
		contentPane.add(campoNovoEndereco);
		
		lblTelefone = new JLabel("Alterar a quantidade do servi\u00E7o prestado");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefone.setBounds(44, 241, 407, 18);
		contentPane.add(lblTelefone);
		
		campoNovoTelefone = new JTextField();
		campoNovoTelefone.setColumns(10);
		campoNovoTelefone.setBounds(44, 266, 109, 20);
		contentPane.add(campoNovoTelefone);
		
		lblEmail = new JLabel("Alterar o pre\u00E7o do servi\u00E7o");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(44, 297, 407, 18);
		contentPane.add(lblEmail);
		
		campoNovoEmail = new JTextField();
		campoNovoEmail.setColumns(10);
		campoNovoEmail.setBounds(44, 322, 109, 20);
		contentPane.add(campoNovoEmail);
		
		btnConfirma = new JButton("Confirmar");
		btnConfirma.setIcon(new ImageIcon(AlterarS.class.getResource("/Imagens/adicionar.png")));
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
	            novoExecutante = campoNovoNome.getText();
	            novoServico = campoNovoEndereco.getText();
	            novoQuantidade = campoNovoTelefone.getText();
	            novoPreco = campoNovoEmail.getText();
	            
	                      
	            pessoa4.setExecutante(novoExecutante);
	            pessoa4.setServico(novoServico);
	            pessoa4.setQuantidade(novoQuantidade);
	            pessoa4.setPreco(novoPreco);
	            
	            if(pessoaBD4.atualizarPessoa(pessoa4, nomeConsulta))
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
		btnConfirma.setBounds(44, 377, 139, 33);
		contentPane.add(btnConfirma);
		
		btnLimpa = new JButton("Limpar");
		btnLimpa.setIcon(new ImageIcon(AlterarS.class.getResource("/Imagens/editar.png")));
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
		btnLimpa.setBounds(213, 377, 128, 33);
		contentPane.add(btnLimpa);
		
		btnCancela = new JButton("Cancelar");
		btnCancela.setIcon(new ImageIcon(AlterarS.class.getResource("/Imagens/botao-cancelar.png")));
		btnCancela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancela.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancela.setBounds(391, 377, 128, 33);
		contentPane.add(btnCancela);
		
		lblNomeNome = new JLabel("Alterar o nome do funcion\u00E1rio que executou o servi\u00E7o");
		lblNomeNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNomeNome.setBounds(44, 129, 407, 18);
		contentPane.add(lblNomeNome);
		
		campoNovoNome = new JTextField();
		campoNovoNome.setColumns(10);
		campoNovoNome.setBounds(44, 154, 237, 20);
		contentPane.add(campoNovoNome);
		
		btnProcura = new JButton("Procurar");
		btnProcura.setIcon(new ImageIcon(AlterarS.class.getResource("/Imagens/pesquisa.png")));
		btnProcura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			   			    
				nomeConsulta = campoNomeConsulta.getText();
				
				if(pessoaBD4.procuraPessoa(pessoa4, nomeConsulta))
				{
					campoNovoEndereco.setText(pessoa4.getServico());
					campoNovoTelefone.setText(pessoa4.getQuantidade());
					campoNovoEmail.setText(pessoa4.getPreco());
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Nome: "+nomeConsulta+" não encontrado!!!","Erro",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnProcura.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnProcura.setBounds(391, 59, 128, 33);
		contentPane.add(btnProcura);
	}

}
