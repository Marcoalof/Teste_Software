package Persistence;

import Model.Usuario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marco Antônio
 */
public class UsuarioDAO 
{
    private static UsuarioDAO instance = new UsuarioDAO();
    
    /* Cria uma nova instância de ClienteDAO */
    private UsuarioDAO(){}
    
    public static UsuarioDAO getInstance() {
        return instance;
    }
    
    public String save(Usuario usua) 
    {
        Connection conn = null;
        Statement st  = null;
        String retorno = "";
        try 
        {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            if(usuarioExiste(usua))
            {
                retorno = "Usuário já cadastrado";
                return retorno;
            }
            else
            {
                st.execute("insert into opteste.usuario (nome, senha, email)" + " values ('" + usua.getNome() + "','" + usua.getSenha() + "','" + usua.getEmail() + "')");
                retorno = "Usuário cadastrado com sucesso";
                return retorno;
            }
        }
        catch(Exception e) 
        {
            retorno = "Erro ao tentar cadastrar novo Usuário";
            return retorno;
        }
        finally 
        {
            closeResources(conn, st);
        }      
    }
    
    public boolean usuarioExiste(Usuario usua) throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT nome, senha, email FROM opteste.usuario WHERE nome = ? and email = ?";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setString(1, usua.getNome());
            preparedStatement.setString(2, usua.getEmail());
            
            ResultSet rs = preparedStatement.executeQuery();
            Usuario u = null;            
            while (rs.next() == true) 
            {                                
                u = new Usuario(rs.getString("nome"), rs.getString("senha"), rs.getString("email"));               

                return true;                
            }                       
            return false;

        }
        catch(SQLException e) 
        {
            throw e;
        }
        finally 
        {
            if (preparedStatement != null) 
            {
                preparedStatement.close();
	    }
            
            if (conn != null) 
            {
                conn.close();
	    } 
	}
    }
    
    public String logar(String nome, String senha) throws SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT nome, senha, email FROM opteste.usuario WHERE nome = ? and senha = ?";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, senha);
            
            ResultSet rs = preparedStatement.executeQuery();
            Usuario u = null;            
            while (rs.next() == true) 
            {                                
                u = new Usuario(rs.getString("nome"), rs.getString("senha"), rs.getString("email"));               

                return "logar";                
            }                       
            return "Usuário e/ou Senha incorretos";

        }
        catch(Exception e) 
        {
            return "Erro ao processar registro";
        }
        finally 
        {
            if (preparedStatement != null) 
            {
                preparedStatement.close();
	    }
            
            if (conn != null) 
            {
                conn.close();
	    } 
	}
    }
    
    public void closeResources(Connection conn, Statement st) {
        try {
            if(st!=null) st.close();
            if(conn!=null) conn.close();
            
        } catch(SQLException e) {
            e.getMessage();
        }
    }    

}
