/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Tarefa;

/**
 *
 * @author willi
 */
public class TaskTabelModel extends AbstractTableModel{
    
    String[] colunas = {"Nome", "Descrição", "Prazo", "Tarefa Concluída", "Editar", "Excluir"};
    List<Tarefa> tarefas = new ArrayList();

    @Override
    public int getRowCount() {
        return tarefas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return colunas[columnIndex];     
    }
    
    
    public boolean isCellEditable(int rowIndex, int columnIndex){
       return columnIndex == 3; 
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        
        if(tarefas.isEmpty()){
            return Object.class;
        }
        
        return this.getValueAt(0, columnIndex).getClass();
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        tarefas.get(rowIndex).setStatus((boolean) aValue);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex){
            
            case 0:
                return tarefas.get(rowIndex).getNome();
                
            case 1:
                return tarefas.get(rowIndex).getDescricao();
                
            case 2:
                SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
                return date.format(tarefas.get(rowIndex).getDatalimite());
                
            case 3:
                return tarefas.get(rowIndex).getStatus();
                
            case 4:
                return "";
                
            case 5:
                return "";
            
            default:
                return "Dados não encontrados";
        }
        
        
    }

    public String[] getColunas() {
        return colunas;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
    
    
    
}
