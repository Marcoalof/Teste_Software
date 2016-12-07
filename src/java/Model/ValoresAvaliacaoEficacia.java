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
public enum ValoresAvaliacaoEficacia 
{
    BAIXO("B", "Baixo"),
    MEDIO("M", "Médio"),
    ALTO("A", "Alto");

    private final String sigla;
    private final String nome;

    ValoresAvaliacaoEficacia(String sigla, String nome)
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
    
    public static ArrayList<ValoresAvaliacaoEficacia> getAll()
    {
        ArrayList<ValoresAvaliacaoEficacia> lr = new ArrayList<>();
        lr.add(ValoresAvaliacaoEficacia.BAIXO);
        lr.add(ValoresAvaliacaoEficacia.MEDIO);
        lr.add(ValoresAvaliacaoEficacia.ALTO);
        return lr;
    }
    
    public static ValoresAvaliacaoEficacia retornaValoresPelaSigla(String sigla)
    {
        if(ValoresAvaliacaoEficacia.BAIXO.getSigla().equals(sigla))
        {
            return ValoresAvaliacaoEficacia.BAIXO;
        }
        else if(ValoresAvaliacaoEficacia.MEDIO.getSigla().equals(sigla))
        {
            return ValoresAvaliacaoEficacia.MEDIO;
        }
        else if(ValoresAvaliacaoEficacia.ALTO.getSigla().equals(sigla))
        {
            return ValoresAvaliacaoEficacia.ALTO;
        }
        else
        {
            return null;
        }
    }
}