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
public enum Status 
{    
    INICIADO("I", "Iniciado"),
    CONCLUÍDO("C", "Concluído"),
    AVALIADO("A", "Avaliado");

    private final String sigla;
    private final String nome;

    Status(String sigla, String nome)
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
    
    public static ArrayList<Status> getAll()
    {
        ArrayList<Status> ls = new ArrayList<>();
        ls.add(Status.INICIADO);
        ls.add(Status.CONCLUÍDO);
        ls.add(Status.AVALIADO);
        return ls;
    }
    
    public static Status retornaStatusPelaSigla(String sigla)
    {
        if(Status.INICIADO.getSigla().equals(sigla))
        {
            return Status.INICIADO;
        }
        else if(Status.CONCLUÍDO.getSigla().equals(sigla))
        {
            return Status.CONCLUÍDO;
        }
        else if(Status.AVALIADO.getSigla().equals(sigla))
        {
            return Status.AVALIADO;
        }
        else
        {
            return null;
        }
    }
}
