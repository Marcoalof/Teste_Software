/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function sair()
{
    var acao = "sair";
    var url = '../../Login';
    
    $.ajax(
    {
        async: false,
        type: 'GET',
        data: 
        {
            acao: acao
        },
        url: url,
        dataType: 'text',
        contentType: "application/text",
        success: function (response) 
        {
            window.location.href = "/Projeto_Teste_Software/ControllerRedirecionar?page=/Projeto_Teste_Software/";
        },
        error: function () 
        {
            window.location.href = "/Projeto_Teste_Software/ControllerRedirecionar?page=/Projeto_Teste_Software/";
        }
    });
    window.location.href = "/Projeto_Teste_Software/ControllerRedirecionar?page=/Projeto_Teste_Software/";
    return true;
}

function redirecionaCaracteristica()
{
    var acao = "teste";
    var title = ""; 
    var msg = "";
    var modalAlerta = "Alert";
    var modalErro = "Erro";
    
    $.ajax(
    {
        async: false,
        type: 'GET',
        data: 
        {
            acao: acao
        },
        url: './Login',
        dataType: 'text',
        contentType: "application/text",
        success: function (response) 
        {
            if(response == "teste")
            {
            }
            /*
            if(response == "entrar")
            {
                window.location = "Views/Menu/Menu.jsp";
            }
            else
            {
                title = response; 
                msg = "<h4> Por favor, aguarde um momento e tente novamente; </h4> <ol type='1' >";
                executaModal(modalErro, title, msg)
                return false;
            }
            */
        },
        error: function () 
        {
            title = "Ocorreu um erro ao processar a a��o"; 
            msg = "<h4> Por favor, aguarde um momento e tente novamente; </h4> <ol type='1' >";
            executaModal(modalErro, title, msg)
            return false;
        }
    });
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