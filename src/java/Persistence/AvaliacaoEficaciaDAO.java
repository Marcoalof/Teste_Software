package Persistence;

import Model.AvaliacaoEficacia;
import Model.ValoresAvaliacaoEficacia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class AvaliacaoEficaciaDAO 
{
    private static AvaliacaoEficaciaDAO instance = new AvaliacaoEficaciaDAO();
    
    /* Cria uma nova instância de ClienteDAO */
    private AvaliacaoEficaciaDAO(){}
    
    public static AvaliacaoEficaciaDAO getInstance() {
        return instance;
    }
    
    public AvaliacaoEficacia buscarAvaliacaoEficacia(int id_projeto_software, int id_pratica_agil) throws ClassNotFoundException, SQLException, ParseException 
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT distinct "
                + "                     id_projeto_software,  "
                + "                     id_pratica_agil,      "
                + "                     ic_grau_pratica_adotado, "
                + "                     ic_nivel_contribuicao, "
                + "                     dc_observacao "
                + "                FROM opteste.avaliacao_eficacia "
                + "               WHERE id_projeto_software = ? "
                + "                 AND id_pratica_agil = ? ";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, id_projeto_software);
            preparedStatement.setInt(2, id_pratica_agil);
            
            ResultSet rs = preparedStatement.executeQuery();
            AvaliacaoEficacia ae = null;            
            while (rs.next() == true) 
            {                                
                ae = CarregarObjetoAvaliacaoEficacia(rs);
                return ae;
            }                       
            return ae;

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

    private AvaliacaoEficacia CarregarObjetoAvaliacaoEficacia(ResultSet rs) throws ParseException, SQLException, ClassNotFoundException
    {
        AvaliacaoEficacia ae = new AvaliacaoEficacia();
        ae.setId_projeto_software(rs.getInt("id_projeto_software"));
        ae.setId_pratica_agil(rs.getInt("id_pratica_agil"));
        ae.setIc_grau_pratica_adotado(ValoresAvaliacaoEficacia.retornaValoresPelaSigla(rs.getString("ic_grau_pratica_adotado")));
        ae.setIc_nivel_contribuicao(ValoresAvaliacaoEficacia.retornaValoresPelaSigla(rs.getString("ic_nivel_contribuicao")));
        String obs = rs.getString("dc_observacao");
        if(obs != null)
        {
            ae.setDc_observacao(obs);
        }
        else
        {
            ae.setDc_observacao("");
        }
        return ae;
    }
    
    public void closeResources(Connection conn, Statement st) {
        try {
            if(st!=null) st.close();
            if(conn!=null) conn.close();
            
        } catch(SQLException e) {
            e.getMessage();
        }
    }    
/*
    public void excluir(int id) throws SQLException, ClassNotFoundException 
    {
        Connection conn = null;
        Statement st  = null;
        try 
        {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("delete from opteste.col_caracteristica_agilidade where id_pratica_agil = " + id);
            st.execute("delete from opteste.projeto_software where id = " + id);
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
*/    

    public void inserirAvaliacoesDeEficacia(ArrayList<AvaliacaoEficacia> lae) throws Exception 
    {
        Connection conn = null;
        Statement st  = null;
        try 
        {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            
            if(lae != null)
            {
                st.execute("delete from opteste.avaliacao_eficacia where id_projeto_software = " + lae.get(0).getId_projeto_software());
                
                for(int i = 0; i < lae.size(); i++)
                {
                    st.execute("insert into opteste.avaliacao_eficacia (id_projeto_software, id_pratica_agil, ic_grau_pratica_adotado, ic_nivel_contribuicao, dc_observacao) values (" + lae.get(i).getId_projeto_software()+ "," + lae.get(i).getId_pratica_agil()+ ", '" +lae.get(i).getIc_grau_pratica_adotado().getSigla()+ "', '" +lae.get(i).getIc_nivel_contribuicao().getSigla()+ "', '" +lae.get(i).getDc_observacao()+ "')");
                }
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

}
