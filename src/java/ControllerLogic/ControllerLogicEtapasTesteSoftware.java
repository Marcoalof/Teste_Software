/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerLogic;

import Model.EtapasTesteSoftware;
import Model.PraticasAgeis;
import Persistence.EtapasTesteSoftwareDAO;
import Persistence.PraticasAgeisDAO;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
@ManagedBean(name = "EtapasTesteSoftware", eager = true)
public class ControllerLogicEtapasTesteSoftware implements ControllerLogic, Serializable
{

    @Override
    public void inserir(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            EtapasTesteSoftware e = new EtapasTesteSoftware();
            e.setNome(request.getParameter("nome"));
            e.setDescricao(request.getParameter("descricao"));
            e.setProdutoTrabalhoProduzido(request.getParameter("produtoTrabalhoProduzido"));
            e.setPraticasAssociadas(recuperarPraticasAssociadas(request.getParameterValues("listDestino")));
            EtapasTesteSoftwareDAO.getInstance().save(e);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicEtapasTesteSoftware&acao=listar").forward(request, response);
        } 
        catch (SQLException | ClassNotFoundException | ServletException | IOException ex) 
        {
            Logger.getLogger(ControllerLogicEtapasTesteSoftware.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao inserir nova Etapa de Teste de Software "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void editar(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            EtapasTesteSoftware e = new EtapasTesteSoftware();
            e.setId(Integer.parseInt(request.getParameter("id")));
            e.setNome(request.getParameter("nome"));
            e.setDescricao(request.getParameter("descricao"));
            e.setProdutoTrabalhoProduzido(request.getParameter("produtoTrabalhoProduzido"));
            e.setPraticasAssociadas(recuperarPraticasAssociadas(request.getParameterValues("listDestino")));
            EtapasTesteSoftwareDAO.getInstance().update(e);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicEtapasTesteSoftware&acao=listar").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicEtapasTesteSoftware.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao editar Etapa de Teste de Software "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void excluir(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            int id = Integer.parseInt(request.getParameter("id"));
            EtapasTesteSoftwareDAO.getInstance().excluir(id);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicEtapasTesteSoftware&acao=listar").forward(request, response);
        } 
        catch (IOException | ServletException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicEtapasTesteSoftware.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao excluir Etapa de Teste de Software "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void listar(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            request.setAttribute("etapas", EtapasTesteSoftwareDAO.getInstance().listar());
            request.getRequestDispatcher("/Views/Cadastros/EtapasTesteSoftware/Index.jsp").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicEtapasTesteSoftware.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao listar as Etapas de Teste de Software "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void editarPopular(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            ArrayList<PraticasAgeis> praticas = new ArrayList();
            ArrayList<PraticasAgeis> praticasAssociadas = new ArrayList();
            EtapasTesteSoftware e = new EtapasTesteSoftware();
            int id = Integer.parseInt(request.getParameter("id"));
            e = EtapasTesteSoftwareDAO.getInstance().buscar(id);
            praticas = PraticasAgeisDAO.getInstance().listar();
            praticasAssociadas = e.getPraticasAssociadas();
            praticas = removerTodosEmB(praticas, praticasAssociadas);
            request.setAttribute("etapa", e);
            request.setAttribute("praticas", praticas);
            request.setAttribute("praticasAssociadas", praticasAssociadas);
            request.getRequestDispatcher("/Views/Cadastros/EtapasTesteSoftware/InserirEditar.jsp").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicEtapasTesteSoftware.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao carregar Etapa de Teste de Sofware"  + ex.getCause() + " " + ex.getMessage());
        }
    }
    
    public void criar(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            request.setAttribute("praticas", PraticasAgeisDAO.getInstance().listar());
            request.getRequestDispatcher("/Views/Cadastros/EtapasTesteSoftware/InserirEditar.jsp").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicCaracteristicaAgilidade.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao carregar Práticas Ágeis "  + ex.getCause() + " " + ex.getMessage());
        }
    }
    
    private ArrayList<PraticasAgeis> recuperarPraticasAssociadas(String[] praticasAssociadas) throws ClassNotFoundException, SQLException
    {
        ArrayList<PraticasAgeis> lp = new ArrayList<>();
        for(int i = 0; i < praticasAssociadas.length; i++)
        {
            lp.add(PraticasAgeisDAO.getInstance().buscar(Integer.parseInt(praticasAssociadas[i])));
        }
        return lp;
    }
    
    private ArrayList<PraticasAgeis> removerTodosEmB(ArrayList<PraticasAgeis> a, ArrayList<PraticasAgeis> b)
    {
        ArrayList<PraticasAgeis> caux = new ArrayList<>();
        caux.addAll(b);
        for(int i = 0; i < caux.size(); i++) 
        {   
            for(int j = 0; j < a.size(); j++) 
            {
                if(a.get(j).getId() == b.get(i).getId())
                {
                    a.remove(j);
                    break;
                }
            }
        }
        return a;
    }
}