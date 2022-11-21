
package controler;

import model.Projeto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.Conexao;
import model.Tarefa;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ControleProjeto {
    
    public void salvar (Projeto projeto){
        
        //String sql = "INSERT INTO projetos (id, nome, descricao, datacriacao, dataatualizacao) VALUES (?, ?, ?, ?, ?)";
        String sql = "INSERT INTO projetos (nome, descricao, datacriacao, dataatualizacao) VALUES (?, ?, ?, ?)";
        Connection c = null;
        PreparedStatement p = null;
        
        
        try {
            c = Conexao.getConexao();
            p = c.prepareStatement(sql);
            
            p.setString(1, projeto.getNome());
            p.setString(2, projeto.getDescricao());
            p.setDate(3, new Date (projeto.getDatacriacao().getTime()));
            p.setDate(4, new Date (projeto.getDataatualizacao().getTime()));
            
            
            p.execute();
                 
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o projeto" + e.getMessage(), e);
        }
        finally{
            Conexao.closeConexao(c,p);
        }
        
    }
    
    public void deletar(int idProjeto){

String sql = "DELETE FROM projetos WHERE id = ?";

Connection c = null;
PreparedStatement p = null;
ResultSet r = null;


try{

c = Conexao.getConexao();
p = c.prepareStatement(sql);

p.setInt(1, idProjeto);
p.execute();
}

catch(Exception e){
throw new RuntimeException("Erro ao deletar." + e.getMessage(), e);
}
finally{
Conexao.closeConexao(c,p,r);
}
}
    
public void atualizacao(Projeto projeto){

String sql = "UPDATE FROM projetos SET nome = ?, descricao = ?, datacriacao = ?, dataatualizacao = ? WHERE id = ?";

Connection c = null;
PreparedStatement p = null;
ResultSet r = null;

try{
c = Conexao.getConexao();
p = c.prepareStatement(sql);

p.setString(1, projeto.getNome());
p.setString(2, projeto.getDescricao());
p.setDate(3, new Date(projeto.getDatacriacao().getTime()));
p.setDate(4, new Date(projeto.getDataatualizacao().getTime()));
p.setInt(5, projeto.getId());
p.execute();
}

catch (Exception e){
throw new RuntimeException("Erro ao atualizar os dados." + e.getMessage(), e);
}

finally{
Conexao.closeConexao(c,p,r);
}
}

public List<Projeto> buscar(){

String sql = "SELECT * FROM projetos";

List<Projeto> projeto = new ArrayList<>();

Connection c = null;
PreparedStatement p = null;
ResultSet r = null;

try{
c = Conexao.getConexao();
p = c.prepareStatement(sql);
r = p.executeQuery();

while(r.next()){
    
    Projeto pro = new Projeto();
    
    pro.setId(r.getInt("id"));
    pro.setNome(r.getString("nome"));
    pro.setDescricao(r.getString("descricao"));
    pro.setDatacriacao(r.getDate("datacriacao"));
    pro.setDataatualizacao(r.getDate("dataatualizacao"));
    projeto.add(pro);
}
}

catch (SQLException e){
    throw new RuntimeException("Erro ao buscar o projeto." + e.getMessage(), e);
}

finally{
    Conexao.closeConexao(c,p,r);
}

return projeto;

}
}