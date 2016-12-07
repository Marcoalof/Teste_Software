/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Model.ComplexidadeProblema;
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
@ManagedBean(name = "ComplexidadeProblemaDAO", eager = true)
public class ComplexidadeProblemaDAO 
{
    private static ComplexidadeProblemaDAO instance = new ComplexidadeProblemaDAO();
    
    /* Cria uma nova instância de ClienteDAO */
    private ComplexidadeProblemaDAO(){}
    
    public static ComplexidadeProblemaDAO getInstance() {
        return instance;
    }
    
    public String save(ComplexidadeProblema cp) 
    {
        Connection conn = null;
        Statement st  = null;
        String retorno = "";
        try 
        {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            
            st.execute("insert into opteste.indicador_complexidade_problema (nome, peso)" + " values ('" + cp.getNome() + "','" + cp.getPeso() + "')");
            retorno = "Indicador de Complexidade do Problema cadastrado com sucesso";
            return retorno;
        }
        catch(Exception e) 
        {
            retorno = "Erro ao tentar cadastrar novo Indicador de Complexidade do Problema";
            return retorno;
        }
        finally 
        {
            closeResources(conn, st);
        }      
    }
    
    public boolean complexidadeProblemaExiste(ComplexidadeProblema cp) throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome, peso FROM opteste.indicador_complexidade_problema WHERE id = ?";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, cp.getId());
            
            ResultSet rs = preparedStatement.executeQuery();
            ComplexidadeProblema c = null;            
            while (rs.next() == true) 
            {                                
                c = new ComplexidadeProblema();
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
    
    public ArrayList<ComplexidadeProblema> listar() throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome, peso FROM opteste.indicador_complexidade_problema ";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<ComplexidadeProblema> lc = new ArrayList<>();
            ComplexidadeProblema c = null;            
            while (rs.next() == true) 
            {                                
                c = new ComplexidadeProblema();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setPeso(rs.getInt("peso"));
                lc.add(c);
            }                       
            return lc;
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

    public void update(ComplexidadeProblema c) throws SQLException, ClassNotFoundException
    {
        Connection conn = null;
        Statement st  = null;
        try 
        {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            if(!existeComplexidadeMesmoPeso(c.getId(), c.getPeso()))
            {
                st.execute("update opteste.indicador_complexidade_problema set nome = '" + c.getNome() + "', peso = '" + c.getPeso()+ "' where id = " + c.getId());
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
            
            st.execute("delete from opteste.indicador_complexidade_problema where id = " + id);
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

    public ComplexidadeProblema buscar(int id) throws ClassNotFoundException, SQLException 
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome, peso FROM opteste.indicador_complexidade_problema WHERE id = ?";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, id);
            
            ResultSet rs = preparedStatement.executeQuery();
            ComplexidadeProblema c = null;            
            while (rs.next() == true) 
            {                                
                c = new ComplexidadeProblema();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setPeso(rs.getInt("peso"));
                return c;                
            }                       
            return c;

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
    
    public boolean existeComplexidadeMesmoPeso(int id, int peso) throws ClassNotFoundException, SQLException 
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome, peso FROM opteste.indicador_complexidade_problema WHERE peso = ? ";
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
            ComplexidadeProblema c = null;            
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
        
        String selectTableSQL = "SELECT max(peso) as peso FROM opteste.indicador_complexidade_problema ";
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
