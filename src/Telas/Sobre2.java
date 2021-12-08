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

public class Sobre2 extends JFrame
{
   private DefaultTableModel modelo;
   private String nome,endereco,telefone,email;
   
   
   private PessoaBD4 pessoaBD4;
   private Pessoa4 pessoa4;
   
   
   public Sobre2()
   {
   	setResizable(false);
   	setAutoRequestFocus(false);
   	getContentPane().setBackground(SystemColor.activeCaption);
	   
	   pessoaBD4 = new PessoaBD4();
	   pessoa4 = new Pessoa4();
	   
	   
	   modelo = new DefaultTableModel();
	   
	   modelo.addColumn("Executante");
	   modelo.addColumn("Serviço");
	   modelo.addColumn("Quantidade");
	   modelo.addColumn("Preço unitário");
	   
	   setTitle("FikLinda");
	   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	   setBounds(300, 100, 618, 463);
	   pessoaBD4.relatorioTabelaPessoas(pessoa4, modelo);
	   Container c = getContentPane();
	   setSize(800,550);
	   setVisible(true);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Sobre2.class.getResource("/Imagens/IMG_2.jpg")));
		lblNewLabel.setBounds(131, 36, 583, 446);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sistema desenvolvido pela EL3R");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(131, 11, 467, 53);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contato: (12) 9999-4848 ");
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("Rockwell", Font.ITALIC, 24));
		lblNewLabel_1_1.setBounds(141, 447, 305, 53);
		getContentPane().add(lblNewLabel_1_1);
	   
	   
   }
}
