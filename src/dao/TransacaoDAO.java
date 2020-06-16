/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO;
import entidade.Transacao;
import java.util.ArrayList;

/**
 *
 * @author morgana
 */
public class TransacaoDAO implements IDAO<Transacao> {

    public String persistirDados(Transacao objeto) {

        if (objeto.getAcao() == null) {
            return "A ação precisa ser válida";
        }

        if (objeto.getQuantidade() <= 0) {
            return "Quantidade deve ser maior que 1";
        }

        if (objeto.getValor() <= 0) {
            return "Valor da transação deve ser maior que 0";
        }

        if (objeto.getTipo() != 'C' && objeto.getTipo() != 'V') {
            return "Tipo da transação deve ser Compra ou Venda";
        }

        return null;
    }

    @Override
    public String salvar(Transacao objeto) {
        
        String validacao = persistirDados(objeto);
        if (validacao != null) {
            return validacao;
        }

        try {
            String sql = "INSERT INTO transacao VALUES (DEFAULT,"
                    + objeto.getUsuario().getId() + ", "
                    + objeto.getAcao().getId() + ","
                    + "current_timestamp,"
                    + objeto.getValor() + ","
                    + objeto.getQuantidade() + ","
                    + objeto.getValor() * objeto.getQuantidade() + ","
                    + "'" + objeto.getTipo() + "',"
                    + "current_timestamp,"
                    + "current_timestamp)";

            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e);
            return e.toString();
        }

        return null;
    }

    @Override
    public String atualizar(Transacao o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String excluir(String cnpj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Transacao> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Transacao> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Transacao consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
