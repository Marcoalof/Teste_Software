/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function salvar_projeto_software()
{    
    var title = ""; 
    var msg = "";
    var modalAlerta = "Alert";
    var retorno = "true";
    
    //comboCidades.options[comboCidades.selectedIndex].text);
    //console.log("A chave �: " + comboCidades.options[comboCidades.selectedIndex].value
    //var comboStatus = document.getElementByName("comboStatus");
    var comboCicloVida = document.getElementById("cicloVida");
    var comboDuracaoProjeto = document.getElementById("duracaoProjeto");
    var comboComplexidadeProblema = document.getElementById("complexidadeProblema");
    var comboInstabilidadeRequisito = document.getElementById("instabilidadeRequisito");
    var comboTamanhoEquipe = document.getElementById("tamanhoEquipe");
    var comboCriticidadeProjeto = document.getElementById("criticidadeProjeto");
    var comboAmbienteFisico = document.getElementById("ambienteFisico");
    var comboPlataformaExecucao = document.getElementById("plataformaExecucao");
    var comboDominioAplicacao = document.getElementById("dominioAplicacao");
    if(document.getElementById("nome").value.length == 0 ||
       document.getElementById("descricao").value.length == 0 ||
       document.getElementById("dt_inicio_projeto").value.length == 0 ||
       document.getElementById("respCliente").value.length == 0 ||
       document.getElementById("respDesenvolvimento").value.length == 0 ||
       comboDuracaoProjeto.selectedIndex == 0 ||
       comboComplexidadeProblema.selectedIndex == 0 ||
       comboInstabilidadeRequisito.selectedIndex == 0 ||
       comboTamanhoEquipe.selectedIndex == 0 ||
       comboCriticidadeProjeto.selectedIndex == 0 ||
       comboAmbienteFisico.selectedIndex == 0 ||
       comboPlataformaExecucao.selectedIndex == 0 ||
       comboDominioAplicacao.selectedIndex == 0
      )
    {
        title = "N�o foi poss�vel realizar o cadastro";
        msg = "<h4> Os campos abaixo s�o de preenchimento obrigat�rio: </h4> <ol type='1' >";
        
        if(document.getElementById("nome").value.length == 0)
        {
            msg = msg + "\n" + " <li> Campo Nome do Projeto � obrigat�rio; </li> ";
        }
        
        if(document.getElementById("descricao").value.length == 0)
        {
            msg = msg + "\n" + " <li> Campo Descri��o Resumida do Projeto � obrigat�rio; </li> ";
        }
        
        /* //Passou a ser preenchido automaticamente pelo sistema
        if(comboStatus.selectedIndex == 0)
        {
            msg = msg + "\n" + " <li> Campo Status do Projeto � obrigat�rio; </li> ";
        }
        */

        if(document.getElementById("dt_inicio_projeto").value.length == 0)
        {
            msg = msg + "\n" + " <li> Campo Data In�cio Projeto � obrigat�rio; </li> ";
        }
        
        if(document.getElementById("respCliente").value.length == 0)
        {
            msg = msg + "\n" + " <li> Campo Respons�vel do Cliente pelo Projeto � obrigat�rio; </li> ";
        }
        
        if(document.getElementById("respDesenvolvimento").value.length == 0)
        {
            msg = msg + "\n" + " <li> Campo Respons�vel pela Equipe de Desenvolvimento do Projeto � obrigat�rio; </li> ";
        }
        
        if(comboCicloVida.selectedIndex == 0)
        {
            msg = msg + "\n" + " <li> Campo Ciclo de Vida do Projeto � obrigat�rio; </li> ";
        }
        
        if(comboDuracaoProjeto.selectedIndex == 0)
        {
            msg = msg + "\n" + " <li> Campo Dura��o do Projeto � obrigat�rio; </li> ";
        }
        
        if(comboComplexidadeProblema.selectedIndex == 0)
        {
            msg = msg + "\n" + " <li> Campo Indicador de Complexidade do Projeto � obrigat�rio; </li> ";
        }
        
        if(comboInstabilidadeRequisito.selectedIndex == 0)
        {
            msg = msg + "\n" + " <li> Campo Indicador de Estabilidade dos Requisitos do Projeto � obrigat�rio; </li> ";
        }
        
        if(comboTamanhoEquipe.selectedIndex == 0)
        {
            msg = msg + "\n" + " <li> Campo Tamanho da Equipe do Projeto � obrigat�rio; </li> ";
        }
        
        if(comboCriticidadeProjeto.selectedIndex == 0)
        {
            msg = msg + "\n" + " <li> Campo Criticidade do Projeto � obrigat�rio; </li> ";
        }

        if(comboAmbienteFisico.selectedIndex == 0)
        {
            msg = msg + "\n" + " <li> Campo Ambiente F�sico do Projeto � obrigat�rio; </li> ";
        }
        
        if(comboPlataformaExecucao.selectedIndex == 0)
        {
            msg = msg + "\n" + " <li> Campo Plataforma de Execu��o do Projeto � obrigat�rio; </li> ";
        }
        
        if(comboDominioAplicacao.selectedIndex == 0)
        {
            msg = msg + "\n" + " <li> Campo Plataforma de Execu��o do Projeto � obrigat�rio; </li> ";
        }
        
        msg = msg + "</ol>"
        document.getElementById("nome").focus();
        executaModal(modalAlerta, title, msg);
        retorno = "false";
    }
    if(retorno == "true")
    {
        return true;
    }
    else
    {
        return false;
    }
}

