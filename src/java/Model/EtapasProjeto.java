/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Marco Antônio
 */
public enum EtapasProjeto implements Serializable
{    
    DADOS_BASICOS("DB", "Dados Básicos", 1),
    ADEQUACAO_PROJETO_ABORDAGENS_AGEIS("APAA", "Adequação do Projeto às Abordagens Ágeis", 2),
    ESCOLHA_CARACTERISTICAS_AGILIDADE("ECA", "Escolha das Características de Agilidade", 3),
    PRATICAS_AGEIS_X_ETAPAS_TESTE("PAXET", "Prática Ágeis x Etapas de Teste de Software", 4),
    AVALIACAO_EFICACIA("AE", "Avaliação de Eficácia", 5);

    private final String sigla;
    private final String nome;
    private final int ic_pagina;

    EtapasProjeto(String sigla, String nome, int ic_pagina)
    {
        this.sigla = sigla;
        this.nome = nome;
        this.ic_pagina = ic_pagina;
    }

    public String getSigla()
    {
        return sigla;
    }

    public String getNome()
    {
        return nome;
    }
    
    public int getIc_pagina()
    {
        return ic_pagina;
    }
    
    public static ArrayList<EtapasProjeto> getAll()
    {
        ArrayList<EtapasProjeto> ls = new ArrayList<>();
        ls.add(EtapasProjeto.DADOS_BASICOS);
        ls.add(EtapasProjeto.ADEQUACAO_PROJETO_ABORDAGENS_AGEIS);
        ls.add(EtapasProjeto.ESCOLHA_CARACTERISTICAS_AGILIDADE);
        ls.add(EtapasProjeto.PRATICAS_AGEIS_X_ETAPAS_TESTE);
        ls.add(EtapasProjeto.AVALIACAO_EFICACIA);
        
        return ls;
    }
    
    public static EtapasProjeto retornaEtapaPelaSigla(String sigla)
    {
        if(EtapasProjeto.DADOS_BASICOS.getSigla().equals(sigla))
        {
            return EtapasProjeto.DADOS_BASICOS;
        }
        else if(EtapasProjeto.ADEQUACAO_PROJETO_ABORDAGENS_AGEIS.getSigla().equals(sigla))
        {
            return EtapasProjeto.ADEQUACAO_PROJETO_ABORDAGENS_AGEIS;
        }
        else if(EtapasProjeto.ESCOLHA_CARACTERISTICAS_AGILIDADE.getSigla().equals(sigla))
        {
            return EtapasProjeto.ESCOLHA_CARACTERISTICAS_AGILIDADE;
        }
        else if(EtapasProjeto.PRATICAS_AGEIS_X_ETAPAS_TESTE.getSigla().equals(sigla))
        {
            return EtapasProjeto.PRATICAS_AGEIS_X_ETAPAS_TESTE;
        }
        else if(EtapasProjeto.AVALIACAO_EFICACIA.getSigla().equals(sigla))
        {
            return EtapasProjeto.AVALIACAO_EFICACIA;
        }
        else
        {
            return null;
        }
    }
    
    public static EtapasProjeto retornaProximaEtapa(EtapasProjeto etapaAtual)
    {
        if(EtapasProjeto.DADOS_BASICOS.getIc_pagina() == (etapaAtual.getIc_pagina()+1))
        {
            return EtapasProjeto.DADOS_BASICOS;
        }
        else if(EtapasProjeto.ADEQUACAO_PROJETO_ABORDAGENS_AGEIS.getIc_pagina() == (etapaAtual.getIc_pagina()+1))
        {
            return EtapasProjeto.ADEQUACAO_PROJETO_ABORDAGENS_AGEIS;
        }
        else if(EtapasProjeto.ESCOLHA_CARACTERISTICAS_AGILIDADE.getIc_pagina() == (etapaAtual.getIc_pagina()+1))
        {
            return EtapasProjeto.ESCOLHA_CARACTERISTICAS_AGILIDADE;
        }
        else if(EtapasProjeto.PRATICAS_AGEIS_X_ETAPAS_TESTE.getIc_pagina() == (etapaAtual.getIc_pagina()+1))
        {
            return EtapasProjeto.PRATICAS_AGEIS_X_ETAPAS_TESTE;
        }
        else if(EtapasProjeto.AVALIACAO_EFICACIA.getIc_pagina() == (etapaAtual.getIc_pagina()+1))
        {
            return EtapasProjeto.AVALIACAO_EFICACIA;
        }
        //Caso já esteja na última etapa;
        else if(EtapasProjeto.AVALIACAO_EFICACIA.getIc_pagina() == (etapaAtual.getIc_pagina()))
        {
            return EtapasProjeto.AVALIACAO_EFICACIA;
        }
        else
        {
            return null;
        }
    }
}
