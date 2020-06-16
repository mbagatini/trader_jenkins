/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import entidade.Carteira;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author morgana
 */
public class jtmCarteira extends AbstractTableModel {
    
    private ArrayList<Carteira> obj;
    private String[] colunas = {"Código", "Nome", "Preço", "Quantidade"};

    public jtmCarteira(ArrayList<Carteira> obj) {
        this.obj = obj;
    }

    public ArrayList<Carteira> getAcoes() {
        return obj;
    }

    public void setAcoes(ArrayList<Carteira> obj) {
        this.obj = obj;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }

    public void addRow(Carteira obj) {
        this.obj.add(obj);
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return this.obj.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return obj.get(linha).getAcao().getId();
            case 1:
                return obj.get(linha).getAcao().getNome();
            case 2:
                return obj.get(linha).getValor();   
            case 3:
                return obj.get(linha).getQuantidade();  
        }

        return null;
    }

    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }
    
    public Carteira get(int linha){
        return this.obj.get(linha);
    }
    
    public void removeRow(int linha){
        this.obj.remove(linha);
        this.fireTableRowsUpdated(linha, linha);
    }
}
