package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import Dados.Pessoa;
import BD.Conexao;


public class PessoaBD
{

    Connection connection = null;

    public boolean inserirPessoa(Pessoa pessoa) 
    {
        System.out.println("Cadastrar o Cliente");
       
        connection = Conexao.getInstance().getConnection();
        
        System.out.println("Conectado e pronto para cadastrar o Cliente");
        Statement stmt = null;
        
        try 
        {
            stmt = connection.createStatement();

            String sql = "INSERT INTO dados(nome,endereco,telefone,email) "
            		   + "VALUES ('"+ pessoa.getNome() + "','" + pessoa.getEndereco() + "', '" 
            		   + pessoa.getTelefone() + "', '" + pessoa.getEmail() + "')";
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

    
    public boolean atualizarPessoa(Pessoa pessoa, String nomeAlterar) 
    {
        System.out.println("Atualizar Cliente");
        
        connection = Conexao.getInstance().getConnection();
        System.out.println("Conectado e pronto para atualizar");
        Statement stmt = null;
    
        try
        {
            stmt = connection.createStatement();

            String sql = "UPDATE dados SET nome='"+pessoa.getNome()+"'," +
                         "endereco='"+pessoa.getEndereco()+"', telefone='"+pessoa.getTelefone()+"'," +
                         "email='"+pessoa.getEmail()+"' WHERE nome='"+nomeAlterar+"';";
                    
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
    	String dados = "";
    	
    	connection = Conexao.getInstance().getConnection();
        System.out.println("Conectado e preparando a listagem");
        Statement stmt = null;
        
        try
        {
            stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM dados");
            
            while (res.next())
            {
            	dados += "\n"+res.getString("nome");
				dados += "\n"+res.getString("endereco");
				dados += "\n"+res.getString("telefone");
				dados += "\n"+res.getString("email");
				dados += "\n-----------------------------------------";				
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
    	
    	return dados;
    }
    
    public void relatorioTabelaPessoas(Pessoa pessoa, DefaultTableModel modelo)
    {
       connection = Conexao.getInstance().getConnection();
       System.out.println("Conectado!! Preparando a exclusão");
       Statement stm = null;
           
       try
  	   {
    	   stm = connection.createStatement();
    	   ResultSet res = stm.executeQuery("SELECT * FROM dados");
  		   
    	   while(res.next())
  		   {
  			   pessoa.setNome(res.getString("nome"));
  			   pessoa.setEndereco(res.getString("endereco"));
  			   pessoa.setTelefone(res.getString("telefone"));
  			   pessoa.setEmail(res.getString("email"));
  			 
  			   modelo.addRow(new Object[] {res.getString("nome"),res.getString("endereco"),
  					   res.getString("telefone"),res.getString("email")});
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
    
    public boolean excluirPessoa(Pessoa pessoa) 
    {
    	boolean status = true;
    	
        System.out.println("Excluir Pessoa");
        
        connection = Conexao.getInstance().getConnection();
        System.out.println("Conectado e pronto para Excluir");
        Statement stmt = null;
        
        try 
        {
            stmt = connection.createStatement();
            
            String sql = "DELETE FROM dados WHERE nome='"+pessoa.getNome()+"'";
            
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
    
    public boolean procuraPessoa(Pessoa pessoa, String nomeConsulta)
    {
    	boolean status = true;
		        
    	connection = Conexao.getInstance().getConnection();
        System.out.println("Conectado e preparando a procura por Cliente");
        Statement stmt = null;
        
        try
        {
            stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM dados");
            
            while(res.next())
			{
			   if(res.getString("nome").compareTo(nomeConsulta)==0)
			   {
				  pessoa.setEndereco(res.getString("endereco"));
				  pessoa.setTelefone(res.getString("telefone"));
				  pessoa.setEmail(res.getString("email"));
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
