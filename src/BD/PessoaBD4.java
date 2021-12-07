package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

import Dados.Pessoa4;
import BD.Conexao4;


public class PessoaBD4
{

    Connection connection = null;

    public boolean inserirPessoa(Pessoa4 pessoa4) 
    {
        System.out.println("Cadastrar o Serviço");
       
        connection = Conexao.getInstance().getConnection();
        
        System.out.println("Conectado e pronto para cadastrar o Serviço");
        Statement stmt = null;
        
        try 
        {
            stmt = connection.createStatement();

            String sql = "INSERT INTO dados4(executante,servico,quantidade,preco) "
            		   + "VALUES ('"+ pessoa4.getExecutante() + "','" + pessoa4.getServico() + "', '" 
            		   + pessoa4.getQuantidade() + "', '" + pessoa4.getPreco() + "')";
            System.out.println("SQL: " + sql);
            stmt.executeUpdate(sql);
           
            return true;
        } 
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            return false;
        } 
        finally 
        {
            try 
            {
                stmt.close();
                connection.close();
            }
            catch (SQLException e)
            {
                System.out.println("Erro ao desconectar" + e.getMessage());
            }
        }
    } 

    
    public boolean atualizarPessoa(Pessoa4 pessoa4, String nomeExecutante) 
    {
        System.out.println("Atualizar Serviço");
        
        connection = Conexao.getInstance().getConnection();
        System.out.println("Conectado e pronto para atualizar");
        Statement stmt = null;
    
        try
        {
            stmt = connection.createStatement();

            String sql = "UPDATE dados4 SET executante='"+pessoa4.getExecutante()+"'," +
                         "servico='"+pessoa4.getServico()+"', quantidade='"+pessoa4.getQuantidade()+"'," +
                         "preco='"+pessoa4.getPreco()+"' WHERE executante='"+nomeExecutante+"';";
                    
            System.out.println("SQL: " + sql);
            stmt.executeUpdate(sql);
            
            return true;
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        finally
        {
            
            try
            {
                stmt.close();
                connection.close();
            }
            catch (SQLException e)
            {
                System.out.println("Erro ao desconectar" + e.getMessage());
            }
        }
    }
    
    
    public String relatorioPessoas()
    {
    	String dados4 = "";
    	
    	connection = Conexao.getInstance().getConnection();
        System.out.println("Conectado e preparando a listagem");
        Statement stmt = null;
        
        try
        {
            stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM dados4");
            
            while (res.next())
            {
            	dados4 += "\n"+res.getString("executante");
				dados4 += "\n"+res.getString("servico");
				dados4 += "\n"+res.getString("quantidade");
				dados4 += "\n"+res.getString("preco");
				dados4 += "\n-----------------------------------------";				
            }
            
        } 
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
        finally
        {
          
            try
            {
                stmt.close();
                connection.close();
            }
            catch (SQLException e)
            {
                System.out.println("Erro ao desconectar" + e.getMessage());
            }
        }
    	
    	return dados4;
    }
    
    public void relatorioTabelaPessoas(Pessoa4 pessoa4, DefaultTableModel modelo)
    {
       connection = Conexao.getInstance().getConnection();
       System.out.println("Conectado!! Preparando a exclusão");
       Statement stm = null;
           
       try
  	   {
    	   stm = connection.createStatement();
    	   ResultSet res = stm.executeQuery("SELECT * FROM dados4");
  		   
    	   while(res.next())
  		   {
  			   pessoa4.setExecutante(res.getString("Executante"));
  			   pessoa4.setServico(res.getString("servico"));
  			   pessoa4.setQuantidade(res.getString("quantidade"));
  			   pessoa4.setPreco(res.getString("preco"));
  			 
  			   modelo.addRow(new Object[] {res.getString("Executante"),res.getString("servico"),
  					   res.getString("quantidade"),res.getString("preco")});
  		   }
  	   }
       catch(SQLException ex)
  	   {
  		   System.out.println("Erro SQL: " + ex.getMessage());
  	   }
  	   finally 
       {
         try
         {
             stm.close();
             connection.close();
         }
         catch (SQLException e)
         {
             System.out.println("Erro ao desconectar" + e.getMessage());
         }
       }
    	
    }
    
    public boolean excluirPessoa(Pessoa4 pessoa4) 
    {
    	boolean status = true;
    	
        System.out.println("Excluir Executante");
        
        connection = Conexao.getInstance().getConnection();
        System.out.println("Conectado e pronto para Excluir");
        Statement stmt = null;
        
        try 
        {
            stmt = connection.createStatement();
            
            String sql = "DELETE FROM dados4 WHERE nome='"+pessoa4.getExecutante()+"'";
            
            System.out.println("SQL: " + sql);
            
            if(stmt.executeUpdate(sql)!=0)
            {
            	status = true;	
            }
            else
            {
            	status = false;
            }
            
        } 
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            status = false;
        }
        finally 
        {
            
            try
            {
                stmt.close();
                connection.close();
            } 
            catch (SQLException e)
            {
                System.out.println("Erro ao desconectar" + e.getMessage());
            }
        }
        return status;
    }
    
    public boolean procuraPessoa(Pessoa4 pessoa4, String nomeExecutante)
    {
    	boolean status = true;
		        
    	connection = Conexao.getInstance().getConnection();
        System.out.println("Conectado e preparando a procura por Serviço");
        Statement stmt = null;
        
        try
        {
            stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM dados4");
            
            while(res.next())
			{
			   if(res.getString("executante").compareTo(nomeExecutante)==0)
			   {
				  pessoa4.setServico(res.getString("servico"));
				  pessoa4.setQuantidade(res.getString("quantidade"));
				  pessoa4.setPreco(res.getString("preco"));
				  status = true;						  
			   }					   			   
		    }
            
        } 
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            status = false;
        }
        finally
        {
          
            try
            {
                stmt.close();
                connection.close();
            }
            catch (SQLException e)
            {
                System.out.println("Erro ao desconectar" + e.getMessage());
                status = false;
            }
        }
    	
		return status;
    }    
}
