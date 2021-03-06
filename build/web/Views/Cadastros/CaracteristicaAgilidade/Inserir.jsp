<%-- 
    Document   : Caracteristicas_Agilidade
    Created on : 27/06/2016, 23:09:10
    Author     : Marco Ant�nio
--%>

<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/Views/Basicos/Head.html" %>
    </head>
    <body>
        
        <%@include file="/Views/Basicos/Modals_Padrao.html" %>
        <%@include file="/Views/Basicos/Header.html" %>
        
        <div class="cadastrosBasicosInserir">
            <form name="fInserirCaracteristicaAgilidade" onSubmit="return salvar_Caracteristica()" action="/Projeto_Teste_Software/Controller?classe=ControllerLogicCaracteristicaAgilidade&acao=inserir" method="POST" >
                <fieldset>
                    <legend>Cadastro Caracter�stica de Agilidade</legend>
                    <fieldset class="form-group">
                        <label for="nome">Nome Caracter�stica</label>
                        <input type="text" class="form-control" id="nome" name="nome"  maxlength="50" placeholder="Insira o nome " >
                        <br>
                        <label for="descricao">Descri��o da Caracter�stica</label>
                        <textarea rows="3" class="form-control" id="descricao" name="descricao"  maxlength="1000" placeholder="Insira a descri��o da pr�tica " ></textarea>
                        <br>
                        <label for="nome">Pertin�ncia (%)</label>
                        <input type="number" min="0" max="100" step="any" class="form-control" id="pertinencia" name="pertinencia" placeholder="Insira o valor da Pertin�ncia ">
                        <p>Informe apenas n�meros. Ex.: 54,23</p>
                        <label for="nome">Relev�ncia (%)</label>
                        <input type="number" min="0" max="100" step="any" class="form-control" id="relevancia" name="relevancia" placeholder="Insira o valor da Relev�ncia " >
                        <p>Informe apenas n�meros. Ex.: 54,23</p>
                    </fieldset>
                </fieldset>
                <button type="submit" class="btn btn-primary" >Salvar</button>  
                <button type="reset" class="btn btn-primary" onclick="window.history.go(-1);">Voltar</button>
            </form>
        </div>
    </body>
</html>
