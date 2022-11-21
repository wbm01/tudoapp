
package controler;

import java.util.List;
import model.Tarefa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.Conexao;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ControleTarefa {
    
    public void salvar(Tarefa t){
        
        String sql = "INSERT INTO tarefas (idprojeto, nome, descricao, status, observacao, datalimite, datacriacao, datatualizacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection c = null;
        
        PreparedStatement p = null;
        
        ResultSet r = null;
        
        try {
            
            c = Conexao.getConexao();
            p = c.prepareStatement(sql);
            p.setInt(1, t.getIdprojeto());
            p.setString(2, t.getNome());
            p.setString(3, t.getDescricao());
            p.setBoolean(4, t.getStatus());
            p.setString(5, t.getObservacao());
            p.setDate(6, new Date(t.getDatalimite().getTime()));
            p.setDate(7, new Date(t.getDatacriacao().getTime()));
            p.setDate(8, new Date(t.getDataatualizacao().getTime()));
            p.execute();
            
            
        } catch (Exception e) {
            
            throw new RuntimeException("Erro ao salvar a tarefa" + e.getMessage(), e);
        }
        finally{
            Conexao.closeConexao(c, p, r);
        }
        
        
        
        
    }
    
    public void atualizar(Tarefa t){
        
        String sql = "UPDATE tarefas SET idprojeto = ?, nome = ?, descricao = ?, status = ?, observacao = ?, datalimite = ?, datacriacao = ?, datatualizacao = ? WHERE id = ?";
        
        Connection c = null;
        PreparedStatement p = null;
        ResultSet r = null;
        
        try {
            c = Conexao.getConexao();
            p = c.prepareStatement(sql);
            p.setInt(1, t.getIdprojeto());
            p.setString(2, t.getNome());
            p.setString(3, t.getDescricao());
            p.setBoolean(4, t.getStatus());
            p.setString(5, t.getObservacao());
            p.setDate(6, new Date(t.getDatalimite().getTime()));
            p.setDate(7, new Date(t.getDatacriacao().getTime()));
            p.setDate(8, new Date(t.getDataatualizacao().getTime()));
            p.setInt(9, t.getId());
            p.execute();
            
        } catch (Exception e) {
            
            throw new RuntimeException("Erro ao atualizar a tarefa" + e.getMessage(),e);
        }
        finally{
            
            Conexao.closeConexao(c,p,r);  
    }
    }
    
    public void deletarId(int tId){
        
        String sql = "DELETE FROM tarefas WHERE id = ?";
        
        Connection c = null;
        
        PreparedStatement p = null;
        
        ResultSet r = null;
        
        try {
            
            c = Conexao.getConexao();
            p = c.prepareStatement(sql);
            p.setInt(1, tId);
            p.execute();
            
        } catch (SQLException e) {
            
            throw new RuntimeException("Erro ao deletar a tarefa" + e.getMessage(), e);
        
        }finally{
        
            Conexao.closeConexao(c, p, r);
            
        }
        
        
    }
    
    
    //public List <Tarefa> buscar(int idprojeto){
    
        public List <Tarefa> buscar(int id){
        
        String sql = "SELECT * FROM tarefas WHERE idprojeto = ?";
        
        List<Tarefa> tarefa = new ArrayList<>();
        
        Connection c = null;
        PreparedStatement p = null;
        ResultSet r = null;
        
         try {
            c = Conexao.getConexao();
            p = c.prepareStatement(sql);
            p.setInt(1, id);
            r = p.executeQuery();
       
            while(r.next()){
                
                Tarefa t = new Tarefa();
                
                t.setId(r.getInt("id"));
                t.setIdprojeto(r.getInt("idprojeto"));
                t.setNome(r.getString("nome"));
                t.setDescricao(r.getString("descricao"));
                t.setStatus(r.getBoolean("status"));
                t.setObservacao(r.getString("observacao"));
                t.setDatalimite(r.getDate("datalimite"));
                t.setDatacriacao(r.getDate("datacriacao"));
                t.setDataatualizacao(r.getDate("datatualizacao"));
                tarefa.add(t);
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao percorrer a lista." + e.getMessage(), e);
        }
        finally{
            Conexao.closeConexao(c,p,r);
        }
        
        return tarefa ;
        
    }

    
    }

