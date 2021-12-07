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
   	getContentPane().setBackground(Color.BLACK);
	   
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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Sobre2.class.getResource("/Imagens/IMG_2.jpg")));
		lblNewLabel.setBounds(131, 94, 506, 369);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("OBRIGADO PELA ATEN\u00C7\u00C3O !!!");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(185, 48, 467, 53);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("FELIZ NATAL ...");
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(257, 447, 238, 53);
		getContentPane().add(lblNewLabel_1_1);
	   
	   
   }
}
