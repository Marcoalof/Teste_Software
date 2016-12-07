package Persistence;

import Model.AmbienteFisico;
import Model.AvaliacaoEficacia;
import Model.CaracteristicaAgilidade;
import Model.EtapasProjeto;
import Model.PraticasAgeis;
import Model.ProjetoSoftware;
import Model.ResultadoAvaliacao;
import Model.ResultadoPraticas;
import Model.Status;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marco Antônio
 */
public class ProjetoSoftwareDAO 
{
    private static ProjetoSoftwareDAO instance = new ProjetoSoftwareDAO();
    
    /* Cria uma nova instância de ClienteDAO */
    private ProjetoSoftwareDAO(){}
    
    public static ProjetoSoftwareDAO getInstance() {
        return instance;
    }
    
    public int saveProjetoSoftware(ProjetoSoftware ps) 
    {
        Connection conn = null;
        Statement st  = null;
        String retorno = "";
        try 
        {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql = "insert into opteste.projeto_software "
                    + "(nome, "
                    + "descricao, "
                    + "ic_status, "
                    + "dt_inicio_projeto, "
                    + "dt_fim_projeto, "
                    + "nome_resp_cliente, "
                    + "nome_resp_desenv, "
                    + "dt_plan_agilidade, "
                    + "dt_aval_agilidade, "
                    + "ic_resultado_aval, "
                    + "id_ciclo_vida, "
                    + "id_duracao_projeto, "
                    + "id_complexidade_problema, "
                    + "id_instabilidade_requisito, "
                    + "id_tamanho_equipe, "
                    + "id_criticidade_projeto, "
                    + "ic_ambiente_fisico, "
                    + "id_plataforma_execucao, "
                    + "id_dominio_aplicacao, "
                    + "ic_etapa_atual, "
                    + "ic_resultado_praticas, "
                    + "dc_observacao "
                    + ")" + 
                    " values "
                    + "('" + ps.getNome() + "',"
                    + "'" + ps.getDescricao() + "', "
                    + "'" + ps.getIc_status().getSigla()+ "', "
                    + "DATE_FORMAT('" + new SimpleDateFormat("yyyy-MM-dd").format(ps.getDt_inicio_projeto()) + "','%Y/%m/%d'), ";
                    if(ps.getDt_fim_projeto() == null)
                    {
                        sql += "NULL, ";
                    }
                    else
                    {
                        sql += "DATE_FORMAT('" + new SimpleDateFormat("yyyy-MM-dd").format(ps.getDt_fim_projeto()) + "','%Y/%m/%d'), ";
                    }
                    sql += "'" + ps.getNome_resp_cliente()+ "', "
                         + "'" + ps.getNome_resp_desenv()+ "', ";
                    if(ps.getDt_plan_agilidade() == null)
                    {
                        sql += "NULL, ";
                    }
                    else
                    {
                        sql += "DATE_FORMAT('" + new SimpleDateFormat("yyyy-MM-dd").format(ps.getDt_plan_agilidade()) + "','%Y/%m/%d'), ";
                    }
                    if(ps.getDt_aval_agilidade()== null)
                    {
                        sql += "NULL, ";
                    }
                    else
                    {
                        sql += "DATE_FORMAT('" + new SimpleDateFormat("yyyy-MM-dd").format(ps.getDt_aval_agilidade()) + "','%Y/%m/%d'), ";
                    }
                    if(ps.getIc_resultado_aval() == null)
                    {
                        sql += "NULL, ";
                    }
                    else
                    {
                        sql += "'" +ps.getIc_resultado_aval().getSigla()+ "', ";
                    }
                    sql += ps.getId_ciclo_vida()+ ", "
                        + ps.getId_duracao_projeto()+ ", "
                        + ps.getId_complexidade_problema()+ ", "
                        + ps.getId_instabilidade_requisitos()+ ", "
                        + ps.getId_tamanho_equipe()+ ", "
                        + ps.getId_criticidade_projeto()+ ", ";
                    if(ps.getIc_ambiente_fisico() == null)
                    {
                        sql += "NULL, ";
                    }
                    else
                    {
                        sql += "'" +ps.getIc_ambiente_fisico().getSigla()+ "', ";
                    }
                    sql += ps.getId_plataforma_execucao()+ ", "
                        + ps.getId_dominio_aplicacao()+ ", ";
                    if(ps.getIc_etapa_atual() == null)
                    {
                        sql += "NULL, ";
                    }
                    else
                    {
                        sql += "'" +ps.getIc_etapa_atual().getSigla()+ "', ";
                    }
                    
                    if(ps.getIc_resultado_praticas()== null)
                    {
                        sql += "NULL, ";
                    }
                    else
                    {
                        sql += "'" +ps.getIc_resultado_praticas().getSigla()+ "', ";
                    }
                    sql += "'" +ps.getDc_observacao()+ "' ";
                    sql += ")";
            st.execute(sql);
            int id_projeto = recuperarUltimoId();
            
            return id_projeto;
        }
        catch(Exception e) 
        {
            return -1;
        }
        finally 
        {
            closeResources(conn, st);
        }      
    }
    
