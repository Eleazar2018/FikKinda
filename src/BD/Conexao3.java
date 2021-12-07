package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao3 
{

    Connection con = null;
    private static Conexao3 instance = null;

    public Conexao3() 
    {
    	try 
    	{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Carregado com sucesso!!!");
        } 
    	catch (ClassNotFoundException e) 
    	{
            System.out.println("O driver do Mysql não pode ser carregado!");
        }
    }
    
   
    public static Conexao3 getInstance() 
    {
        if (instance == null) 
        {
            instance = new Conexao3();
        }
        return instance;
    }

    public Connection getConnection() 
    {
        try 
        {
            if ((con == null) || (con.isClosed())) 
            {
                con = DriverManager.getConnection("jdbc:mysql://localhost/agenda2", "root", "");
                System.out.println("Conexão estabelecida");
            }
        } 
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return con;
    }

    public void destroy() 
    {
        try 
        {
            con.close();
        } 
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    
}
