<%-- 
    Document   : login
    Created on : 24/04/2015, 15:12:22
    Author     : Marco Antônio
--%>

<%@ page session="false" %>
<%@ page language="java" contentType="text/html; " pageEncoding="iso-8859-1" %>
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
        
        <div class="cadastrosBasicos">
            
            <legend>Características de Agilidade</legend>
            
                <div id="caracteristicaAgilidade" class="panel panel-default">
                    <div class="panel-heading" style>
                        <a href="/Projeto_Teste_Software/ControllerRedirecionar?page=/Projeto_Teste_Software/Views/Cadastros/CaracteristicaAgilidade/Inserir.jsp">
                            <button type="button" class="btn btn-success">
                                <span class="glyphicon glyphicon-plus"></span>
                                <font>
                                    <font>Inserir</font>
                                </font>
                            </button>
                        </a>
                    </div>
                    
                    <table class="table" id="tbl-quality-answers">
                        <thead>
                            <tr>
                                <th>Ações</th>
                                <th>ID</th>
                                <th>Nome</th>
                                <th>Descrição</th>
                                <th>Pertinência</th>
                                <th>Relevância</th>
                            </tr>
                        </thead>
                    
                        <tbody>
                            <!-- column data -->
                            <c:forEach var="caracteristica" items="${caracteristicas}">
                                <tr>
                                    <td>
                                        <a href="/Projeto_Teste_Software/Controller?classe=ControllerLogicCaracteristicaAgilidade&acao=editarPopular&id=${caracteristica.id}" >
                                            <button type="button" class="btn btn-warning btn-sm btn-edit-quality-answer">
                                                <span class="glyphicon glyphicon-pencil"></span>
                                                <font>
                                                    <font>Editar</font>
                                                </font>
                                            </button>
                                        </a>
                                        <a onclick="return excluirCaracteristicaAgilidade(${caracteristica.id}); return false;" href="/Projeto_Teste_Software/Controller?classe=ControllerLogicCaracteristicaAgilidade&acao=excluir&id=${caracteristica.id}" >
                                            <button type="button" class="btn btn-danger btn-sm btn-remove-quality-answer" >
                                                <span class="glyphicon glyphicon-trash"></span>
                                                <font>
                                                    <font>Excluir</font>
                                                </font>
                                            </button>
                                        </a>    
                                    </td>
                                    <td><c:out value="${caracteristica.id}"/></td>
                                    <td><c:out value="${caracteristica.nome}"/></td>
                                    <td><c:out value="${caracteristica.descricao}"/></td>
                                    <td><c:out value="${caracteristica.pertinencia}"/></td>
                                    <td><c:out value="${caracteristica.relevancia}"/></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <div class="panel-footer">
                    </div>
                </div>
        </div>
    </body>
</html>
