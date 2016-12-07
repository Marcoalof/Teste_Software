/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Model.TamanhoEquipe;
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
@ManagedBean(name = "TamanhoEquipeDAO", eager = true)
public class TamanhoEquipeDAO 
{
    private static TamanhoEquipeDAO instance = new TamanhoEquipeDAO();
    
    /* Cria uma nova instância de ClienteDAO */
    private TamanhoEquipeDAO(){}
    
    public static TamanhoEquipeDAO getInstance() {
        return instance;
    }
    
    public String save(TamanhoEquipe te) 
    {
        Connection conn = null;
        Statement st  = null;
        String retorno = "";
        try 
        {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            
            st.execute("insert into opteste.tamanho_equipe (nome, peso)" + " values ('" + te.getNome() + "','" + te.getPeso() + "')");
            retorno = "Indicador de Faixa de Tamanho da Equipe cadastrado com sucesso";
            return retorno;
        }
        catch(Exception e) 
        {
            retorno = "Erro ao tentar cadastrar nova Faixa de Tamanho da Equipe";
            return retorno;
        }
        finally 
        {
            closeResources(conn, st);
        }      
    }
    
    public boolean TamanhoEquipeExiste(TamanhoEquipe te) throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome, peso FROM opteste.tamanho_equipe WHERE id = ?";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, te.getId());
            
            ResultSet rs = preparedStatement.executeQuery();
            TamanhoEquipe i = null;            
            while (rs.next() == true) 
            {                                
                i = new TamanhoEquipe();
                i.setId(rs.getInt("id"));
                i.setNome(rs.getString("nome"));
                i.setPeso(rs.getInt("peso"));
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
    
    public ArrayList<TamanhoEquipe> listar() throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome, peso FROM opteste.tamanho_equipe ";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<TamanhoEquipe> lte = new ArrayList<>();
            TamanhoEquipe e = null;            
            while (rs.next() == true) 
            {                                
                e = new TamanhoEquipe();
                e.setId(rs.getInt("id"));
                e.setNome(rs.getString("nome"));
                e.setPeso(rs.getInt("peso"));
                lte.add(e);
            }                       
            return lte;
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

    public void update(TamanhoEquipe te) throws SQLException, ClassNotFoundException
    {
        Connection conn = null;
        Statement st  = null;
        try 
        {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            if(!existeTamanhoEquipeMesmoPeso(te.getId(), te.getPeso()))
            {
                st.execute("update opteste.tamanho_equipe set nome = '" + te.getNome() + "', peso = '" + te.getPeso()+ "' where id = " + te.getId());
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
            
            st.execute("delete from opteste.tamanho_equipe where id = " + id);
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

    public TamanhoEquipe buscar(int id) throws ClassNotFoundException, SQLException 
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome, peso FROM opteste.tamanho_equipe WHERE id = ?";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, id);
            
            ResultSet rs = preparedStatement.executeQuery();
            TamanhoEquipe te = null;            
            while (rs.next() == true) 
            {                                
                te = new TamanhoEquipe();
                te.setId(rs.getInt("id"));
                te.setNome(rs.getString("nome"));
                te.setPeso(rs.getInt("peso"));
                return te;                
            }                       
            return te;

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
    
    public boolean existeTamanhoEquipeMesmoPeso(int id, int peso) throws ClassNotFoundException, SQLException 
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome, peso FROM opteste.tamanho_equipe WHERE peso = ? ";
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
        
        String selectTableSQL = "SELECT max(peso) as peso FROM opteste.tamanho_equipe ";
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
