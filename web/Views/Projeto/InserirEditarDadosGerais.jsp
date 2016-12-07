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
        
        <div class="cadastrosBasicosInserir">      
            <c:set var="acao" scope="request" value='<%=request.getParameter("acao")%>' />
            <c:set var="etapa" scope="request" value='<%=request.getParameter("etapa")%>' />
            <form name="fInserirEditarProjetoSoftware" id="fInserirEditarProjetoSoftware" onSubmit="return salvar_projeto_software(); return false;" action="/Projeto_Teste_Software/Controller?classe=ControllerLogicProjetoSoftware&acao=salvar&etapa=DB" method="POST" >
                <fieldset>
                    <c:if test="${acao == 'editarPopular'}" >
                        <legend>Edição do Dados do Projeto</legend>
                    </c:if>
                    <c:if test="${acao == 'inserir' || acao == 'criar'}" >
                        <legend>Cadastro de Novo Projeto</legend>
                    </c:if>
                    <p>Preencha abaixo as informações do projeto para dar continuidade.</p>
                    <fieldset class="form-group">
                        <legend>Dados Gerais</legend>
                        <label for="id_">Identificador</label>
                        <input type="text" readonly="true" class="form-control" id="id" name="id" value="${projetoSoftware.id}">
                        <br>
                        <label for="nome">Nome do Projeto*</label>
                        <input type="text" class="form-control" id="nome" name="nome"  maxlength="100" placeholder="Insira o nome do projeto" value="${projetoSoftware.nome}">
                        <br>
                        <label for="descricao">Descrição Sucinta*</label>
                        <textarea rows="3" class="form-control" id="descricao" name="descricao"  maxlength="1000" placeholder="Insira a descrição sucinta do projeto " >${projetoSoftware.descricao}</textarea>
                        <br>
                        <label for="status">Status</label>
                        <div class="selectContainer" style="height: auto; width: auto; max-width: 30%;">
                            <select class="form-control" name="comboStatus" readonly="true" >
                                <option value="">Escolha o Status</option>
                                <c:forEach var="statusProjeto" items="${statusProjetos}">
                                    <c:choose>
                                        <c:when test="${projetoSoftware.ic_status.nome == statusProjeto.nome}">
                                            <option value="${statusProjeto.sigla}" selected="true">${statusProjeto.nome}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${statusProjeto.sigla}">${statusProjeto.nome}</option>
                                        </c:otherwise>
                                    </c:choose>                                            
                                </c:forEach>
                            </select>
                        </div> 
                        <br>
                        <div id="datas" class="row">
                            <div class="col-sm-6">
                                <label for="dataInicioProj">Data Início do Projeto*</label>
                                <div id="dataInicioProjeto" name="dataInicioProjeto" class="input-append date">
                                    <fmt:formatDate value="${projetoSoftware.dt_inicio_projeto}" pattern="dd/MM/yyyy" var="dt_inicio_projeto" />
                                    <input type="text" id="dt_inicio_projeto" name="dt_inicio_projeto" data-format="dd/MM/yyyy" value="${dt_inicio_projeto}">
                                    <span class="add-on">
                                        <i class="glyphicon glyphicon-calendar" style="display: inline"></i>
                                    </span>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <label for="dataFimProj">Data Fim do Projeto</label>
                                <div id="dataFimProjeto" class="input-append date">
                                    <fmt:formatDate value="${projetoSoftware.dt_fim_projeto}" pattern="dd/MM/yyyy" var="dt_fim_projeto" />
                                    <input id="dt_fim_Projeto" name="dt_fim_Projeto" data-format="dd/MM/yyyy" type="text" value="${dt_fim_projeto}">
                                    <span class="add-on">
                                        <i class="glyphicon glyphicon-calendar" style="display: inline"></i>
                                    </span>
                                </div>
                            </div>
                        </div>
                        <br>
                        <label for="respCliente">Responsável do Cliente*</label>
                        <input type="text" class="form-control" id="respCliente" name="respCliente"  maxlength="200" placeholder="Responsável do cliente" value="${projetoSoftware.nome_resp_cliente}">
                        <br>
                        <label for="respDesenvolvimento">Responsável da Equipe de Desenvolvimento*</label>
                        <input type="text" class="form-control" id="respDesenvolvimento" name="respDesenvolvimento"  maxlength="200" placeholder="Responsável pelo desenvolvimento" value="${projetoSoftware.nome_resp_desenv}" style="min-width: 40%">
                        <br>
                        <label for="dataPlanejamentoAgilidade">Data de Planejamento da Agilidade no Projeto</label>
                        <div id="dataPlanejamentoAgilidade" class="input-append date">
                            <fmt:formatDate value="${projetoSoftware.dt_plan_agilidade}" pattern="dd/MM/yyyy" var="dt_plan_agilidade" />
                            <input type="text" id="dt_plan_agilidade" name="dt_plan_agilidade" data-format="dd/MM/yyyy" value="${dt_plan_agilidade}" disabled="true" readonly="true">
                            <span class=""> <!--span class="add-on"-->
                                <i class="glyphicon glyphicon-calendar" style="display: inline"></i>
                            </span>
                        </div>
                        <br>
                        <div id="datas" class="row">
                            <div class="col-sm-6">
                                <label for="nome">Data da Avaliação da Agilidade no Projeto</label>
                                <div id="dataAvaliacaoAgilidade" class="input-append date">
                                    <fmt:formatDate value="${projetoSoftware.dt_aval_agilidade}" pattern="dd/MM/yyyy" var="dt_aval_agilidade" />
                                    <input id="dt_aval_agilidade" name="dt_aval_agilidade" data-format="dd/MM/yyyy" type="text" value="${projetoSoftware.dt_aval_agilidade}" disabled="true" readonly="true">
                                    <span class=""> <!--span class="add-on"-->
                                        <i class="glyphicon glyphicon-calendar" style="display: inline"></i>
                                    </span>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <label for="resultadoAvaliacaoAgilidade">Resultado da Avaliação de Agilidade</label>
                                <div class="selectContainer" style="height: auto; width: auto; max-width: 50%;">
                                    <select class="form-control" id="resultadoAvaliacaoAgilidade" name="resultadoAvaliacaoAgilidade" readonly="true" >
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
                            </div>
                        </div>
                        <script type="text/javascript">
                            $(function() {
                                $('#dataInicioProjeto').datetimepicker({
                                    language: "pt-BR"
                                });
                                
                                $('#dataFimProjeto').datetimepicker({
                                    language: "pt-BR"
                                });
                                
                                $('#dataPlanejamentoAgilidade').datetimepicker({
                                  language: "pt-BR"
                                });
                                
                                $('#dataAvaliacaoAgilidade').datetimepicker({
                                  language: "pt-BR"
                                });
                            });
                        </script>
                        <br>
                        <br>
                        <legend>Características do Projeto</legend>
                        <label for="cicloVida">Modelo de Ciclo de Vida*</label>
                        <div class="selectContainer" style="height: auto; width: auto; max-width: 30%;">
                            <select class="form-control" id="cicloVida" name="cicloVida" >
                                <option value=""></option>
                                <c:forEach var="cicloVida" items="${ciclosVida}">
                                    <c:choose>
                                        <c:when test="${projetoSoftware.id_ciclo_vida == cicloVida.getId()}">
                                            <option value="${cicloVida.getId()}" selected="true">${cicloVida.getNome()}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${cicloVida.getId()}">${cicloVida.getNome()}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div> 
                        <br>
                        <label for="duracaoProjeto">Duração Estimada do Projeto*</label>
                        <div class="selectContainer" style="height: auto; width: auto; max-width: 30%;">
                            <select class="form-control" id="duracaoProjeto" name="duracaoProjeto" >
                                <option value=""></option>
                                <c:forEach var="duracaoProjeto" items="${duracoesProjeto}">
                                    <c:choose>
                                        <c:when test="${projetoSoftware.id_duracao_projeto == duracaoProjeto.getId()}">
                                            <option value="${duracaoProjeto.getId()}" selected="true">${duracaoProjeto.getNome()}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${duracaoProjeto.getId()}">${duracaoProjeto.getNome()}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                        <br>
                        <label for="complexidadeProblema">Indicador de Complexidade do Problema*</label>
                        <div class="selectContainer" style="height: auto; width: auto; max-width: 30%;">
                            <select class="form-control" id="complexidadeProblema" name="complexidadeProblema" >
                                <option value=""></option>
                                <c:forEach var="complexidadeProblema" items="${complexidadeProblemas}">
                                    <c:choose>
                                        <c:when test="${projetoSoftware.id_complexidade_problema == complexidadeProblema.getId()}">
                                            <option value="${complexidadeProblema.getId()}" selected="true">${complexidadeProblema.getNome()}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${complexidadeProblema.getId()}">${complexidadeProblema.getNome()}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                        <br>
                        <label for="instabilidadeRequisito">Indicador de Estabilidade dos Requisitos*</label>
                        <div class="selectContainer" style="height: auto; width: auto; max-width: 30%;">
                            <select class="form-control" id="instabilidadeRequisito" name="instabilidadeRequisito" >
                                <option value=""></option>
                                <c:forEach var="instabilidadeRequisito" items="${instabilidadeRequisitos}">
                                    <c:choose>
                                        <c:when test="${projetoSoftware.id_instabilidade_requisitos == instabilidadeRequisito.getId()}">
                                            <option value="${instabilidadeRequisito.getId()}" selected="true">${instabilidadeRequisito.getNome()}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${instabilidadeRequisito.getId()}">${instabilidadeRequisito.getNome()}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                        <br>
                        <label for="tamanhoEquipe">Tamanho da Equipe do Projeto*</label>
                        <div class="selectContainer" style="height: auto; width: auto; max-width: 30%;">
                            <select class="form-control" id="tamanhoEquipe" name="tamanhoEquipe" >
                                <option value=""></option>
                                <c:forEach var="tamanhoEquipe" items="${tamanhoEquipes}">
                                    <c:choose>
                                        <c:when test="${projetoSoftware.id_tamanho_equipe == tamanhoEquipe.getId()}">
                                            <option value="${tamanhoEquipe.getId()}" selected="true">${tamanhoEquipe.getNome()}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${tamanhoEquipe.getId()}">${tamanhoEquipe.getNome()}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                        <br>
                        <label for="criticidadeProjeto">Criticidade do Projeto*</label>
                        <div class="selectContainer" style="height: auto; width: auto; max-width: 30%;">
                            <select class="form-control" id="criticidadeProjeto" name="criticidadeProjeto" >
                                <option value=""></option>
                                <c:forEach var="criticidadeProjeto" items="${criticidadeProjetos}">
                                    <c:choose>
                                        <c:when test="${projetoSoftware.id_criticidade_projeto == criticidadeProjeto.getId()}">
                                            <option value="${criticidadeProjeto.getId()}" selected="true">${criticidadeProjeto.getNome()}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${criticidadeProjeto.getId()}">${criticidadeProjeto.getNome()}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                        <br>
                        <label for="ambienteFisico">Ambiente Físico*</label>
                        <div class="selectContainer" style="height: auto; width: auto; max-width: 30%;">
                            <select class="form-control" id="ambienteFisico" name="ambienteFisico" >
                                <option value=""></option>
                                <c:forEach var="ambienteFisico" items="${ambientesFisico}">
                                    <c:choose>
                                        <c:when test="${projetoSoftware.ic_ambiente_fisico.nome == ambienteFisico.nome}">
                                            <option value="${ambienteFisico.sigla}" selected="true">${ambienteFisico.nome}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${ambienteFisico.sigla}">${ambienteFisico.nome}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                        <br>
                        <label for="plataformaExecucao">Plataforma de Execução*</label>
                        <div class="selectContainer" style="height: auto; width: auto; max-width: 30%;">
                            <select class="form-control" id="plataformaExecucao" name="plataformaExecucao" >
                                 <option value=""></option>
                                <c:forEach var="plataformaExecucao" items="${plataformaExecucoes}">
                                    <c:choose>
                                        <c:when test="${projetoSoftware.id_plataforma_execucao == plataformaExecucao.getId()}">
                                            <option value="${plataformaExecucao.getId()}" selected="true">${plataformaExecucao.getNome()}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${plataformaExecucao.getId()}">${plataformaExecucao.getNome()}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                        <br>
                        <label for="dominioAplicacao">Domínio da Aplicação*</label>
                        <div class="selectContainer" style="height: auto; width: auto; max-width: 30%;">
                            <select class="form-control" id="dominioAplicacao" name="dominioAplicacao" >
                                 <option value=""></option>
                                <c:forEach var="dominioAplicacao" items="${dominioAplicacoes}">
                                    <c:choose>
                                        <c:when test="${projetoSoftware.id_dominio_aplicacao == dominioAplicacao.getId()}">
                                            <option value="${dominioAplicacao.getId()}" selected="true">${dominioAplicacao.getNome()}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${dominioAplicacao.getId()}">${dominioAplicacao.getNome()}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                    </fieldset>
                </fieldset>
                <a href="/Projeto_Teste_Software/Controller?classe=ControllerLogicProjetoSoftware&acao=listar" >
                    <button type="button" id="btnProximo" class="btn btn-primary" >
                        <font>
                            <font>Voltar</font>
                        </font>
                    </button>
                </a>
                <button type="reset" id="btnCancelar" class="btn btn-primary" >Cancelar</button>
                <button type="submit" id="btnSalvar" class="btn btn-primary" >Salvar</button>  
                <a onclick="return proxima_etapa(); return false;" href="/Projeto_Teste_Software/Controller?classe=ControllerLogicProjetoSoftware&acao=editarPopular&id=${projetoSoftware.id}&etapa=APAA" >
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
