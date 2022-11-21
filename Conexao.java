
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class Conexao {
    
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/todoapp";
    public static final String USER = "root";
    public static final String PASS = "";
    
    public static Connection getConexao(){
        
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
            
        } catch (Exception e) {
            throw new RuntimeException("Erro de conexão com o banco de dados", e);
        }
        
    }
    
    public static void closeConexao(Connection c, PreparedStatement p, ResultSet r){
        
        try {
            if(c != null){
                
                c.close();
            }
            
            if(p != null){
                
                p.close();
        } 
            
            if(r != null){
                
                r.close();
            
            }
        }catch (Exception e) {
            throw new RuntimeException("Erro ao fechar o banco de dados", e);
        }
    }

    public static void closeConexao(Connection c, PreparedStatement p){
        
        try {
            if(c != null){
                
                c.close();
            }
            
            if(p != null){
                
                p.close();
        } 
            
           
        }catch (Exception e) {
            throw new RuntimeException("Erro ao fechar o banco de dados", e);
        }
    }
}
        
    
    

    

