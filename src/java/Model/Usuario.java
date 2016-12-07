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
public class Usuario implements Serializable
{
    private String nome;
    private String senha;
    private String email;
    
    public Usuario() 
    {
        this.nome = "";
        this.senha = "";
        this.email = "";
    }
    
    public Usuario(String nome, String senha, String email) 
    {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }
    
    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public String getSenha() 
    {
        return senha;
    }

    public void setSenha(String senha) 
    {
        this.senha = senha;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }
    
}