    public void updateProjetoSoftware(ProjetoSoftware ps) throws SQLException, ClassNotFoundException
    {
        Connection conn = null;
        Statement st  = null;
        try 
        {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql = "update opteste.projeto_software set "
                    + "nome = '"+ps.getNome()+ "', "
                    + "descricao = '"+ps.getDescricao()+ "', "
                    + "ic_status = '"+ps.getIc_status().getSigla()+ "', "
                    + "dt_inicio_projeto = DATE_FORMAT('"+new SimpleDateFormat("yyyy-MM-dd").format(ps.getDt_inicio_projeto())+ "','%Y/%m/%d'), "
                    + "dt_fim_projeto = ";
                    if(ps.getDt_fim_projeto() == null)
                    {
                        sql += "NULL, ";
                    }
                    else
                    {
                        sql += "DATE_FORMAT('"+new SimpleDateFormat("yyyy-MM-dd").format(ps.getDt_fim_projeto())+ "','%Y/%m/%d'), ";
                    }
                    sql += "nome_resp_cliente = '"+ps.getNome_resp_cliente()+ "', "
                    + "nome_resp_desenv = '"+ps.getNome_resp_desenv()+ "', "
                    + "dt_plan_agilidade = ";
                    if(ps.getDt_plan_agilidade()== null)
                    {
                        sql += "NULL, ";
                    }
                    else
                    {
                        sql += "DATE_FORMAT('"+new SimpleDateFormat("yyyy-MM-dd").format(ps.getDt_plan_agilidade())+ "','%Y/%m/%d'), ";
                    }
                    sql += "dt_aval_agilidade = ";
                    if(ps.getDt_aval_agilidade()== null)
                    {
                        sql += "NULL, ";
                    }
                    else
                    {
                        sql += "DATE_FORMAT('"+new SimpleDateFormat("yyyy-MM-dd").format(ps.getDt_aval_agilidade())+ "','%Y/%m/%d'), ";
                    }
                    sql += "ic_resultado_aval = ";
                    if(ps.getIc_resultado_aval() == null)
                    {
                        sql += "NULL, ";
                    }
                    else
                    {
                        sql += "'" +ps.getIc_resultado_aval().getSigla()+ "', ";
                    }
                    sql += "id_ciclo_vida = "+ps.getId_ciclo_vida()+ ", "
                    + "id_duracao_projeto = "+ps.getId_duracao_projeto()+ ", "
                    + "id_complexidade_problema = "+ps.getId_complexidade_problema()+ ", "
                    + "id_instabilidade_requisito = "+ps.getId_instabilidade_requisitos()+ ", "
                    + "id_tamanho_equipe = "+ps.getId_tamanho_equipe()+ ", "
                    + "id_criticidade_projeto = "+ps.getId_criticidade_projeto()+ ", "
                    + "ic_ambiente_fisico = ";
                    if(ps.getIc_ambiente_fisico() == null)
                    {
                        sql += "NULL, ";
                    }
                    else
                    {
                        sql += "'" +ps.getIc_ambiente_fisico().getSigla()+ "', ";
                    }
                    sql += "id_plataforma_execucao = "+ps.getId_plataforma_execucao()+ ", "
                    + "id_dominio_aplicacao = "+ps.getId_dominio_aplicacao()+ ", "
                    + "ic_etapa_atual = ";
                    if(ps.getIc_etapa_atual() == null)
                    {
                        sql += "NULL, ";
                    }
                    else
                    {
                        sql += "'" +ps.getIc_etapa_atual().getSigla()+ "', ";
                    }
                    
                    sql += " ic_resultado_praticas = ";
                    if(ps.getIc_resultado_praticas() == null)
                    {
                        sql += "NULL, ";
                    }
                    else
                    {
                        sql += "'" +ps.getIc_resultado_praticas().getSigla()+ "', ";
                    }
                    sql += " dc_observacao = '" +ps.getDc_observacao()+ "' ";
                    
                    sql += " WHERE id = " +ps.getId();
            st.execute(sql);
            if(ps.getCaracteristicasAssociadas() != null)
            {
                st.execute("delete from opteste.col_caracteristica_agilidade_por_projeto where id_projeto_software = " + ps.getId());
                insereCaracteristicasAssociadasAoProjeto(ps);
            }
            if(ps.getAvaliacaoEficacia() != null)
            {
                st.execute("delete from opteste.avaliacao_eficacia where id_projeto_software = " + ps.getId());
                insereAvaliacaoEficaciaAssociadaAoProjeto(ps);
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
    
    private void insereCaracteristicasAssociadasAoProjeto(ProjetoSoftware ps) throws SQLException, ClassNotFoundException
    {
        Connection conn = null;
        Statement st  = null;
        conn = DatabaseLocator.getInstance().getConnection();
        st = conn.createStatement();

        for(int i = 0; i < ps.getCaracteristicasAssociadas().size(); i++)
        {
            st.execute("insert into opteste.col_caracteristica_agilidade_por_projeto (id_caracteristica_agilidade, id_projeto_software) values (" + ps.getCaracteristicasAssociadas().get(i).getId() + "," + ps.getId() + ")");
        }
        closeResources(conn, st);
    }
    
    public ArrayList<ProjetoSoftware> listar() throws ClassNotFoundException, SQLException, ParseException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, "
                    + "nome, "
                    + "descricao, "
                    + "ic_status, "
                    + "DATE_FORMAT(dt_inicio_projeto,'%d/%m/%Y') as dt_inicio_projeto, "
                    + "DATE_FORMAT(dt_fim_projeto,'%d/%m/%Y') as dt_fim_projeto, "
                    + "nome_resp_cliente, "
                    + "nome_resp_desenv, "
                    + "DATE_FORMAT(dt_plan_agilidade,'%d/%m/%Y') as dt_plan_agilidade, "
                    + "DATE_FORMAT(dt_aval_agilidade,'%d/%m/%Y') as dt_aval_agilidade, "
                    + "ic_resultado_aval, "
                    + "id_ciclo_vida, "
                    + "id_duracao_projeto, "
                    + "id_complexidade_problema, "
                    + "id_instabilidade_requisito, "
                    + "id_tamanho_equipe, "
                    + "id_criticidade_projeto, "
                    + "ic_ambiente_fisico, "
                    + "id_plataforma_execucao, "
                    + "id_dominio_aplicacao, "
                    + "ic_etapa_atual, "
                    + "ic_resultado_praticas, "
                    + "dc_observacao "
                    + "FROM opteste.projeto_software ";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<ProjetoSoftware> lp = new ArrayList<>();
            ProjetoSoftware p = null;            
            while (rs.next() == true) 
            {                                
                p = CarregarObjetoProjetoSoftware(rs);
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
    
    public ProjetoSoftware buscarProjetoSoftware(int id) throws ClassNotFoundException, SQLException, ParseException 
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, "
                    + "nome, "
                    + "descricao, "
                    + "ic_status, "
                    + "DATE_FORMAT(dt_inicio_projeto,'%d/%m/%Y') as dt_inicio_projeto, "
                    + "DATE_FORMAT(dt_fim_projeto,'%d/%m/%Y') as dt_fim_projeto, "
                    + "nome_resp_cliente, "
                    + "nome_resp_desenv, "
                    + "DATE_FORMAT(dt_plan_agilidade,'%d/%m/%Y') as dt_plan_agilidade, "
                    + "DATE_FORMAT(dt_aval_agilidade,'%d/%m/%Y') as dt_aval_agilidade, "
                    + "ic_resultado_aval, "
                    + "id_ciclo_vida, "
                    + "id_duracao_projeto, "
                    + "id_complexidade_problema, "
                    + "id_instabilidade_requisito, "
                    + "id_tamanho_equipe, "
                    + "id_criticidade_projeto, "
                    + "ic_ambiente_fisico, "
                    + "id_plataforma_execucao, "
                    + "id_dominio_aplicacao, "
                    + "ic_etapa_atual, "
                    + "ic_resultado_praticas, "
                    + "dc_observacao "
                    + "FROM opteste.projeto_software "
                    + "WHERE id = ? ";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, id);
            
            ResultSet rs = preparedStatement.executeQuery();
            ProjetoSoftware ps = null;            
            while (rs.next() == true) 
            {                                
                ps = CarregarObjetoProjetoSoftware(rs);
                return ps;
            }                       
            return ps;

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
    
    public ArrayList<CaracteristicaAgilidade> recuperarCaracteristicasAssociadasAoProjeto(int id_projeto_software) throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT distinct id_caracteristica_agilidade  FROM opteste.col_caracteristica_agilidade_por_projeto WHERE id_projeto_software = ? order by 1 ";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, id_projeto_software);
            
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
        
        String selectTableSQL = "SELECT max(id) as id FROM opteste.projeto_software ";
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

    private ProjetoSoftware CarregarObjetoProjetoSoftware(ResultSet rs) throws ParseException, SQLException, ClassNotFoundException
    {
        ProjetoSoftware ps = new ProjetoSoftware();
        ps.setId(rs.getInt("id"));
        ps.setNome(rs.getString("nome"));
        ps.setDescricao(rs.getString("descricao"));
        ps.setIc_status(Status.retornaStatusPelaSigla(rs.getString("ic_status")));
        String dt_inicio_projeto = rs.getString("dt_inicio_projeto");
        String dt_fim_projeto = rs.getString("dt_fim_Projeto");
        SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
        if(dt_inicio_projeto != null && !dt_inicio_projeto.equals(""))
        {
            ps.setDt_inicio_projeto(sfd.parse(dt_inicio_projeto));
        }
        else
        {
            ps.setDt_inicio_projeto(null);
        }
        if(dt_fim_projeto != null && !dt_fim_projeto.equals(""))
        {
            ps.setDt_fim_projeto(sfd.parse(dt_fim_projeto));
        }
        else
        {
            ps.setDt_fim_projeto(null);
        }
        ps.setNome_resp_cliente(rs.getString("nome_resp_cliente"));
        ps.setNome_resp_desenv(rs.getString("nome_resp_desenv"));
        String dt_plan_agilidade = rs.getString("dt_plan_agilidade");
        String dt_aval_agilidade = rs.getString("dt_aval_agilidade");
        if(dt_plan_agilidade != null && !dt_plan_agilidade.equals(""))
        {
            ps.setDt_plan_agilidade(sfd.parse(dt_plan_agilidade));
        }
        else
        {
            ps.setDt_plan_agilidade(null);
        }
        
        if(dt_aval_agilidade != null && !dt_aval_agilidade.equals(""))
        {
            ps.setDt_aval_agilidade(sfd.parse(dt_aval_agilidade));
        }
        else
        {
            ps.setDt_aval_agilidade(null);
        }
        ps.setIc_resultado_aval(ResultadoAvaliacao.retornaResultadoPelaSigla(rs.getString("ic_resultado_aval")));
        ps.setId_ciclo_vida(rs.getInt("id_ciclo_vida"));
        ps.setId_duracao_projeto(rs.getInt("id_duracao_projeto"));
        ps.setId_complexidade_problema(rs.getInt("id_complexidade_problema"));
        ps.setId_instabilidade_requisitos(rs.getInt("id_instabilidade_requisito"));
        ps.setId_tamanho_equipe(rs.getInt("id_tamanho_equipe"));
        ps.setId_criticidade_projeto(rs.getInt("id_criticidade_projeto"));
        ps.setIc_ambiente_fisico(AmbienteFisico.retornaAmbientePelaSigla(rs.getString("ic_ambiente_fisico")));
        ps.setId_plataforma_execucao(rs.getInt("id_plataforma_execucao"));
        ps.setId_dominio_aplicacao(rs.getInt("id_dominio_aplicacao"));
        ps.setIc_etapa_atual(EtapasProjeto.retornaEtapaPelaSigla(rs.getString("ic_etapa_atual")));
        ps.setIc_resultado_praticas(ResultadoPraticas.retornaResultadoPelaSigla(rs.getString("ic_resultado_praticas")));
        String obs = rs.getString("dc_observacao");
        if(obs != null)
        {
            ps.setDc_observacao(obs);
        }
        else
        {
            ps.setDc_observacao("");
        }
        ps.setCaracteristicasAssociadas(recuperarCaracteristicasAssociadasAoProjeto(ps.getId()));
        ps.setAvaliacaoEficacia(recuperarAvaliacaoEficaciaAssociadasAoProjeto(ps.getId()));
        return ps;
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

    private void insereAvaliacaoEficaciaAssociadaAoProjeto(ProjetoSoftware ps) throws SQLException, ClassNotFoundException 
    {
        Connection conn = null;
        Statement st  = null;
        conn = DatabaseLocator.getInstance().getConnection();
        st = conn.createStatement();

        for(int i = 0; i < ps.getAvaliacaoEficacia().size(); i++)
        {
            st.execute("insert into opteste.avaliacao_eficacia (id_projeto_software, id_pratica_agil, ic_grau_pratica_adotado, ic_nivel_contribuicao, dc_observacao) values (" + ps.getAvaliacaoEficacia().get(i).getId_projeto_software()+ ", " + ps.getAvaliacaoEficacia().get(i).getId_pratica_agil()+ ", '"+ps.getAvaliacaoEficacia().get(i).getIc_grau_pratica_adotado().getSigla()+"', '"+ps.getAvaliacaoEficacia().get(i).getIc_nivel_contribuicao().getSigla()+"', '"+ps.getAvaliacaoEficacia().get(i).getDc_observacao()+"')");
        }
        closeResources(conn, st);
    }

    private ArrayList<AvaliacaoEficacia> recuperarAvaliacaoEficaciaAssociadasAoProjeto(int id) throws ClassNotFoundException, ParseException, SQLException 
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
                + "               WHERE id_projeto_software = ?";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, id);
            
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<AvaliacaoEficacia> la = new ArrayList<>();
            AvaliacaoEficacia a = null;            
            while (rs.next() == true) 
            {                                
                a = AvaliacaoEficaciaDAO.getInstance().buscarAvaliacaoEficacia(rs.getInt("id_projeto_software"), rs.getInt("id_pratica_agil"));
                la.add(a);
            }                       
            return la;
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
