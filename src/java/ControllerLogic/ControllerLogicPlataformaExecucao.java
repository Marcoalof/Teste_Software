/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerLogic;

import Model.PlataformaExecucao;
import Persistence.PlataformaExecucaoDAO;
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
@ManagedBean(name = "PlataformaExecucaoLogic", eager = true)
public class ControllerLogicPlataformaExecucao implements ControllerLogic, Serializable 
{
    @Override
    public void inserir(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            PlataformaExecucao pe = new PlataformaExecucao();
            pe.setNome(request.getParameter("nome"));
            PlataformaExecucaoDAO.getInstance().save(pe);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicPlataformaExecucao&acao=listar").forward(request, response);
        } 
        catch (ServletException | IOException ex) 
        {
            Logger.getLogger(ControllerLogicPlataformaExecucao.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao inserir nova Plataforma de Execução "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void editar(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            PlataformaExecucao pe = new PlataformaExecucao();
            pe.setId(Integer.parseInt(request.getParameter("id")));
            pe.setNome(request.getParameter("nome"));
            PlataformaExecucaoDAO.getInstance().update(pe);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicPlataformaExecucao&acao=listar").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicPlataformaExecucao.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao editar Plataforma de Execução "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void excluir(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            int id = Integer.parseInt(request.getParameter("id"));
            PlataformaExecucaoDAO.getInstance().excluir(id);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicPlataformaExecucao&acao=listar").forward(request, response);
        } 
        catch (IOException | ServletException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicPlataformaExecucao.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao excluir Plataforma de Execução "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void listar(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            request.setAttribute("pes", PlataformaExecucaoDAO.getInstance().listar());
            request.getRequestDispatcher("/Views/Cadastros/PlataformaExecucao/Index.jsp").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicPlataformaExecucao.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao listar Plataforma de Execução "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void editarPopular(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("pe", PlataformaExecucaoDAO.getInstance().buscar(id));
            request.getRequestDispatcher("/Views/Cadastros/PlataformaExecucao/InserirEditar.jsp").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicPlataformaExecucao.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao carregar Plataforma de Execução "  + ex.getCause() + " " + ex.getMessage());
        }
    }    
}
