/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Usuario;
import Persistence.UsuarioDAO;
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
 * @author Marco Antônio
 */

//@RequestMapping("/Login")
@ManagedBean(name = "Login", eager = true)
public class Login extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        String acao = request.getParameter("acao");
        String retorno = "";
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        if(acao.equals("teste"))
        {
            response.getWriter().write("teste");
        }
        else if(acao.equals("entrar"))
        {
            String usuario = request.getParameter("usuario");
            String senha = request.getParameter("senha");
            try 
            {
                retorno = UsuarioDAO.getInstance().logar(usuario, senha);
            } 
            catch (SQLException ex) 
            {
                retorno = "Erro ao processar registro";
            }
            response.getWriter().write(retorno);
        }
        else if(acao.equals("cadastrar"))
        {
            String nome = request.getParameter("nome");
            String senha = request.getParameter("senha");
            String email = request.getParameter("email");
            Usuario usua = new Usuario(nome, senha, email);
            retorno = UsuarioDAO.getInstance().save(usua);
            response.getWriter().write(retorno);
        }
        else
        {
            response.getWriter().write("Ação não identificada.");
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
//        processRequest(request, response);
        doGet(request, response);
    }   

}
