/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerLogic;

import Model.DominioAplicacao;
import Persistence.DominioAplicacaoDAO;
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
@ManagedBean(name = "DominioAplicacaoLogic", eager = true)
public class ControllerLogicDominioAplicacao implements ControllerLogic, Serializable 
{
    @Override
    public void inserir(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            DominioAplicacao da = new DominioAplicacao();
            da.setNome(request.getParameter("nome"));
            DominioAplicacaoDAO.getInstance().save(da);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicDominioAplicacao&acao=listar").forward(request, response);
        } 
        catch (ServletException | IOException ex) 
        {
            Logger.getLogger(ControllerLogicDominioAplicacao.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao inserir novo Domínio da Aplicação "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void editar(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            DominioAplicacao da = new DominioAplicacao();
            da.setId(Integer.parseInt(request.getParameter("id")));
            da.setNome(request.getParameter("nome"));
            DominioAplicacaoDAO.getInstance().update(da);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicDominioAplicacao&acao=listar").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicDominioAplicacao.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao editar Domínio da Aplicação "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void excluir(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            int id = Integer.parseInt(request.getParameter("id"));
            DominioAplicacaoDAO.getInstance().excluir(id);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicDominioAplicacao&acao=listar").forward(request, response);
        } 
        catch (IOException | ServletException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicDominioAplicacao.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao excluir Domínio da Aplicação "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void listar(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            request.setAttribute("das", DominioAplicacaoDAO.getInstance().listar());
            request.getRequestDispatcher("/Views/Cadastros/DominioAplicacao/Index.jsp").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicDominioAplicacao.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao listar Domínio da Aplicação "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void editarPopular(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("da", DominioAplicacaoDAO.getInstance().buscar(id));
            request.getRequestDispatcher("/Views/Cadastros/DominioAplicacao/InserirEditar.jsp").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicDominioAplicacao.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao carregar Domínio da Aplicação "  + ex.getCause() + " " + ex.getMessage());
        }
    }    
}
