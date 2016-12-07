/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Model.CriticidadeProjeto;
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
@ManagedBean(name = "CriticidadeProjetoDAO", eager = true)
public class CriticidadeProjetoDAO 
{
    private static CriticidadeProjetoDAO instance = new CriticidadeProjetoDAO();
    
    /* Cria uma nova instância de ClienteDAO */
    private CriticidadeProjetoDAO(){}
    
    public static CriticidadeProjetoDAO getInstance() {
        return instance;
    }
    
    public String save(CriticidadeProjeto cp)
    {
        Connection conn = null;
        Statement st  = null;
        String retorno = "";
        try 
        {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            
            st.execute("insert into opteste.criticidade_projeto (nome, peso)" + " values ('" + cp.getNome() + "','" + cp.getPeso() + "')");
            retorno = "Indicador de Criticidade do Projeto cadastrado com sucesso";
            return retorno;
        }
        catch(Exception e) 
        {
            retorno = "Erro ao tentar cadastrar nova Criticidade do Projeto ";
            return retorno;
        }
        finally 
        {
            closeResources(conn, st);
        }      
    }
    
    public boolean CriticidadeProjetoExiste(CriticidadeProjeto cp) throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome, peso FROM opteste.criticidade_projeto WHERE id = ?";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, cp.getId());
            
            ResultSet rs = preparedStatement.executeQuery();
            CriticidadeProjeto c = null;            
            while (rs.next() == true) 
            {                                
                c = new CriticidadeProjeto();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setPeso(rs.getInt("peso"));
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
    
    public ArrayList<CriticidadeProjeto> listar() throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome, peso FROM opteste.criticidade_projeto ";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<CriticidadeProjeto> lcp = new ArrayList<>();
            CriticidadeProjeto c = null;            
            while (rs.next() == true) 
            {                                
                c = new CriticidadeProjeto();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setPeso(rs.getInt("peso"));
                lcp.add(c);
            }                       
            return lcp;
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

    public void update(CriticidadeProjeto cp) throws SQLException, ClassNotFoundException
    {
        Connection conn = null;
        Statement st  = null;
        try 
        {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            if(!existeCriticidadeProjetoMesmoPeso(cp.getId(), cp.getPeso()))
            {
                st.execute("update opteste.criticidade_projeto set nome = '" + cp.getNome() + "', peso = '" + cp.getPeso()+ "' where id = " + cp.getId());
            }            
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
            
            st.execute("delete from opteste.criticidade_projeto where id = " + id);
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

    public CriticidadeProjeto buscar(int id) throws ClassNotFoundException, SQLException 
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome, peso FROM opteste.criticidade_projeto WHERE id = ?";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, id);
            
            ResultSet rs = preparedStatement.executeQuery();
            CriticidadeProjeto cp = null;            
            while (rs.next() == true) 
            {                                
                cp = new CriticidadeProjeto();
                cp.setId(rs.getInt("id"));
                cp.setNome(rs.getString("nome"));
                cp.setPeso(rs.getInt("peso"));
                return cp;                
            }                       
            return cp;

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
    
    public boolean existeCriticidadeProjetoMesmoPeso(int id, int peso) throws ClassNotFoundException, SQLException 
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome, peso FROM opteste.criticidade_projeto WHERE peso = ? ";
        if(id > 0)
        {
            selectTableSQL += " and id <> ? ";
        }
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            if(id > 0)
            {
                preparedStatement.setInt(1, peso);
                preparedStatement.setInt(2, id);
            }
            else
            {
                preparedStatement.setInt(1, peso);
            }
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next() == true) 
            {
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

    public int getMaiorPeso() throws ClassNotFoundException, SQLException 
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT max(peso) as peso FROM opteste.criticidade_projeto ";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            preparedStatement = conn.prepareStatement(selectTableSQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next() == true) 
            {                                
                return rs.getInt("peso");
            }                       
            return 0;

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
