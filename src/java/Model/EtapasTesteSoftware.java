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
public class EtapasTesteSoftware implements Serializable
{
    private int id;
    private String nome;  
    private String descricao;  
    private String produtoTrabalhoProduzido;
    private ArrayList<PraticasAgeis> praticasAssociadas;
    
    public EtapasTesteSoftware() 
    {
        this.nome = "";
        this.descricao = "";
        this.produtoTrabalhoProduzido = "";
        this.praticasAssociadas = null;
    }
    
    public int getId() 
    {
        return id;
    }
    
    public void setId(int id) 
    {
        this.id = id;
    }
    
    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }
    
    public String getDescricao() 
    {
        return descricao;
    }

    public void setDescricao(String descricao) 
    {
        this.descricao = descricao;
    }
    
    public String getProdutoTrabalhoProduzido() 
    {
        return descricao;
    }

    public void setProdutoTrabalhoProduzido(String produtoTrabalhoProduzido) 
    {
        this.produtoTrabalhoProduzido = produtoTrabalhoProduzido;
    }

    public ArrayList<PraticasAgeis> getPraticasAssociadas() 
    {
        return praticasAssociadas;
    }

    public void setPraticasAssociadas(ArrayList<PraticasAgeis> praticasAssociadas) 
    {
        this.praticasAssociadas = praticasAssociadas;
    }
}
