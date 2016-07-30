/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerLogic;

import Model.CaracteristicaAgilidade;
import Persistence.CaracteristicaAgilidadeDAO;
import Persistence.UsuarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marco Antônio
 */
public class ControllerLogicCaracteristicaAgilidade implements ControllerLogic
{

    @Override
    public void inserir(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            CaracteristicaAgilidade c = new CaracteristicaAgilidade();
            c.setNome(request.getParameter("nome"));
            CaracteristicaAgilidadeDAO.getInstance().save(c);
            request.getRequestDispatcher("/Projeto_Teste_Software/Views/Cadastros/CaracteristicaAgilidade/Index.jsp").forward(request, response);
        } 
        catch (ServletException | IOException ex) 
        {
            Logger.getLogger(ControllerLogicCaracteristicaAgilidade.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao inserir nova caracteristica de agilidade "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void editar(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            CaracteristicaAgilidade c = new CaracteristicaAgilidade();
            c.setId(Integer.parseInt(request.getParameter("id")));
            c.setNome(request.getParameter("nome"));
            CaracteristicaAgilidadeDAO.getInstance().update(c);
            request.getRequestDispatcher("/Projeto_Teste_Software/Views/Cadastros/CaracteristicaAgilidade/Index.jsp").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicCaracteristicaAgilidade.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao inserir nova caracteristica de agilidade "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void excluir(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            int id = Integer.parseInt(request.getParameter("id"));
            CaracteristicaAgilidadeDAO.getInstance().excluir(id);
            request.getRequestDispatcher("/Projeto_Teste_Software/Views/Cadastros/CaracteristicaAgilidade/Index.jsp").forward(request, response);
        } 
        catch (IOException | ServletException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicCaracteristicaAgilidade.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao inserir nova caracteristica de agilidade "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void listar(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            request.setAttribute("caracteristicas", CaracteristicaAgilidadeDAO.getInstance().listar());
            request.getRequestDispatcher("/Views/Cadastros/CaracteristicaAgilidade/Index.jsp").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicCaracteristicaAgilidade.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao inserir nova caracteristica de agilidade "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void editarPopular(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("caracteristica", CaracteristicaAgilidadeDAO.getInstance().buscar(id));
            request.getRequestDispatcher("/Projeto_Teste_Software/Views/Cadastros/CaracteristicaAgilidade/Editar.jsp").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicCaracteristicaAgilidade.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao inserir nova caracteristica de agilidade "  + ex.getCause() + " " + ex.getMessage());
        }
    }
    
}