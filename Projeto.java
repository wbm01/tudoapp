
package model;

import java.util.Date;
import util.TaskTabelModel;



public class Projeto {
    
    private int id;
    private String nome;
    private String descricao;
    private Date datacriacao;
    private Date dataatualizacao;

    public Projeto(int id, String nome, Date datacriacao, Date dataatualizacao) {
        this.id = id;
        this.nome = nome;
        this.datacriacao = datacriacao;
        this.dataatualizacao = dataatualizacao;
    }

    public Projeto() {
        this.datacriacao = new Date();
        this.dataatualizacao = new Date();
       
    }
    
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(Date datacriacao) {
        this.datacriacao = datacriacao;
    }

    public Date getDataatualizacao() {
        return dataatualizacao;
    }

    public void setDataatualizacao(Date dataatualizacao) {
        this.dataatualizacao = dataatualizacao;
    }
    
   

    @Override
    public String toString() {
        return this.nome;
    }

    
    
    
    
}
