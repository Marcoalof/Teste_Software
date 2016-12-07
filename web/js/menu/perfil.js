/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function voltar_home()
{
    window.location.href = "/Projeto_Teste_Software/ControllerRedirecionar?page=/Projeto_Teste_Software/Views/Menu/Menu.jsp";
}

function salvar_perfil()
{
    var acao = "atualizarPerfil";
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
    var tamAntes = window.location.pathname.toString().length;
    var tamDepois = ((window.location.pathname.toString()).split("/").join("")).length;
    var i = tamAntes - tamDepois - 2;//-1 é o / inicial;
    while(i > 0)
    {
        url += '../';
        i = i - 1;
    }
    url += 'Perfil';
    
    if(usuario.length == 0 || senha.length < 8 || senha !== confirmar_senha || email.length == 0 || 
            (email.length < 4) || (email.search("@")==-1) || (email.search(".com")==-1)
      )
    {
        title = "Não foi possível realizar o cadastro";
        msg = "<h4> Os campos abaixo são de preenchimento obrigatório: </h4> <ol type='1' >";
        if(usuario.length == 0)
        {
            msg = msg + "\n" + " <li> Campo Usuário é obrigatório; </li> ";
        }

        if(senha.length < 8)
        {
            msg = msg + "\n" + "<li> Campo Senha é obrigatório e deve conter pelo menos 8 caracteres; </li>";
        }
        
        if(senha != confirmar_senha)
        {
            msg = msg + "\n" + "<li> Campo Senha e Confirmar Senha devem conter a mesma informação; </li>";
        }
        
        if(email.length == 0 || (email.length < 4) || (email.search("@")==-1) || (email.search(".com")==-1))
        {
            msg = msg + "\n" + "<li> Campo email é obrigatório e deve conter formato adequado. Ex.: teste@teste.com; </li>";
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
            if(response == "Cadastro Atualizado com sucesso.")
            {
                title = response; 
                msg = "<h4> As informações do perfil foram atualizadas com sucesso; </h4> <ol type='1' >";
                executaModal(modalSucesso, title, msg)
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
            title = "Ocorreu um erro ao processar a ação"; 
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