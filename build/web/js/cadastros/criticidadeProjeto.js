/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function salvar_criticidade_projeto(action)
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
        url = './CriticidadeProjeto';
    }
    else if(action == "inserir")
    {
        acao = "inserir";
        url = '../../../CriticidadeProjeto';
    }
    
    if(document.getElementById("nome").value.length == 0 || document.getElementById("peso").value.length == 0)
    {
        title = "Não foi possível realizar o cadastro";
        msg = "<h4> Os campos abaixo são de preenchimento obrigatório: </h4> <ol type='1' >";
        
        if(document.getElementById("nome").value.length == 0)
        {
            msg = msg + "\n" + " <li> Campo Nome Criticidade do Projeto é obrigatório; </li> ";
        }
        
        if(document.getElementById("peso").value.length == 0)
        {
            msg = msg + "\n" + " <li> Campo Peso associado a Criticidade do Projeto é obrigatório; </li> ";
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
                title = "Não foi possível realizar a inclusão/edição";
                msg = "<h4> Já existe outra Criticidade do Projeto com o mesmo Peso informado </h4> <ol type='1' >";
                executaModal(modalAlerta, title, msg)
                retorno = "false";
            }
            else if(response == "Ação não identificada.")
            {
                title = "Ação não identificada"; 
                msg = "<h4> Por favor, aguarde um momento e tente novamente; </h4> <ol type='1' >"; 
                executaModal(modalErro, title, msg);
                retorno = "false";
            }
        },
        error: function () 
        {
            title = "Ocorreu um erro ao processar a ação"; 
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
        modal.find('#myModalLabelAlert').html("Atenção: " + title);
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