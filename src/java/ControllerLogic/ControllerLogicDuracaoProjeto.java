/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerLogic;

import Model.DuracaoProjeto;
import Persistence.DuracaoProjetoDAO;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marco Antônio
 */
@ManagedBean(name = "DuracaoProjetoLogic", eager = true)
public class ControllerLogicDuracaoProjeto implements ControllerLogic, Serializable 
{
    @Override
    public void inserir(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            DuracaoProjeto dp = new DuracaoProjeto();
            dp.setNome(request.getParameter("nome"));
            dp.setPeso(Integer.parseInt(request.getParameter("peso")));
            DuracaoProjetoDAO.getInstance().save(dp);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicDuracaoProjeto&acao=listar").forward(request, response);
        } 
        catch (ServletException | IOException ex) 
        {
            Logger.getLogger(ControllerLogicDuracaoProjeto.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao inserir nova Faixa de Duração dos Projetos "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void editar(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            DuracaoProjeto dp = new DuracaoProjeto();
            dp.setId(Integer.parseInt(request.getParameter("id")));
            dp.setNome(request.getParameter("nome"));
            dp.setPeso(Integer.parseInt(request.getParameter("peso")));
            DuracaoProjetoDAO.getInstance().update(dp);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicDuracaoProjeto&acao=listar").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicDuracaoProjeto.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao editar Faixa de Duração dos Projetos "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void excluir(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            int id = Integer.parseInt(request.getParameter("id"));
            DuracaoProjetoDAO.getInstance().excluir(id);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicDuracaoProjeto&acao=listar").forward(request, response);
        } 
        catch (IOException | ServletException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicDuracaoProjeto.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao excluir Faixa de Duração dos Projetos "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void listar(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            request.setAttribute("dps", DuracaoProjetoDAO.getInstance().listar());
            request.getRequestDispatcher("/Views/Cadastros/DuracaoProjeto/Index.jsp").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicDuracaoProjeto.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao listar Faixa de Duração dos Projetos "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void editarPopular(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("dp", DuracaoProjetoDAO.getInstance().buscar(id));
            request.getRequestDispatcher("/Views/Cadastros/DuracaoProjeto/InserirEditar.jsp").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicDuracaoProjeto.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao carregar Faixa de Duração dos Projetos "  + ex.getCause() + " " + ex.getMessage());
        }
    }    
}
