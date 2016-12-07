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
            
            <legend>Adequação do Projeto às Abordagens Ágeis</legend>
                <p>Segue abaixo o Grau de Adequação do Projeto às Aboragens Ágeis, calculado a partir das características do projeto informadas até o momento.</p>
                <p>Agora você deve optar, por continuar ou não com a utilização das características de agilidade.</p>
                <div id="projetosSoftware" class="panel panel-default">
                    <div class="panel-footer">
                    </div>
                    <table class="table" id="tbl-quality-answers">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Parâmetro</th>
                                <th>Valor Informado</th>
                                <th>Valor Máximo</th>
                                <th>Valor Atribuído</th>
                            </tr>
                        </thead>
                    
                        <tbody>
                        <% String[][] parametros = (String[][]) request.getAttribute("listaParametros"); %>
                        <% for (int i=0; i < 7 - 1; i++) //Última linha será montada na mão
                        {
                        %>
                            <tr>
                        <%
                            for (int j=0; j < 5; j++)
                            {
                        %>
                                <% if(i >= 5)
                                {

                                %>
                                    <td style="font-weight: bold"><%out.print(parametros[i][j]); %></td>
                                <%
                                }  
                                else
                                {
                                %>
                                    <td><%out.print(parametros[i][j]); %></td>
                        <%      }    
                            }
                        %>
                            </tr>
                        <%
                        }
                        %>
                            <tr>
                                <td style="font-weight: bold"><%out.print(parametros[6][0]); %></td>
                                <td colspan="3" style="font-weight: bold"><%out.print(parametros[6][1]); %></td>
                                <td style="font-weight: bold"><%out.print(parametros[6][4]); %>%</td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="panel-footer">
                    </div>
                    <fieldset>
                        <c:set var="percentualAdequacao" scope="request" value='<%= Double.parseDouble(parametros[6][4].replace(",", ".")) %>' />
                        <c:if test="${percentualAdequacao >= 50.00}" >
                            <legend style="color: #34af23">Resultado: Projeto adequado para utilização de abordagens ágeis. Indicada a continuidade no processo.</legend>
                        </c:if>
                        <c:if test="${percentualAdequacao < 50.00}" >
                            <legend style="color: #FF0404">Resultado: Projeto não adequado para utilização de abordagens ágeis. Não é indicada a continuidade no processo devido ao Grau de Adequação estar menor que 50%.</legend>
                        </c:if>
                    </fieldset>
                </div>
                <a href="/Projeto_Teste_Software/Controller?classe=ControllerLogicProjetoSoftware&acao=editarPopular&id=${projetoSoftware.id}&etapa=DB" >
                    <button type="button" id="btnProximo" class="btn btn-primary" >
                        <font>
                            <font>Voltar</font>
                        </font>
                    </button>
                </a>
                <button type="reset" id="btnCancelar" class="btn btn-primary" >Cancelar</button>
                <!--button type="submit" id="btnSalvar" class="btn btn-primary" >Salvar</button-->
                <a href="/Projeto_Teste_Software/Controller?classe=ControllerLogicProjetoSoftware&acao=editarPopular&id=${projetoSoftware.id}&etapa=ECA" >
                    <button type="button" id="btnProximo" class="btn btn-primary" >
                        <font>
                            <font>Próximo</font>
                        </font>
                    </button>
                </a>
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
