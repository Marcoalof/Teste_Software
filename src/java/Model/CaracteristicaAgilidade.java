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
    
    public CaracteristicaAgilidade() 
    {
        this.nome = "";
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

}