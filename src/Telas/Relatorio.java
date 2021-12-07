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


import BD.PessoaBD;
import Dados.Pessoa;
import java.awt.SystemColor;

public class Relatorio extends JFrame
{
   private DefaultTableModel modelo;
   private JTable tabela;
   private String nome,endereco,telefone,email;
   
   
   private PessoaBD pessoaBD;
   private Pessoa pessoa;
   
   
   public Relatorio()
   {
   	getContentPane().setBackground(SystemColor.inactiveCaption);
	   
	   pessoaBD = new PessoaBD();
	   pessoa = new Pessoa();
	   
	   
	   modelo = new DefaultTableModel();
	   tabela = new JTable(modelo);
	   
	   modelo.addColumn("Nome");
	   modelo.addColumn("Endereço");
	   modelo.addColumn("Telefone");
	   modelo.addColumn("Email");
	   
	   setTitle("Relatório de Pessoas");
	   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	   setBounds(300, 100, 618, 463);
	   pessoaBD.relatorioTabelaPessoas(pessoa, modelo);   
	   
	   
	   tabela.setPreferredScrollableViewportSize(new Dimension(700,400));
	   Container c = getContentPane();
	   c.setLayout(new FlowLayout());
	   JScrollPane scarollPane = new JScrollPane(tabela);
	   c.add(scarollPane);
	   setSize(800,550);
	   setVisible(true);
	   
	  
	   JButton btnConsultar = new JButton("Fechar");
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();				
			}
			
		});
		btnConsultar.setBounds(100, 410, 124, 23);
		c.add(btnConsultar);
	   
	   
   }
    
}
