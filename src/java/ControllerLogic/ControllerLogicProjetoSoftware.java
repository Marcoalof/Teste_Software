/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerLogic;

import Model.AmbienteFisico;
import Model.AvaliacaoEficacia;
import Model.CaracteristicaAgilidade;
import Model.ComplexidadeProblema;
import Model.CriticidadeProjeto;
import Model.DuracaoProjeto;
import Model.EtapasProjeto;
import Model.EtapasTesteSoftware;
import Model.InstabilidadeRequisito;
import Model.PraticasAgeis;
import Model.ProjetoSoftware;
import Model.ResultadoAvaliacao;
import Model.ResultadoPraticas;
import Model.Status;
import Model.TamanhoEquipe;
import Model.ValoresAvaliacaoEficacia;
import Persistence.AvaliacaoEficaciaDAO;
import Persistence.CaracteristicaAgilidadeDAO;
import Persistence.CicloVidaDAO;
import Persistence.ComplexidadeProblemaDAO;
import Persistence.CriticidadeProjetoDAO;
import Persistence.DominioAplicacaoDAO;
import Persistence.DuracaoProjetoDAO;
import Persistence.EtapasTesteSoftwareDAO;
import Persistence.InstabilidadeRequisitoDAO;
import Persistence.PlataformaExecucaoDAO;
import Persistence.PraticasAgeisDAO;
import Persistence.ProjetoSoftwareDAO;
import Persistence.TamanhoEquipeDAO;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marco Antônio
 */
@ManagedBean(name = "ProjetoSoftware", eager = true)
public class ControllerLogicProjetoSoftware implements ControllerLogic, Serializable
{
    
