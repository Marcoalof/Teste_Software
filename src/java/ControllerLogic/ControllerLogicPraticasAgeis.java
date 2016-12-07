/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerLogic;

import Model.CaracteristicaAgilidade;
import Model.PraticasAgeis;
import Persistence.CaracteristicaAgilidadeDAO;
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
@ManagedBean(name = "PraticasAgeis", eager = true)
public class ControllerLogicPraticasAgeis implements ControllerLogic, Serializable
{

    @Override
    public void inserir(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            PraticasAgeis p = new PraticasAgeis();
            p.setNome(request.getParameter("nome"));
            p.setDescricao(request.getParameter("descricao"));
            p.setPertinencia(Double.parseDouble(request.getParameter("pertinencia")));
            p.setRelevancia(Double.parseDouble(request.getParameter("relevancia")));
            p.setCaracteristicasAssociadas(recuperarCaracteristicasAssociadas(request.getParameterValues("listDestino")));
            PraticasAgeisDAO.getInstance().save(p);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicPraticasAgeis&acao=listar").forward(request, response);
        } 
        catch (SQLException | ClassNotFoundException | ServletException | IOException ex) 
        {
            Logger.getLogger(ControllerLogicPraticasAgeis.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao inserir nova Prática Ágil "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void editar(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            PraticasAgeis p = new PraticasAgeis();
            p.setId(Integer.parseInt(request.getParameter("id")));
            p.setNome(request.getParameter("nome"));
            p.setDescricao(request.getParameter("descricao"));
            p.setPertinencia(Double.parseDouble(request.getParameter("pertinencia")));
            p.setRelevancia(Double.parseDouble(request.getParameter("relevancia")));
            p.setCaracteristicasAssociadas(recuperarCaracteristicasAssociadas(request.getParameterValues("listDestino")));
            PraticasAgeisDAO.getInstance().update(p);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicPraticasAgeis&acao=listar").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicPraticasAgeis.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao editar Prática Ágil "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void excluir(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            int id = Integer.parseInt(request.getParameter("id"));
            PraticasAgeisDAO.getInstance().excluir(id);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicPraticasAgeis&acao=listar").forward(request, response);
        } 
        catch (IOException | ServletException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicPraticasAgeis.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao excluir Prática Ágil "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void listar(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            request.setAttribute("praticas", PraticasAgeisDAO.getInstance().listar());
            request.getRequestDispatcher("/Views/Cadastros/PraticasAgeis/Index.jsp").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicPraticasAgeis.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao listar as práticas ágeis"  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void editarPopular(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            ArrayList<CaracteristicaAgilidade> carateristicas = new ArrayList();
            ArrayList<CaracteristicaAgilidade> cacateristicasAssociadas = new ArrayList();
            PraticasAgeis p = new PraticasAgeis();
            int id = Integer.parseInt(request.getParameter("id"));
            p = PraticasAgeisDAO.getInstance().buscar(id);
            carateristicas = CaracteristicaAgilidadeDAO.getInstance().listar();
            cacateristicasAssociadas = p.getCaracteristicasAssociadas();
            carateristicas = removerTodosEmB(carateristicas, cacateristicasAssociadas);
            request.setAttribute("pratica", p);
            request.setAttribute("caracteristicas", carateristicas);
            request.setAttribute("cacateristicasAssociadas", cacateristicasAssociadas);
            request.getRequestDispatcher("/Views/Cadastros/PraticasAgeis/Editar.jsp").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicPraticasAgeis.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao carregar prática ágil "  + ex.getCause() + " " + ex.getMessage());
        }
    }
    
    public void criar(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            request.setAttribute("caracteristicas", CaracteristicaAgilidadeDAO.getInstance().listar());
            request.getRequestDispatcher("/Views/Cadastros/PraticasAgeis/Inserir.jsp").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicCaracteristicaAgilidade.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao carregar caracteristica de agilidade "  + ex.getCause() + " " + ex.getMessage());
        }
    }
    
    private ArrayList<CaracteristicaAgilidade> recuperarCaracteristicasAssociadas(String[] caracteristicasAssociadas) throws ClassNotFoundException, SQLException
    {
        ArrayList<CaracteristicaAgilidade> lc = new ArrayList<>();
        for(int i = 0; i < caracteristicasAssociadas.length; i++)
        {
            lc.add(CaracteristicaAgilidadeDAO.getInstance().buscar(Integer.parseInt(caracteristicasAssociadas[i])));
        }
        return lc;
    }
    
    private ArrayList<CaracteristicaAgilidade> removerTodosEmB(ArrayList<CaracteristicaAgilidade> a, ArrayList<CaracteristicaAgilidade> b)
    {
        ArrayList<CaracteristicaAgilidade> caux = new ArrayList<>();
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