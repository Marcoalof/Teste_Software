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
public enum ResultadoPraticas 
{
    MUITO_RUIM("MR", "Muito Ruim"),
    RUIM("RU", "Ruim"),
    REGULAR("RE", "Regular"),
    BOM("BO", "Bom"),
    MUITO_BOM("MB", "Muito Bom");

    private final String sigla;
    private final String nome;

    ResultadoPraticas(String sigla, String nome)
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
    
    public static ArrayList<ResultadoPraticas> getAll()
    {
        ArrayList<ResultadoPraticas> lr = new ArrayList<>();
        lr.add(ResultadoPraticas.MUITO_RUIM);
        lr.add(ResultadoPraticas.RUIM);
        lr.add(ResultadoPraticas.REGULAR);
        lr.add(ResultadoPraticas.BOM);
        lr.add(ResultadoPraticas.MUITO_BOM);
        return lr;
    }
    
    public static ResultadoPraticas retornaResultadoPelaSigla(String sigla)
    {
        if(ResultadoPraticas.MUITO_RUIM.getSigla().equals(sigla))
        {
            return ResultadoPraticas.MUITO_RUIM;
        }
        else if(ResultadoPraticas.RUIM.getSigla().equals(sigla))
        {
            return ResultadoPraticas.RUIM;
        }
        else if(ResultadoPraticas.REGULAR.getSigla().equals(sigla))
        {
            return ResultadoPraticas.REGULAR;
        }
        else if(ResultadoPraticas.BOM.getSigla().equals(sigla))
        {
            return ResultadoPraticas.BOM;
        }
        else if(ResultadoPraticas.MUITO_BOM.getSigla().equals(sigla))
        {
            return ResultadoPraticas.MUITO_BOM;
        }
        else
        {
            return null;
        }
    }
}