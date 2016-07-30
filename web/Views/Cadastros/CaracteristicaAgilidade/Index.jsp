<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : login
    Created on : 24/04/2015, 15:12:22
    Author     : Marco Antônio
--%>

<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<jsp:useBean id="carac" scope="request" class="Model.CaracteristicaAgilidade" />

<html xmlns="http://www.w3.org/1999/xhtml" lang="pt-br" xml:lang="pt-br">
    <head>
        <%@include file="/Views/Basicos/Head.html" %>
    </head>
    <body>
        
        <%@include file="/Views/Basicos/Modals_Padrao.html" %>
        <%@include file="/Views/Basicos/Header.html" %>
        
        <div>
            <table border="1">
                <thead>
                    <tr>
                        <th colspan="2">Ações</th>
                        <th>ID</th>
                        <th>Nome</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- column data -->
                    <c:forEach var="caracteristica" items="${caracteristicas}">
                        <tr>
                            <td><a href="/Projeto_Teste_Software/Controller/Caracteristica_Agilidade?acao=editar&id=${caracteristica.id}">Editar</a></td>
                            <td><a href="/Projeto_Teste_Software/Controller/Caracteristica_Agilidade?acao=excluir&id=${caracteristica.id}">Excluir</a></td>
                            <td><c:out value="${caracteristica.id}"/></td>
                            <td><c:out value="${caracteristica.nome}"/></td>
                        </tr>
                    </c:forEach>
                </tbody>    
            </table>
            
        </div>
         <br>   
            <button type="submit" class="btn btn-primary" onClick="validaCadastroPolo(0)"><?php if($id=="-1") echo "Cadastrar"; else echo "Salvar altera&ccedil;&otilde;s"; ?></button>
            <button type="reset" class="btn btn-primary" onClick="changeContent('listaPolos.php')">Voltar</button>	
        <form method="post" action="adicionaPolo.php">
            <fieldset>
                <input type="hidden" name="id" value="<?php echo $id; ?>">
                <legend>Lista de Características de Agilidade</legend>
                <fieldset class="form-group">
                    <label for="id">Id</label>
                    <input type="text" class="form-control" name="id" value="${caracteristica.id}" >
                </fieldset>
                <fieldset class="form-group">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" name="nome" value="${caracteristica.nome}" >
                </fieldset>
            </fieldset>
        </form>
    </body>
</html>
