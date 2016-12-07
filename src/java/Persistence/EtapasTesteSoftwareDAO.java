package Persistence;

import Model.EtapasTesteSoftware;
import Model.PraticasAgeis;
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
public class EtapasTesteSoftwareDAO 
{
    private static EtapasTesteSoftwareDAO instance = new EtapasTesteSoftwareDAO();
    
    /* Cria uma nova instância de ClienteDAO */
    private EtapasTesteSoftwareDAO(){}
    
    public static EtapasTesteSoftwareDAO getInstance() {
        return instance;
    }
    
    public String save(EtapasTesteSoftware ets) 
    {
        Connection conn = null;
        Statement st  = null;
        String retorno = "";
        try 
        {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            
            st.execute("insert into opteste.etapa_teste_software (nome, descricao, produto_trabalho_produzido)" + " values ('" + ets.getNome() + "','" + ets.getDescricao() + "', '" + ets.getProdutoTrabalhoProduzido() + "')");
            int id_etapa = recuperarUltimoId();
            if(id_etapa != -1)
            {
                inserePraticasAssociadasAEtapa(ets, id_etapa);
            }
            retorno = "Etapa de Teste cadastrada com sucesso";
            return retorno;
        }
        catch(Exception e) 
        {
            retorno = "Erro ao tentar cadastrar nova Etapa de Teste";
            return retorno;
        }
        finally 
        {
            closeResources(conn, st);
        }      
    }
    
    private void inserePraticasAssociadasAEtapa(EtapasTesteSoftware ets, int id_etapa) throws SQLException, ClassNotFoundException
    {
        Connection conn = null;
        Statement st  = null;
        conn = DatabaseLocator.getInstance().getConnection();
        st = conn.createStatement();

        for(int i = 0; i < ets.getPraticasAssociadas().size(); i++)
        {
            st.execute("insert into opteste.col_praticas_ageis (id_pratica_agil, id_etapa_teste_software) values (" + ets.getPraticasAssociadas().get(i).getId() + "," + id_etapa + ")");
        }
        closeResources(conn, st);
    }
    
    public boolean EtapaExiste(EtapasTesteSoftware ets) throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome, descricao, produto_trabalho_produzido FROM opteste.etapa_teste_software WHERE id = ?";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, ets.getId());
            
            ResultSet rs = preparedStatement.executeQuery();
            EtapasTesteSoftware e = null;            
            while (rs.next() == true) 
            {                                
                e = new EtapasTesteSoftware();
                e.setId(rs.getInt("id"));
                e.setNome(rs.getString("nome"));
                e.setDescricao(rs.getString("descricao"));
                e.setProdutoTrabalhoProduzido(rs.getString("produto_trabalho_produzido"));
                e.setPraticasAssociadas(recuperarPraticasAssociadasAEtapa(rs.getInt("id")));
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
    
    public ArrayList<EtapasTesteSoftware> listar() throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome, descricao, produto_trabalho_produzido FROM opteste.etapa_teste_software order by 1";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<EtapasTesteSoftware> le = new ArrayList<>();
            EtapasTesteSoftware e = null;            
            while (rs.next() == true) 
            {                                
                e = new EtapasTesteSoftware();
                e.setId(rs.getInt("id"));
                e.setNome(rs.getString("nome"));
                e.setDescricao(rs.getString("descricao"));
                e.setProdutoTrabalhoProduzido(rs.getString("produto_trabalho_produzido"));
                e.setPraticasAssociadas(recuperarPraticasAssociadasAEtapa(rs.getInt("id")));
                le.add(e);
            }                       
            return le;
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

    public void update(EtapasTesteSoftware e) throws SQLException, ClassNotFoundException 
    {
        Connection conn = null;
        Statement st  = null;
        try 
        {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("update opteste.etapa_teste_software set nome = '" + e.getNome() + "', descricao = '" + e.getDescricao()+ "', produto_trabalho_produzido = '" + e.getProdutoTrabalhoProduzido()+ "' where id = " + e.getId());
            st.execute("delete from opteste.col_praticas_ageis where id_etapa_teste_software = " + e.getId());
            inserePraticasAssociadasAEtapa(e, e.getId());
        }
        catch(SQLException | ClassNotFoundException ex)
        {
            throw ex;
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
            st.execute("delete from opteste.col_praticas_ageis where id_etapa_teste_software = " + id);
            st.execute("delete from opteste.etapa_teste_software where id = " + id);
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

    public EtapasTesteSoftware buscar(int id) throws ClassNotFoundException, SQLException 
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome, descricao, produto_trabalho_produzido FROM opteste.etapa_teste_software WHERE id = ?";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, id);
            
            ResultSet rs = preparedStatement.executeQuery();
            EtapasTesteSoftware e = null;            
            while (rs.next() == true) 
            {                                
                e = new EtapasTesteSoftware();
                e.setId(rs.getInt("id"));
                e.setNome(rs.getString("nome"));
                e.setDescricao(rs.getString("descricao"));
                e.setProdutoTrabalhoProduzido(rs.getString("produto_trabalho_produzido"));
                e.setPraticasAssociadas(recuperarPraticasAssociadasAEtapa(rs.getInt("id")));
                return e;                
            }                       
            return e;

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
    
    public ArrayList<PraticasAgeis> recuperarPraticasAssociadasAEtapa(int id_etapa) throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT distinct id_pratica_agil  FROM opteste.col_praticas_ageis WHERE id_etapa_teste_software = ?";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, id_etapa);
            
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<PraticasAgeis> lp = new ArrayList<>();
            PraticasAgeis p = null;            
            while (rs.next() == true) 
            {                                
                p = new PraticasAgeis();
                p = PraticasAgeisDAO.getInstance().buscar(rs.getInt("id_pratica_agil"));
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

    private int recuperarUltimoId() throws ClassNotFoundException, SQLException 
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT max(id) as id FROM opteste.etapa_teste_software ";
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

}