function proxima_etapa()
{
    var retorno = salvar_projeto_software();
    if(retorno == false)
    {
        return false;
    }
    else
    {
        var modalAlerta = "Alert";
        var title = "N�o � poss�vel realizar a a��o";
        var msg = "<h4> Antes de Avan�ar a pr�xima etapa � necess�rio Salvar a atual </h4>";
        if(document.getElementById("id").value == 0)
        {
            executaModal(modalAlerta, title, msg);
            return false;
        }
        else
        {
            return true;
        }
    }
}

function proxima_etapa_ECA()
{
    var retorno = salvar_escolha_caracteristicas_agilidade();
    if(retorno == false)
    {
        return false;
    }
    else
    {
        return true;
    }
}

function salvar_escolha_caracteristicas_agilidade()
{    
    var title = ""; 
    var msg = "";
    var modalAlerta = "Alert";
    var modalErro = "Erro";
    
    if(document.getElementById("listDestino").length == 0)
    {
        title = "N�o foi poss�vel realizar a opera��o";
        msg = "<h4> Os campos abaixo s�o de preenchimento obrigat�rio: </h4> <ol type='1' >";
        
        if(document.getElementById("listDestino").length == 0)
        {
            msg = msg + "\n" + " <li> Ao menos uma caracter�stica de agilidade deve ser selecionada; </li> ";
        }
        
        msg = msg + "</ol>"
        executaModal(modalAlerta, title, msg);
        return false;
    }
    var listDestino = document.getElementById("listDestino");
    for (var i = 0; i < listDestino.length; i = i + 1) 
    {
        listDestino.options[i].selected = true;
    }
    
    return true;
}

function selecionar_lista_origem()
{
    document.getElementById('botaoAdicionar').disabled = false;
}

function selecionar_lista_destino()
{
    document.getElementById('botaoRemover').disabled = false;
}

function adicionar()
{
    var qtd = 0;
    var listOrigem = document.getElementById("listOrigem");
    var listDestino = document.getElementById("listDestino");
    for (var i = 0; i < listOrigem.length; i = i + 1) 
    {
        if(listOrigem.options[i].selected == true)
        {
             $("#listDestino").append('<option value=\"'+ listOrigem.options[i].value +'\" onclick="selecionar_lista_destino()" >'+ listOrigem.options[i].text +'</option>');
            listOrigem.remove(i);
            qtd = qtd + 1;
            i = i - 1; //Ajustando o indice a ser pesquisado, pois a lista � ajustada dinamicamente
        }
    }
    document.getElementById('botaoAdicionar').disabled = true;
    
    if(qtd == 0)
    {
        var title = "Nenhuma caracter�stica selecionada"; 
        var msg = "<h4> � necess�rio selecionar ao menos uma caracter�stica para adicionar; </h4> <ol type='1' > </ol>";
        var modalAlerta = "Alert";
        msg = msg + "</ol>"
        executaModal(modalAlerta, title, msg);
        return false;
    }
}

function remover()
{
    var qtd = 0;
    var listDestino = document.getElementById("listDestino");
    var listOrigem = document.getElementById("listOrigem");
    for (var i = 0; i < listDestino.length; i = i + 1) 
    {
        if(listDestino.options[i].selected == true)
        {
             $("#listOrigem").append('<option value=\"'+ listDestino.options[i].value +'\" onclick="selecionar_lista_origem()" >'+ listDestino.options[i].text +'</option>');
            listDestino.remove(i);
            qtd = qtd + 1;
            i = i - 1; //Ajustando o indice a ser pesquisado, pois a lista � ajustada dinamicamente
        }
    }
    document.getElementById('botaoRemover').disabled = true;
    
    if(qtd == 0)
    {
        var title = "Nenhuma caracter�stica selecionada"; 
        var msg = "<h4> � necess�rio selecionar ao menos uma caracter�stica para remover; </h4> <ol type='1' > </ol>";
        var modalAlerta = "Alert";
        msg = msg + "</ol>"
        executaModal(modalAlerta, title, msg);
        return false;
    }
    
}

function executaModal(modal, title, msg)
{
    if(modal == "Alert")
    {
        modal = $('#myModalAlert');
        modal.find('#myModalLabelAlert').html("Aten��o: " + title);
        modal.find('#myModalBodyAlert').html(msg);
        modal.find('#modalButtonDefault').hide("slow");
        modal.find('#modalButtonSucess').hide("slow");
        modal.modal();
    }
    else if(modal == "Erro")
    {
        modal = $('#myModalErro');
        modal.find('#myModalLabelErro').html("Erro: " + title);
        modal.find('#myModalBodyErro').html(msg);
        modal.find('#modalButtonDefault').hide("slow");
        modal.find('#modalButtonSucess').hide("slow");
        modal.modal();
    }
    else if(modal == "Sucesso")
    {
        modal = $('#myModalSucesso');
        modal.find('#myModalLabelSucesso').html(title);
        modal.find('#myModalBodySucesso').html(msg);
        modal.find('#modalButtonDefault').hide("slow");
        modal.find('#modalButtonSucess').hide("slow");
        modal.modal();
    }
}