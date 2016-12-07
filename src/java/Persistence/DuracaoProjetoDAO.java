/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Model.DuracaoProjeto;
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
@ManagedBean(name = "DuracaoProjetoDAO", eager = true)
public class DuracaoProjetoDAO 
{
    private static DuracaoProjetoDAO instance = new DuracaoProjetoDAO();
    
    /* Cria uma nova instância de ClienteDAO */
    private DuracaoProjetoDAO(){}
    
    public static DuracaoProjetoDAO getInstance() {
        return instance;
    }
    
    public String save(DuracaoProjeto dp)
    {
        Connection conn = null;
        Statement st  = null;
        String retorno = "";
        try 
        {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            
            st.execute("insert into opteste.duracao_projeto (nome, peso)" + " values ('" + dp.getNome() + "','" + dp.getPeso() + "')");
            retorno = "Indicador de Duração dos Projetos cadastrado com sucesso";
            return retorno;
        }
        catch(Exception e) 
        {
            retorno = "Erro ao tentar cadastrar nova Duração dos Projetos ";
            return retorno;
        }
        finally 
        {
            closeResources(conn, st);
        }      
    }
    
    public boolean DuracaoProjetoExiste(DuracaoProjeto dp) throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome, peso FROM opteste.duracao_projeto WHERE id = ?";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, dp.getId());
            
            ResultSet rs = preparedStatement.executeQuery();
            DuracaoProjeto d = null;            
            while (rs.next() == true) 
            {                                
                d = new DuracaoProjeto();
                d.setId(rs.getInt("id"));
                d.setNome(rs.getString("nome"));
                d.setPeso(rs.getInt("peso"));
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
    
    public ArrayList<DuracaoProjeto> listar() throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome, peso FROM opteste.duracao_projeto ";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<DuracaoProjeto> ldp = new ArrayList<>();
            DuracaoProjeto d = null;            
            while (rs.next() == true) 
            {                                
                d = new DuracaoProjeto();
                d.setId(rs.getInt("id"));
                d.setNome(rs.getString("nome"));
                d.setPeso(rs.getInt("peso"));
                ldp.add(d);
            }                       
            return ldp;
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

    public void update(DuracaoProjeto dp) throws SQLException, ClassNotFoundException
    {
        Connection conn = null;
        Statement st  = null;
        try 
        {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            if(!existeDuracaoProjetoMesmoPeso(dp.getId(), dp.getPeso()))
            {
                st.execute("update opteste.duracao_projeto set nome = '" + dp.getNome() + "', peso = '" + dp.getPeso()+ "' where id = " + dp.getId());
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
            
            st.execute("delete from opteste.duracao_projeto where id = " + id);
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

    public DuracaoProjeto buscar(int id) throws ClassNotFoundException, SQLException 
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome, peso FROM opteste.duracao_projeto WHERE id = ?";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, id);
            
            ResultSet rs = preparedStatement.executeQuery();
            DuracaoProjeto dp = null;            
            while (rs.next() == true) 
            {                                
                dp = new DuracaoProjeto();
                dp.setId(rs.getInt("id"));
                dp.setNome(rs.getString("nome"));
                dp.setPeso(rs.getInt("peso"));
                return dp;                
            }                       
            return dp;

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
    
    public boolean existeDuracaoProjetoMesmoPeso(int id, int peso) throws ClassNotFoundException, SQLException 
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome, peso FROM opteste.duracao_projeto WHERE peso = ? ";
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
        
        String selectTableSQL = "SELECT max(peso) as peso FROM opteste.duracao_projeto ";
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
