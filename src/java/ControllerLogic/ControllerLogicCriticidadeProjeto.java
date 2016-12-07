/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerLogic;

import Model.CriticidadeProjeto;
import Persistence.CriticidadeProjetoDAO;
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
@ManagedBean(name = "CriticidadeProjetoLogic", eager = true)
public class ControllerLogicCriticidadeProjeto implements ControllerLogic, Serializable 
{
    @Override
    public void inserir(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            CriticidadeProjeto cp = new CriticidadeProjeto();
            cp.setNome(request.getParameter("nome"));
            cp.setPeso(Integer.parseInt(request.getParameter("peso")));
            CriticidadeProjetoDAO.getInstance().save(cp);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicCriticidadeProjeto&acao=listar").forward(request, response);
        } 
        catch (ServletException | IOException ex) 
        {
            Logger.getLogger(ControllerLogicCriticidadeProjeto.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao inserir nova Criticidade do Projeto "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void editar(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            CriticidadeProjeto cp = new CriticidadeProjeto();
            cp.setId(Integer.parseInt(request.getParameter("id")));
            cp.setNome(request.getParameter("nome"));
            cp.setPeso(Integer.parseInt(request.getParameter("peso")));
            CriticidadeProjetoDAO.getInstance().update(cp);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicCriticidadeProjeto&acao=listar").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicCriticidadeProjeto.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao editar Criticidade do Projeto "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void excluir(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            int id = Integer.parseInt(request.getParameter("id"));
            CriticidadeProjetoDAO.getInstance().excluir(id);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicCriticidadeProjeto&acao=listar").forward(request, response);
        } 
        catch (IOException | ServletException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicCriticidadeProjeto.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao excluir Criticidade do Projeto "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void listar(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            request.setAttribute("cps", CriticidadeProjetoDAO.getInstance().listar());
            request.getRequestDispatcher("/Views/Cadastros/CriticidadeProjeto/Index.jsp").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicCriticidadeProjeto.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao listar Criticidade do Projeto "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void editarPopular(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("cp", CriticidadeProjetoDAO.getInstance().buscar(id));
            request.getRequestDispatcher("/Views/Cadastros/CriticidadeProjeto/InserirEditar.jsp").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicCriticidadeProjeto.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao carregar Criticidade do Projeto "  + ex.getCause() + " " + ex.getMessage());
        }
    }    
}
