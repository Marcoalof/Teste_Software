/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function voltar_login()
{
    window.location.href = "/Projeto_Teste_Software/ControllerRedirecionar?page=/Projeto_Teste_Software/";
}

function esqueci_minha_senha()
{
    var acao = "redefinirSenha";
    var usuario = $("#Username").val().trim();
    var email = $("#email").val().trim();
    var title = ""; 
    var msg = "";
    var modalAlerta = "Alert";
    var modalErro = "Erro";
    var modalSucesso = "Sucesso";
    
    var url = '../../Login';
    
    if(document.getElementById("Username").value.length == 0 || email.length == 0 || (email.length < 4) || (email.search("@")==-1) || (email.search(".com")==-1)
      )
    {
        title = "N�o foi poss�vel realizar a redefini��o de senha";
        msg = "<h4> Os campos abaixo s�o de preenchimento obrigat�rio: </h4> <ol type='1' >";
        
        if(document.getElementById("Username").value.length == 0)
        {
                msg = msg + "\n" + " <li> Campo Usu�rio � obrigat�rio; </li> ";
        }
        
        if(email.length == 0 || (email.length < 4) || (email.search("@")==-1) || (email.search(".com")==-1))
        {
            msg = msg + "\n" + "<li> Campo email � obrigat�rio e deve conter formato adequado. Ex.: teste@teste.com; </li>";
        }
        
        msg = msg + "</ol>"
        executaModal(modalAlerta, title, msg);
        return false;
    }
    
    $.ajax(
    {
        async: false,
        type: 'GET',
        data: 
        {
            acao: acao,
            usuario: usuario,
            email: email
        },
        url: url,
        dataType: 'text',
        contentType: "application/text",
        success: function (response) 
        {
            if(response == "Usu�rio localizado")
            {
                title = response; 
                msg = "<h4> Email encaminhado com a nova senha; </h4> <ol type='1' >";
                executaModal(modalSucesso, title, msg)
                return true;
            }
            else if(response == "Usu�rio e email informado n�o foi localizado")
            {
                title = response; 
                msg = "<h4> Cadastro n�o localizado. Verifique a informa��o e tente novamente ou realize o cadastro para navegar pelas funcionalidades do projeto; </h4> <ol type='1' >";
                executaModal(modalAlerta, title, msg)
                return true;
            }
            else
            {
                title = response; 
                msg = "<h4> Por favor, aguarde um momento e tente novamente; </h4> <ol type='1' >";
                executaModal(modalErro, title, msg)
                return false;
            }
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