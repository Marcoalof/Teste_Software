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
<jsp:useBean id="praticasAgeisDAO" scope="request" class="Persistence.PraticasAgeisDAO" />

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/Views/Basicos/Head.html" %>
    </head>
    <body>
        
        <%@include file="/Views/Basicos/Modals_Padrao.html" %>
        <%@include file="/Views/Basicos/Header.html" %>
        
        <input type="hidden" id="erro" value="<%=request.getAttribute("errosEncerrarAvaliacaoEficacia")%>" />
        <div class="cadastrosBasicos">
            <form name="fEscolhaCaracteristicasAgilidade" id="fEscolhaCaracteristicasAgilidade" onSubmit="return salvar_avaliacao_eficacia(); return false;" action="/Projeto_Teste_Software/Controller?classe=ControllerLogicProjetoSoftware&acao=encerrarAvaliacao&id=${projetoSoftware.id}&etapa=AE" method="POST" >
            <legend>Avaliação de Eficácia</legend>
                <p>Responda as perguntas abaixo avaliando a eficácia das atividades desempenhadas durante o teste de software.</p>
                <label for="id_">Identificador do Projeto</label>
                <input type="text" readonly="true" class="form-control" id="id" name="id" value="${projetoSoftware.id}" style="height: auto; width: auto; max-height: 30%;">
                <c:forEach var="avaliacaoEficacia" items="${listaAvaliacaoEficacia}">
                    <label for="id_pratica">Prática Ágil</label>
                    <input type="text" readonly="true" class="form-control" id="pratica" name="pratica" value="${praticasAgeisDAO.buscar(avaliacaoEficacia.id_pratica_agil).nome}" style="height: auto; width: auto; min-height: 40%; max-height: 50%;">
                    <label>Qual o grau em que a prática foi adotada e seguida pela equipe?</label>
                    <div class="selectContainer" style="height: auto; width: auto; max-width: 30%;">
                        <select class="form-control" name="comboQ1${avaliacaoEficacia.id_pratica_agil}">
                            <option value="">Escolha o Grau</option>
                            <c:forEach var="valorAvaliacaoEficacia" items="${valoresAvaliacaoEficacia}">
                                <c:choose>
                                    <c:when test="${avaliacaoEficacia.ic_grau_pratica_adotado.sigla == valorAvaliacaoEficacia.sigla}">
                                        <option value="${valorAvaliacaoEficacia.sigla}" selected="true">${valorAvaliacaoEficacia.nome}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${valorAvaliacaoEficacia.sigla}">${valorAvaliacaoEficacia.nome}</option>
                                    </c:otherwise>
                                </c:choose>                                            
                            </c:forEach>
                        </select>
                    </div>
                    <br>
                    <label>Qual o nível de contribuição para o sucesso das atividades de teste?</label>
                    <div class="selectContainer" style="height: auto; width: auto; max-width: 30%;">
                        <select class="form-control" name="comboQ2${avaliacaoEficacia.id_pratica_agil}">
                            <option value="">Escolha o Nível</option>
                            <c:forEach var="valorAvaliacaoEficacia" items="${valoresAvaliacaoEficacia}">
                                <c:choose>
                                    <c:when test="${avaliacaoEficacia.ic_nivel_contribuicao.sigla == valorAvaliacaoEficacia.sigla}">
                                        <option value="${valorAvaliacaoEficacia.sigla}" selected="true">${valorAvaliacaoEficacia.nome}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${valorAvaliacaoEficacia.sigla}">${valorAvaliacaoEficacia.nome}</option>
                                    </c:otherwise>
                                </c:choose>                                            
                            </c:forEach>
                        </select>
                    </div>
                    <label>Observação</label>
                    <textarea rows="3" class="form-control" id="observacaoPratica${avaliacaoEficacia.id_pratica_agil}" name="observacaoPratica${avaliacaoEficacia.id_pratica_agil}"  maxlength="500" placeholder="Insira a observação quanto à prática " >${avaliacaoEficacia.dc_observacao}</textarea>
                    </c:forEach>
                    <br>
                    <label>Quanto ao processo como um todo, como você avalia o resultado das práticas para o processo de testes?</label>
                    <div class="selectContainer" style="height: auto; width: auto; max-width: 30%;">
                        <select class="form-control" name="comboProjeto${projetoSoftware.id}">
                            <option value="">Escolha o Resultado</option>
                            <c:forEach var="resultadoPratica" items="${resultadosPraticas}">
                                <c:choose>
                                    <c:when test="${projetoSoftware.ic_resultado_praticas.sigla == resultadoPratica.sigla}">
                                        <option value="${resultadoPratica.sigla}" selected="true">${resultadoPratica.nome}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${resultadoPratica.sigla}">${resultadoPratica.nome}</option>
                                    </c:otherwise>
                                </c:choose>                                            
                            </c:forEach>
                        </select>
                    </div>
                    <br>
                    <label for="resultadoAvaliacaoAgilidade">Resultado da Avaliação de Agilidade</label>
                    <div class="selectContainer" style="height: auto; width: auto; max-width: 50%;">
                        <select class="form-control" id="resultadoAvaliacaoAgilidadeProjeto${projetoSoftware.id}" name="resultadoAvaliacaoAgilidadeProjeto${projetoSoftware.id}" >
                            <option value="">Não avaliado</option>
                            <c:forEach var="resultadoAvaliacao" items="${resultadoAvaliacoes}">
                                <c:choose>
                                    <c:when test="${projetoSoftware.ic_resultado_aval.nome == resultadoAvaliacao.nome}">
                                        <option value="${resultadoAvaliacao.sigla}" selected="true">${resultadoAvaliacao.nome}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${resultadoAvaliacao.sigla}">${resultadoAvaliacao.nome}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                    <br>
                    <label>Observações</label>
                    <textarea rows="4" class="form-control" id="observacaoProjeto${projetoSoftware.id}" name="observacaoProjeto${projetoSoftware.id}"  maxlength="1000" placeholder="Insira a observação quanto à prática " >${projetoSoftware.dc_observacao}</textarea>
                    <br>
                <a href="/Projeto_Teste_Software/Controller?classe=ControllerLogicProjetoSoftware&acao=editarPopular&id=${projetoSoftware.id}&etapa=PAXET" >
                    <button type="button" id="btnProximo" class="btn btn-primary" >
                        <font>
                            <font>Voltar</font>
                        </font>
                    </button>
                </a>
                <button type="reset" id="btnCancelar" class="btn btn-primary" >Cancelar</button>
                <button type="submit" id="btnSalvar" onSubmit="return salvar_avaliacao_eficacia(); return false;" class="btn btn-primary" >Encerrar Avaliação</button>
                <!--a href="/Projeto_Teste_Software/Controller?classe=ControllerLogicProjetoSoftware&acao=editarPopular&id=${projetoSoftware.id}&etapa=PAXET" >
                    <button type="button" id="btnProximo" class="btn btn-primary" >
                        <font>
                            <font>Ir para Avaliação do Projeto</font>
                        </font>
                    </button>
                </a-->
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
        
        $(document).ready(function() 
        { 
            var msg = document.getElementById("erro").value.toString();            
            if(msg == "null")
            {
            }
            else if(msg != "")
            {
                var modalAlerta = "Alert";
                var title = "Não é possível concluir a ação";
                executaModal(modalAlerta, title, msg);
            }
            else
            {
                var modalSucesso = "Sucesso";
                var title = "Projeto salvo com sucesso";
                msg = "O projeto foi encerrado com sucesso."
                executaModal(modalSucesso, title, msg);
            }
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
