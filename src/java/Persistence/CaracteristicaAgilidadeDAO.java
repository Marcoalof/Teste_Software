package Persistence;

import Model.CaracteristicaAgilidade;
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
public class CaracteristicaAgilidadeDAO 
{
    private static CaracteristicaAgilidadeDAO instance = new CaracteristicaAgilidadeDAO();
    
    /* Cria uma nova instância de ClienteDAO */
    private CaracteristicaAgilidadeDAO(){}
    
    public static CaracteristicaAgilidadeDAO getInstance() {
        return instance;
    }
    
    public String save(CaracteristicaAgilidade carac) 
    {
        Connection conn = null;
        Statement st  = null;
        String retorno = "";
        try 
        {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            
            st.execute("insert into opteste.caracteristica_agilidade (nome)" + " values ('" + carac.getNome() + "')");
            retorno = "Característica cadastrada com sucesso";
            return retorno;
        }
        catch(Exception e) 
        {
            retorno = "Erro ao tentar cadastrar nova Característica";
            return retorno;
        }
        finally 
        {
            closeResources(conn, st);
        }      
    }
    
    public boolean caracteristicaExiste(CaracteristicaAgilidade carac) throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome FROM opteste.caracteristica_agilidade WHERE id = ?";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, carac.getId());
            
            ResultSet rs = preparedStatement.executeQuery();
            CaracteristicaAgilidade c = null;            
            while (rs.next() == true) 
            {                                
                c = new CaracteristicaAgilidade();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
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
    
    public ArrayList<CaracteristicaAgilidade> listar() throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome FROM opteste.caracteristica_agilidade ";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<CaracteristicaAgilidade> lc = new ArrayList<>();
            CaracteristicaAgilidade c = null;            
            while (rs.next() == true) 
            {                                
                c = new CaracteristicaAgilidade();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
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

    public void update(CaracteristicaAgilidade c) throws SQLException, ClassNotFoundException
    {
        Connection conn = null;
        Statement st  = null;
        String retorno = "";
        try 
        {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            
            st.execute("update opteste.caracteristica_agilidade set nome = " + c.getNome() + " where id = " + c.getId());
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
        String retorno = "";
        try 
        {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            
            st.execute("delete from opteste.caracteristica_agilidade where id = " + id);
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

    public CaracteristicaAgilidade buscar(int id) throws ClassNotFoundException, SQLException 
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome FROM opteste.caracteristica_agilidade WHERE id = ?";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, id);
            
            ResultSet rs = preparedStatement.executeQuery();
            CaracteristicaAgilidade c = null;            
            while (rs.next() == true) 
            {                                
                c = new CaracteristicaAgilidade();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
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

}
