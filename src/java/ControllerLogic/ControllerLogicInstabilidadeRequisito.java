/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerLogic;

import Model.InstabilidadeRequisito;
import Persistence.InstabilidadeRequisitoDAO;
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
@ManagedBean(name = "InstabilidadeRequisitoLogic", eager = true)
public class ControllerLogicInstabilidadeRequisito implements ControllerLogic, Serializable 
{
    @Override
    public void inserir(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            InstabilidadeRequisito ir = new InstabilidadeRequisito();
            ir.setNome(request.getParameter("nome"));
            ir.setPeso(Integer.parseInt(request.getParameter("peso")));
            InstabilidadeRequisitoDAO.getInstance().save(ir);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicInstabilidadeRequisito&acao=listar").forward(request, response);
        } 
        catch (ServletException | IOException ex) 
        {
            Logger.getLogger(ControllerLogicCaracteristicaAgilidade.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao inserir novo indicador de instabilidade dos requisitos "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void editar(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            InstabilidadeRequisito ir = new InstabilidadeRequisito();
            ir.setId(Integer.parseInt(request.getParameter("id")));
            ir.setNome(request.getParameter("nome"));
            ir.setPeso(Integer.parseInt(request.getParameter("peso")));
            InstabilidadeRequisitoDAO.getInstance().update(ir);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicInstabilidadeRequisito&acao=listar").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicCaracteristicaAgilidade.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao editar indicador de instabilidade dos requisitos "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void excluir(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            int id = Integer.parseInt(request.getParameter("id"));
            InstabilidadeRequisitoDAO.getInstance().excluir(id);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicInstabilidadeRequisito&acao=listar").forward(request, response);
        } 
        catch (IOException | ServletException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicCaracteristicaAgilidade.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao excluir indicador de Instabilidade dos Requisitos "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void listar(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            request.setAttribute("irs", InstabilidadeRequisitoDAO.getInstance().listar());
            request.getRequestDispatcher("/Views/Cadastros/InstabilidadeRequisito/Index.jsp").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicCaracteristicaAgilidade.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao listar indicador de Instabilidade dos Requisitos "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void editarPopular(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("ir", InstabilidadeRequisitoDAO.getInstance().buscar(id));
            request.getRequestDispatcher("/Views/Cadastros/InstabilidadeRequisito/InserirEditar.jsp").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicCaracteristicaAgilidade.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao carregar indicador de instabilidade dos requisitos "  + ex.getCause() + " " + ex.getMessage());
        }
    }    
}
