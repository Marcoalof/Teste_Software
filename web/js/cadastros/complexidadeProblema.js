/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function salvar_complexidade_problema(action)
{    
    var acao = "";
    var url = "";
    var title = ""; 
    var retorno = "true";
    var msg = "";
    var modalAlerta = "Alert";
    var modalErro = "Erro";
    if(action == "editarPopular")
    {
        acao = "editar";
        url = './ComplexidadeProblema';
    }
    else if(action == "inserir")
    {
        acao = "inserir";
        url = '../../../ComplexidadeProblema';
    }
    
    if(document.getElementById("nome").value.length == 0 || document.getElementById("peso").value.length == 0)
    {
        title = "N�o foi poss�vel realizar o cadastro";
        msg = "<h4> Os campos abaixo s�o de preenchimento obrigat�rio: </h4> <ol type='1' >";
        
        if(document.getElementById("nome").value.length == 0)
        {
            msg = msg + "\n" + " <li> Campo Nome do Indicador de Complexidade do Problema � obrigat�rio; </li> ";
        }
        
        if(document.getElementById("peso").value.length == 0)
        {
            msg = msg + "\n" + " <li> Campo Peso do Indicador de Complexidade do Problema � obrigat�rio; </li> ";
        }
        
        msg = msg + "</ol>"
        document.getElementById("nome").focus();
        executaModal(modalAlerta, title, msg);
        return false;
    }
    var id = document.getElementById("id").value;
    var peso = document.getElementById("peso").value;
    
    $.ajax(
    {
        async: false,
        type: 'GET',
        data: 
        {
            acao: acao,
            peso: peso,
            id: id
        },
        url: url,
        dataType: 'text',
        contentType: "application/text",
        success: function (response) 
        {
            if(response == true.toString())
            {
                title = "N�o foi poss�vel realizar a inclus�o/edi��o";
                msg = "<h4> J� existe outro Indicador de Complexidade do Problema com o mesmo Peso informado </h4> <ol type='1' >";
                executaModal(modalAlerta, title, msg)
                retorno = "false";
            }
            else if(response == "A��o n�o identificada.")
            {
                title = "A��o n�o identificada"; 
                msg = "<h4> Por favor, aguarde um momento e tente novamente; </h4> <ol type='1' >"; 
                executaModal(modalErro, title, msg);
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