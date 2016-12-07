package Persistence;

import Model.CaracteristicaAgilidade;
import Model.PraticasAgeis;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marco Antônio
 */
@ManagedBean(name = "CaracteristicaAgilidadeDAO", eager = true)
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
            
            st.execute("insert into opteste.caracteristica_agilidade (nome, descricao, pertinencia, relevancia)" + " values ('" + carac.getNome() + "','" + carac.getDescricao() + "', " + carac.getPertinencia() + ", " + carac.getRelevancia() + ")");
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
        
        String selectTableSQL = "SELECT id, nome, descricao, pertinencia, relevancia FROM opteste.caracteristica_agilidade WHERE id = ?";
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
                c.setDescricao(rs.getString("descricao"));
                c.setPertinencia(rs.getDouble("pertinencia"));
                c.setRelevancia(rs.getDouble("relevancia"));
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
    
    public ArrayList<CaracteristicaAgilidade> listarCaracteristicasComPratica() throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT distinct "
                + "                     ca.id as id, "
                + "                     ca.nome as nome, "
                + "                     ca.descricao as descricao, "
                + "                     ca.pertinencia as pertinencia, "
                + "                     ca.relevancia as relevancia "
                + "                FROM opteste.caracteristica_agilidade ca,"
                + "                     opteste.col_caracteristica_agilidade cca "
                + "               WHERE ca.id = cca.id_caracteristica_agilidade "
                + "              order by 1 ";
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
                c.setDescricao(rs.getString("descricao"));
                c.setPertinencia(rs.getDouble("pertinencia"));
                c.setRelevancia(rs.getDouble("relevancia"));
                lc.add(c);
            }                       
            return lc;
        }
        catch(SQLException | ClassNotFoundException e) 
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
        
        String selectTableSQL = "SELECT id, nome, descricao, pertinencia, relevancia FROM opteste.caracteristica_agilidade ";
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
                c.setDescricao(rs.getString("descricao"));
                c.setPertinencia(rs.getDouble("pertinencia"));
                c.setRelevancia(rs.getDouble("relevancia"));
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
        try 
        {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            
            st.execute("update opteste.caracteristica_agilidade set nome = '" + c.getNome() + "', descricao = '" + c.getDescricao()+ "', pertinencia = " + c.getPertinencia() + ", relevancia = " + c.getRelevancia() + " where id = " + c.getId());
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
        
        String selectTableSQL = "SELECT id, nome, descricao, pertinencia, relevancia FROM opteste.caracteristica_agilidade WHERE id = ?";
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
                c.setDescricao(rs.getString("descricao"));
                c.setPertinencia(rs.getDouble("pertinencia"));
                c.setRelevancia(rs.getDouble("relevancia"));
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
    
    public String getListaPraticasAssociadasACaracteristica(int id) throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT distinct group_concat(id_pratica_agil,', ') as praticas FROM opteste.col_caracteristica_agilidade WHERE id_caracteristica_agilidade = ? ";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            String retorno = "";
            while (rs.next() == true) 
            {                   
                retorno = rs.getString("praticas");
                if(retorno != null)
                {
                    return retorno;
                }
                else
                {
                    retorno = "";
                }
            }                       
            return retorno;
        }
        catch(SQLException e) 
        {
            return "";
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
    
    public ArrayList<PraticasAgeis> getPraticasAssociadasACaracteristica(int id) throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id_pratica_agil FROM opteste.col_caracteristica_agilidade WHERE id_caracteristica_agilidade = ? ";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<PraticasAgeis> lp = new ArrayList<>();
            while (rs.next() == true) 
            {                   
                lp.add(PraticasAgeisDAO.getInstance().buscar(Integer.parseInt(rs.getString("id_pratica_agil"))));
            }
            return lp;
        }
        catch(SQLException e) 
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

    public ArrayList<PraticasAgeis> getPraticasAssociadasAsCaracteristicas(String ids) throws ClassNotFoundException, SQLException 
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT distinct id_pratica_agil FROM opteste.col_caracteristica_agilidade WHERE id_caracteristica_agilidade in (?) order by 1";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setString(1, ids);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<PraticasAgeis> lp = new ArrayList<>();
            while (rs.next() == true) 
            {                   
                lp.add(PraticasAgeisDAO.getInstance().buscar(Integer.parseInt(rs.getString("id_pratica_agil"))));
            }
            return lp;
        }
        catch(SQLException e) 
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

}
