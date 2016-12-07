<%-- 
    Document   : Caracteristicas_Agilidade
    Created on : 27/06/2016, 23:09:10
    Author     : Marco Antônio
--%>

<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<jsp:useBean id="ir" scope="request" class="Model.InstabilidadeRequisito" />

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/Views/Basicos/Head.html" %>
    </head>
    <body>
        
        <%@include file="/Views/Basicos/Modals_Padrao.html" %>
        <%@include file="/Views/Basicos/Header.html" %>
        
        <div class="cadastrosBasicosInserir">      
            <c:set var="acao" scope="request" value='<%=request.getParameter("acao")%>' />
            <c:if test="${acao == 'editarPopular'}" >
                <form name="fInserirEditarInstabilidadeRequisito" id="fInserirEditarInstabilidadeRequisito" onSubmit="return salvar_instabilidade_requisito('editarPopular'); return false;" action="/Projeto_Teste_Software/Controller?classe=ControllerLogicInstabilidadeRequisito&acao=editar&id=${ir.id}" method="POST" >
            </c:if>
            <c:if test="${acao == 'inserir'}" >
                <form name="fInserirEditarInstabilidadeRequisito" id="fInserirEditarInstabilidadeRequisito" onSubmit="return salvar_instabilidade_requisito('inserir'); return false;" action="/Projeto_Teste_Software/Controller?classe=ControllerLogicInstabilidadeRequisito&acao=inserir&id=${ir.id}" method="POST" >
            </c:if>
            
                <fieldset>
                    <c:if test="${acao == 'editarPopular'}" >
                        <legend>Edição de Indicador de Instabilidade dos Requisitos</legend>
                    </c:if>
                    <c:if test="${acao == 'inserir'}" >
                        <legend>Cadastro de Indicador de Instabilidade dos Requisitos</legend>
                    </c:if>
                            
                    <fieldset class="form-group">
                        <label for="id">Identificador</label>
                        <input type="text" readonly="true" class="form-control" id="id" name="id" value="${ir.id}">
                        <br>
                        <label for="nome">Nome Indicador de Instabilidade do Requisito</label>
                        <input type="text" class="form-control" id="nome" name="nome"  maxlength="100" placeholder="Insira o nome " value="${ir.nome}">
                        <br>
                        <label for="peso">Peso Associado</label>
                        <input type="number" class="form-control" id="peso" name="peso"  placeholder="Insira o peso associado ao indicador " value="${ir.peso}">
                        <br>
                    </fieldset>
                </fieldset>
                <button type="submit" class="btn btn-primary" >Salvar</button>  
                <button type="reset" class="btn btn-primary" onclick="window.history.go(-1);">Voltar</button>
            </form>
        </div>
    </body>
</html>
