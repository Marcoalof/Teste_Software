/*
 * To change this license header, choose License Headers in Project Prodarties.
 * To change this template file, choose Tools | Templates
 * and odan the template in the editor.
 */
package Persistence;

import Model.DominioAplicacao;
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
@ManagedBean(name = "DominioAplicacaoDAO", eager = true)
public class DominioAplicacaoDAO 
{
    private static DominioAplicacaoDAO instance = new DominioAplicacaoDAO();
    
    /* Cria uma nova instância de ClienteDAO */
    private DominioAplicacaoDAO(){}
    
    public static DominioAplicacaoDAO getInstance() {
        return instance;
    }
    
    public String save(DominioAplicacao da)
    {
        Connection conn = null;
        Statement st  = null;
        String retorno = "";
        try 
        {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            
            st.execute("insert into opteste.dominio_aplicacao (nome)" + " values ('" + da.getNome() + "')");
            retorno = "Domínio da Aplicação cadastrada com sucesso";
            return retorno;
        }
        catch(Exception e) 
        {
            retorno = "Erro ao tentar cadastrar novo Domínio da Aplicação ";
            return retorno;
        }
        finally 
        {
            closeResources(conn, st);
        }      
    }
    
    public boolean DominioAplicacaoExiste(DominioAplicacao da) throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome FROM opteste.dominio_aplicacao WHERE id = ?";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, da.getId());
            
            ResultSet rs = preparedStatement.executeQuery();
            DominioAplicacao d = null;            
            while (rs.next() == true) 
            {                                
                d = new DominioAplicacao();
                d.setId(rs.getInt("id"));
                d.setNome(rs.getString("nome"));
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
    
    public ArrayList<DominioAplicacao> listar() throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome FROM opteste.dominio_aplicacao ";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<DominioAplicacao> lda = new ArrayList<>();
            DominioAplicacao d = null;            
            while (rs.next() == true) 
            {                                
                d = new DominioAplicacao();
                d.setId(rs.getInt("id"));
                d.setNome(rs.getString("nome"));
                lda.add(d);
            }                       
            return lda;
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

    public void update(DominioAplicacao da) throws SQLException, ClassNotFoundException
    {
        Connection conn = null;
        Statement st  = null;
        try 
        {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("update opteste.dominio_aplicacao set nome = '" + da.getNome() + "' where id = " + da.getId());
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
            
            st.execute("delete from opteste.dominio_aplicacao where id = " + id);
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

    public DominioAplicacao buscar(int id) throws ClassNotFoundException, SQLException 
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome FROM opteste.dominio_aplicacao WHERE id = ?";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, id);
            
            ResultSet rs = preparedStatement.executeQuery();
            DominioAplicacao da = null;            
            while (rs.next() == true) 
            {                                
                da = new DominioAplicacao();
                da.setId(rs.getInt("id"));
                da.setNome(rs.getString("nome"));
                return da;                
            }                       
            return da;

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
