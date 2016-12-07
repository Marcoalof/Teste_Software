<%-- 
    Document   : Caracteristicas_Agilidade
    Created on : 27/06/2016, 23:09:10
    Author     : Marco Antônio
--%>

<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
        
        <div class="cadastrosBasicos">
            <form name="fEscolhaCaracteristicasAgilidade" id="fEscolhaCaracteristicasAgilidade" onSubmit="return salvar_escolha_caracteristicas_agilidade(); return false;" action="/Projeto_Teste_Software/Controller?classe=ControllerLogicProjetoSoftware&acao=salvar&id=${projetoSoftware.id}&etapa=PAXET" method="POST" >
            <legend>Relação Práticas Ágeis x Etapas de Teste de Software</legend>
                <p>Abaixo estão listadas as práticas e cada etapa do teste aonde as mesmas devem ser aplicadas durante a execução do projeto.</p>
                <p>Fique bastante atendo a cada uma das tarefas e a forma como deve ser executada.</p>
                <div id="projetosSoftware" class="panel panel-default">
                    <div class="panel-footer">
                    </div>
                    <table class="table" id="tbl-quality-answers">
                        <% 
                            String[][] parametros = (String[][]) request.getAttribute("etapasTeste");
                            int linhas = Integer.parseInt((String) request.getAttribute("linhas").toString());
                            int colunas = Integer.parseInt((String) request.getAttribute("colunas").toString());
                        for (int i=0; i < linhas; i++)
                        {
                            if(i == 0)
                            {
                        %>
                                <thead>
                                    <tr>
                                        <% for (int j=0; j < colunas; j++)
                                        {
                                        %>
                                            <th><%out.print(parametros[i][j]); %></th>
                                        <%
                                        }
                                        %>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                            <%
                            }
                            else
                            {
                                for (int j=0; j < colunas; j++)
                                {
                                    if(j == 0) //Está na primeira coluna, então vêm em negrito
                                    {
                            %>
                                        <td style="font-weight: bold"><%out.print(parametros[i][j]); %></td>
                            <%
                                    }
                                    else //Está nas demais colunas que não a primeira
                                    {
                            %>
                                        <td><%out.print(parametros[i][j]); %></td>
                            <%
                                    }
                                }
                            }
                        }
                        %>
                                    </tr>
                                </tbody>
                    </table>
                    <div class="panel-footer">
                    </div>
                </div>
                <a href="/Projeto_Teste_Software/Controller?classe=ControllerLogicProjetoSoftware&acao=editarPopular&id=${projetoSoftware.id}&etapa=ECA" >
                    <button type="button" id="btnProximo" class="btn btn-primary" >
                        <font>
                            <font>Voltar</font>
                        </font>
                    </button>
                </a>
                <button type="reset" id="btnCancelar" class="btn btn-primary" >Cancelar</button>
                <button type="submit" id="btnSalvar" class="btn btn-primary" >Salvar</button>
                <a href="/Projeto_Teste_Software/Controller?classe=ControllerLogicProjetoSoftware&acao=editarPopular&id=${projetoSoftware.id}&etapa=AE" >
                    <button type="button" id="btnProximo" class="btn btn-primary" >
                        <font>
                            <font>Ir para Avaliação do Projeto</font>
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
