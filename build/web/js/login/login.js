/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function valida_login()
{
    var acao = "entrar";
    var usuario = $("#username").val();
    var senha = $("#password").val();
    var title = ""; 
    var msg = "";
    var modalAlerta = "Alert";
    var modalErro = "Erro";
    var url = "";
    if(window.location.pathname.toString() == '/Projeto_Teste_Software/')
    {
        url = './Login';
    }
    else
    {
        url = '../../Login';
    }
    
    if(document.getElementById("username").value.length == 0 || document.getElementById("password").value.length < 8)
    {
        title = "N�o foi poss�vel realizar o login";
        msg = "<h4> Os campos abaixo s�o de preenchimento obrigat�rio: </h4> <ol type='1' >";
        if(document.getElementById("username").value.length == 0)
        {
                msg = msg + "\n" + " <li> Campo Usu�rio � obrigat�rio; </li> ";
        }

        if(document.getElementById("password").value.length < 8)
        {
                msg = msg + "\n" + "<li> Campo Senha � obrigat�rio e deve conter pelo menos 8 caracteres; </li>";
        }          
        msg = msg + "</ol>"
        document.getElementById("username").focus();
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
            senha: senha
        },
        url: url,
        dataType: 'text',
        contentType: "application/text",
        success: function (response) 
        {
            if(response == "Usu�rio e/ou Senha incorretos")
            {
                title = response; 
                msg = "<h4> Por favor, verifique os dados informados e tente novamente; </h4> <ol type='1' >";
                executaModal(modalAlerta, title, msg)
                return false;
            }
            else if(response == "logar")
            {
                window.location.href = "Views/Menu/Menu.jsp";
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

function cadastrar()
{
    
    var acao = "cadastrar";
    var usuario = $("#Username").val();
    var senha = $("#Password").val();
    var confirmar_senha = $("#rPassword").val();
    var email = $("#email").val().trim();
    var title = ""; 
    var msg = "";
    var modalAlerta = "Alert";
    var modalErro = "Erro";
    var modalSucesso = "Sucesso";
    
    var url = "";
    if(window.location.pathname.toString() == '/Projeto_Teste_Software/')
    {
        url = './Login';
    }
    else
    {
        url = '../../Login';
    }
    
    if(usuario.length == 0 || senha.length < 8 || senha !== confirmar_senha || email.length == 0 || 
            (email.length < 4) || (email.search("@")==-1) || (email.search(".com")==-1)
      )
    {
        title = "N�o foi poss�vel realizar o cadastro";
        msg = "<h4> Os campos abaixo s�o de preenchimento obrigat�rio: </h4> <ol type='1' >";
        if(usuario.length == 0)
        {
            msg = msg + "\n" + " <li> Campo Usu�rio � obrigat�rio; </li> ";
        }

        if(senha.length < 8)
        {
            msg = msg + "\n" + "<li> Campo Senha � obrigat�rio e deve conter pelo menos 8 caracteres; </li>";
        }
        
        if(senha != confirmar_senha)
        {
            msg = msg + "\n" + "<li> Campo Senha e Confirmar Senha devem conter a mesma informa��o; </li>";
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
            nome: usuario,
            senha: senha,
            email: email
        },
        url: url,
        dataType: 'text',
        contentType: "application/text",
        success: function (response) 
        {
            if(response == "Usu�rio cadastrado com sucesso")
            {
                title = response; 
                msg = "<h4> Realize o login para navegar pelas funcionalidades do projeto; </h4> <ol type='1' >";
                executaModal(modalSucesso, title, msg)
                return true;
            }
            else if(response == "Usu�rio j� cadastrado")
            {
                title = response; 
                msg = "<h4> Usu�rio j� cadastrado. Por favor informe outro.; </h4> <ol type='1' >";
                executaModal(modalAlerta, title, msg)
                return false;
            }
            else if(response == "Erro ao tentar cadastrar novo Usu�rio")
            {
                title = response; 
                msg = "<h4> Ocorreu um erro ao tentar cadastrar novo usu�rio. Por favor, aguarde um momento e tente novamente; </h4> <ol type='1' >";
                executaModal(modalErro, title, msg)
                return false;
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