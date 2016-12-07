/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerLogic;

import Model.CicloVida;
import Persistence.CicloVidaDAO;
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
@ManagedBean(name = "CicloVida", eager = true)
public class ControllerLogicCicloVida implements ControllerLogic, Serializable 
{
    @Override
    public void inserir(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            CicloVida c = new CicloVida();
            c.setNome(request.getParameter("nome"));
            c.setDescricao(request.getParameter("descricao"));
            CicloVidaDAO.getInstance().save(c);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicCicloVida&acao=listar").forward(request, response);
        } 
        catch (ServletException | IOException ex) 
        {
            Logger.getLogger(ControllerLogicCaracteristicaAgilidade.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao inserir novo ciclo de vida "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void editar(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            CicloVida c = new CicloVida();
            c.setId(Integer.parseInt(request.getParameter("id")));
            c.setNome(request.getParameter("nome"));
            c.setDescricao(request.getParameter("descricao"));
            CicloVidaDAO.getInstance().update(c);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicCicloVida&acao=listar").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicCaracteristicaAgilidade.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao editar ciclo de vida "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void excluir(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            int id = Integer.parseInt(request.getParameter("id"));
            CicloVidaDAO.getInstance().excluir(id);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicCicloVida&acao=listar").forward(request, response);
        } 
        catch (IOException | ServletException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicCaracteristicaAgilidade.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao excluir ciclo de vida "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void listar(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            request.setAttribute("ciclos", CicloVidaDAO.getInstance().listar());
            request.getRequestDispatcher("/Views/Cadastros/CicloVida/Index.jsp").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicCaracteristicaAgilidade.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao listar ciclos de vida "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void editarPopular(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("ciclo", CicloVidaDAO.getInstance().buscar(id));
            request.getRequestDispatcher("/Views/Cadastros/CicloVida/InserirEditar.jsp").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicCaracteristicaAgilidade.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao carregar ciclo de vida "  + ex.getCause() + " " + ex.getMessage());
        }
    }    
}
