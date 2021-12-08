package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import Telas.ManualPdf;
import Telas.Sobre2;

public class Principal extends JFrame {

	private JPanel contentPane;

	
	private Cadastrar cad;
	private CadastrarF cadF;
	private CadastrarP cadP;
	private CadastrarS cadS;
	private Sobre2 cad2;
	private Consultar cons;
	private ConsultarF consF;
	private ConsultarP consP;
	private ConsultarS consS;
	private Relatorio relatPessoas;
	private RelatorioF frelatF;
	private RelatorioP prelatP;
	private RelatorioS srelatS;
	private Excluir ex;
	private ExcluirF exF;
	private ExcluirP exP;
	private ExcluirS exS;
	private Alterar alt;
	private AlterarF altF;
	private AlterarP altP;
	private AlterarS altS;
	private Fik fik;
	private Sobre2 sobre;
	private Manual manual;
	
	public Principal() {
		setFont(new Font("Helvetica", Font.PLAIN, 18));
		setForeground(SystemColor.activeCaption);
		setTitle("Sistema FikLinda ");
		
		cad = new Cadastrar();
		cadF = new CadastrarF();
		cadP = new CadastrarP();
		cadS = new CadastrarS();//para cadastro clientes, funcionarios,produtos e servicos
		cad2 = new Sobre2();
		cons = new Consultar();
		consF = new ConsultarF();
		consP = new ConsultarP();
		consS = new ConsultarS();//para consulta de clientes, funcionarios,produtos e servicos
		ex = new Excluir();
		exF = new ExcluirF();
		exP = new ExcluirP();
		exS = new ExcluirS();//para exclusao de clientes, funcionarios,produtos e servicos
		alt = new Alterar();
		altF = new AlterarF();
		altP = new AlterarP();
		altS = new AlterarS();//para alteração de clientes, funcionarios,produtos e servicos
		fik = new Fik();
		sobre = new Sobre2();
		manual = new Manual();
		relatPessoas = new Relatorio();
		frelatF = new RelatorioF();
		prelatP = new RelatorioP();
		srelatS = new RelatorioS();//para gerar relatorios de clientes, funcionarios,produtos e servicos
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-5, 0, 1380, 730);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//INICIO DE cLIENTES
		JMenu mnNewMenu = new JMenu("Clientes");//menu
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Cadastrar");//submenu1
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmNewMenuItem_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				cad.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Consultar");//submenu2
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				cons.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Alterar");//submenu3
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmNewMenuItem_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cons.setVisible(true);
				alt.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Excluir");//submenu4
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cons.setVisible(true);
				ex.setVisible(true);
			}
		});//FIM CLIENTES
		
		//INICIO FUNCIONARIO
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnFuncionrios = new JMenu("Funcion\u00E1rios");
		mnFuncionrios.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnFuncionrios);
		
		JMenuItem mntmNewMenuItem_2_1 = new JMenuItem("Cadastrar");
		mntmNewMenuItem_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnFuncionrios.add(mntmNewMenuItem_2_1);
		mntmNewMenuItem_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				cadF.setVisible(true);
				
			}
		});
		
		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("Consultar");
		mntmNewMenuItem_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmNewMenuItem_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				consF.setVisible(true);
				
			}
		});
		mnFuncionrios.add(mntmNewMenuItem_1_1);
		
		JMenuItem mntmNewMenuItem_3_1 = new JMenuItem("Alterar");
		mntmNewMenuItem_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmNewMenuItem_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				altF.setVisible(true);
				consF.setVisible(true);
			}
		});
		mnFuncionrios.add(mntmNewMenuItem_3_1);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Excluir");
		mntmNewMenuItem_7.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmNewMenuItem_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				exF.setVisible(true);
				consF.setVisible(true);
			}
		});
		
		mnFuncionrios.add(mntmNewMenuItem_7);//FIM FUNCIONARIOS
		
		//INICIO PRODUTOS
		JMenu mnProdutos = new JMenu("Produtos");
		mnProdutos.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnProdutos);
		
		JMenuItem mntmNewMenuItem_2_1_1 = new JMenuItem("Cadastrar");
		mntmNewMenuItem_2_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmNewMenuItem_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cadP.setVisible(true);
			}
		});
		mnProdutos.add(mntmNewMenuItem_2_1_1);
		
		JMenuItem mntmNewMenuItem_1_1_1 = new JMenuItem("Consultar");
		mntmNewMenuItem_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmNewMenuItem_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				consP.setVisible(true);
			}
		});
		mnProdutos.add(mntmNewMenuItem_1_1_1);
		
		JMenuItem mntmNewMenuItem_3_1_1 = new JMenuItem("Alterar");
		mntmNewMenuItem_3_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmNewMenuItem_3_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				altP.setVisible(true);
				consP.setVisible(true);
			}
		});
		mnProdutos.add(mntmNewMenuItem_3_1_1);
		
		JMenuItem mntmNewMenuItem_7_1 = new JMenuItem("Excluir");
		mntmNewMenuItem_7_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmNewMenuItem_7_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				exP.setVisible(true);
				consP.setVisible(true);
			}
			
		});
		mnProdutos.add(mntmNewMenuItem_7_1);//FIM PRODUTOS
		
		//INICIO SERVICOS
		JMenu mnServios = new JMenu("Servi\u00E7os");
		mnServios.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnServios);
		
		JMenuItem mntmNewMenuItem_2_1_1_1 = new JMenuItem("Cadastrar");
		mntmNewMenuItem_2_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmNewMenuItem_2_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cadS.setVisible(true);
			}
		});
		mnServios.add(mntmNewMenuItem_2_1_1_1);
		
		JMenuItem mntmNewMenuItem_1_1_1_1 = new JMenuItem("Consultar");
		mntmNewMenuItem_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmNewMenuItem_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				consS.setVisible(true);
			}
		});
		mnServios.add(mntmNewMenuItem_1_1_1_1);
		
		JMenuItem mntmNewMenuItem_3_1_1_1 = new JMenuItem("Alterar");
		mntmNewMenuItem_3_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmNewMenuItem_3_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				altS.setVisible(true);
				consS.setVisible(true);
			}
		});
		mnServios.add(mntmNewMenuItem_3_1_1_1);
		
		JMenuItem mntmNewMenuItem_7_1_1 = new JMenuItem("Excluir");
		mntmNewMenuItem_7_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmNewMenuItem_7_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				exS.setVisible(true);
				consS.setVisible(true);
			}
		});
		mnServios.add(mntmNewMenuItem_7_1_1);//FIM SERVICOS
		
		//INICIO RELATORIOS
		JMenu mnNewMenu_1 = new JMenu("Relat\u00F3rios");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Clientes");
		mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmNewMenuItem_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				relatPessoas.setVisible(true); //chamando a tela relatórios
			}
		});		
		mnNewMenu_1.add(mntmNewMenuItem_4);//fim sub menu1 relatorios
		
		JMenuItem mntmNewMenuItem_55 = new JMenuItem("Funcionários");
		mntmNewMenuItem_55.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmNewMenuItem_55.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				frelatF.setVisible(true);
			}
		});	
		mnNewMenu_1.add(mntmNewMenuItem_55);//fim sub menu 2 relatorios
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Produtos");
		mntmNewMenuItem_6.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmNewMenuItem_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				prelatP.setVisible(true);
			}
		});		
		mnNewMenu_1.add(mntmNewMenuItem_6);//fim sub menu 3 relatorios
		
		JMenuItem mntmNewMenuItem_66 = new JMenuItem("Serviços");
		mntmNewMenuItem_66.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmNewMenuItem_66.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				srelatS.setVisible(true);
			}
		});		
		mnNewMenu_1.add(mntmNewMenuItem_66);
		
		JMenuItem mntmNewMenuItem_661 = new JMenuItem("Sair");
		mntmNewMenuItem_661.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmNewMenuItem_661.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		
		JMenu mnNewMenu_2 = new JMenu("Informa\u00E7\u00F5es");
		
		
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Sobre a FikLinda");
		mntmNewMenuItem_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				sobre.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Manual FikLinda");
		mntmNewMenuItem_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				manual.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_8);
		menuBar.add(mntmNewMenuItem_661);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
