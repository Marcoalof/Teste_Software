package Persistence;

import Model.Usuario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marco Ant�nio
 */
@ManagedBean(name = "UsuarioDAO", eager = true)
public class UsuarioDAO 
{
    private static UsuarioDAO instance = new UsuarioDAO();
    
    /* Cria uma nova inst�ncia de ClienteDAO */
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
                retorno = "Usu�rio j� cadastrado";
                return retorno;
            }
            else
            {
                st.execute("insert into opteste.usuario (nome, senha, email)" + " values ('" + usua.getNome() + "','" + usua.getSenha() + "','" + usua.getEmail() + "')");
                retorno = "Usu�rio cadastrado com sucesso";
                return retorno;
            }
        }
        catch(Exception e) 
        {
            retorno = "Erro ao tentar cadastrar novo Usu�rio";
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
            return "Usu�rio e/ou Senha incorretos";

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
    
    public Usuario usuarioLogado(String nome, String senha) throws SQLException
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

                return u;                
            }                       
            return u;

        }
        catch(Exception e) 
        {
            return null;
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
    
    public void update(Usuario usuarioLogado, Usuario usuarioNovo) throws SQLException, ClassNotFoundException
    {
        Connection conn = null;
        Statement st  = null;
        try 
        {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("update opteste.usuario set senha = '" + usuarioNovo.getSenha() + "', email = '" + usuarioNovo.getEmail()+ "' where nome = '" + usuarioLogado.getNome()+ "'");
        }
        catch(Exception e) 
        {
            throw e;
        }
        finally 
        {
            closeResources(conn, st);
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
