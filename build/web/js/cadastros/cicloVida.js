/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function salvar_ciclo_vida()
{    
    var title = ""; 
    var msg = "";
    var modalAlerta = "Alert";
    var modalErro = "Erro";
    if(document.getElementById("nome").value.length == 0 || document.getElementById("descricao").value.length == 0)
    {
        title = "N�o foi poss�vel realizar o cadastro";
        msg = "<h4> Os campos abaixo s�o de preenchimento obrigat�rio: </h4> <ol type='1' >";
        
        if(document.getElementById("nome").value.length == 0)
        {
            msg = msg + "\n" + " <li> Campo Nome do Ciclo de Vida � obrigat�rio; </li> ";
        }
        
        if(document.getElementById("descricao").value.length == 0)
        {
            msg = msg + "\n" + " <li> Campo Descri��o do Ciclo de Vida � obrigat�rio; </li> ";
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