
package model;
import java.util.Date;
import util.TaskTabelModel;


public class Tarefa {
    
    private int id;
    private int idprojeto;
    private String nome;
    private String descricao;
    private boolean status;
    private String observacao;
    private Date datalimite;
    private Date datacriacao;
    private Date dataatualizacao;
    
    public Tarefa(){
        
        this.status = false;
        this.datacriacao = new Date();
        this.dataatualizacao = new Date();
    }

    //public Tarefa(int id, int idprojeto, String nome, String descricao, boolean status, String observacao, Date datalimite, Date datacriacao, Date dataatualizacao) {
        
    public Tarefa(String nome, String descricao, boolean status, String observacao, Date datalimite, Date datacriacao, Date dataatualizacao) {
        //this.id = id;
        //this.idprojeto = idprojeto;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.observacao = observacao;
        this.datalimite = datalimite;
        this.datacriacao = datacriacao;
        this.dataatualizacao = dataatualizacao;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public int getIdprojeto() {
        return idprojeto;
    }

    public void setIdprojeto(int idprojeto) {
        this.idprojeto = idprojeto;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDatalimite() {
        return datalimite;
    }

    public void setDatalimite(Date datalimite) {
        this.datalimite = datalimite;
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
        return "Tarefa{" + "id=" + id + ", idprojeto=" + idprojeto + ", nome=" + nome + ", descricao=" + descricao + ", status=" + status + ", observacao=" + observacao + ", datalimite=" + datalimite + ", datacriacao=" + datacriacao + ", dataatualizacao=" + dataatualizacao + '}';
    }
    
    
    
    
}
