/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Model.PlataformaExecucao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Marco Antônio
 */
@ManagedBean(name = "PlataformaExecucaoDAO", eager = true)
public class PlataformaExecucaoDAO 
{
    private static PlataformaExecucaoDAO instance = new PlataformaExecucaoDAO();
    
    /* Cria uma nova instância de ClienteDAO */
    private PlataformaExecucaoDAO(){}
    
    public static PlataformaExecucaoDAO getInstance() {
        return instance;
    }
    
    public String save(PlataformaExecucao pe)
    {
        Connection conn = null;
        Statement st  = null;
        String retorno = "";
        try 
        {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            
            st.execute("insert into opteste.plataforma_execucao (nome)" + " values ('" + pe.getNome() + "')");
            retorno = "Plataforma de Execução cadastrada com sucesso";
            return retorno;
        }
        catch(Exception e) 
        {
            retorno = "Erro ao tentar cadastrar nova Plataforma de Execução ";
            return retorno;
        }
        finally 
        {
            closeResources(conn, st);
        }      
    }
    
    public boolean PlataformaExecucaoExiste(PlataformaExecucao pe) throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome FROM opteste.plataforma_execucao WHERE id = ?";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, pe.getId());
            
            ResultSet rs = preparedStatement.executeQuery();
            PlataformaExecucao p = null;            
            while (rs.next() == true) 
            {                                
                p = new PlataformaExecucao();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
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
    
    public ArrayList<PlataformaExecucao> listar() throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome FROM opteste.plataforma_execucao ";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<PlataformaExecucao> lpe = new ArrayList<>();
            PlataformaExecucao p = null;            
            while (rs.next() == true) 
            {                                
                p = new PlataformaExecucao();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                lpe.add(p);
            }                       
            return lpe;
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
    
    public void closeResources(Connection conn, Statement st) {
        try {
            if(st!=null) st.close();
            if(conn!=null) conn.close();
            
        } catch(SQLException e) {
            e.getMessage();
        }
    }    

    public void update(PlataformaExecucao pe) throws SQLException, ClassNotFoundException
    {
        Connection conn = null;
        Statement st  = null;
        try 
        {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("update opteste.plataforma_execucao set nome = '" + pe.getNome() + "' where id = " + pe.getId());
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

    public void excluir(int id) throws SQLException, ClassNotFoundException 
    {
        Connection conn = null;
        Statement st  = null;
        try 
        {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            
            st.execute("delete from opteste.plataforma_execucao where id = " + id);
        }
        catch(SQLException | ClassNotFoundException e) 
        {
            throw e;
        }
        finally 
        {
            closeResources(conn, st);
        }
    }

    public PlataformaExecucao buscar(int id) throws ClassNotFoundException, SQLException 
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome FROM opteste.plataforma_execucao WHERE id = ?";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, id);
            
            ResultSet rs = preparedStatement.executeQuery();
            PlataformaExecucao pe = null;            
            while (rs.next() == true) 
            {                                
                pe = new PlataformaExecucao();
                pe.setId(rs.getInt("id"));
                pe.setNome(rs.getString("nome"));
                return pe;                
            }                       
            return pe;

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
}