    public void criar(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            setAtributosDependentesProjeto(request);
            request.getRequestDispatcher("/Views/Projeto/InserirEditarDadosGerais.jsp?etapa=DB").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicProjetoSoftware.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao carregar Projeto de Software "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    @Override
    public void inserir(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            ProjetoSoftware ps = CarregarObjetoProjetoSoftware(request, true);
            int id = ProjetoSoftwareDAO.getInstance().saveProjetoSoftware(ps);
            if(id != -1)
            {
                ps.setId(id);
            }
            //Direcionar para a tela com a avaliação do % de adequação para utilização de abordagens ageis. Criar Parâmetro com % sugerido
            request.setAttribute("projetoSoftware", ps);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicProjetoSoftware&acao=editarPopular&id="+ps.getId()+"&etapa="+ps.getIc_etapa_atual().getSigla()).forward(request, response);
        } 
        catch (ServletException | IOException | ParseException | SQLException ex) 
        {
            Logger.getLogger(ControllerLogicProjetoSoftware.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao inserir novo Projeto "  + ex.getCause() + " " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControllerLogicProjetoSoftware.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void salvar(HttpServletRequest request, HttpServletResponse response) throws ParseException 
    {
        try 
        {
            EtapasProjeto etapaAtual = EtapasProjeto.retornaEtapaPelaSigla(request.getParameter("etapa"));
            boolean isGetParameterDADOS_BASICOS;
            boolean isGetParameterESCOLHA_CARACTERISTICAS_AGILIDADE;
            ProjetoSoftware ps;
            if(etapaAtual.equals(EtapasProjeto.DADOS_BASICOS)) //Se está nesta etapa
            {
                isGetParameterDADOS_BASICOS = true;
                ps = CarregarObjetoProjetoSoftware(request, isGetParameterDADOS_BASICOS);
                saveOrUpdate(request, ps);
                request.setAttribute("projetoSoftware", ps);
                request.getRequestDispatcher("/Controller?classe=ControllerLogicProjetoSoftware&acao=editarPopular&id="+ps.getId()+"&etapa="+ps.getIc_etapa_atual().getSigla()).forward(request, response);
            }
            else //Se não está
            {
                isGetParameterDADOS_BASICOS = false;
                ps = CarregarObjetoProjetoSoftware(request, isGetParameterDADOS_BASICOS);
                saveOrUpdate(request, ps);
                request.setAttribute("projetoSoftware", ps);
            }
            
            if(etapaAtual.equals(EtapasProjeto.ADEQUACAO_PROJETO_ABORDAGENS_AGEIS)) //Se está nesta etapa
            {
                ps.setIc_etapa_atual(etapaAtual);
                saveOrUpdate(request, ps);
                request.setAttribute("projetoSoftware", ps);
            }
            
            ArrayList<CaracteristicaAgilidade> caracteristicasAssociadas = new ArrayList();
            if(etapaAtual.equals(EtapasProjeto.ESCOLHA_CARACTERISTICAS_AGILIDADE)) //Se está nesta etapa
            {
                ps.setIc_etapa_atual(etapaAtual);
                if(ps.getDt_plan_agilidade() == null)
                {
                    Date data = new Date(System.currentTimeMillis());
                    SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
                    ps.setDt_plan_agilidade(sfd.parse(sfd.format(data)));
                }
                isGetParameterESCOLHA_CARACTERISTICAS_AGILIDADE = true;
                caracteristicasAssociadas = CarregarObjetosCaracteristicasSelecionadas(request, isGetParameterESCOLHA_CARACTERISTICAS_AGILIDADE, ps);
                saveOrUpdate(request, ps);
                request.setAttribute("projetoSoftware", ps);
                request.getRequestDispatcher("/Controller?classe=ControllerLogicProjetoSoftware&acao=editarPopular&id="+ps.getId()+"&etapa="+ps.getIc_etapa_atual().getSigla()).forward(request, response);
            }
            else //Se não está
            {
                isGetParameterESCOLHA_CARACTERISTICAS_AGILIDADE = false;
                caracteristicasAssociadas = CarregarObjetosCaracteristicasSelecionadas(request, isGetParameterESCOLHA_CARACTERISTICAS_AGILIDADE, ps);
                saveOrUpdate(request, ps);
                request.setAttribute("projetoSoftware", ps);
            }
            
            if(etapaAtual.equals(EtapasProjeto.PRATICAS_AGEIS_X_ETAPAS_TESTE)) //Se está nesta etapa
            {
                ps.setIc_etapa_atual(etapaAtual);
                String acao = request.getParameter("acao");
                if(acao != null)
                {
                    if(request.getParameter("acao").equals("salvar"))
                    {
                        if(ps.getIc_status() != Status.AVALIADO)
                        {
                            ps.setIc_status(Status.CONCLUÍDO);
                        }
                        Date data = new Date(System.currentTimeMillis());
                        SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
                        ps.setDt_fim_projeto(sfd.parse(sfd.format(data)));
                    }
                }
                saveOrUpdate(request, ps);
                request.setAttribute("projetoSoftware", ps);
                if(acao != null)
                {
                    if(request.getParameter("acao").equals("salvar"))
                    {
                        request.getRequestDispatcher("/Controller?classe=ControllerLogicProjetoSoftware&acao=editarPopular&id="+ps.getId()+"&etapa="+ps.getIc_etapa_atual().getSigla()).forward(request, response);
                    }
                }
            }
            
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicProjetoSoftware.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao editar Projeto de Software "  + ex.getCause() + " " + ex.getMessage());
        }
    }
    
    public void encerrarAvaliacao(HttpServletRequest request, HttpServletResponse response) throws ParseException 
    {
        try 
        {
            
            String msg = "";
                msg = "<h4> Os campos abaixo são de preenchimento obrigatório: </h4> <ol type='1' >";
            int id = Integer.parseInt(request.getParameter("id"));
            ProjetoSoftware ps;
            ps = ProjetoSoftwareDAO.getInstance().buscarProjetoSoftware(id);
            ArrayList<CaracteristicaAgilidade> lca = new ArrayList<>();
            ArrayList<PraticasAgeis> lpa = new ArrayList<>();
            lca = ProjetoSoftwareDAO.getInstance().recuperarCaracteristicasAssociadasAoProjeto(id);
            if(ps.getCaracteristicasAssociadas() == null)
            {
                ps.setCaracteristicasAssociadas(lca);
            }
            lpa = prepararEtapasTesteSoftwarePraticasAgeisXEtapasTeste(request, lca);
            String comboQ1 = "comboQ1";
            String comboQ2 = "comboQ2";
            String observacaoPratica = "observacaoPratica";
            String comboProjeto = "comboProjeto" + String.valueOf(id);
            String observacaoProjeto = "observacaoProjeto" + String.valueOf(id);
            String resultadoAvaliacaoAgilidadeProjeto = "resultadoAvaliacaoAgilidadeProjeto" + String.valueOf(id);
            String r_comboQ1 = "";
            String r_comboQ2 = "";
            String r_observacaoPratica = "";
            String r_comboProjeto = "";
            String r_observacaoProjeto = "";
            String r_resultadoAvaliacaoAgilidadeProjeto = "";
            ArrayList<AvaliacaoEficacia> lae = new ArrayList<>();
            AvaliacaoEficacia ae = null;
            for(int i = 0; i < lpa.size(); i++)
            {
                r_comboQ1 = "";
                r_comboQ2 = "";
                r_observacaoPratica = "";
                r_comboProjeto = "";
                r_observacaoProjeto = "";
                r_resultadoAvaliacaoAgilidadeProjeto = "";
                
                r_comboQ1 = request.getParameter(comboQ1+String.valueOf(lpa.get(i).getId()));
                r_comboQ2 = request.getParameter(comboQ2+String.valueOf(lpa.get(i).getId()));
                r_observacaoPratica = request.getParameter(observacaoPratica+String.valueOf(lpa.get(i).getId()));
                r_comboProjeto = request.getParameter(comboProjeto);
                r_observacaoProjeto = request.getParameter(observacaoProjeto);
                r_resultadoAvaliacaoAgilidadeProjeto = request.getParameter(resultadoAvaliacaoAgilidadeProjeto);
                
                if(r_comboQ1 != null || r_comboQ2 != null || r_comboProjeto != null || r_resultadoAvaliacaoAgilidadeProjeto != null)
                {
                    if(!r_comboQ1.equals("") || !r_comboQ2.equals("") || !r_comboProjeto.equals("") || !r_resultadoAvaliacaoAgilidadeProjeto.equals(""))
                    {
                        ae = new AvaliacaoEficacia();
                        if(!r_comboQ1.equals(""))
                        {
                            ae.setIc_grau_pratica_adotado(ValoresAvaliacaoEficacia.retornaValoresPelaSigla(r_comboQ1));
                        }
                        else
                        {
                            msg += "\n" + " <li> Campo Grau em que a Prática " + lpa.get(i).getNome() + " foi adotada é obrigatório; </li> ";
                        }
                        
                        if(!r_comboQ2.equals(""))
                        {
                            ae.setIc_nivel_contribuicao(ValoresAvaliacaoEficacia.retornaValoresPelaSigla(r_comboQ2));
                        }
                        else
                        {
                            msg += "\n" + " <li> Campo Nível de contribuição da Prática " + lpa.get(i).getNome() + " é obrigatório; </li> ";
                        }
                        
                        if(!r_comboProjeto.equals(""))
                        {
                            ps.setIc_resultado_praticas(ResultadoPraticas.retornaResultadoPelaSigla(r_comboProjeto));
                        }
                        else
                        {
                            msg += "\n" + " <li> Campo Nível de contribuição da Prática " + lpa.get(i).getNome() + " é obrigatório; </li> ";
                        }
                        
                        if(!r_resultadoAvaliacaoAgilidadeProjeto.equals(""))
                        {
                            ps.setIc_resultado_aval(ResultadoAvaliacao.retornaResultadoPelaSigla(r_resultadoAvaliacaoAgilidadeProjeto));
                        }
                        else
                        {
                            msg += "\n" + " <li> Campo Resultado da Avaliação do Projeto é obrigatório; </li> ";
                        }
                    }
                }
                
                if(ae != null)
                {
                    if(r_observacaoPratica != null)
                    {
                        if(!r_observacaoPratica.equals(""))
                        {
                            ae.setDc_observacao(r_observacaoPratica);
                        }
                    }
                    
                    if(r_observacaoProjeto != null)
                    {
                        if(!r_observacaoProjeto.equals(""))
                        {
                            ps.setDc_observacao(r_observacaoProjeto);
                        }
                    }
                    ae.setId_projeto_software(id);
                    ae.setId_pratica_agil(lpa.get(i).getId());
                    lae.add(ae);
                    ae = null;
                }
            }
            if(msg.equals("<h4> Os campos abaixo são de preenchimento obrigatório: </h4> <ol type='1' >"))
            {
               msg = ""; 
               AvaliacaoEficaciaDAO.getInstance().inserirAvaliacoesDeEficacia(lae);
               ps.setAvaliacaoEficacia(lae);
               Date data = new Date(System.currentTimeMillis());
               SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
               ps.setDt_aval_agilidade(sfd.parse(sfd.format(data)));
               saveOrUpdate(request, ps);
            }
            else
            {
                msg = msg + "</ol>";
                request.setAttribute("listaAvaliacaoEficaciaEncerrar", lae);
                request.setAttribute("projetoSoftwareEncerrar", ps);
            }
            request.setAttribute("errosEncerrarAvaliacaoEficacia", msg);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicProjetoSoftware&acao=editarPopular&id="+ps.getId()+"&etapa="+ps.getIc_etapa_atual().getSigla()).forward(request, response);
            //request.getRequestDispatcher("/Views/Projeto/AvaliacaoEficacia.jsp?id="+ps.getId()+"&etapa="+ps.getIc_etapa_atual().getSigla()).forward(request, response);
            
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(ControllerLogicProjetoSoftware.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao editar Projeto de Software "  + ex.getCause() + " " + ex.getMessage());
        }
    }
    
    @Override
    public void editarPopular(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            EtapasProjeto etapaAtual = EtapasProjeto.retornaEtapaPelaSigla(request.getParameter("etapa"));
            int id = Integer.parseInt(request.getParameter("id"));
            ProjetoSoftware ps;
            if(etapaAtual.equals(EtapasProjeto.DADOS_BASICOS)) //Se está nesta etapa
            {
                ps = prepararEtapaDadosBasicos(request, id);
                request.setAttribute("projetoSoftware", ps);
                request.getRequestDispatcher("/Views/Projeto/InserirEditarDadosGerais.jsp?id="+ps.getId()+"&etapa="+ps.getIc_etapa_atual().getSigla()).forward(request, response);
            }
            else
            {
                ps = prepararEtapaDadosBasicos(request, id);
                request.setAttribute("projetoSoftware", ps);
            }
            
            if(etapaAtual.equals(EtapasProjeto.ADEQUACAO_PROJETO_ABORDAGENS_AGEIS)) //Se está nesta etapa
            {
                salvar(request, response);
                String[][] listParametros = prepararAdequacaoProjetoAbordagensAgeis(request, ps);
                request.setAttribute("listaParametros", listParametros);
                request.getRequestDispatcher("/Views/Projeto/AdequacaoAbordagensAgeis.jsp?id="+ps.getId()+"&etapa="+ps.getIc_etapa_atual().getSigla()).forward(request, response);
            }
            ArrayList<CaracteristicaAgilidade> caracteristicasAssociadas = new ArrayList();
            ArrayList<CaracteristicaAgilidade> caracteristicas = new ArrayList();
            if(etapaAtual.equals(EtapasProjeto.ESCOLHA_CARACTERISTICAS_AGILIDADE)) //Se está nesta etapa
            {
                caracteristicasAssociadas = prepararEtapaEscolhaCaracteristicasAgilidadeAssociadas(request, ps);
                caracteristicas = prepararEtapaEscolhaCaracteristicasAgilidade(request, ps, caracteristicasAssociadas);
                request.setAttribute("caracteristicasAssociadas", caracteristicasAssociadas);
                request.setAttribute("caracteristicas", caracteristicas);
                ArrayList<String[][]> praticasAssociadas = recuperarPraticasAssociadasAsCaracteristicasDoProjeto(request, ps);
                request.setAttribute("praticasAssociadas", praticasAssociadas);
                request.getRequestDispatcher("/Views/Projeto/EscolhaCaracteristicasAgilidade.jsp?id="+ps.getId()+"&etapa="+ps.getIc_etapa_atual().getSigla()).forward(request, response);
            }
            else
            {
                caracteristicasAssociadas = prepararEtapaEscolhaCaracteristicasAgilidadeAssociadas(request, ps);
                caracteristicas = prepararEtapaEscolhaCaracteristicasAgilidade(request, ps, caracteristicasAssociadas);
                request.setAttribute("caracteristicasAssociadas", caracteristicasAssociadas);
                request.setAttribute("caracteristicas", caracteristicas);
                ArrayList<String[][]> praticasAssociadas = recuperarPraticasAssociadasAsCaracteristicasDoProjeto(request, ps);
                request.setAttribute("praticasAssociadas", praticasAssociadas);
            }
            
            ArrayList<EtapasTesteSoftware> ets = new ArrayList<>();
            ArrayList<PraticasAgeis> lpa = new ArrayList<>();
            if(etapaAtual.equals(EtapasProjeto.PRATICAS_AGEIS_X_ETAPAS_TESTE)) //Se está nesta etapa
            {
                salvar(request, response);
                ets = EtapasTesteSoftwareDAO.getInstance().listar(); 
                lpa = prepararEtapasTesteSoftwarePraticasAgeisXEtapasTeste(request, caracteristicasAssociadas);
                String[][] etapasTeste = recuperarEtapasTesteAssociadasAsPraticasAgeis(request, ets, lpa);
                request.setAttribute("etapasTeste", etapasTeste);
                request.setAttribute("linhas", lpa.size() + 1);
                request.setAttribute("colunas", ets.size() +1);
                request.getRequestDispatcher("/Views/Projeto/PraticasAgeisXEtapasTeste.jsp?id="+ps.getId()+"&etapa="+ps.getIc_etapa_atual().getSigla()).forward(request, response);
            }
            else
            {
                ets = EtapasTesteSoftwareDAO.getInstance().listar(); 
                lpa = prepararEtapasTesteSoftwarePraticasAgeisXEtapasTeste(request, caracteristicasAssociadas);
                String[][] etapasTeste = recuperarEtapasTesteAssociadasAsPraticasAgeis(request, ets, lpa);
                request.setAttribute("etapasTeste", etapasTeste);
                request.setAttribute("linhas", lpa.size() + 1);
                request.setAttribute("colunas", ets.size() +1);
            }
            ArrayList<AvaliacaoEficacia> lae = new ArrayList<>();
            if(etapaAtual.equals(EtapasProjeto.AVALIACAO_EFICACIA)) //Se está nesta etapa
            {
                if(ps.getIc_etapa_atual() != etapaAtual)
                {
                    ps.setIc_etapa_atual(etapaAtual);                    
                    saveOrUpdate(request, ps);
                    request.setAttribute("projetoSoftware", ps);
                }
                ProjetoSoftware pse = (ProjetoSoftware) request.getAttribute("projetoSoftwareEncerrar");
                if(pse != null)
                {
                    if(pse.getDc_observacao() != null)
                    {
                        if(!pse.getDc_observacao().equals(""))
                        {
                            ps.setDc_observacao(pse.getDc_observacao());
                        }
                    }

                    if(pse.getIc_resultado_praticas() != null)
                    {
                        ps.setIc_resultado_praticas(pse.getIc_resultado_praticas());
                    }
                }
                
                if(request.getAttribute("listaAvaliacaoEficaciaEncerrar") == null)
                {
                    if(ps.getAvaliacaoEficacia() == null) //Primeira vez na tela
                    {
                        lae = prepararEtapaAvaliacaoEficacia(request, ps, lpa);
                    }
                    else
                    {
                        lae = ps.getAvaliacaoEficacia();
                    }
                    request.setAttribute("listaAvaliacaoEficacia", lae);
                }
                else
                {
                    request.setAttribute("listaAvaliacaoEficacia", (ArrayList<AvaliacaoEficacia>) request.getAttribute("listaAvaliacaoEficaciaEncerrar"));
                }
                request.setAttribute("resultadoAvaliacoes", ResultadoAvaliacao.getAll());
                request.setAttribute("valoresAvaliacaoEficacia", ValoresAvaliacaoEficacia.getAll());
                request.setAttribute("resultadosPraticas", ResultadoPraticas.getAll());
                request.getRequestDispatcher("/Views/Projeto/AvaliacaoEficacia.jsp?id="+ps.getId()+"&etapa="+ps.getIc_etapa_atual().getSigla()).forward(request, response);
            }
            
        } 
        catch (IOException | SQLException | ClassNotFoundException | ParseException | ServletException ex) 
        {
            Logger.getLogger(ControllerLogicProjetoSoftware.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao carregar Projeto de Software"  + ex.getCause() + " " + ex.getMessage());
        }
    }
    
    @Override
    public void listar(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            request.setAttribute("projetos", ProjetoSoftwareDAO.getInstance().listar());
            request.getRequestDispatcher("/Views/Projeto/Index.jsp").forward(request, response);
        } 
        catch (ServletException | IOException | SQLException | ClassNotFoundException | ParseException ex) 
        {
            Logger.getLogger(ControllerLogicProjetoSoftware.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao listar os Projetos de Software "  + ex.getCause() + " " + ex.getMessage());
        }
    }

    private ProjetoSoftware CarregarObjetoProjetoSoftware(HttpServletRequest request, boolean isGetParameter) throws ParseException, ClassNotFoundException, SQLException 
    {
        ProjetoSoftware ps = new ProjetoSoftware();
        if(isGetParameter) //Está na página e deve buscar as informações via request.getParameter()
        {
            String s_id = request.getParameter("id");
            if(s_id != null)
            {
                ps.setId(Integer.parseInt(s_id));
            }
            else
            {
                ps.setId(0);
            }
            ps.setNome(request.getParameter("nome"));
            ps.setDescricao(request.getParameter("descricao"));
            ps.setIc_status(Status.retornaStatusPelaSigla(request.getParameter("comboStatus")));
            String dt_inicio_projeto = request.getParameter("dt_inicio_projeto");
            String dt_fim_projeto = request.getParameter("dt_fim_Projeto");
            SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
            if(dt_inicio_projeto != null && !dt_inicio_projeto.equals(""))
            {
                ps.setDt_inicio_projeto(sfd.parse(dt_inicio_projeto));
            }
            else
            {
                ps.setDt_inicio_projeto(null);
            }
            if(dt_fim_projeto != null && !dt_fim_projeto.equals(""))
            {
                ps.setDt_fim_projeto(sfd.parse(dt_fim_projeto));
            }
            else
            {
                ps.setDt_fim_projeto(null);
            }
            ps.setNome_resp_cliente(request.getParameter("respCliente"));
            ps.setNome_resp_desenv(request.getParameter("respDesenvolvimento"));
            String dt_plan_agilidade = request.getParameter("dt_plan_agilidade");
            String dt_aval_agilidade = request.getParameter("dt_aval_agilidade");
            if(dt_plan_agilidade != null && !dt_plan_agilidade.equals(""))
            {
                ps.setDt_plan_agilidade(sfd.parse(dt_plan_agilidade));
            }
            else
            {
                ps.setDt_plan_agilidade(null);
            }

            if(dt_aval_agilidade != null && !dt_aval_agilidade.equals(""))
            {
                ps.setDt_aval_agilidade(sfd.parse(dt_aval_agilidade));
            }
            else
            {
                ps.setDt_aval_agilidade(null);
            }
            ps.setIc_resultado_aval(ResultadoAvaliacao.retornaResultadoPelaSigla(request.getParameter("resultadoAvaliacaoAgilidade")));
            ps.setId_ciclo_vida(Integer.parseInt(request.getParameter("cicloVida")));
            ps.setId_duracao_projeto(Integer.parseInt(request.getParameter("duracaoProjeto")));
            ps.setId_complexidade_problema(Integer.parseInt(request.getParameter("complexidadeProblema")));
            ps.setId_instabilidade_requisitos(Integer.parseInt(request.getParameter("instabilidadeRequisito")));
            ps.setId_tamanho_equipe(Integer.parseInt(request.getParameter("tamanhoEquipe")));
            ps.setId_criticidade_projeto(Integer.parseInt(request.getParameter("criticidadeProjeto")));
            ps.setIc_ambiente_fisico(AmbienteFisico.retornaAmbientePelaSigla(request.getParameter("ambienteFisico")));
            ps.setId_plataforma_execucao(Integer.parseInt(request.getParameter("plataformaExecucao")));
            ps.setId_dominio_aplicacao(Integer.parseInt(request.getParameter("dominioAplicacao")));
            ps.setId_dominio_aplicacao(Integer.parseInt(request.getParameter("dominioAplicacao")));
            ps.setIc_etapa_atual(EtapasProjeto.retornaEtapaPelaSigla(request.getParameter("etapa")));
            ps.setIc_resultado_praticas(ResultadoPraticas.retornaResultadoPelaSigla(request.getParameter("ic_resultado_praticas")));
            String obs = request.getParameter("etapa");
            if(obs != null)
            {
                ps.setDc_observacao(obs);
            }
            else
            {
                ps.setDc_observacao("");
            }
            
        }
        else //Não está na página e deve buscar as informações via getAttribute
        {
            String s_id = request.getParameter("id");
            if(s_id != null)
            {
                ps = ProjetoSoftwareDAO.getInstance().buscarProjetoSoftware(Integer.parseInt(s_id));
            }
            else
            {
                ps = (ProjetoSoftware) request.getAttribute("projetoSoftware");
            }
        }
        return ps;
    }

    @Override
    public void excluir(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setAtributosDependentesProjeto(HttpServletRequest request) throws ClassNotFoundException, SQLException 
    {
        request.setAttribute("statusProjetos", Status.getAll());
        request.setAttribute("resultadoAvaliacoes", ResultadoAvaliacao.getAll());
        request.setAttribute("ciclosVida", CicloVidaDAO.getInstance().listar());
        request.setAttribute("duracoesProjeto", DuracaoProjetoDAO.getInstance().listar());
        request.setAttribute("complexidadeProblemas", ComplexidadeProblemaDAO.getInstance().listar());
        request.setAttribute("instabilidadeRequisitos", InstabilidadeRequisitoDAO.getInstance().listar());
        request.setAttribute("tamanhoEquipes", TamanhoEquipeDAO.getInstance().listar());
        request.setAttribute("criticidadeProjetos", CriticidadeProjetoDAO.getInstance().listar());
        request.setAttribute("ambientesFisico", AmbienteFisico.getAll());
        request.setAttribute("plataformaExecucoes", PlataformaExecucaoDAO.getInstance().listar());
        request.setAttribute("dominioAplicacoes", DominioAplicacaoDAO.getInstance().listar());
        request.setAttribute("etapasProjeto", EtapasProjeto.getAll());
    }
    
    /*

    @Override
    public void excluir(HttpServletRequest request, HttpServletResponse response) 
    {
        try 
        {
            int id = Integer.parseInt(request.getParameter("id"));
            PraticasAgeisDAO.getInstance().excluir(id);
            request.getRequestDispatcher("/Controller?classe=ControllerLogicPraticasAgeis&acao=listar").forward(request, response);
        } 
        catch (IOException | ServletException | SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ControllerLogicProjetoSoftware.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao excluir Prática Ágil "  + ex.getCause() + " " + ex.getMessage());
        }
    }
*/

    private void saveOrUpdate(HttpServletRequest request, ProjetoSoftware ps) throws SQLException, ClassNotFoundException 
    {
        if(ps.getId() == 0) //Se é para salvar a primeira vez
        {
            int id = ProjetoSoftwareDAO.getInstance().saveProjetoSoftware(ps);
            if(id != -1)
            {
                ps.setId(id);
            }
        }
        else //Se é para atualizar
        {
            ProjetoSoftwareDAO.getInstance().updateProjetoSoftware(ps);
        }
    }

    @Override
    public void editar(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private ProjetoSoftware prepararEtapaDadosBasicos(HttpServletRequest request, int id) throws ClassNotFoundException, SQLException, ParseException 
    {
        ProjetoSoftware ps = ProjetoSoftwareDAO.getInstance().buscarProjetoSoftware(id);
        setAtributosDependentesProjeto(request);
        return ps;
    }

    private String[][] prepararAdequacaoProjetoAbordagensAgeis(HttpServletRequest request, ProjetoSoftware ps) throws ClassNotFoundException, SQLException 
    {
        String[][] listaParametros = new String[7][5];
        DuracaoProjeto dp = DuracaoProjetoDAO.getInstance().buscar(ps.getId_duracao_projeto());
        ComplexidadeProblema cp = ComplexidadeProblemaDAO.getInstance().buscar(ps.getId_complexidade_problema());
        InstabilidadeRequisito ir = InstabilidadeRequisitoDAO.getInstance().buscar(ps.getId_instabilidade_requisitos());
        TamanhoEquipe te = TamanhoEquipeDAO.getInstance().buscar(ps.getId_tamanho_equipe());
        CriticidadeProjeto cproj = CriticidadeProjetoDAO.getInstance().buscar(ps.getId_criticidade_projeto());
        int somaMaximoPossivel = DuracaoProjetoDAO.getInstance().getMaiorPeso() + ComplexidadeProblemaDAO.getInstance().getMaiorPeso() + InstabilidadeRequisitoDAO.getInstance().getMaiorPeso() + TamanhoEquipeDAO.getInstance().getMaiorPeso() + CriticidadeProjetoDAO.getInstance().getMaiorPeso();
        int somaValoresInformados = dp.getPeso() + cp.getPeso() + ir.getPeso() + te.getPeso() + cproj.getPeso();
        listaParametros[0][0] = String.valueOf(dp.getId());
        listaParametros[0][1] = "Duração Estimada do Projeto";
        listaParametros[0][2] = dp.getNome();
        listaParametros[0][3] = String.valueOf(DuracaoProjetoDAO.getInstance().getMaiorPeso());
        listaParametros[0][4] = String.valueOf(dp.getPeso());
        
        listaParametros[1][0] = String.valueOf(cp.getId());
        listaParametros[1][1] = "Indicador de Complexidade do Problema";
        listaParametros[1][2] = cp.getNome();
        listaParametros[1][3] = String.valueOf(ComplexidadeProblemaDAO.getInstance().getMaiorPeso());
        listaParametros[1][4] = String.valueOf(cp.getPeso());
        
        listaParametros[2][0] = String.valueOf(ir.getId());
        listaParametros[2][1] = "Indicador de Instabilidade dos Requisitos";
        listaParametros[2][2] = ir.getNome();
        listaParametros[2][3] = String.valueOf(InstabilidadeRequisitoDAO.getInstance().getMaiorPeso());
        listaParametros[2][4] = String.valueOf(ir.getPeso());
        
        listaParametros[3][0] = String.valueOf(te.getId());
        listaParametros[3][1] = "Tamanho da Equipe do Projeto";
        listaParametros[3][2] = te.getNome();
        listaParametros[3][3] = String.valueOf(TamanhoEquipeDAO.getInstance().getMaiorPeso());
        listaParametros[3][4] = String.valueOf(te.getPeso());
        
        listaParametros[4][0] = String.valueOf(cproj.getId());
        listaParametros[4][1] = "Criticidade do Projeto";
        listaParametros[4][2] = cproj.getNome();
        listaParametros[4][3] = String.valueOf(CriticidadeProjetoDAO.getInstance().getMaiorPeso());
        listaParametros[4][4] = String.valueOf(cproj.getPeso());
        
        listaParametros[5][0] = "";
        listaParametros[5][1] = "TOTALIZADORES";
        listaParametros[5][2] = "";
        listaParametros[5][3] = String.valueOf(somaMaximoPossivel);
        listaParametros[5][4] = String.valueOf(somaValoresInformados);
        
        DecimalFormat df = new DecimalFormat("#.##");
        listaParametros[6][0] = "";
        listaParametros[6][1] = "Grau de Adequação do Projeto com Abordagens Ágeis";
        listaParametros[6][2] = "";
        listaParametros[6][3] = "";
        listaParametros[6][4] = df.format((double)(somaValoresInformados*100)/somaMaximoPossivel);
        
        return listaParametros;
    }

    private ArrayList<CaracteristicaAgilidade> prepararEtapaEscolhaCaracteristicasAgilidade(HttpServletRequest request, ProjetoSoftware ps, ArrayList<CaracteristicaAgilidade> caracteristicasAssociadas) throws ClassNotFoundException, SQLException 
    {
        ArrayList<CaracteristicaAgilidade> caracteristicas;
        caracteristicas = CaracteristicaAgilidadeDAO.getInstance().listarCaracteristicasComPratica();
        caracteristicas = removerTodosEmB(caracteristicas, caracteristicasAssociadas);
        return caracteristicas;
    }
    
    private ArrayList<CaracteristicaAgilidade> prepararEtapaEscolhaCaracteristicasAgilidadeAssociadas(HttpServletRequest request, ProjetoSoftware ps) throws ClassNotFoundException, SQLException 
    {
        ArrayList<CaracteristicaAgilidade> carateristicasAssociadas = new ArrayList();
        if(ps.getCaracteristicasAssociadas() != null)
        {
            carateristicasAssociadas = ps.getCaracteristicasAssociadas();
        }
        return carateristicasAssociadas;
    }

    private ArrayList<CaracteristicaAgilidade> removerTodosEmB(ArrayList<CaracteristicaAgilidade> a, ArrayList<CaracteristicaAgilidade> b)
    {
        ArrayList<CaracteristicaAgilidade> caux = new ArrayList<>();
        if(b != null)
        {
            caux.addAll(b);
            for(int i = 0; i < caux.size(); i++) 
            {   
                for(int j = 0; j < a.size(); j++) 
                {
                    if(a.get(j).getId() == b.get(i).getId())
                    {
                        a.remove(j);
                        break;
                    }
                }
            }
        }
        return a;
    }

    private ArrayList<CaracteristicaAgilidade> CarregarObjetosCaracteristicasSelecionadas(HttpServletRequest request, boolean getParameterESCOLHA_CARACTERISTICAS_AGILIDADE, ProjetoSoftware ps) throws ClassNotFoundException, SQLException 
    {
        ArrayList<CaracteristicaAgilidade> caracteristicasAssociadas = new ArrayList<>();
        if(getParameterESCOLHA_CARACTERISTICAS_AGILIDADE) //Está na página e deve buscar as informações via request.getParameter()
        {
            caracteristicasAssociadas = recuperarCaracteristicasAssociadas(request.getParameterValues("listDestino"));
        }
        else //Não está na página e deve buscar as informações via getAttibute
        {
            caracteristicasAssociadas = (ArrayList<CaracteristicaAgilidade>) request.getAttribute("caracteristicasAssociadas");
        }
        ps.setCaracteristicasAssociadas(caracteristicasAssociadas);
        return caracteristicasAssociadas;
    }
    
    private ArrayList<CaracteristicaAgilidade> recuperarCaracteristicasAssociadas(String[] caracteristicasAssociadas) throws ClassNotFoundException, SQLException
    {
        if(caracteristicasAssociadas != null)
        {
            ArrayList<CaracteristicaAgilidade> lc = new ArrayList<>();
            for(int i = 0; i < caracteristicasAssociadas.length; i++)
            {
                lc.add(CaracteristicaAgilidadeDAO.getInstance().buscar(Integer.parseInt(caracteristicasAssociadas[i])));
            }
            return lc;
        }
        else
        {
            return null;
        }
    }

    private ArrayList<String[][]> recuperarPraticasAssociadasAsCaracteristicasDoProjeto(HttpServletRequest request, ProjetoSoftware ps) throws ClassNotFoundException, SQLException 
    {
        int i = 0, j = 0, k = 0;
        ArrayList<PraticasAgeis> lp = new ArrayList<>();
        ArrayList<PraticasAgeis> lpAll = new ArrayList<>();
        ArrayList<String[][]> listaParametros = new ArrayList<>();
        for(i = 0 ; i < ps.getCaracteristicasAssociadas().size(); i++)
        {
            String[][] parametro = new String[1][5];
            lp = CaracteristicaAgilidadeDAO.getInstance().getPraticasAssociadasACaracteristica(ps.getCaracteristicasAssociadas().get(i).getId());
            lpAll.addAll(lp);
            for(j = 0; j < lp.size(); j++)
            {
                
                parametro[0][0] = String.valueOf(ps.getCaracteristicasAssociadas().get(i).getId());
                parametro[0][1] = ps.getCaracteristicasAssociadas().get(i).getNome();
                parametro[0][2] = String.valueOf(lp.get(j).getId());
                parametro[0][3] = lp.get(j).getNome();
                parametro[0][4] = calculaGrauAgilidadeEmPotencialPratica(ps, lp.get(j));
                if(listaParametros.size() == 0)
                {
                    parametro[0][4] += "%";
                    listaParametros.add(parametro);
                }
                else
                {
                    for(k = 0; k < listaParametros.size(); k++)
                    {
                        if(Double.parseDouble(parametro[0][4].replaceAll(",", ".")) >= Double.parseDouble(listaParametros.get(k)[0][4].replaceAll("%", "").replaceAll(",", ".")))
                        {
                            parametro[0][4] += "%";
                            listaParametros.add(k, parametro);
                            break;
                        }
                        else if(k == listaParametros.size()-1)
                        {
                            parametro[0][4] += "%";
                            listaParametros.add(parametro);
                            break;
                        }
                    }
                }
            }
            
            if(lp.size() == 0)
            {
                parametro[0][0] = String.valueOf(ps.getCaracteristicasAssociadas().get(i).getId());
                parametro[0][1] = ps.getCaracteristicasAssociadas().get(i).getNome();
                parametro[0][2] = "-";
                parametro[0][3] = "-";
                parametro[0][4] = "0";
                listaParametros.add(parametro);
            }
            parametro = null;
        }
        
        return listaParametros;
    }

    private String calculaGrauAgilidadeEmPotencialPratica(ProjetoSoftware ps, PraticasAgeis pa) throws ClassNotFoundException, SQLException 
    {
        ArrayList<CaracteristicaAgilidade> lcp = new ArrayList<>();
        ArrayList<CaracteristicaAgilidade> lca = new ArrayList<>();
        ArrayList<CaracteristicaAgilidade> aux = new ArrayList<>();
        int i = 0, j = 0;
        double valor = 0.00;
        DecimalFormat df = new DecimalFormat("#.##");
        lcp = ps.getCaracteristicasAssociadas();
        lca = PraticasAgeisDAO.getInstance().recuperarCaracteristicasAssociadasAPratica(pa.getId());
        aux.addAll(lca);
        for(i = 0; i < lcp.size(); i++)
        {
            for(j = 0; j < aux.size(); j++)
            {
                if(aux.get(j).getId() == lcp.get(i).getId())
                {
                    aux.remove(j);
                    j--;
                }
            }
        }
        for(i = 0; i < aux.size(); i++)
        {
            for(j = 0; j < lca.size(); j++)
            {
                if(lca.get(j).getId() == aux.get(i).getId())
                {
                    lca.remove(j);
                    j--;
                }
            }
        }
        
        for(i = 0; i < lca.size(); i++)
        {
            valor += lca.get(i).getPertinencia();
        }
        return df.format((((valor*pa.getPertinencia())/lcp.size())/100));
    }

    private ArrayList<PraticasAgeis> prepararEtapasTesteSoftwarePraticasAgeisXEtapasTeste(HttpServletRequest request, ArrayList<CaracteristicaAgilidade> caracteristicasAssociadas) throws ClassNotFoundException, SQLException 
    {
        int i = 0, j = 0, k = 0;
        String ids = "";
        ArrayList<PraticasAgeis> lp = new ArrayList<>();
        for(i = 0 ; i < caracteristicasAssociadas.size(); i++)
        {
            if(i == 0)
            {
                ids += String.valueOf(caracteristicasAssociadas.get(i).getId());
            }
            else
            {
                ids += ", " + String.valueOf(caracteristicasAssociadas.get(i).getId());
            }
        }
        lp = CaracteristicaAgilidadeDAO.getInstance().getPraticasAssociadasAsCaracteristicas(ids);
        return lp;
    }

    private String[][] recuperarEtapasTesteAssociadasAsPraticasAgeis(HttpServletRequest request, ArrayList<EtapasTesteSoftware> ets, ArrayList<PraticasAgeis> pa) 
    {        
        int i = 0, j = 0, k = 0;   
        int linhas = pa.size() + 1; //Adicionando o cabeçalho com Nome Prática
        int colunas = ets.size() +1; //Adicionando o cabeçalho com Nome da Etapa de Teste
        String resultado = "";
        ArrayList<PraticasAgeis> lp = new ArrayList<>();
        String[][] parametro = new String[linhas][colunas];
        for(i = 0 ; i < colunas; i++)
        {
            if(i == 0)
            {
                lp = ets.get(i).getPraticasAssociadas();
            }
            else
            {
                lp = ets.get(i-1).getPraticasAssociadas();
            }
            for(j = 0; j < linhas; j++)
            {
                if(i == 0) //Preenche as práticas;
                {
                    if(j == 0) //Primeiro item é vazio. Interseção entre Etapas de Teste e Práticas
                    {
                        parametro[j][i] = "";
                    }
                    else //Preenche as Práticas 
                    {
                        parametro[j][i] = pa.get(j-1).getNome();
                    }
                }
                else if(j == 0) //Preenche as Etapas de Teste
                {
                    parametro[j][i] = ets.get(i-1).getNome();
                }
                else //Preenche se existe ou não relacionamento entre elas;
                {
                    resultado = "";
                    //Testar se a etapa de teste contém a prática que está sendo percorrida, se sim, deve inserir X, senão Vazio
                    for(k = 0; k < lp.size(); k++)
                    {
                        if(pa.get(j-1).getId() == lp.get(k).getId())
                        {
                            resultado = "X";
                            break;
                        }
                    }
                    parametro[j][i] = resultado;
                }
            }
        }
        
        return parametro;
    }
    
    private ArrayList<AvaliacaoEficacia> prepararEtapaAvaliacaoEficacia(HttpServletRequest request, ProjetoSoftware ps, ArrayList<PraticasAgeis> pa)
    {
        ArrayList<AvaliacaoEficacia> lae = new ArrayList<>();
        AvaliacaoEficacia ae;
        for(int i = 0; i < pa.size(); i++)
        {
            ae = new AvaliacaoEficacia();
            ae.setId_projeto_software(ps.getId());
            ae.setId_pratica_agil(pa.get(i).getId());
            ae.setIc_grau_pratica_adotado(null);
            ae.setIc_nivel_contribuicao(null);
            ae.setDc_observacao("");
            lae.add(ae);
        }
        return lae;
    }
}