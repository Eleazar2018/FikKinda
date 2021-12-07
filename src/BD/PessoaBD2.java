package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import Dados.Pessoa2;
import BD.Conexao2;


public class PessoaBD2
{

    Connection connection = null;

    public boolean inserirPessoa(Pessoa2 pessoa2) 
    {
        System.out.println("Cadastrar o Funcionário");//FUNCIONÁRIOS
       
        connection = Conexao.getInstance().getConnection();
        
        System.out.println("Conectado e pronto para cadastrar o Funcionário");
        Statement stmt = null;
        
        try 
        {
            stmt = connection.createStatement();

            String sql = "INSERT INTO dados2(nome,endereco,telefone,email) "
            		   + "VALUES ('"+ pessoa2.getNome() + "','" + pessoa2.getEndereco() + "', '" 
            		   + pessoa2.getTelefone() + "', '" + pessoa2.getEmail() + "')";
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

    
    public boolean atualizarPessoa(Pessoa2 pessoa2, String nomeAlterar) 
    {
        System.out.println("Atualizar Funcionário");
        
        connection = Conexao.getInstance().getConnection();
        System.out.println("Conectado e pronto para atualizar");
        Statement stmt = null;
    
        try
        {
            stmt = connection.createStatement();

            String sql = "UPDATE dados2 SET nome='"+pessoa2.getNome()+"'," +
                         "endereco='"+pessoa2.getEndereco()+"', telefone='"+pessoa2.getTelefone()+"'," +
                         "email='"+pessoa2.getEmail()+"' WHERE nome='"+nomeAlterar+"';";
                    
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
    	String dados2 = "";
    	
    	connection = Conexao.getInstance().getConnection();
        System.out.println("Conectado e preparando a listagem");
        Statement stmt = null;
        
        try
        {
            stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM dados2");
            
            while (res.next())
            {
            	dados2 += "\n"+res.getString("nome");
				dados2 += "\n"+res.getString("endereco");
				dados2 += "\n"+res.getString("telefone");
				dados2 += "\n"+res.getString("email");
				dados2 += "\n-----------------------------------------";				
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
    	
    	return dados2;
    }
    
    public void relatorioTabelaPessoas(Pessoa2 pessoa2, DefaultTableModel modelo)
    {
       connection = Conexao.getInstance().getConnection();
       System.out.println("Conectado!! Preparando a exclusão");
       Statement stm = null;
           
       try
  	   {
    	   stm = connection.createStatement();
    	   ResultSet res = stm.executeQuery("SELECT * FROM dados2");
  		   
    	   while(res.next())
  		   {
  			   pessoa2.setNome(res.getString("nome"));
  			   pessoa2.setEndereco(res.getString("endereco"));
  			   pessoa2.setTelefone(res.getString("telefone"));
  			   pessoa2.setEmail(res.getString("email"));
  			 
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
    
    public boolean excluirPessoa(Pessoa2 pessoa2) 
    {
    	boolean status = true;
    	
        System.out.println("Excluir dados do funcionário");
        
        connection = Conexao.getInstance().getConnection();
        System.out.println("Conectado e pronto para Excluir");
        Statement stmt = null;
        
        try 
        {
            stmt = connection.createStatement();
            
            String sql = "DELETE FROM dados2 WHERE nome='"+pessoa2.getNome()+"'";
            
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
    
    public boolean procuraPessoa(Pessoa2 pessoa2, String nomeConsulta)
    {
    	boolean status = true;
		        
    	connection = Conexao.getInstance().getConnection();
        System.out.println("Conectado e preparando a procura por Cliente");
        Statement stmt = null;
        
        try
        {
            stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM dados2");
            
            while(res.next())
			{
			   if(res.getString("nome").compareTo(nomeConsulta)==0)
			   {
				  pessoa2.setEndereco(res.getString("endereco"));
				  pessoa2.setTelefone(res.getString("telefone"));
				  pessoa2.setEmail(res.getString("email"));
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
