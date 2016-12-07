/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerLogic;

import Model.TamanhoEquipe;
import Persistence.TamanhoEquipeDAO;
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
@ManagedBean(name = "TamanhoEquipeLogic", eager = true)
public class ControllerLogicTamanhoEquipe implements ControllerLogic, Serializable 
{
    @Override
    public void inserir(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            TamanhoEquipe te = new TamanhoEquipe();
            te.setNome(request.getParameter("nome"));
            te.setPeso(Integer.parseInt(request.getParameter("peso")));
            TamanhoEquipeDAO.getInstance().save(te);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicTamanhoEquipe&acao=listar").forward(request, response);
        } 
        catch (ServletException | IOException ex) 
        {
            Logger.getLogger(ControllerLogicTamanhoEquipe.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao inserir nova Faixa de Tamanho da Equipe "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void editar(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            TamanhoEquipe te = new TamanhoEquipe();
            te.setId(Integer.parseInt(request.getParameter("id")));
            te.setNome(request.getParameter("nome"));
            te.setPeso(Integer.parseInt(request.getParameter("peso")));
            TamanhoEquipeDAO.getInstance().update(te);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicTamanhoEquipe&acao=listar").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicTamanhoEquipe.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao editar Faixa de Tamanho da Equipe "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void excluir(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            int id = Integer.parseInt(request.getParameter("id"));
            TamanhoEquipeDAO.getInstance().excluir(id);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicTamanhoEquipe&acao=listar").forward(request, response);
        } 
        catch (IOException | ServletException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicTamanhoEquipe.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao excluir Faixa de Tamanho da Equipe "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void listar(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            request.setAttribute("tes", TamanhoEquipeDAO.getInstance().listar());
            request.getRequestDispatcher("/Views/Cadastros/TamanhoEquipe/Index.jsp").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicTamanhoEquipe.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao listar Faixa de Tamanho da Equipe "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void editarPopular(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("te", TamanhoEquipeDAO.getInstance().buscar(id));
            request.getRequestDispatcher("/Views/Cadastros/TamanhoEquipe/InserirEditar.jsp").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicTamanhoEquipe.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao carregar Faixa de Tamanho da Equipe "  + ex.getCause() + " " + ex.getMessage());
        }
    }    
}
