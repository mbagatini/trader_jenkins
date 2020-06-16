/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO;
import entidade.Acao;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author morgana
 */
public class AcaoDAO implements IDAO<Acao> {

    public String validaDados(Acao acao) {

        if (acao.getPreco() <= 0) {
            return "Preço da ação inválido";
        }

        String acaoNome = acao.getNome().trim();

        if (acaoNome.equals("") ||  acao.getNome() == null) {
            return "Nome da ação invalido";
        }

        return null;

    }

    @Override
    public String salvar(Acao objeto) {
        try {
            String sql = "INSERT INTO acao VALUES (DEFAULT,"
                    + "'" + objeto.getNome() + "', "
                    + "'" + objeto.getPreco() + "')";

            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e);
            return e.toString();
        }
        return null;
    }

    @Override
    public String atualizar(Acao o) {
        try {
            String sql = "UPDATE acao SET "
                    + "nome = '" + o.getNome() + "', "
                    + "preco = '" + o.getPreco() + "'"
                    + "WHERE id = " + o.getId();

            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e);
            return e.toString();
        }
        return null;
    }

    public String excluir(int id) {
        try {
            String sql = "DELETE FROM acao "
                    + "WHERE id = " + id;

            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e);
            return e.toString();
        }
        return null;
    }

    @Override
    public ArrayList<Acao> consultarTodos() {
        ArrayList<Acao> obj = new ArrayList<>();

        try {
            String sql = "SELECT * FROM acao"
                    + " ORDER BY nome ";

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                Acao u = new Acao();

                u.setId(resultado.getInt("id"));
                u.setNome(resultado.getString("nome"));
                u.setPreco(resultado.getFloat("preco"));

                obj.add(u);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        return obj;
    }

    @Override
    public ArrayList<Acao> consultar(String criterio) {
        ArrayList<Acao> obj = new ArrayList<>();

        try {
            String sql = "SELECT * FROM acao"
                    + " WHERE " + criterio
                    + " ORDER BY nome ";

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                Acao u = new Acao();

                u.setId(resultado.getInt("id"));
                u.setNome(resultado.getString("nome"));
                u.setPreco(resultado.getFloat("preco"));

                obj.add(u);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        return obj;
    }

    @Override
    public String excluir(String cnpj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Acao consultarId(int id) {
        Acao obj = new Acao();

        try {
            String sql = "SELECT * FROM acao"
                    + " WHERE id = " + id;

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                obj.setId(resultado.getInt("id"));
                obj.setNome(resultado.getString("nome"));
                obj.setPreco(resultado.getFloat("preco"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        return obj;
    }

    public String atualizarGlobal(Acao o) {
        try {
            String sql = "UPDATE acao SET "
                    + "nome = '" + o.getNome() + "', "
                    + "preco = '" + o.getPreco() + "'"
                    + "WHERE id = " + o.getId();

            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

            sql = "UPDATE carteira SET "
                    + "valor = '" + o.getPreco() + "'"
                    + "WHERE acao = " + o.getId();

            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e);
            return e.toString();
        }
        return null;
    }

}
