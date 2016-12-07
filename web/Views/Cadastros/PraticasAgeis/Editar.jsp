<%-- 
    Document   : Caracteristicas_Agilidade
    Created on : 27/06/2016, 23:09:10
    Author     : Marco Antônio
--%>

<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<jsp:useBean id="pratica" scope="request" class="Model.PraticasAgeis" />

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/Views/Basicos/Head.html" %>
    </head>
    <body>
        
        <%@include file="/Views/Basicos/Modals_Padrao.html" %>
        <%@include file="/Views/Basicos/Header.html" %>
        
        <div class="cadastrosBasicosInserir">
            <form name="fEditarPraticaAgil" onSubmit="return salvar_Pratica()" action="/Projeto_Teste_Software/Controller?classe=ControllerLogicPraticasAgeis&acao=editar&id=${pratica.id}" method="POST" >
                <fieldset>
                    <legend>Edição de Práticas Ágeis</legend>
                    <fieldset class="form-group">
                        <label for="id">Identificador</label>
                        <input type="text" readonly="true" class="form-control" id="id" name="id" value="${pratica.id}">
                        <br>
                        <label for="nome">Nome Prática</label>
                        <input type="text" class="form-control" id="nome" name="nome"  maxlength="50" placeholder="Insira o nome " value="${pratica.nome}">
                        <br>
                        <label for="descricao">Descrição da Prática</label>
                        <textarea rows="3" class="form-control" id="descricao" name="descricao"  maxlength="1000" placeholder="Insira a descrição da prática " >${pratica.descricao}</textarea>
                        <br>
                        <label for="nome">Pertinência (%)</label>
                        <input type="number" min="0" max="100" step="any" class="form-control" id="pertinencia" name="pertinencia" placeholder="Insira o valor da Pertinência " value="${pratica.pertinencia}">
                        <p>Informe apenas números. Ex.: 54,23</p>
                        <label for="nome">Relevância (%)</label>
                        <input type="number" min="0" max="100" step="any" class="form-control" id="relevancia" name="relevancia" placeholder="Insira o valor da Relevância " value="${pratica.relevancia}" >
                        <p>Informe apenas números. Ex.: 54,23</p>
                    </fieldset>
                    <fieldset>
                        <legend>Associação Práticas Ágeis x Características de Agilidade</legend>
                        <div id="dual-list-box-employees" class="form-group row">
                            <div class="col-md-5">
                                <h4>
                                    <span class="unselected-title">Características Disponíveis</span> 
                                </h4>
                                <select id="listOrigem" class="unselected form-control" style="height: 200px; width: 100%;" multiple="multiple">
                                    <c:forEach var="caracteristica" items="${caracteristicas}">                                        
                                        <option value="${caracteristica.id}" onclick="selecionar_lista_origem()" title="${caracteristica.descricao}" >${caracteristica.nome}</option>
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
                                   <span class="selected-title">Características Associadas</span> 
                               </h4>
                               <select id="listDestino" name="listDestino" class="selected form-control" style="height: 200px; width: 100%;" multiple="" name="">
                                    <c:forEach var="cacateristicaAssociada" items="${cacateristicasAssociadas}">                                        
                                        <option value="${cacateristicaAssociada.id}" onclick="selecionar_lista_destino()" title="${cacateristicaAssociada.descricao}" >${cacateristicaAssociada.nome}</option>
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
