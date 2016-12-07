<%-- 
    Document   : login
    Created on : 24/04/2015, 15:12:22
    Author     : Marco Antônio
--%>

<%@ page session="false" %>
<%@ page language="java" contentType="text/html; " pageEncoding="iso-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="ps" scope="request" class="Model.ProjetoSoftware" />

<html xmlns="http://www.w3.org/1999/xhtml" lang="pt-br" xml:lang="pt-br">
    <head>
        <%@include file="/Views/Basicos/Head.html" %>
    </head>
    <body>
        
        <%@include file="/Views/Basicos/Modals_Padrao.html" %>
        <%@include file="/Views/Basicos/Header.html" %>
        
        <div class="cadastrosBasicos">
            
            <legend>Projetos de Software</legend>
            
                <div id="projetosSoftware" class="panel panel-default">
                    <div class="panel-heading" style>
                        <a href="/Projeto_Teste_Software/Controller?classe=ControllerLogicProjetoSoftware&acao=criar&etapa=DB">
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
                                <th>Status</th>
                                <th>Data Início</th>
                                <th>Cliente</th>
                                <th>Responsável Equipe Desenvolvimento</th>
                                <th>Etapa Atual</th>
                            </tr>
                        </thead>
                    
                        <tbody>
                            <!-- column data -->
                            <c:forEach var="projeto" items="${projetos}">
                                <tr>
                                    <td>
                                        <a href="/Projeto_Teste_Software/Controller?classe=ControllerLogicProjetoSoftware&acao=editarPopular&id=${projeto.id}&etapa=${projeto.ic_etapa_atual.getSigla()}" >
                                            <button type="button" class="btn btn-warning btn-sm btn-edit-quality-answer">
                                                <span class="glyphicon glyphicon-pencil"></span>
                                                <font>
                                                    <font>Editar</font>
                                                </font>
                                            </button>
                                        </a>
                                        <a href="/Projeto_Teste_Software/Controller?classe=ControllerLogicProjetoSoftware&acao=excluir&id=${projeto.id}" >
                                            <button type="button" class="btn btn-danger btn-sm btn-remove-quality-answer" >
                                                <span class="glyphicon glyphicon-trash"></span>
                                                <font>
                                                    <font>Excluir</font>
                                                </font>
                                            </button>
                                        </a>    
                                    </td>
                                    <td><c:out value="${projeto.id}"/></td>
                                    <td><c:out value="${projeto.nome}"/></td>
                                    <td><c:out value="${projeto.descricao}"/></td>
                                    <td><c:out value="${projeto.ic_status.getNome()}"/></td>
                                    <fmt:formatDate value="${projeto.dt_inicio_projeto}" pattern="dd/MM/yyyy" var="dt_inicio_projeto" />
                                    <td><c:out value="${dt_inicio_projeto}"/></td>
                                    <td><c:out value="${projeto.nome_resp_cliente}"/></td>
                                    <td><c:out value="${projeto.nome_resp_desenv}"/></td>
                                    <td><c:out value="${projeto.ic_etapa_atual.nome}"/></td>
                            </c:forEach>
                        </tbody>
                    </table>
                    <div class="panel-footer">
                    </div>
                </div>
        </div>
    </body>
</html>
