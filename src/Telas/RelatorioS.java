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

public class RelatorioS extends JFrame
{
   private DefaultTableModel modelo;
   private JTable tabela;
   private String nome,endereco,telefone,email;
   
   
   private PessoaBD4 pessoaBD4;
   private Pessoa4 pessoa4;
   
   
   public RelatorioS()
   {
   	setResizable(false);
   	getContentPane().setBackground(SystemColor.inactiveCaption);
	   
	   pessoaBD4 = new PessoaBD4();
	   pessoa4 = new Pessoa4();
	   
	   
	   modelo = new DefaultTableModel();
	   tabela = new JTable(modelo);
	   
	   modelo.addColumn("Executante");
	   modelo.addColumn("Serviço");
	   modelo.addColumn("Quantidade");
	   modelo.addColumn("Preço unitário");
	   
	   setTitle("Relatório de Serviços");
	   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	   setBounds(300, 100, 618, 463);
	   pessoaBD4.relatorioTabelaPessoas(pessoa4, modelo);
	   
	   
	  
	   tabela.setPreferredScrollableViewportSize(new Dimension(700,400));
	   Container c = getContentPane();
	   c.setLayout(new FlowLayout());
	   JScrollPane scarollPane = new JScrollPane(tabela);
	   c.add(scarollPane);
	   setSize(800,550);
	   setVisible(true);
	   
	  
	   JButton btnFechar = new JButton("Fechar");
	   btnFechar.setIcon(new ImageIcon(RelatorioS.class.getResource("/Imagens/botao-cancelar.png")));
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
