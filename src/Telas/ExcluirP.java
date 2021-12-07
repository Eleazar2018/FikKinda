package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BD.PessoaBD3;
import Dados.Pessoa3;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class ExcluirP extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;

	
	public ExcluirP() {
		setResizable(false);
		setTitle("Exclus\u00E3o de Produtos do Estoque");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 200, 405, 278);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Excluir produto por Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(84, 66, 295, 14);
		contentPane.add(lblNewLabel);
		
		campoNome = new JTextField();
		campoNome.setBounds(84, 93, 188, 20);
		contentPane.add(campoNome);
		campoNome.setColumns(10);
		
		JButton btnProcurar = new JButton("Excluir");
		btnProcurar.setIcon(new ImageIcon(ExcluirP.class.getResource("/Imagens/bin.png")));
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome;
				
				PessoaBD3 pessoaBD3 = new PessoaBD3();
				Pessoa3 pessoa3 = new Pessoa3();
				
				nome = campoNome.getText();
				
				pessoa3.setDescricao(nome);
				
				if(pessoaBD3.excluirPessoa(pessoa3) == true)
				{
					JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!!!", "Exclusão",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Produto não excluído!!!", "Erro",JOptionPane.ERROR_MESSAGE);
				}				
				
			}
		});
		btnProcurar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnProcurar.setBounds(33, 188, 124, 40);
		contentPane.add(btnProcurar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(ExcluirP.class.getResource("/Imagens/botao-cancelar.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBounds(223, 188, 134, 40);
		contentPane.add(btnCancelar);
	}
	
}
