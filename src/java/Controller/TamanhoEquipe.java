/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Persistence.TamanhoEquipeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marco Ant�nio
 */
@ManagedBean(name = "TamanhoEquipe", eager = true)
public class TamanhoEquipe extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String retorno = "";
        boolean existeTamanhoEquipeMesmoPeso = false;
        response.setContentType("text/plain");
        response.setCharacterEncoding("iso-8859-1");
        if(acao.equals("inserir") || acao.equals("editar"))
        {
            int id = Integer.parseInt(request.getParameter("id"));
            int peso = Integer.parseInt(request.getParameter("peso"));
            try 
            {
                existeTamanhoEquipeMesmoPeso = TamanhoEquipeDAO.getInstance().existeTamanhoEquipeMesmoPeso(id, peso);
                if(existeTamanhoEquipeMesmoPeso)
                {
                    retorno = "true";
                }
                else
                {
                    retorno = "false";
                }
            } 
            catch (ClassNotFoundException | SQLException ex ) 
            {
                retorno = "Erro ao processar registro";
            }
            response.getWriter().write(retorno);
        }
        else
        {
            response.getWriter().write("A��o n�o identificada.");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
