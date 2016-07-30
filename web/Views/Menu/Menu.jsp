<%-- 
    Document   : Menu
    Created on : 24/04/2015, 15:12:22
    Author     : Marco Antônio
--%>
<%@ page session="false" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="pt-br" xml:lang="pt-br">
    <head>
        <%@include file="../Basicos/Head.html" %>
    </head>
    <body>
        
        <%@include file="../Basicos/Modals_Padrao.html" %>
        <%@include file="../Basicos/Header.html" %>

        <div class="jumbotron" style="margin: 50px 50px 50px 50px;">
            <div class="container">
              <h1>Bem vindo!</h1><br> 
              <p>Atrav&eacute;s do uso do OptGrade voc&ecirc; pode gerenciar todos os seus projetos (planejamento das grades acad&ecirc;micas):</p>
              <ul>
                <li>
                <td>1 - Cria&ccedil;&atilde;o/Edi&ccedil;&atilde;o de Grades Acad&ecirc;micas;</td>
                </li>
                <li>
                <td>2 - An&aacute;lise de Grades Acad&ecirc;micas</td>
                </li>
                <li>
                <td>3 - Aloca&ccedil;&otilde;es de Salas x Turma x Professor (dentre outros);</td>
                </li>
                <li>
                    <td>4 - Relat&oacute;rios;</td>
                </li>
              </ul>
              <p>E tudo isso de forma pr&aacute;tica e r&aacute;pida.</p>
              <p><a class="btn btn-primary btn-lg" href="help.php" role="button">Saiba mais &raquo;</a></p>
            </div>
        </div>
</body>
</html>