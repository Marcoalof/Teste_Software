/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Marco Antônio
 */
public enum ResultadoAvaliacao 
{
    SUCESSO("S", "Sucesso"),
    FRACASSO("F", "Fracasso"),
    NÃO_DEFINIDO("N", "Não Definido");

    private final String sigla;
    private final String nome;

    ResultadoAvaliacao(String sigla, String nome)
    {
        this.sigla = sigla;
        this.nome = nome;
    }

    public String getSigla()
    {
        return sigla;
    }

    public String getNome()
    {
        return nome;
    }
    
    public static ArrayList<ResultadoAvaliacao> getAll()
    {
        ArrayList<ResultadoAvaliacao> lr = new ArrayList<>();
        lr.add(ResultadoAvaliacao.SUCESSO);
        lr.add(ResultadoAvaliacao.FRACASSO);
        lr.add(ResultadoAvaliacao.NÃO_DEFINIDO);
        return lr;
    }
    
    public static ResultadoAvaliacao retornaResultadoPelaSigla(String sigla)
    {
        if(ResultadoAvaliacao.SUCESSO.getSigla().equals(sigla))
        {
            return ResultadoAvaliacao.SUCESSO;
        }
        else if(ResultadoAvaliacao.FRACASSO.getSigla().equals(sigla))
        {
            return ResultadoAvaliacao.FRACASSO;
        }
        else if(ResultadoAvaliacao.NÃO_DEFINIDO.getSigla().equals(sigla))
        {
            return ResultadoAvaliacao.NÃO_DEFINIDO;
        }
        else
        {
            return null;
        }
    }
}