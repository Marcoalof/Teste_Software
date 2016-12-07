<%-- 
    Document   : login
    Created on : 24/04/2015, 15:12:22
    Author     : Marco Ant�nio
--%>

<%@ page session="false" %>
<%@ page language="java" contentType="text/html;" pageEncoding="iso-8859-1" %>

<html xmlns="http://www.w3.org/1999/xhtml" lang="pt-br" xml:lang="pt-br">
    <head>
        <%@include file="../Basicos/Head.html" %>
    </head>
    <body>
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div id="navbar" class="navbar-collapse collapse">
            <a class="navbar-brand" >Apoio a Teste de Software - Projeto Final Monografia</a>
            <div class="navbar-form navbar-right">
            <table cellspacing="0" role="presentation">
                <tbody>
                    <tr>
                        <td style="padding: 5px">
                        <input type="text" name="userName" id="username" placeholder="Usu�rio" class="form-control" tabindex="1">
                      </td>
                      <td style="padding: 5px">
                        <input type="password" name="password" id="password" placeholder="Senha" class="form-control" tabindex="2">         
                      </td>
                      <td style="padding: 5px">
                          <button type="button" class="btn btn-success" tabindex="4" id="entrar" onClick="return valida_login()">Entrar <span class="glyphicon glyphicon-circle-arrow-right"/></button>
                      </td>  
                    </tr>
                    <tr>
                      <td>
                      </td>
                      <td style="padding: 5px">
                        <a style="color: #1870BB" href="/Projeto_Teste_Software/ControllerRedirecionar?page=/Projeto_Teste_Software/Views/Login/EsqueciMinhaSenha.jsp">Esqueceu sua senha?</a>
                      </td>
                    </tr>
                </tbody>
              </table>
          </div>
        </div><!--/.navbar-collapse -->
      </div>
    </nav>
        
    <%@include file="../Basicos/Modals_Padrao.html" %>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1>Bem vindo!</h1>
        <p>Este projeto foi desenvolvido como trabalho final do aluno Marco Ant�nio Lup�rcio Oliveira Freitas para o projeto final da Monografia da Universidade Federal de Juiz de Fora.</p>
        <p>Resumidamente, o trabalho final tem o intuito desenvolver uma ferramenta para apoio a decis�o de qual metodologia deve ser utilizada para acrescentarmos mais agilidade na escolha e execu��o dos testes em softwares.</p>        
        <p>Cadastre-se abaixo e realize o login acima para navegar pelas funcionalidades ofereridas no projeto.</p>        
      </div>
    </div>
    
    <div class="container">
        <hr>
        <br>
    </div>
    
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-6">
            <img src="/Projeto_Teste_Software/img/login_2.png">
        </div>
        <div class="col-md-6">
            <div class="login-block">
                <!-- BEGIN REGISTRATION FORM -->
                  <h3>Cadastre-se</h3>
                  <p>Informe os detalhas da sua conta:</p>
                  <div class="control-group">
                    <label>Usu�rio</label>
                    <div class="iconInput">
                        <i class="glyphicon glyphicon-user"></i>
                        <input type="text" placeholder="Username" name="username" id="Username" maxlength="45"/>
                    </div> 
                  </div>   
                  <div class="control-group">
                    <label>Password</label>
                    <div class="iconInput">
                        <i class="glyphicon glyphicon-lock"></i>
                        <input type="password" id="Password" placeholder="Senha. Ao menos 8 caracteres" name="password" maxlength="20"/>
                    </div>
                  </div>
                  <div class="control-group">
                    <label class="control-label visible-ie8 visible-ie9">Confirma��o Senha</label>
                    <div class="iconInput">
                        <i class="glyphicon glyphicon-ok"></i>
                        <input type="password" placeholder="Confirmar a Senha" name="rPassword" id="rPassword" maxlength="20"/>
                    </div>
                  </div>
                  <div class="control-group">
                    <!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
                    <label class="control-label visible-ie8 visible-ie9">Email</label>
                    <div class="iconInput">
                        <i class="glyphicon glyphicon-envelope"></i>
                        <input type="email" placeholder="Email. Ex.: teste@teste.com" name="email" id="email" maxlength="55"/>
                    </div>
                  </div>
                  <br>
                  <div class="form-actions">
                    <!--
                      <button type="submit" id="register-back-btn" class="btn">
                    <span class="glyphicon glyphicon-circle-arrow-left"></span>
                    <font>
                        <font class="">    Voltar
                        </font>
                    </font>
                    </button>
                    -->  
                    <button type="submit" id="cadastrar" class="btn btn-success" onClick="return cadastrar(this)">
                        <font>
                            <font class="">  Cadastrar
                            </font>
                        </font>
                        <span class="glyphicon glyphicon-circle-arrow-right"/>
                    </button>            
                  </div>
                <!-- END REGISTRATION FORM -->
            </div>
            <!-- END LOGIN -->
       </div>
      </div>
    <div class="container">
        <hr>
    </div>
      
    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-6">
          <h2>UFJF</h2>
          <p>Fundada em 1960, por ato do ent�o Presidente Juscelino Kubitschek, a fim de tornar-se um p�lo acad�mico e cultural de uma regi�o de 2,5 milh�es de habitantes no Sudeste do Estado de Minas Gerais que tem como centro a cidade de Juiz de Fora, a Universidade Federal de Juiz de fora � atualmente uma mais importantes da regi�o. Conta hoje com 20.000 estudantes, 1.000 professores e 1144 servidores t�cnico-administrativos educacionais. Oferece 37 cursos superiores de gradua��o ...</p>
          <p><a class="btn btn-default" href="http://www.ufjf.br/portal/" target="_blank" role="button">Mais detalhes &raquo;</a></p>
        </div>
        <div class="col-md-6">
          <h2>Ci�ncia da Computa��o</h2>
          <p>O curso de Bacharelado em Ci�ncia da Computa��o da Universidade Federal de Juiz de Fora tem a computa��o como atividade-fim e desta forma tem por objetivo formar profissionais com profunda fundamenta��o t�cnica e cient�fica na �rea, aptos para a inser��o em setores profissionais, acad�micos e cient�ficos, e que possam participar do desenvolvimento da sociedade brasileira e contribuir para o avan�o da ci�ncia e da tecnologia.</p>
          <p><a class="btn btn-default" href="http://www.ufjf.br/cursocomputacao/" target="_blank" role="button">Mais detalhes &raquo;</a></p>
       </div>
      </div>

      <hr>

      <footer>
        <p>Projeto Final de Bacharelado em Ci�ncia da Computa��o - Universidade Federal de Juiz de Fora</p>
      </footer>
    </div> <!-- /container -->        
    </body>
</html>
