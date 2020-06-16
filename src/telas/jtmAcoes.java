/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import entidade.Acao;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author morgana
 */
public class jtmAcoes extends AbstractTableModel {
    
    private ArrayList<Acao> acoes;
    private String[] colunas = {"Código", "Nome", "Preço"};

    public jtmAcoes(ArrayList<Acao> acoes) {
        this.acoes = acoes;
    }

    public ArrayList<Acao> getAcoes() {
        return acoes;
    }

    public void setAcoes(ArrayList<Acao> acoes) {
        this.acoes = acoes;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }

    public void addRow(Acao fornecedor) {
        this.acoes.add(fornecedor);
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return this.acoes.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return acoes.get(linha).getId();
            case 1:
                return acoes.get(linha).getNome();
            case 2:
                return acoes.get(linha).getPreco();          
        }

        return null;
    }

    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }
    
    public Acao get(int linha){
        return this.acoes.get(linha);
    }
    
    public void removeRow(int linha){
        this.acoes.remove(linha);
        this.fireTableRowsUpdated(linha, linha);
    }
}
