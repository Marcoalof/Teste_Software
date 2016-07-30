/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marco Antônio
 */
public interface ControllerLogic 
{
    public void inserir(HttpServletRequest request, HttpServletResponse response);
    
    public void editar(HttpServletRequest request, HttpServletResponse response);
    
    public void excluir(HttpServletRequest request, HttpServletResponse response);
    
    public void listar(HttpServletRequest request, HttpServletResponse response);
    
    public void editarPopular(HttpServletRequest request, HttpServletResponse response);
    
}
