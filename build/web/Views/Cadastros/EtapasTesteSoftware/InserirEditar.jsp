<%-- 
    Document   : Caracteristicas_Agilidade
    Created on : 27/06/2016, 23:09:10
    Author     : Marco Antônio
--%>

<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<jsp:useBean id="etapa" scope="request" class="Model.EtapasTesteSoftware" />

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
                <form name="fInserirEditarEtapasTesteSoftware" id="fInserirEditarEtapasTesteSoftware" onSubmit="return salvar_etapa_teste('editarPopular'); return false;" action="/Projeto_Teste_Software/Controller?classe=ControllerLogicEtapasTesteSoftware&acao=editar&id=${etapa.id}" method="POST" >
            </c:if>
            <c:if test="${acao == 'inserir' || acao == 'criar'}" >
                <form name="fInserirEditarEtapasTesteSoftware" id="fInserirEditarEtapasTesteSoftware" onSubmit="return salvar_etapa_teste('inserir'); return false;" action="/Projeto_Teste_Software/Controller?classe=ControllerLogicEtapasTesteSoftware&acao=inserir" method="POST" >
            </c:if>
            
                <fieldset>
                    <c:if test="${acao == 'editarPopular'}" >
                        <legend>Edição de Etapa de Teste de Software</legend>
                    </c:if>
                    <c:if test="${acao == 'inserir' || acao == 'criar'}" >
                        <legend>Cadastro de Etapa de Teste de Software</legend>
                    </c:if>                            
                    <fieldset class="form-group">
                        <label for="id">Identificador</label>
                        <input type="text" readonly="true" class="form-control" id="id" name="id" value="${etapa.id}">
                        <br>
                        <label for="nome">Nome da Etapa de Teste de Software</label>
                        <input type="text" class="form-control" id="nome" name="nome"  maxlength="50" placeholder="Insira o nome " value="${etapa.nome}">
                        <br>
                        <label for="descricao">Descrição Resumida da Etapa de Teste</label>
                        <textarea rows="3" class="form-control" id="descricao" name="descricao"  maxlength="1000" placeholder="Insira a descrição da etapa " >${etapa.descricao}</textarea>
                        <br>
                        <label for="produtoTrabalhoProduzido">Produto ou Trabalho Produzido na etapa</label>
                        <textarea rows="3" class="form-control" id="produtoTrabalhoProduzido" name="produtoTrabalhoProduzido"  maxlength="500" placeholder="Insira os produtos ou trabalhos produzidos nesta etapa " >${etapa.produtoTrabalhoProduzido}</textarea>
                    </fieldset>
                    <fieldset>
                        <legend>Associação Etapas de Teste de Software x Práticas Ágeis</legend>
                        <div id="dual-list-box-employees" class="form-group row">
                            <div class="col-md-5">
                                <h4>
                                    <span class="unselected-title">Práticas Ágeis Disponíveis</span> 
                                </h4>
                                <select id="listOrigem" class="unselected form-control" style="height: 200px; width: 100%;" multiple="multiple">
                                    <c:forEach var="pratica" items="${praticas}">                                        
                                        <option value="${pratica.id}" onclick="selecionar_lista_origem()" title="${pratica.descricao}" >${pratica.nome}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-md-2 center-block" style="margin-top: 80px">       
 <!--                               <button type="button" class="btn btn-default col-md-8 col-md-offset-2 atr" data-type="atr" style="margin-bottom: 10px;">
                                     <span class="glyphicon glyphicon-list"></span> 
                                     <span class="glyphicon glyphicon-chevron-right"></span>
                                </button>       -->
                                <button type="button" id="botaoAdicionar" onclick="adicionar()" class="btn btn-default col-md-8 col-md-offset-2 str" data-type="str" style="margin-bottom: 20px;" disabled="">
                                    <span class="glyphicon glyphicon-chevron-right"></span>
                                </button>       
                                <button type="button" id="botaoRemover" onclick="remover()" class="btn btn-default col-md-8 col-md-offset-2 stl" data-type="stl" style="margin-bottom: 10px;" disabled="">
                                    <span class="glyphicon glyphicon-chevron-left"></span>
                                </button>       
 <!--                               <button type="button" class="btn btn-default col-md-8 col-md-offset-2 atl" data-type="atl" style="margin-bottom: 10px;">
                                    <span class="glyphicon glyphicon-chevron-left"></span> 
                                    <span class="glyphicon glyphicon-list"></span>
                                </button>   -->
                            </div>
                            <div class="col-md-5">
                               <h4>
                                   <span class="selected-title">Práticas Ágeis Associadas</span> 
                               </h4>
                               <select id="listDestino" name="listDestino" class="selected form-control" style="height: 200px; width: 100%;" multiple="" name="">
                                    <c:forEach var="praticaAssociada" items="${praticasAssociadas}">                                        
                                        <option value="${praticaAssociada.id}" onclick="selecionar_lista_destino()" title="${praticaAssociada.descricao}" >${praticaAssociada.nome}</option>
                                    </c:forEach>
                                </select>
                               </select>
                            </div>
                        </div>
                     </fieldset>
                </fieldset>
                <button type="submit" class="btn btn-primary" >Salvar</button>  
                <button type="reset" class="btn btn-primary" onclick="window.history.go(-1);">Voltar</button>
            </form>
        </div>
    </body>
</html>