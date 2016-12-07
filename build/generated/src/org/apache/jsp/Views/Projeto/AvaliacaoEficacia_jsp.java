package org.apache.jsp.Views.Projeto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AvaliacaoEficacia_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/Views/Basicos/Head.html");
    _jspx_dependants.add("/Views/Basicos/Modals_Padrao.html");
    _jspx_dependants.add("/Views/Basicos/Header.html");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_otherwise;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_otherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_when_test.release();
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_c_otherwise.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=iso-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      Model.CicloVida cicloVida = null;
      synchronized (request) {
        cicloVida = (Model.CicloVida) _jspx_page_context.getAttribute("cicloVida", PageContext.REQUEST_SCOPE);
        if (cicloVida == null){
          cicloVida = new Model.CicloVida();
          _jspx_page_context.setAttribute("cicloVida", cicloVida, PageContext.REQUEST_SCOPE);
        }
      }
      out.write('\n');
      Model.DuracaoProjeto duracaoProjeto = null;
      synchronized (request) {
        duracaoProjeto = (Model.DuracaoProjeto) _jspx_page_context.getAttribute("duracaoProjeto", PageContext.REQUEST_SCOPE);
        if (duracaoProjeto == null){
          duracaoProjeto = new Model.DuracaoProjeto();
          _jspx_page_context.setAttribute("duracaoProjeto", duracaoProjeto, PageContext.REQUEST_SCOPE);
        }
      }
      out.write('\n');
      Model.ComplexidadeProblema complexidadeProblema = null;
      synchronized (request) {
        complexidadeProblema = (Model.ComplexidadeProblema) _jspx_page_context.getAttribute("complexidadeProblema", PageContext.REQUEST_SCOPE);
        if (complexidadeProblema == null){
          complexidadeProblema = new Model.ComplexidadeProblema();
          _jspx_page_context.setAttribute("complexidadeProblema", complexidadeProblema, PageContext.REQUEST_SCOPE);
        }
      }
      out.write('\n');
      Model.InstabilidadeRequisito instabilidadeRequisito = null;
      synchronized (request) {
        instabilidadeRequisito = (Model.InstabilidadeRequisito) _jspx_page_context.getAttribute("instabilidadeRequisito", PageContext.REQUEST_SCOPE);
        if (instabilidadeRequisito == null){
          instabilidadeRequisito = new Model.InstabilidadeRequisito();
          _jspx_page_context.setAttribute("instabilidadeRequisito", instabilidadeRequisito, PageContext.REQUEST_SCOPE);
        }
      }
      out.write('\n');
      Model.TamanhoEquipe tamanhoEquipe = null;
      synchronized (request) {
        tamanhoEquipe = (Model.TamanhoEquipe) _jspx_page_context.getAttribute("tamanhoEquipe", PageContext.REQUEST_SCOPE);
        if (tamanhoEquipe == null){
          tamanhoEquipe = new Model.TamanhoEquipe();
          _jspx_page_context.setAttribute("tamanhoEquipe", tamanhoEquipe, PageContext.REQUEST_SCOPE);
        }
      }
      out.write('\n');
      Model.CriticidadeProjeto criticidadeProjeto = null;
      synchronized (request) {
        criticidadeProjeto = (Model.CriticidadeProjeto) _jspx_page_context.getAttribute("criticidadeProjeto", PageContext.REQUEST_SCOPE);
        if (criticidadeProjeto == null){
          criticidadeProjeto = new Model.CriticidadeProjeto();
          _jspx_page_context.setAttribute("criticidadeProjeto", criticidadeProjeto, PageContext.REQUEST_SCOPE);
        }
      }
      out.write('\n');
      Model.PlataformaExecucao plataformaExecucao = null;
      synchronized (request) {
        plataformaExecucao = (Model.PlataformaExecucao) _jspx_page_context.getAttribute("plataformaExecucao", PageContext.REQUEST_SCOPE);
        if (plataformaExecucao == null){
          plataformaExecucao = new Model.PlataformaExecucao();
          _jspx_page_context.setAttribute("plataformaExecucao", plataformaExecucao, PageContext.REQUEST_SCOPE);
        }
      }
      out.write('\n');
      Model.DominioAplicacao dominioAplicacao = null;
      synchronized (request) {
        dominioAplicacao = (Model.DominioAplicacao) _jspx_page_context.getAttribute("dominioAplicacao", PageContext.REQUEST_SCOPE);
        if (dominioAplicacao == null){
          dominioAplicacao = new Model.DominioAplicacao();
          _jspx_page_context.setAttribute("dominioAplicacao", dominioAplicacao, PageContext.REQUEST_SCOPE);
        }
      }
      out.write('\n');
      Model.ProjetoSoftware projetoSoftware = null;
      synchronized (request) {
        projetoSoftware = (Model.ProjetoSoftware) _jspx_page_context.getAttribute("projetoSoftware", PageContext.REQUEST_SCOPE);
        if (projetoSoftware == null){
          projetoSoftware = new Model.ProjetoSoftware();
          _jspx_page_context.setAttribute("projetoSoftware", projetoSoftware, PageContext.REQUEST_SCOPE);
        }
      }
      out.write('\n');
      Persistence.PraticasAgeisDAO praticasAgeisDAO = null;
      synchronized (request) {
        praticasAgeisDAO = (Persistence.PraticasAgeisDAO) _jspx_page_context.getAttribute("praticasAgeisDAO", PageContext.REQUEST_SCOPE);
        if (praticasAgeisDAO == null){
          praticasAgeisDAO = new Persistence.PraticasAgeisDAO();
          _jspx_page_context.setAttribute("praticasAgeisDAO", praticasAgeisDAO, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        ");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; \" />\r\n");
      out.write("<title>OptTeste</title>\r\n");
      out.write("<meta name=\"description\" content=\"\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link rel=\"apple-touch-icon\" href=\"apple-touch-icon.png\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/Projeto_Teste_Software/css/bootstrap.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/Projeto_Teste_Software/css/font-awesome.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/Projeto_Teste_Software/css/bootstrap.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/Projeto_Teste_Software/css/modals.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/Projeto_Teste_Software/css/cadastrosBasicos.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/Projeto_Teste_Software/css/bootstrap-theme.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/Projeto_Teste_Software/css/main.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/Projeto_Teste_Software/css/bootstrap-datetimepicker.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/Projeto_Teste_Software/css/esqueciMinhaSenha.css\">\r\n");
      out.write("<style>\r\n");
      out.write("\tbody {\r\n");
      out.write("\t\tpadding-top: 50px;\r\n");
      out.write("\t\tpadding-bottom: 20px;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("<script src=\"/Projeto_Teste_Software/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js\"></script>\r\n");
      out.write("<script src=\"/Projeto_Teste_Software/js/login/login.js\"></script>\r\n");
      out.write("<script src=\"/Projeto_Teste_Software/js/header/header.js\"></script>\r\n");
      out.write("<script src=\"//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.js\"></script>\r\n");
      out.write("<script>window.jQuery || document.write('<script src=\"js/vendor/jquery-1.11.2.js\"><\\/script>')</script>\r\n");
      out.write("<script src=\"/Projeto_Teste_Software/js/vendor/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"/Projeto_Teste_Software/js/main.js\"></script>\r\n");
      out.write("<script src=\"/Projeto_Teste_Software/js/cadastros/caracteristicasAgilidade.js\"></script>\r\n");
      out.write("<script src=\"/Projeto_Teste_Software/js/cadastros/praticasAgeis.js\"></script>\r\n");
      out.write("<script src=\"/Projeto_Teste_Software/js/cadastros/etapasTesteSoftware.js\"></script>\r\n");
      out.write("<script src=\"/Projeto_Teste_Software/js/cadastros/cicloVida.js\"></script>\r\n");
      out.write("<script src=\"/Projeto_Teste_Software/js/cadastros/complexidadeProblema.js\"></script>\r\n");
      out.write("<script src=\"/Projeto_Teste_Software/js/cadastros/instabilidadeRequisito.js\"></script>\r\n");
      out.write("<script src=\"/Projeto_Teste_Software/js/cadastros/tamanhoEquipe.js\"></script>\r\n");
      out.write("<script src=\"/Projeto_Teste_Software/js/cadastros/duracaoProjeto.js\"></script>\r\n");
      out.write("<script src=\"/Projeto_Teste_Software/js/cadastros/criticidadeProjeto.js\"></script>\r\n");
      out.write("<script src=\"/Projeto_Teste_Software/js/cadastros/plataformaExecucao.js\"></script>\r\n");
      out.write("<script src=\"/Projeto_Teste_Software/js/cadastros/dominioAplicacao.js\"></script>\r\n");
      out.write("<script src=\"/Projeto_Teste_Software/js/projeto/projeto.js\"></script>\r\n");
      out.write("<script src=\"/Projeto_Teste_Software/js/bootstrap-datetimepicker.min.js\"></script>\r\n");
      out.write("<script src=\"/Projeto_Teste_Software/js/login/esqueciMinhaSenha.js\"></script>\r\n");
      out.write("<script src=\"/Projeto_Teste_Software/js/menu/perfil.js\"></script>\r\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");
      out.write("    <body>\r\n");
      out.write("        <div class=\"modal fade\" id=\"myModalAlert\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">\r\n");
      out.write("            <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("              <div class=\"modal-content\">\r\n");
      out.write("                <div class=\"modal-headerAlert\">\r\n");
      out.write("                  <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\r\n");
      out.write("                  <h4 class=\"modal-title\" id=\"myModalLabelAlert\">Alerta: </h4>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"modal-body\" id=\"myModalBodyAlert\">                  \r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"modal-footer\">\r\n");
      out.write("                  <button type=\"button\" id=\"modalButtonDefault\" class=\"btn btn-default\" data-dismiss=\"modal\">Cancelar</button>\r\n");
      out.write("                  <button type=\"button\" id=\"modalButtonPrimary\" class=\"btn btn-primary\" data-dismiss=\"modal\">OK</button>\r\n");
      out.write("                  <button type=\"button\" id=\"modalButtonSucess\" class=\"btn btn-sucess\">Salvar</button>\r\n");
      out.write("                </div>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div> \r\n");
      out.write("        \r\n");
      out.write("        <div class=\"modal fade\" id=\"myModalConfirmacao\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">\r\n");
      out.write("                <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("                  <div class=\"modal-content\">\r\n");
      out.write("                    <div class=\"modal-headerConfirmacao\">\r\n");
      out.write("                      <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\r\n");
      out.write("                      <h4 class=\"modal-title\" id=\"myModalLabelConfirmacao\">Confirmação: </h4>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"modal-body\" id=\"myModalBodyConfirmacao\">                  \r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"modal-footer\">\r\n");
      out.write("                      <button type=\"button\" id=\"idmodalButtonDefault\" class=\"btn btn-default\" data-dismiss=\"modal\">Cancelar</button>\r\n");
      out.write("                      <button type=\"button\" id=\"idmodalButtonPrimary\" class=\"btn btn-primary\" data-dismiss=\"modal\">OK</button>\r\n");
      out.write("                      <button type=\"button\" id=\"idmodalButtonSucess\" class=\"btn btn-sucess\">Salvar</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"modal fade\" id=\"myModalErro\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">\r\n");
      out.write("            <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("              <div class=\"modal-content\">\r\n");
      out.write("                <div class=\"modal-headerErro\">\r\n");
      out.write("                  <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\r\n");
      out.write("                  <h4 class=\"modal-title\" id=\"myModalLabelErro\">Erro: </h4>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"modal-body\" id=\"myModalBodyErro\">                  \r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"modal-footer\">\r\n");
      out.write("                  <button type=\"button\" id=\"modalButtonDefault\" class=\"btn btn-default\" data-dismiss=\"modal\">Cancelar</button>\r\n");
      out.write("                  <button type=\"button\" id=\"modalButtonPrimary\" class=\"btn btn-primary\" data-dismiss=\"modal\">OK</button>\r\n");
      out.write("                  <button type=\"button\" id=\"modalButtonSucess\" class=\"btn btn-sucess\">Salvar</button>\r\n");
      out.write("                </div>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"modal fade\" id=\"myModalSucesso\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">\r\n");
      out.write("            <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("              <div class=\"modal-content\">\r\n");
      out.write("                <div class=\"modal-headerSucesso\">\r\n");
      out.write("                  <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\r\n");
      out.write("                  <h4 class=\"modal-title\" id=\"myModalLabelSucesso\"></h4>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"modal-body\" id=\"myModalBodySucesso\">                  \r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"modal-footer\">\r\n");
      out.write("                  <button type=\"button\" id=\"modalButtonDefault\" class=\"btn btn-default\" data-dismiss=\"modal\">Cancelar</button>\r\n");
      out.write("                  <button type=\"button\" id=\"modalButtonPrimary\" class=\"btn btn-primary\" data-dismiss=\"modal\">OK</button>\r\n");
      out.write("                  <button type=\"button\" id=\"modalButtonSucess\" class=\"btn btn-sucess\">Salvar</button>\r\n");
      out.write("                </div>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div> ");
      out.write("\n");
      out.write("        ");
      out.write("<nav class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("        <div class=\"navbar-header\">\r\n");
      out.write("            <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\r\n");
      out.write("                <span class=\"icon-bar\"></span>\r\n");
      out.write("                <span class=\"icon-bar\"></span>\r\n");
      out.write("                <span class=\"icon-bar\"></span>\r\n");
      out.write("            </button>\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"/Projeto_Teste_Software/ControllerRedirecionar?page=/Projeto_Teste_Software/Views/Menu/Menu.jsp\">OptTeste</a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\r\n");
      out.write("            <ul class=\"nav navbar-nav\">\r\n");
      out.write("\r\n");
      out.write("                <li>\r\n");
      out.write("                    <a href=\"/Projeto_Teste_Software/ControllerRedirecionar?page=/Projeto_Teste_Software/Views/Menu/Menu.jsp\"><span class=\"glyphicon glyphicon-home\"></span> Home</a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"dropdown\">\r\n");
      out.write("                    <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Projeto <span class=\"caret\"></span></a>\r\n");
      out.write("                    <ul class=\"dropdown-menu\">\r\n");
      out.write("                        <li><a href=\"/Projeto_Teste_Software/Controller?classe=ControllerLogicProjetoSoftware&acao=criar&etapa=BD\">Novo Projeto</a></li>  \r\n");
      out.write("                        <li><a href=\"/Projeto_Teste_Software/Controller?classe=ControllerLogicProjetoSoftware&acao=listar\">Abrir Projeto</a></li>\r\n");
      out.write("                        <li><a href=\"/Projeto_Teste_Software/ControllerRedirecionar?page=/Projeto_Teste_Software/Views/Menu/Menu.jsp\">Fechar</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"dropdown\">\r\n");
      out.write("                    <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Cadastros Basicos <span class=\"caret\"></span></a>\r\n");
      out.write("                    <ul class=\"dropdown-menu\">\r\n");
      out.write("                        <li><a href=\"/Projeto_Teste_Software/Controller?classe=ControllerLogicCicloVida&acao=listar\">1 - Ciclos de Vida</a></li>\r\n");
      out.write("                        <li><a href=\"/Projeto_Teste_Software/Controller?classe=ControllerLogicCaracteristicaAgilidade&acao=listar\">2 - Caracter&iacute;sticas de Agilidade</a></li>\r\n");
      out.write("                        <li><a href=\"/Projeto_Teste_Software/Controller?classe=ControllerLogicPraticasAgeis&acao=listar\">3 - Pr&aacute;ticas &Aacute;geis</a></li>\r\n");
      out.write("                        <li><a href=\"/Projeto_Teste_Software/Controller?classe=ControllerLogicEtapasTesteSoftware&acao=listar\">4 - Etapas de Teste de Software</a></li>\r\n");
      out.write("                        <li><a href=\"/Projeto_Teste_Software/Controller?classe=ControllerLogicComplexidadeProblema&acao=listar\">5 - Indicador de Complexidade do Problema</a></li>\r\n");
      out.write("                        <li><a href=\"/Projeto_Teste_Software/Controller?classe=ControllerLogicInstabilidadeRequisito&acao=listar\">6 - Indicador de Instabilidade dos Requisitos</a></li>\r\n");
      out.write("                        <li><a href=\"/Projeto_Teste_Software/Controller?classe=ControllerLogicTamanhoEquipe&acao=listar\">7 - Faixa de Tamanho das Equipes</a></li>\r\n");
      out.write("                        <li><a href=\"/Projeto_Teste_Software/Controller?classe=ControllerLogicDuracaoProjeto&acao=listar\">8 - Faixa de Dura&ccedil;&atilde;o dos Projetos</a></li>\r\n");
      out.write("                        <li><a href=\"/Projeto_Teste_Software/Controller?classe=ControllerLogicCriticidadeProjeto&acao=listar\">9 - Criticidade dos Projetos</a></li>\r\n");
      out.write("                        <li><a href=\"/Projeto_Teste_Software/Controller?classe=ControllerLogicPlataformaExecucao&acao=listar\">10 - Plataforma de Execu&ccedil;&atilde;o</a></li>\r\n");
      out.write("                        <li><a href=\"/Projeto_Teste_Software/Controller?classe=ControllerLogicDominioAplicacao&acao=listar\">11 - Dom&iacute;nio da Aplica&ccedil;&atilde;o</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <!--li class=\"dropdown\">\r\n");
      out.write("                    <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Relat&oacute;rios <span class=\"caret\"></span></a>\r\n");
      out.write("                <ul class=\"dropdown-menu\">\r\n");
      out.write("                 <li><a href=\"main.php?relatorio=1&page=relatorioSala\">Turma x Sala</a></li>\r\n");
      out.write("                 <li><a href=\"#\">Turma x Professor</a></li>\r\n");
      out.write("                 <li><a href=\"#\">Turma x Disciplina</a></li>\r\n");
      out.write("                 <li><a href=\"#\">Turma x Departamento</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                </li -->\r\n");
      out.write("            </ul>\r\n");
      out.write("            <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("                <li><a href=\"/Projeto_Teste_Software/ControllerRedirecionar?page=/Projeto_Teste_Software/Views/Menu/Perfil.jsp\"><span class=\"glyphicon glyphicon-user\"></span> Perfil</a></li>\r\n");
      out.write("                <li><a href=\"help.php\"><span class=\"glyphicon glyphicon-book\"></span> Ajuda</a></li>\r\n");
      out.write("                <li><a onclick=\"return sair(); return false;\" href=\"#\"><span class=\"glyphicon glyphicon-log-in\"></span> Sair</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>");
      out.write("\n");
      out.write("        \n");
      out.write("        <input type=\"hidden\" id=\"erro\" value=\"");
      out.print(request.getAttribute("errosEncerrarAvaliacaoEficacia"));
      out.write("\" />\n");
      out.write("        <div class=\"cadastrosBasicos\">\n");
      out.write("            <form name=\"fEscolhaCaracteristicasAgilidade\" id=\"fEscolhaCaracteristicasAgilidade\" onSubmit=\"return salvar_avaliacao_eficacia(); return false;\" action=\"/Projeto_Teste_Software/Controller?classe=ControllerLogicProjetoSoftware&acao=encerrarAvaliacao&id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projetoSoftware.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&etapa=AE\" method=\"POST\" >\n");
      out.write("            <legend>Avaliação de Eficácia</legend>\n");
      out.write("                <p>Responda as perguntas abaixo avaliando a eficácia das atividades desempenhadas durante o teste de software.</p>\n");
      out.write("                <label for=\"id_\">Identificador do Projeto</label>\n");
      out.write("                <input type=\"text\" readonly=\"true\" class=\"form-control\" id=\"id\" name=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projetoSoftware.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                    <br>\n");
      out.write("                    <label>Quanto ao processo como um todo, como você avalia o resultado das práticas para o processo de testes?</label>\n");
      out.write("                    <div class=\"selectContainer\" style=\"height: auto; width: auto; max-width: 30%;\">\n");
      out.write("                        <select class=\"form-control\" name=\"comboProjeto");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projetoSoftware.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                            <option value=\"\">Escolha o Resultado</option>\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                    <label>Observações</label>\n");
      out.write("                    <textarea rows=\"4\" class=\"form-control\" id=\"observacaoProjeto");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projetoSoftware.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"observacaoProjeto");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projetoSoftware.dc_observacao}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"  maxlength=\"1000\" placeholder=\"Insira a observação quanto à prática \" >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projetoSoftware.dc_observacao}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</textarea>\n");
      out.write("                    <br>\n");
      out.write("                <a href=\"/Projeto_Teste_Software/Controller?classe=ControllerLogicProjetoSoftware&acao=editarPopular&id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projetoSoftware.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&etapa=PAXET\" >\n");
      out.write("                    <button type=\"button\" id=\"btnProximo\" class=\"btn btn-primary\" >\n");
      out.write("                        <font>\n");
      out.write("                            <font>Voltar</font>\n");
      out.write("                        </font>\n");
      out.write("                    </button>\n");
      out.write("                </a>\n");
      out.write("                <button type=\"reset\" id=\"btnCancelar\" class=\"btn btn-primary\" >Cancelar</button>\n");
      out.write("                <button type=\"submit\" id=\"btnSalvar\" onSubmit=\"return salvar_avaliacao_eficacia(); return false;\" class=\"btn btn-primary\" >Encerrar Avaliação</button>\n");
      out.write("                <!--a href=\"/Projeto_Teste_Software/Controller?classe=ControllerLogicProjetoSoftware&acao=editarPopular&id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projetoSoftware.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&etapa=PAXET\" >\n");
      out.write("                    <button type=\"button\" id=\"btnProximo\" class=\"btn btn-primary\" >\n");
      out.write("                        <font>\n");
      out.write("                            <font>Ir para Avaliação do Projeto</font>\n");
      out.write("                        </font>\n");
      out.write("                    </button>\n");
      out.write("                </a-->\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("    <script>\n");
      out.write("        $('#btnCancelar').click(function(){\n");
      out.write("            var title = \"\"; \n");
      out.write("            var retorno = \"true\";\n");
      out.write("            var msg = \"\";\n");
      out.write("\n");
      out.write("            title = \"Cancelamento da Operação\";\n");
      out.write("            msg = \"<h4> Tem certeza que deseja cancelar a operação? Esta ação não irá salvar as informações. </h4>\";\n");
      out.write("\n");
      out.write("            var modalConfirmacao = $('#myModalConfirmacao');\n");
      out.write("            modalConfirmacao.find('#myModalLabelConfirmacao').html(\"Atenção: \" + title);\n");
      out.write("            modalConfirmacao.find('#myModalBodyConfirmacao').html(msg);\n");
      out.write("            modalConfirmacao.find('#idmodalButtonSucess').hide(\"slow\");\n");
      out.write("            modalConfirmacao.modal();\n");
      out.write("        });\n");
      out.write("        \n");
      out.write("        $('#idmodalButtonDefault').click(function()\n");
      out.write("        {\n");
      out.write("            $('#myModalConfirmacao').hide();\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        $('#idmodalButtonPrimary').click(function()\n");
      out.write("        {\n");
      out.write("            //var acao = \"cancelar\";\n");
      out.write("            var page = \"/Projeto_Teste_Software/Views/Menu/Menu.jsp\";\n");
      out.write("            var url = url = '../../ControllerRedirecionar';\n");
      out.write("            var title = \"\";\n");
      out.write("            var msg = \"\";\n");
      out.write("            var modalErro = \"Erro\";\n");
      out.write("            window.location.href = \"/Projeto_Teste_Software/Controller?classe=ControllerLogicProjetoSoftware&acao=listar\";\n");
      out.write("        });\n");
      out.write("    </script>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("avaliacaoEficacia");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listaAvaliacaoEficacia}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                    <label for=\"id_pratica\">Prática Ágil</label>\n");
          out.write("                    <input type=\"text\" readonly=\"true\" class=\"form-control\" id=\"pratica\" name=\"pratica\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${praticasAgeisDAO.buscar(avaliacaoEficacia.id_pratica_agil)}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                    <label>Qual o grau em que a prática foi adotada e seguida pela equipe?</label>\n");
          out.write("                    <div class=\"selectContainer\" style=\"height: auto; width: auto; max-width: 30%;\">\n");
          out.write("                        <select class=\"form-control\" name=\"comboQ1");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${avaliacaoEficacia.id_pratica_agil}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                            <option value=\"\">Escolha o Grau</option>\n");
          out.write("                            ");
          if (_jspx_meth_c_forEach_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("                        </select>\n");
          out.write("                    </div>\n");
          out.write("                    <br>\n");
          out.write("                    <label>Qual o nível de contribuição para o sucesso das atividades de teste?</label>\n");
          out.write("                    <div class=\"selectContainer\" style=\"height: auto; width: auto; max-width: 30%;\">\n");
          out.write("                        <select class=\"form-control\" name=\"comboQ2");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${avaliacaoEficacia.id_pratica_agil}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                            <option value=\"\">Escolha o Nível</option>\n");
          out.write("                            ");
          if (_jspx_meth_c_forEach_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("                        </select>\n");
          out.write("                    </div>\n");
          out.write("                    <label>Observação</label>\n");
          out.write("                    <textarea rows=\"3\" class=\"form-control\" id=\"observacaoPratica");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${avaliacaoEficacia.id_pratica_agil}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" name=\"observacaoPratica");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${avaliacaoEficacia.id_pratica_agil}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"  maxlength=\"500\" placeholder=\"Insira a observação quanto à prática \" >");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${avaliacaoEficacia.dc_observacao}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</textarea>\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_forEach_1.setVar("valorAvaliacaoEficacia");
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${valoresAvaliacaoEficacia}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                ");
          if (_jspx_meth_c_choose_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
            return true;
          out.write("                                            \n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_choose_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
    if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    ");
        if (_jspx_meth_c_when_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
          return true;
        out.write("\n");
        out.write("                                    ");
        if (_jspx_meth_c_otherwise_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
          return true;
        out.write("\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_choose_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
    return false;
  }

  private boolean _jspx_meth_c_when_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_0.setPageContext(_jspx_page_context);
    _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${avaliacaoEficacia.ic_grau_pratica_adotado.sigla == valorAvaliacaoEficacia.sigla}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
    if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                        <option value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${valorAvaliacaoEficacia.sigla}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\" selected=\"true\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${valorAvaliacaoEficacia.nome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</option>\n");
        out.write("                                    ");
        int evalDoAfterBody = _jspx_th_c_when_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
    return false;
  }

  private boolean _jspx_meth_c_otherwise_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_otherwise_0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_otherwise_0.setPageContext(_jspx_page_context);
    _jspx_th_c_otherwise_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    int _jspx_eval_c_otherwise_0 = _jspx_th_c_otherwise_0.doStartTag();
    if (_jspx_eval_c_otherwise_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                        <option value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${valorAvaliacaoEficacia.sigla}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write('"');
        out.write('>');
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${valorAvaliacaoEficacia.nome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</option>\n");
        out.write("                                    ");
        int evalDoAfterBody = _jspx_th_c_otherwise_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_otherwise_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
      return true;
    }
    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_2.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_forEach_2.setVar("valorAvaliacaoEficacia");
    _jspx_th_c_forEach_2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${valoresAvaliacaoEficacia}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_2 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_2 = _jspx_th_c_forEach_2.doStartTag();
      if (_jspx_eval_c_forEach_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                ");
          if (_jspx_meth_c_choose_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_2, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
            return true;
          out.write("                                            \n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_2.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_2);
    }
    return false;
  }

  private boolean _jspx_meth_c_choose_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_1 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_1.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_2);
    int _jspx_eval_c_choose_1 = _jspx_th_c_choose_1.doStartTag();
    if (_jspx_eval_c_choose_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    ");
        if (_jspx_meth_c_when_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_1, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
          return true;
        out.write("\n");
        out.write("                                    ");
        if (_jspx_meth_c_otherwise_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_1, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
          return true;
        out.write("\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_choose_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_1);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_1);
    return false;
  }

  private boolean _jspx_meth_c_when_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_1 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_1.setPageContext(_jspx_page_context);
    _jspx_th_c_when_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_1);
    _jspx_th_c_when_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${avaliacaoEficacia.ic_nivel_contribuicao.sigla == valorAvaliacaoEficacia.sigla}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_1 = _jspx_th_c_when_1.doStartTag();
    if (_jspx_eval_c_when_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                        <option value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${valorAvaliacaoEficacia.sigla}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\" selected=\"true\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${valorAvaliacaoEficacia.nome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</option>\n");
        out.write("                                    ");
        int evalDoAfterBody = _jspx_th_c_when_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
    return false;
  }

  private boolean _jspx_meth_c_otherwise_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_otherwise_1 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_otherwise_1.setPageContext(_jspx_page_context);
    _jspx_th_c_otherwise_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_1);
    int _jspx_eval_c_otherwise_1 = _jspx_th_c_otherwise_1.doStartTag();
    if (_jspx_eval_c_otherwise_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                        <option value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${valorAvaliacaoEficacia.sigla}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write('"');
        out.write('>');
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${valorAvaliacaoEficacia.nome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</option>\n");
        out.write("                                    ");
        int evalDoAfterBody = _jspx_th_c_otherwise_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_otherwise_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_1);
      return true;
    }
    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_1);
    return false;
  }

  private boolean _jspx_meth_c_forEach_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_3 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_3.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_3.setParent(null);
    _jspx_th_c_forEach_3.setVar("resultadoPratica");
    _jspx_th_c_forEach_3.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resultadosPraticas}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_3 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_3 = _jspx_th_c_forEach_3.doStartTag();
      if (_jspx_eval_c_forEach_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                ");
          if (_jspx_meth_c_choose_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_3, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
            return true;
          out.write("                                            \n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_3.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_3);
    }
    return false;
  }

  private boolean _jspx_meth_c_choose_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_2 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_2.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_3);
    int _jspx_eval_c_choose_2 = _jspx_th_c_choose_2.doStartTag();
    if (_jspx_eval_c_choose_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    ");
        if (_jspx_meth_c_when_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_2, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
          return true;
        out.write("\n");
        out.write("                                    ");
        if (_jspx_meth_c_otherwise_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_2, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
          return true;
        out.write("\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_choose_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_2);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_2);
    return false;
  }

  private boolean _jspx_meth_c_when_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_2 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_2.setPageContext(_jspx_page_context);
    _jspx_th_c_when_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_2);
    _jspx_th_c_when_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projetoSoftware.ic_resultado_praticas.sigla == resultadoPratica.sigla}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_2 = _jspx_th_c_when_2.doStartTag();
    if (_jspx_eval_c_when_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                        <option value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resultadoPratica.sigla}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\" selected=\"true\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resultadoPratica.nome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</option>\n");
        out.write("                                    ");
        int evalDoAfterBody = _jspx_th_c_when_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_2);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_2);
    return false;
  }

  private boolean _jspx_meth_c_otherwise_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_otherwise_2 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_otherwise_2.setPageContext(_jspx_page_context);
    _jspx_th_c_otherwise_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_2);
    int _jspx_eval_c_otherwise_2 = _jspx_th_c_otherwise_2.doStartTag();
    if (_jspx_eval_c_otherwise_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                        <option value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resultadoPratica.sigla}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write('"');
        out.write('>');
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resultadoPratica.nome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</option>\n");
        out.write("                                    ");
        int evalDoAfterBody = _jspx_th_c_otherwise_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_otherwise_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_2);
      return true;
    }
    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_2);
    return false;
  }
}
