/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Marco Antônio
 */
public class CaracteristicaAgilidade implements Serializable
{
    private int id;
    private String nome;  
    private String descricao;  
    private double pertinencia;
    private double relevancia;
    
    public CaracteristicaAgilidade() 
    {
        this.nome = "";
        this.descricao = "";
        this.pertinencia = 0.00;
        this.relevancia = 0.00;
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

    public double getPertinencia() {
        return pertinencia;
    }

    public void setPertinencia(double pertinencia) {
        this.pertinencia = pertinencia;
    }

    public double getRelevancia() {
        return relevancia;
    }

    public void setRelevancia(double relevancia) {
        this.relevancia = relevancia;
    }
}
