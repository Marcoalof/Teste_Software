/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
//sun.util.calendar.BaseCalendar.Date;

/**
 *
 * @author Marco Antônio
 */
public class ProjetoSoftware implements Serializable
{
    private int id;
    private String nome;
    private String descricao;
    private Status ic_status;
    private Date dt_inicio_projeto;
    private Date dt_fim_projeto;
    private String nome_resp_cliente;
    private String nome_resp_desenv;
    private Date dt_plan_agilidade;
    private Date dt_aval_agilidade;
    private ResultadoAvaliacao ic_resultado_aval;
    private int id_ciclo_vida;
    private int id_duracao_projeto;
    private int id_complexidade_problema;
    private int id_instabilidade_requisitos;
    private int id_tamanho_equipe;
    private int id_criticidade_projeto;
    private AmbienteFisico ic_ambiente_fisico;
    private int id_plataforma_execucao;
    private int id_dominio_aplicacao;
    private EtapasProjeto ic_etapa_atual;
    private ResultadoPraticas ic_resultado_praticas;
    private String dc_observacao;
    private ArrayList<CaracteristicaAgilidade> caracteristicasAssociadas;
    private ArrayList<AvaliacaoEficacia> avaliacaoEficacia;

    public ProjetoSoftware() 
    {
        this.nome = "";
        this.descricao = "";
        this.ic_status = Status.INICIADO;
        this.dt_inicio_projeto = null;
        this.dt_fim_projeto = null;
        this.nome_resp_cliente = "";
        this.nome_resp_desenv = "";
        this.dt_plan_agilidade = null;
        this.dt_aval_agilidade = null;
        this.ic_resultado_aval = null;
        this.id_ciclo_vida = 0;
        this.id_duracao_projeto = 0;
        this.id_complexidade_problema = 0;
        this.id_instabilidade_requisitos = 0;
        this.id_tamanho_equipe = 0;
        this.id_criticidade_projeto = 0;
        this.ic_ambiente_fisico = null;
        this.id_plataforma_execucao = 0;
        this.id_dominio_aplicacao = 0;
        this.ic_etapa_atual = null;
        this.ic_resultado_praticas = null;
        this.dc_observacao = "";
        this.caracteristicasAssociadas = null;
        this.avaliacaoEficacia = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getIc_status() {
        return ic_status;
    }

    public void setIc_status(Status ic_status) {
        this.ic_status = ic_status;
    }

    public Date getDt_inicio_projeto() {
        return dt_inicio_projeto;
    }

    public void setDt_inicio_projeto(Date dt_inicio_projeto) {
        this.dt_inicio_projeto = dt_inicio_projeto;
    }

    public Date getDt_fim_projeto() {
        return dt_fim_projeto;
    }

    public void setDt_fim_projeto(Date dt_fim_projeto) {
        this.dt_fim_projeto = dt_fim_projeto;
    }

    public String getNome_resp_cliente() {
        return nome_resp_cliente;
    }

    public void setNome_resp_cliente(String nome_resp_cliente) {
        this.nome_resp_cliente = nome_resp_cliente;
    }

    public String getNome_resp_desenv() {
        return nome_resp_desenv;
    }

    public void setNome_resp_desenv(String nome_resp_desenv) {
        this.nome_resp_desenv = nome_resp_desenv;
    }

    public Date getDt_plan_agilidade() {
        return dt_plan_agilidade;
    }

    public void setDt_plan_agilidade(Date dt_plan_agilidade) {
        this.dt_plan_agilidade = dt_plan_agilidade;
    }

    public Date getDt_aval_agilidade() {
        return dt_aval_agilidade;
    }

    public void setDt_aval_agilidade(Date dt_aval_agilidade) {
        this.dt_aval_agilidade = dt_aval_agilidade;
    }

    public ResultadoAvaliacao getIc_resultado_aval() {
        return ic_resultado_aval;
    }

    public void setIc_resultado_aval(ResultadoAvaliacao ic_resultado_aval) {
        this.ic_resultado_aval = ic_resultado_aval;
    }

    public int getId_ciclo_vida() {
        return id_ciclo_vida;
    }

    public void setId_ciclo_vida(int id_ciclo_vida) {
        this.id_ciclo_vida = id_ciclo_vida;
    }

    public int getId_duracao_projeto() {
        return id_duracao_projeto;
    }

    public void setId_duracao_projeto(int id_duracao_projeto) {
        this.id_duracao_projeto = id_duracao_projeto;
    }

    public int getId_complexidade_problema() {
        return id_complexidade_problema;
    }

    public void setId_complexidade_problema(int id_complexidade_problema) {
        this.id_complexidade_problema = id_complexidade_problema;
    }

    public int getId_instabilidade_requisitos() {
        return id_instabilidade_requisitos;
    }

    public void setId_instabilidade_requisitos(int id_instabilidade_requisitos) {
        this.id_instabilidade_requisitos = id_instabilidade_requisitos;
    }

    public int getId_tamanho_equipe() {
        return id_tamanho_equipe;
    }

    public void setId_tamanho_equipe(int id_tamanho_equipe) {
        this.id_tamanho_equipe = id_tamanho_equipe;
    }

    public int getId_criticidade_projeto() {
        return id_criticidade_projeto;
    }

    public void setId_criticidade_projeto(int id_criticidade_projeto) {
        this.id_criticidade_projeto = id_criticidade_projeto;
    }

    public AmbienteFisico getIc_ambiente_fisico() {
        return ic_ambiente_fisico;
    }

    public void setIc_ambiente_fisico(AmbienteFisico ic_ambiente_fisico) {
        this.ic_ambiente_fisico = ic_ambiente_fisico;
    }

    public int getId_plataforma_execucao() {
        return id_plataforma_execucao;
    }

    public void setId_plataforma_execucao(int id_plataforma_execucao) {
        this.id_plataforma_execucao = id_plataforma_execucao;
    }

    public int getId_dominio_aplicacao() {
        return id_dominio_aplicacao;
    }

    public void setId_dominio_aplicacao(int id_dominio_aplicacao) {
        this.id_dominio_aplicacao = id_dominio_aplicacao;
    }
    
    public EtapasProjeto getIc_etapa_atual() {
        return ic_etapa_atual;
    }

    public void setIc_etapa_atual(EtapasProjeto ic_etapa_atual) {
        this.ic_etapa_atual = ic_etapa_atual;
    }
    
    public ResultadoPraticas getIc_resultado_praticas() {
        return ic_resultado_praticas;
    }

    public void setIc_resultado_praticas(ResultadoPraticas ic_resultado_praticas) {
        this.ic_resultado_praticas = ic_resultado_praticas;
    }
    
    public String getDc_observacao() {
        return dc_observacao;
    }

    public void setDc_observacao(String dc_observacao) {
        this.dc_observacao = dc_observacao;
    }
    
    public ArrayList<CaracteristicaAgilidade> getCaracteristicasAssociadas() 
    {
        return caracteristicasAssociadas;
    }

    public void setCaracteristicasAssociadas(ArrayList<CaracteristicaAgilidade> caracteristicasAssociadas) 
    {
        this.caracteristicasAssociadas = caracteristicasAssociadas;
    }
    
    public ArrayList<AvaliacaoEficacia> getAvaliacaoEficacia() 
    {
        return avaliacaoEficacia;
    }

    public void setAvaliacaoEficacia(ArrayList<AvaliacaoEficacia> avaliacaoEficacia) 
    {
        this.avaliacaoEficacia = avaliacaoEficacia;
    }
    
}
