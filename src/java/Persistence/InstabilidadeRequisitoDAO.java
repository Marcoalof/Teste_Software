/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Model.InstabilidadeRequisito;
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
@ManagedBean(name = "InstabilidadeRequisitoDAO", eager = true)
public class InstabilidadeRequisitoDAO 
{
    private static InstabilidadeRequisitoDAO instance = new InstabilidadeRequisitoDAO();
    
    /* Cria uma nova instância de ClienteDAO */
    private InstabilidadeRequisitoDAO(){}
    
    public static InstabilidadeRequisitoDAO getInstance() {
        return instance;
    }
    
    public String save(InstabilidadeRequisito ir) 
    {
        Connection conn = null;
        Statement st  = null;
        String retorno = "";
        try 
        {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            
            st.execute("insert into opteste.indicador_instabilidade_requisitos (nome, peso)" + " values ('" + ir.getNome() + "','" + ir.getPeso() + "')");
            retorno = "Indicador de Instabilidade dos Requisitos cadastrado com sucesso";
            return retorno;
        }
        catch(Exception e) 
        {
            retorno = "Erro ao tentar cadastrar novo Indicador de Instabilidade dos Requisitos";
            return retorno;
        }
        finally 
        {
            closeResources(conn, st);
        }      
    }
    
    public boolean InstabilidadeRequisitoExiste(InstabilidadeRequisito ir) throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome, peso FROM opteste.indicador_instabilidade_requisitos WHERE id = ?";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, ir.getId());
            
            ResultSet rs = preparedStatement.executeQuery();
            InstabilidadeRequisito i = null;            
            while (rs.next() == true) 
            {                                
                i = new InstabilidadeRequisito();
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
    
    public ArrayList<InstabilidadeRequisito> listar() throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome, peso FROM opteste.indicador_instabilidade_requisitos ";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<InstabilidadeRequisito> lir = new ArrayList<>();
            InstabilidadeRequisito i = null;            
            while (rs.next() == true) 
            {                                
                i = new InstabilidadeRequisito();
                i.setId(rs.getInt("id"));
                i.setNome(rs.getString("nome"));
                i.setPeso(rs.getInt("peso"));
                lir.add(i);
            }                       
            return lir;
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

    public void update(InstabilidadeRequisito ir) throws SQLException, ClassNotFoundException
    {
        Connection conn = null;
        Statement st  = null;
        try 
        {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            if(!existeInstabilidadeMesmoPeso(ir.getId(), ir.getPeso()))
            {
                st.execute("update opteste.indicador_instabilidade_requisitos set nome = '" + ir.getNome() + "', peso = '" + ir.getPeso()+ "' where id = " + ir.getId());
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
            
            st.execute("delete from opteste.indicador_instabilidade_requisitos where id = " + id);
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

    public InstabilidadeRequisito buscar(int id) throws ClassNotFoundException, SQLException 
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome, peso FROM opteste.indicador_instabilidade_requisitos WHERE id = ?";
        try 
        {            
            conn = DatabaseLocator.getInstance().getConnection();
            
            preparedStatement = conn.prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, id);
            
            ResultSet rs = preparedStatement.executeQuery();
            InstabilidadeRequisito ir = null;            
            while (rs.next() == true) 
            {                                
                ir = new InstabilidadeRequisito();
                ir.setId(rs.getInt("id"));
                ir.setNome(rs.getString("nome"));
                ir.setPeso(rs.getInt("peso"));
                return ir;                
            }                       
            return ir;

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
    
    public boolean existeInstabilidadeMesmoPeso(int id, int peso) throws ClassNotFoundException, SQLException 
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;                
        
        String selectTableSQL = "SELECT id, nome, peso FROM opteste.indicador_instabilidade_requisitos WHERE peso = ? ";
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
        
        String selectTableSQL = "SELECT max(peso) as peso FROM opteste.indicador_instabilidade_requisitos ";
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
