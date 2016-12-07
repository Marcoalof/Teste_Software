<%-- 
    Document   : login
    Created on : 24/04/2015, 15:12:22
    Author     : Marco Antônio
--%>

<%@ page session="false" %>
<%@ page language="java" contentType="text/html; " pageEncoding="iso-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<jsp:useBean id="dp" scope="request" class="Model.DuracaoProjeto" />

<html xmlns="http://www.w3.org/1999/xhtml" lang="pt-br" xml:lang="pt-br" >
    <head>
        <%@include file="/Views/Basicos/Head.html" %>
    </head>
    <body>
        
        <%@include file="/Views/Basicos/Modals_Padrao.html" %>
        <%@include file="/Views/Basicos/Header.html" %>
        
        <div class="cadastrosBasicos">
            
            <legend>Faixa de Duração dos Projetos</legend>
            
                <div id="duracaoProjeto" class="panel panel-default">
                    <div class="panel-heading" style>
                        <a href="ControllerRedirecionar?page=/Projeto_Teste_Software/Views/Cadastros/DuracaoProjeto/InserirEditar.jsp&acao=inserir">
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
                                <th>Peso</th>
                            </tr>
                        </thead>
                    
                        <tbody>
                            <!-- column data -->
                            <c:forEach var="dp" items="${dps}">
                                <tr>
                                    <td>
                                        <a href="/Projeto_Teste_Software/Controller?classe=ControllerLogicDuracaoProjeto&acao=editarPopular&id=${dp.id}" >
                                            <button type="button" class="btn btn-warning btn-sm btn-edit-quality-answer">
                                                <span class="glyphicon glyphicon-pencil"></span>
                                                <font>
                                                    <font>Editar</font>
                                                </font>
                                            </button>
                                        </a>
                                        <a href="/Projeto_Teste_Software/Controller?classe=ControllerLogicDuracaoProjeto&acao=excluir&id=${dp.id}" >
                                            <button type="button" class="btn btn-danger btn-sm btn-remove-quality-answer" >
                                                <span class="glyphicon glyphicon-trash"></span>
                                                <font>
                                                    <font>Excluir</font>
                                                </font>
                                            </button>
                                        </a>    
                                    </td>
                                    <td><c:out value="${dp.id}"/></td>
                                    <td><c:out value="${dp.nome}"/></td>
                                    <td><c:out value="${dp.peso}"/></td>
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
