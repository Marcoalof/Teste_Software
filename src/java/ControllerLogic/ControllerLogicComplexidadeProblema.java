/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerLogic;

import Model.ComplexidadeProblema;
import Persistence.ComplexidadeProblemaDAO;
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
@ManagedBean(name = "ComplexidadeProblemaLogic", eager = true)
public class ControllerLogicComplexidadeProblema implements ControllerLogic, Serializable 
{
    @Override
    public void inserir(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            ComplexidadeProblema c = new ComplexidadeProblema();
            c.setNome(request.getParameter("nome"));
            c.setPeso(Integer.parseInt(request.getParameter("peso")));
            ComplexidadeProblemaDAO.getInstance().save(c);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicComplexidadeProblema&acao=listar").forward(request, response);
        } 
        catch (ServletException | IOException ex) 
        {
            Logger.getLogger(ControllerLogicCaracteristicaAgilidade.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao inserir novo indicador de complexidade do problema "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void editar(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            ComplexidadeProblema c = new ComplexidadeProblema();
            c.setId(Integer.parseInt(request.getParameter("id")));
            c.setNome(request.getParameter("nome"));
            c.setPeso(Integer.parseInt(request.getParameter("peso")));
            ComplexidadeProblemaDAO.getInstance().update(c);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicComplexidadeProblema&acao=listar").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicCaracteristicaAgilidade.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao editar indicador de complexidade do problema "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void excluir(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            int id = Integer.parseInt(request.getParameter("id"));
            ComplexidadeProblemaDAO.getInstance().excluir(id);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicComplexidadeProblema&acao=listar").forward(request, response);
        } 
        catch (IOException | ServletException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicCaracteristicaAgilidade.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao excluir indicador de complexidade do problema "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void listar(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            request.setAttribute("cps", ComplexidadeProblemaDAO.getInstance().listar());
            request.getRequestDispatcher("/Views/Cadastros/ComplexidadeProblema/Index.jsp").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicCaracteristicaAgilidade.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao listar indicador de complexidade do problema "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void editarPopular(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("cp", ComplexidadeProblemaDAO.getInstance().buscar(id));
            request.getRequestDispatcher("/Views/Cadastros/ComplexidadeProblema/InserirEditar.jsp").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicCaracteristicaAgilidade.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao carregar indicador de complexidade do problema "  + ex.getCause() + " " + ex.getMessage());
        }
    }    
}
