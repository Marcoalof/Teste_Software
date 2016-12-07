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
public enum AmbienteFisico 
{
    DISTRIBUÍDO("D", "Distribuído"),
    LOCALIZADO("L", "Localizado");

    private final String sigla;
    private final String nome;

    AmbienteFisico(String sigla, String nome)
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
    
    public static ArrayList<AmbienteFisico> getAll()
    {
        ArrayList<AmbienteFisico> af = new ArrayList<>();
        af.add(AmbienteFisico.DISTRIBUÍDO);
        af.add(AmbienteFisico.LOCALIZADO);
        return af;
    }
    
    public static AmbienteFisico retornaAmbientePelaSigla(String sigla)
    {
        if(AmbienteFisico.DISTRIBUÍDO.getSigla().equals(sigla))
        {
            return AmbienteFisico.DISTRIBUÍDO;
        }
        else if(AmbienteFisico.LOCALIZADO.getSigla().equals(sigla))
        {
            return AmbienteFisico.LOCALIZADO;
        }
        else
        {
            return null;
        }
    }
}
