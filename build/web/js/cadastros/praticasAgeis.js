/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function salvar_Pratica()
{    
    var title = ""; 
    var msg = "";
    var modalAlerta = "Alert";
    var modalErro = "Erro";
    
    if(document.getElementById("nome").value.length == 0 || document.getElementById("descricao").value.length == 0 || document.getElementById("pertinencia").value.length == 0 || document.getElementById("relevancia").value.length == 0 || document.getElementById("listDestino").length == 0)
    {
        title = "N�o foi poss�vel realizar o cadastro";
        msg = "<h4> Os campos abaixo s�o de preenchimento obrigat�rio: </h4> <ol type='1' >";
        
        if(document.getElementById("nome").value.length == 0)
        {
            msg = msg + "\n" + " <li> Campo Nome da Pr�tica � obrigat�rio; </li> ";
        }
        
        if(document.getElementById("descricao").value.length == 0)
        {
            msg = msg + "\n" + " <li> Campo Descri��o da Pr�tica � obrigat�rio; </li> ";
        }
        
        if(document.getElementById("pertinencia").value.length == 0)
        {
            msg = msg + "\n" + " <li> Campo Pertin�ncia � obrigat�rio; </li> ";
        }
        
        if(document.getElementById("relevancia").value.length == 0)
        {
            msg = msg + "\n" + " <li> Campo Relev�ncia � obrigat�rio; </li> ";
        }
        
        if(document.getElementById("listDestino").length == 0)
        {
            msg = msg + "\n" + " <li> Ao menos uma caracter�stica de agilidade deve ser estar associada a pr�tica; </li> ";
        }
        
        msg = msg + "</ol>";
        document.getElementById("nome").focus();
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

function excluirPraticasAgeis(id)
{
    var acao = "excluir";
    var title = ""; 
    var msg = "";
    var modalAlerta = "Alert";
    var modalErro = "Erro";
    var retorno = "false";
    title = "N�o foi poss�vel realizar a exclus�o";
    
    $.ajax(
    {
        async: false,
        type: 'GET',
        data: 
        {
            acao: acao,
            id: id
        },
        url: './PraticasAgeis',
        dataType: 'text',
        contentType: "application/text",
        success: function (response) 
        {
            if(response == "")
            {
                retorno = "true";
            }
            else if(response == "Erro ao processar registro" || response == "A��o n�o identificada.")
            {
                title = "Ocorreu um erro ao processar a a��o"; 
                msg = "<h4> Por favor, aguarde um momento e tente novamente; </h4> <ol type='1' >";
                executaModal(modalErro, title, msg)
                retorno = "false";
            }
            else
            {
                msg = "<h4> A pr�tica selecionada possui associa��o com Etapas de Teste de Software (ID: ";
                msg += response;
                msg += ") e n�o pode ser exclu�da </h4> <ol type='1' >";
                msg += "</ol>"
                executaModal(modalAlerta, title, msg)
                retorno = "false";
            }
        },
        error: function () 
        {
            title = "Ocorreu um erro ao processar a a��o"; 
            msg = "<h4> Por favor, aguarde um momento e tente novamente; </h4> <ol type='1' >";
            executaModal(modalErro, title, msg)
            retorno = "false";
        }
    });
    if(retorno == "true")
    {
        return true;
    }
    else
    {
        return false;
    }
}