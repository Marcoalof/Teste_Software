/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function salvar_Caracteristica()
{    
    var title = ""; 
    var msg = "";
    var modalAlerta = "Alert";
    var modalErro = "Erro";
    
    if(document.getElementById("nome").value.length == 0 || document.getElementById("descricao").value.length == 0 || document.getElementById("pertinencia").value.length == 0 || document.getElementById("relevancia").value.length == 0)
    {
        title = "N�o foi poss�vel realizar o cadastro";
        msg = "<h4> Os campos abaixo s�o de preenchimento obrigat�rio: </h4> <ol type='1' >";
        
        if(document.getElementById("nome").value.length == 0)
        {
            msg = msg + "\n" + " <li> Campo Nome da Caracter�stica � obrigat�rio; </li> ";
        }
        
        if(document.getElementById("descricao").value.length == 0)
        {
            msg = msg + "\n" + " <li> Campo Descri��o da Caracter�stica � obrigat�rio; </li> ";
        }
        
        if(document.getElementById("pertinencia").value.length == 0)
        {
            msg = msg + "\n" + " <li> Campo Pertin�ncia � obrigat�rio; </li> ";
        }
        
        if(document.getElementById("relevancia").value.length == 0)
        {
            msg = msg + "\n" + " <li> Campo Relev�ncia � obrigat�rio; </li> ";
        }
        msg = msg + "</ol>"
        document.getElementById("nome").focus();
        executaModal(modalAlerta, title, msg);
        return false;
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

function excluirCaracteristicaAgilidade(id)
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
        url: './CaracteristicaAgilidade',
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
                msg = "<h4> A carater�stica selecionada possui associa��o com pr�ticas �geis (ID: ";
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