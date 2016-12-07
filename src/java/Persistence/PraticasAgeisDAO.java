package Persistence;

import Model.CaracteristicaAgilidade;
import Model.PraticasAgeis;
import java.io.IOException;
import java.io.Serializable;
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
public class PraticasAgeisDAO implements Serializable
{
    private static PraticasAgeisDAO instance = new PraticasAgeisDAO();
    
    /* Cria uma nova instância de ClienteDAO */
    public PraticasAgeisDAO()
    {
    }
    
    public static PraticasAgeisDAO getInstance() {
        return instance;
    }
    
    public String save(PraticasAgeis prat) 
    {
        Connection conn = null;
        Statement st  = null;
        String retorno = "";
        try 
        {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            
            st.execute("insert into opteste.praticas_ageis (nome, descricao, pertinencia, relevancia)" + " values ('" + prat.getNome() + "','" + prat.getDescricao() + "', " + prat.getPertinencia() + ", " + prat.getRelevancia() + ")");
            int id_pratica = recuperarUltimoId();
            if(id_pratica != -1)
            {
                insereCaracteristicasAssociadasAPratica(prat, id_pratica);
            }
            retorno = "Prática cadastrada com sucesso";
            return retorno;
        }
        catch(Exception e) 
        {
            retorno = "Erro ao tentar cadastrar nova Prática";
            return retorno;
        }
        finally 
        {
            closeResources(conn, st);
        }      
    }
    
    private void insereCaracteristicasAssociadasAPratica(PraticasAgeis prat, int id_pratica) throws SQLException, ClassNotFoundException
    {
        Connection conn = null;
        Statement st  = null;
        String retorno = "";
        conn = DatabaseLocator.getInstance().getConnection();
        st = conn.createStatement();

        for(int i = 0; i < prat.getCaracteristicasAssociadas().size(); i++)
        {
            st.execute("insert into opteste.col_caracteristica_agilidade (id_caracteristica_agilidade, id_pratica_agil) values (" + prat.getCaracteristicasAssociadas().get(i).getId() + "," + id_pratica + ")");
        }
        closeResources(conn, st);
    }
    
    public boolean PraticaExiste(PraticasAgeis prat) throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome, descricao, pertinencia, relevancia FROM opteste.praticas_ageis WHERE id = ?";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, prat.getId());
            
            ResultSet rs = preparedStatement.executeQuery();
            PraticasAgeis p = null;            
            while (rs.next() == true) 
            {                                
                p = new PraticasAgeis();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setPertinencia(rs.getDouble("pertinencia"));
                p.setRelevancia(rs.getDouble("relevancia"));
                p.setCaracteristicasAssociadas(recuperarCaracteristicasAssociadasAPratica(rs.getInt("id")));
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
    
    public ArrayList<PraticasAgeis> listar() throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome, descricao, pertinencia, relevancia FROM opteste.praticas_ageis ";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<PraticasAgeis> lp = new ArrayList<>();
            PraticasAgeis p = null;            
            while (rs.next() == true) 
            {                                
                p = new PraticasAgeis();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setPertinencia(rs.getDouble("pertinencia"));
                p.setRelevancia(rs.getDouble("relevancia"));
                p.setCaracteristicasAssociadas(recuperarCaracteristicasAssociadasAPratica(rs.getInt("id")));
                lp.add(p);
            }                       
            return lp;
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

    public void update(PraticasAgeis p) throws SQLException, ClassNotFoundException
    {
        Connection conn = null;
        Statement st  = null;
        try 
        {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            
            st.execute("update opteste.praticas_ageis set nome = '" + p.getNome() + "', descricao = '" + p.getDescricao()+ "', pertinencia = " + p.getPertinencia() + ", relevancia = " + p.getRelevancia() + " where id = " + p.getId());
            st.execute("delete from opteste.col_caracteristica_agilidade where id_pratica_agil = " + p.getId());
            insereCaracteristicasAssociadasAPratica(p, p.getId());
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
            st.execute("delete from opteste.col_caracteristica_agilidade where id_pratica_agil = " + id);
            st.execute("delete from opteste.praticas_ageis where id = " + id);
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

    public PraticasAgeis buscar(int id) throws ClassNotFoundException, SQLException 
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome, descricao, pertinencia, relevancia FROM opteste.praticas_ageis WHERE id = ?";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, id);
            
            ResultSet rs = preparedStatement.executeQuery();
            PraticasAgeis p = null;            
            while (rs.next() == true) 
            {                                
                p = new PraticasAgeis();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setPertinencia(rs.getDouble("pertinencia"));
                p.setRelevancia(rs.getDouble("relevancia"));
                p.setCaracteristicasAssociadas(recuperarCaracteristicasAssociadasAPratica(rs.getInt("id")));
                return p;                
            }                       
            return p;

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
    
    public ArrayList<CaracteristicaAgilidade> recuperarCaracteristicasAssociadasAPratica(int id_pratica) throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT distinct id_caracteristica_agilidade  FROM opteste.col_caracteristica_agilidade WHERE id_pratica_agil = ?";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, id_pratica);
            
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<CaracteristicaAgilidade> lc = new ArrayList<>();
            CaracteristicaAgilidade c = null;            
            while (rs.next() == true) 
            {                                
                c = new CaracteristicaAgilidade();
                c = CaracteristicaAgilidadeDAO.getInstance().buscar(rs.getInt("id_caracteristica_agilidade"));
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

    private int recuperarUltimoId() throws ClassNotFoundException, SQLException 
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT max(id) as id FROM opteste.praticas_ageis ";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            preparedStatement = conn.prepareStatement(selectTableSQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next() == true) 
            {
                return rs.getInt("id");
            }
            return -1;
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

    public String getListaEtapasTesteAssociadasAPraticas(int id) throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT distinct group_concat(id_etapa_teste_software,', ') as etapas FROM opteste.col_praticas_ageis WHERE id_pratica_agil = ? ";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            String retorno = "";
            while (rs.next() == true) 
            {                   
                retorno = rs.getString("etapas");
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
}
