package Telas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


import BD.PessoaBD4;
import Dados.Pessoa4;
import java.awt.SystemColor;
import java.awt.Color;

public class Manual extends JFrame
{
   private DefaultTableModel modelo;
   private String nome,endereco,telefone,email;
   
   
   private PessoaBD4 pessoaBD4;
   private Pessoa4 pessoa4;
   
   
   public Manual()
   {
   	getContentPane().setBackground(SystemColor.textHighlight);
   	setResizable(false);
   	setAutoRequestFocus(false);
	   
	   pessoaBD4 = new PessoaBD4();
	   pessoa4 = new Pessoa4();
	   
	   
	   modelo = new DefaultTableModel();
	   
	   modelo.addColumn("Executante");
	   modelo.addColumn("Serviço");
	   modelo.addColumn("Quantidade");
	   modelo.addColumn("Preço unitário");
	   
	   setTitle("Manual do Sistema FikLinda");
	   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	   setBounds(300, 100, 618, 463);
	   pessoaBD4.relatorioTabelaPessoas(pessoa4, modelo);
	   setSize(800,550);
	   getContentPane().setLayout(null);
	   
	   JButton btnNewButton = new JButton("Manual .pdf");
	   btnNewButton.setForeground(Color.WHITE);
	   btnNewButton.setIcon(new ImageIcon(Manual.class.getResource("/Imagens/FikLinda.png")));
	   btnNewButton.setBackground(Color.BLACK);
	   btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
	   btnNewButton.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent arg0) {
	   		
	   		try {
				Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "E:\\2-FATEC\\3-Engenharia-de-Software-Bruno\\FikLindaManualUsuario.pdf");
				
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Verifique se o seu arquivo existe");
		
			}
		}
	});
	   btnNewButton.setBounds(187, 88, 422, 356);
	   getContentPane().add(btnNewButton);
	   
	   JLabel lblNewLabel = new JLabel("Clique na imagem para acessar o Manual do Sistema");
	   lblNewLabel.setFont(new Font("Segoe Print", Font.BOLD, 22));
	   lblNewLabel.setForeground(Color.WHITE);
	   lblNewLabel.setBounds(109, 21, 584, 31);
	   getContentPane().add(lblNewLabel);
	   setVisible(true);
	   
	   
   }
}
