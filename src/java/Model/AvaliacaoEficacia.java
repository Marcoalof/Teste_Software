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
public class AvaliacaoEficacia implements Serializable
{
    private int id_projeto_software;
    private int id_pratica_agil;
    private ValoresAvaliacaoEficacia ic_grau_pratica_adotado;
    private ValoresAvaliacaoEficacia ic_nivel_contribuicao;
    private String dc_observacao;    

    public AvaliacaoEficacia() 
    {
        this.ic_grau_pratica_adotado = null;
        this.ic_nivel_contribuicao = null;
        this.dc_observacao = "";
    }
    
    public int getId_projeto_software() {
        return id_projeto_software;
    }

    public void setId_projeto_software(int id_projeto_software) {
        this.id_projeto_software = id_projeto_software;
    }

    public int getId_pratica_agil() {
        return id_pratica_agil;
    }

    public void setId_pratica_agil(int id_pratica_agil) {
        this.id_pratica_agil = id_pratica_agil;
    }

    public ValoresAvaliacaoEficacia getIc_grau_pratica_adotado() {
        return ic_grau_pratica_adotado;
    }

    public void setIc_grau_pratica_adotado(ValoresAvaliacaoEficacia ic_grau_pratica_adotado) {
        this.ic_grau_pratica_adotado = ic_grau_pratica_adotado;
    }

    public ValoresAvaliacaoEficacia getIc_nivel_contribuicao() {
        return ic_nivel_contribuicao;
    }

    public void setIc_nivel_contribuicao(ValoresAvaliacaoEficacia ic_nivel_contribuicao) {
        this.ic_nivel_contribuicao = ic_nivel_contribuicao;
    }

    public String getDc_observacao() {
        return dc_observacao;
    }

    public void setDc_observacao(String dc_observacao) {
        this.dc_observacao = dc_observacao;
    }
    
}
