<%-- 
    Document   : Caracteristicas_Agilidade
    Created on : 27/06/2016, 23:09:10
    Author     : Marco Antônio
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<jsp:useBean id="cicloVida" scope="request" class="Model.CicloVida" />
<jsp:useBean id="duracaoProjeto" scope="request" class="Model.DuracaoProjeto" />
<jsp:useBean id="complexidadeProblema" scope="request" class="Model.ComplexidadeProblema" />
<jsp:useBean id="instabilidadeRequisito" scope="request" class="Model.InstabilidadeRequisito" />
<jsp:useBean id="tamanhoEquipe" scope="request" class="Model.TamanhoEquipe" />
<jsp:useBean id="criticidadeProjeto" scope="request" class="Model.CriticidadeProjeto" />
<jsp:useBean id="plataformaExecucao" scope="request" class="Model.PlataformaExecucao" />
<jsp:useBean id="dominioAplicacao" scope="request" class="Model.DominioAplicacao" />
<jsp:useBean id="projetoSoftware" scope="request" class="Model.ProjetoSoftware" />

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/Views/Basicos/Head.html" %>
    </head>
    <body>
        
        <%@include file="/Views/Basicos/Modals_Padrao.html" %>
        <%@include file="/Views/Basicos/Header.html" %>
        
        <div class="cadastrosBasicosInserir">
            <form name="fEscolhaCaracteristicasAgilidade" id="fEscolhaCaracteristicasAgilidade" onSubmit="return salvar_escolha_caracteristicas_agilidade(); return false;" action="/Projeto_Teste_Software/Controller?classe=ControllerLogicProjetoSoftware&acao=salvar&id=${projetoSoftware.id}&etapa=ECA" method="POST" >
                <fieldset>
                    <legend>Etapa de Escolha das Características de Agilidade</legend>
                    <p>Nesta etapa, você deve escolher as características de agilidade para o processo de Teste de Software. </p>
                    <p>Após a escolha, e confirmação, serão exibidas as Práticas Ágeis associadas e o grau de agilidade estimado para cada uma.</p>
                    <fieldset>
                        <legend>Lista de Características de Agilidade</legend>
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
                                   <span class="selected-title">Características Selecionadas</span> 
                               </h4>
                               <select id="listDestino" name="listDestino" class="selected form-control" style="height: 200px; width: 100%;" multiple="" name="">
                                    <c:forEach var="caracteristicaAssociada" items="${caracteristicasAssociadas}">
                                        <option value="${caracteristicaAssociada.id}" onclick="selecionar_lista_destino()" title="${caracteristicaAssociada.descricao}" >${caracteristicaAssociada.nome}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                     </fieldset>
                </fieldset>
                
                <% 
                    ArrayList<String[][]> parametros = (ArrayList<String[][]>) request.getAttribute("praticasAssociadas");
                    if(parametros != null)
                    {
                %>
                
                    <legend>Lista de Práticas Associadas às Características Selecionadas</legend>
                        <div id="projetosSoftware" class="panel panel-default">
                            <div class="panel-footer">
                            </div>
                            <table class="table" id="tbl-quality-answers">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Característica</th>
                                        <th>ID</th>
                                        <th>Prática</th>
                                        <th>Grau de Agilidade em Potencial da Prática</th>
                                    </tr>
                                </thead>

                                <tbody>
                                <% 
                                    for (int i=0; i < parametros.size(); i++)
                                    {
                                %>
                                        <tr>
                                            <% 
                                                for(int j = 0; j < 5; j++)
                                                {
                                            %>
                                                    <td><%out.print(parametros.get(i)[0][j]); %></td>
                                            <% 
                                                }
                                            %>        
                                        </tr>
                                    <%
                                    }
                                    %>
                                    </tbody>
                                </table>
                            <div class="panel-footer">
                            </div>
                        </div>
                
                <% 
                    }
                %>
                <a href="/Projeto_Teste_Software/Controller?classe=ControllerLogicProjetoSoftware&acao=editarPopular&id=${projetoSoftware.id}&etapa=APAA" >
                    <button type="button" id="btnProximo" class="btn btn-primary" >
                        <font>
                            <font>Voltar</font>
                        </font>
                    </button>
                </a>
                <button type="reset" id="btnCancelar" class="btn btn-primary" >Cancelar</button>
                <button type="submit" id="btnSalvar" class="btn btn-primary" >Salvar</button>
                <a onclick="return proxima_etapa_ECA(); return false;" href="/Projeto_Teste_Software/Controller?classe=ControllerLogicProjetoSoftware&acao=editarPopular&id=${projetoSoftware.id}&etapa=PAXET" >
                    <button type="button" id="btnProximo" class="btn btn-primary" >
                        <font>
                            <font>Próximo</font>
                        </font>
                    </button>
                </a>
            </form>
        </div>
    </body>
    <script>
        $('#btnCancelar').click(function(){
            var title = ""; 
            var retorno = "true";
            var msg = "";

            title = "Cancelamento da Operação";
            msg = "<h4> Tem certeza que deseja cancelar a operação? Esta ação não irá salvar as informações. </h4>";

            var modalConfirmacao = $('#myModalConfirmacao');
            modalConfirmacao.find('#myModalLabelConfirmacao').html("Atenção: " + title);
            modalConfirmacao.find('#myModalBodyConfirmacao').html(msg);
            modalConfirmacao.find('#idmodalButtonSucess').hide("slow");
            modalConfirmacao.modal();
        });
        
        $('#idmodalButtonDefault').click(function()
        {
            $('#myModalConfirmacao').hide();
        });

        $('#idmodalButtonPrimary').click(function()
        {
            //var acao = "cancelar";
            var page = "/Projeto_Teste_Software/Views/Menu/Menu.jsp";
            var url = url = '../../ControllerRedirecionar';
            var title = "";
            var msg = "";
            var modalErro = "Erro";
            window.location.href = "/Projeto_Teste_Software/Controller?classe=ControllerLogicProjetoSoftware&acao=listar";
        });
    </script>
</html>
