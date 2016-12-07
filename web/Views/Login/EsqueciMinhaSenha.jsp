<%-- 
    Document   : login
    Created on : 24/04/2015, 15:12:22
    Author     : Marco Antônio
--%>

<%@ page session="false" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/Views/Basicos/Head.html" %>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
              <div id="navbar" class="navbar-collapse collapse">
                  <a class="navbar-brand" >Apoio a Teste de Software - Projeto Final Monografia</a>
                  <div class="navbar-form navbar-right">
                  <table cellspacing="0" role="presentation">
                      <tbody>
                          <tr>
                              <td style="padding: 5px">
                              <input type="text" name="userName" id="username" placeholder="Usuário" class="form-control" tabindex="1">
                            </td>
                            <td style="padding: 5px">
                              <input type="password" name="password" id="password" placeholder="Senha" class="form-control" tabindex="2">         
                            </td>
                            <td style="padding: 5px">
                                <button type="button" class="btn btn-success" tabindex="4" id="entrar" onClick="return valida_login()">Entrar <span class="glyphicon glyphicon-circle-arrow-right"/></button>
                            </td>  
                          </tr>
                          <tr>
                            <td>
                            </td>
                            <td style="padding: 5px">
                              <a style="color: #1870BB" href="/Projeto_Teste_Software/ControllerRedirecionar?page=/Projeto_Teste_Software/Views/Login/EsqueciMinhaSenha.jsp">Esqueceu sua senha?</a>
                            </td>
                          </tr>
                      </tbody>
                    </table>
                </div>
              </div><!--/.navbar-collapse -->
            </div>
        </nav>
        <%@include file="/Views/Basicos/Modals_Padrao.html" %>
                
        <div class="esqueciMinhaSenhaInserir">      
            <fieldset>
                <legend>Redefinição de Senha</legend>
                <fieldset class="form-group">
                    <label>Informe o Usuário cadastrado</label>
                    <div class="iconInput">
                        <i class="glyphicon glyphicon-user"></i>
                        <input type="text" placeholder="Username" name="username" id="Username" maxlength="45"/>
                    </div>
                    <label class="control-label visible-ie8 visible-ie9">Informe o seu email cadastrado</label>
                    <div class="iconInput">
                        <i class="glyphicon glyphicon-envelope"></i>
                        <input type="email" placeholder="Ex.: teste@teste.com" name="email" id="email" maxlength="55"/>
                    </div>
                </fieldset>
            </fieldset>
            <button type="submit" class="btn btn-primary" onclick="return esqueci_minha_senha(); return false;">Salvar</button>  
            <button type="reset" class="btn btn-primary" onclick="voltar_login();">Voltar</button>
        </div>
    </body>
</html>