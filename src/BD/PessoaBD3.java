package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import Dados.Pessoa3;
import BD.Conexao3;


public class PessoaBD3
{

    Connection connection = null;

    public boolean inserirPessoa(Pessoa3 pessoa3) 
    {
        System.out.println("Cadastrar o Produto");//PRODUTOS
       
        connection = Conexao.getInstance().getConnection();
        
        System.out.println("Conectado e pronto para cadastrar o Produto");
        Statement stmt = null;
        
        try 
        {
            stmt = connection.createStatement();

            String sql = "INSERT INTO dados3(descricao,quantidade,estoque,preco) "
            		   + "VALUES ('"+ pessoa3.getDescricao() + "','" + pessoa3.getQuantidade() + "', '" 
            		   + pessoa3.getEstoque() + "', '" + pessoa3.getPreco() + "')";
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

    
    public boolean atualizarPessoa(Pessoa3 pessoa3, String descricaoAlterar) 
    {
        System.out.println("Atualizar Produto");
        
        connection = Conexao.getInstance().getConnection();
        System.out.println("Conectado e pronto para atualizar");
        Statement stmt = null;
    
        try
        {
            stmt = connection.createStatement();

            String sql = "UPDATE dados3 SET descricao='"+pessoa3.getDescricao()+"'," +
                         "quantidade='"+pessoa3.getQuantidade()+"', estoque='"+pessoa3.getEstoque()+"'," +
                         "preco='"+pessoa3.getPreco()+"' WHERE descricao='"+descricaoAlterar+"';";
                    
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
    	String dados3 = "";
    	
    	connection = Conexao.getInstance().getConnection();
        System.out.println("Conectado e preparando a listagem de produtos");
        Statement stmt = null;
        
        try
        {
            stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM dados3");
            
            while (res.next())
            {
            	dados3 += "\n"+res.getString("descricao");
				dados3 += "\n"+res.getString("quantidade");
				dados3 += "\n"+res.getString("estoque");
				dados3 += "\n"+res.getString("preco");
				dados3 += "\n-----------------------------------------";				
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
    	
    	return dados3;
    }
    
    public void relatorioTabelaPessoas(Pessoa3 pessoa3, DefaultTableModel modelo)
    {
       connection = Conexao.getInstance().getConnection();
       System.out.println("Conectado!! Preparando a exclusão");
       Statement stm = null;
           
       try
  	   {
    	   stm = connection.createStatement();
    	   ResultSet res = stm.executeQuery("SELECT * FROM dados3");
  		   
    	   while(res.next())
  		   {
  			   pessoa3.setDescricao(res.getString("descricao"));
  			   pessoa3.setQuantidade(res.getString("quantidade"));
  			   pessoa3.setEstoque(res.getString("estoque"));
  			   pessoa3.setPreco(res.getString("preço"));
  			 
  			   modelo.addRow(new Object[] {res.getString("descricao"),res.getString("quantidade"),
  					   res.getString("estoque"),res.getString("preco")});
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
    
    public boolean excluirPessoa(Pessoa3 pessoa3) 
    {
    	boolean status = true;
    	
        System.out.println("Excluir Produto");
        
        connection = Conexao.getInstance().getConnection();
        System.out.println("Conectado e pronto para Excluir");
        Statement stmt = null;
        
        try 
        {
            stmt = connection.createStatement();
            
            String sql = "DELETE FROM dados3 WHERE nome='"+pessoa3.getDescricao()+"'";
            
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
    
    public boolean procuraPessoa(Pessoa3 pessoa3, String nomeConsulta)
    {
    	boolean status = true;
		        
    	connection = Conexao.getInstance().getConnection();
        System.out.println("Conectado e preparando a procura por Produto");
        Statement stmt = null;
        
        try
        {
            stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM dados3");
            
            while(res.next())
			{
			   if(res.getString("descricao").compareTo(nomeConsulta)==0)
			   {
				  pessoa3.setQuantidade(res.getString("quantidade"));
				  pessoa3.setEstoque(res.getString("estoque"));
				  pessoa3.setPreco(res.getString("preco"));
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
