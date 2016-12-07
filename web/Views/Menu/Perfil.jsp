<%-- 
    Document   : login
    Created on : 24/04/2015, 15:12:22
    Author     : Marco Antônio
--%>

<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/Views/Basicos/Head.html" %>
    </head>
    <body>
        
        <%@include file="/Views/Basicos/Modals_Padrao.html" %>
        <%@include file="/Views/Basicos/Header.html" %>
        <c:set var="PerfilUsuarioLogado" scope="request" value='<%=(Model.Usuario) request.getSession().getAttribute("UsuarioLogado")%>' />
        <div class="cadastrosBasicosInserir">
            <!-- BEGIN REGISTRATION FORM -->
              <h3>Perfil do Usuário</h3>
              <p>Informe os detalhas da sua conta:</p>
                <div class="control-group">                
                  <label>Usuário</label>
                  <input type="text" readonly="true" class="form-control" placeholder="Username" name="username" id="Username" maxlength="45" value="${PerfilUsuarioLogado.getNome()}"/>
                </div>   
                <div class="control-group">
                  <label>Password</label>
                  <input type="password" class="form-control" id="Password" placeholder="Ao menos 8 caracteres" name="password" maxlength="20" value="${PerfilUsuarioLogado.getSenha()}"/>
                </div>
                <div class="control-group">
                  <label class="control-label visible-ie8 visible-ie9">Confirmação Senha</label>
                  <input type="password" class="form-control" placeholder="Confirmar a Senha" name="rPassword" id="rPassword" maxlength="20" value="${PerfilUsuarioLogado.getSenha()}"/>
                </div>
                <div class="control-group">
                  <!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
                  <label class="control-label visible-ie8 visible-ie9">Email</label>
                  <input type="email" class="form-control" placeholder="Email. Ex.: teste@teste.com" name="email" id="email" maxlength="55" value="${PerfilUsuarioLogado.getEmail()}"/>
                </div>
                <br>
              <div class="form-actions">
                <button type="submit" class="btn btn-primary" onclick="return salvar_perfil(); return false;">Salvar</button>  
                <button type="reset" class="btn btn-primary" onclick="voltar_home();">Voltar</button>            
              </div>
            <!-- END REGISTRATION FORM -->
        </div>
    </body>
</html>
