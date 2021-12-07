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


import BD.PessoaBD3;
import Dados.Pessoa3;
import java.awt.SystemColor;

public class RelatorioP extends JFrame
{
   private DefaultTableModel modelo;
   private JTable tabela;
   private String descricao,quantidade,estoque,preco;
   
   
   private PessoaBD3 pessoaBD3;
   private Pessoa3 pessoa3;
   
   
   public RelatorioP()
   {
   	setResizable(false);
   	getContentPane().setBackground(SystemColor.inactiveCaption);
	   
	   pessoaBD3 = new PessoaBD3();
	   pessoa3 = new Pessoa3();
	   
	   
	   modelo = new DefaultTableModel();
	   tabela = new JTable(modelo);
	   
	   modelo.addColumn("Descrição");
	   modelo.addColumn("Quantidade");
	   modelo.addColumn("Estoque");
	   modelo.addColumn("Preço");
	   
	   setTitle("Relat\u00F3rio de Produtos");
	   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	   setBounds(300, 100, 618, 463);
	   pessoaBD3.relatorioTabelaPessoas(pessoa3, modelo);
	   
	   
	  
	   tabela.setPreferredScrollableViewportSize(new Dimension(700,400));
	   Container c = getContentPane();
	   c.setLayout(new FlowLayout());
	   JScrollPane scarollPane = new JScrollPane(tabela);
	   c.add(scarollPane);
	   setSize(800,550);
	   setVisible(true);
	   
	  
	   JButton btnFechar = new JButton("Fechar");
	   btnFechar.setIcon(new ImageIcon(RelatorioP.class.getResource("/Imagens/botao-cancelar.png")));
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
