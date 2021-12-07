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


import BD.PessoaBD2;
import Dados.Pessoa2;
import java.awt.SystemColor;

public class RelatorioF extends JFrame
{
   private DefaultTableModel modelo;
   private JTable tabela;
   private String nome,endereco,telefone,email;
   
   
   private PessoaBD2 pessoaBD2;
   private Pessoa2 pessoa2;
   
   
   public RelatorioF()
   {
   	setResizable(false);
   	getContentPane().setBackground(SystemColor.inactiveCaption);
	   
	   pessoaBD2 = new PessoaBD2();
	   pessoa2 = new Pessoa2();
	   
	   
	   modelo = new DefaultTableModel();
	   tabela = new JTable(modelo);
	   
	   modelo.addColumn("Nome");
	   modelo.addColumn("Endereço");
	   modelo.addColumn("Telefone");
	   modelo.addColumn("Email");
	   
	   setTitle("Relatório de Funcionários");
	   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	   setBounds(300, 100, 618, 463);
	   pessoaBD2.relatorioTabelaPessoas(pessoa2, modelo);
	   
	   
	  
	   tabela.setPreferredScrollableViewportSize(new Dimension(700,400));
	   Container c = getContentPane();
	   c.setLayout(new FlowLayout());
	   JScrollPane scarollPane = new JScrollPane(tabela);
	   c.add(scarollPane);
	   setSize(800,550);
	   setVisible(true);
	   
	  
	   JButton btnFechar = new JButton("Fechar");
	   btnFechar.setIcon(new ImageIcon(RelatorioF.class.getResource("/Imagens/botao-cancelar.png")));
		btnFechar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();				
			}
			
		});
		btnFechar.setBounds(100, 410, 124, 23);
		c.add(btnFechar);
	   
	   
   }
    
}
