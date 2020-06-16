/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO;
import entidade.Acao;
import entidade.Carteira;
import entidade.Transacao;
import entidade.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author morgana
 */
public class CarteiraDAO implements IDAO<Carteira> {
    
    public String persistirDados(Carteira objeto){
        
        if (objeto.getQuantidade() <= 0) {
            return "Quantidade deve ser maior que 1";
        }
        
        if (objeto.getValor() <= 0) {
            return "Valor da ação deve ser maior que 0";
        }
        
        if (objeto.getAcao() == null) {
            return "A ação precisa ser válida";
        }
        
        return null;
    }

    @Override
    public String salvar(Carteira objeto) {
        
        String validacao = persistirDados(objeto);
        if (persistirDados(objeto) != null) {
            return validacao;
        }
        
        try {
            // Atualiza
            String sql = "UPDATE carteira SET "
                    + "quantidade = quantidade + " + objeto.getQuantidade()
                    + "WHERE usuario = ?"
                    + "  AND acao = ?";
            
            PreparedStatement pstmt = ConexaoBD.getInstance().getConnection().prepareStatement(sql);
 
            pstmt.setInt(1, objeto.getUsuario().getId());
            pstmt.setInt(2, objeto.getAcao().getId());

            int resultado = pstmt.executeUpdate();
            
            // Se não atualizou, insere
            if (resultado == 0) {
                sql = "INSERT INTO carteira VALUES ("
                        + objeto.getUsuario().getId() + ", "
                        + objeto.getAcao().getId() + ","
                        + objeto.getValor() + ","
                        + objeto.getQuantidade() + ")";

                resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);
            }
            
            // Transação
            Transacao t = new Transacao(objeto.getUsuario(), 
                                        objeto.getAcao(), 
                                        objeto.getValor(), 
                                        objeto.getQuantidade(), 
                                        'C');
            String erro = new TransacaoDAO().salvar(t);

        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e);
            return e.toString();
        }
        return null;
    }

    @Override
    public String atualizar(Carteira objeto) {
        try {
            // Atualiza a carteira
            String sql = "UPDATE carteira SET "
                    + "quantidade = quantidade - " + objeto.getQuantidade()
                    + "WHERE usuario = ?"
                    + "  AND acao = ?";
            
            PreparedStatement pstmt = ConexaoBD.getInstance().getConnection().prepareStatement(sql);
 
            pstmt.setInt(1, objeto.getUsuario().getId());
            pstmt.setInt(2, objeto.getAcao().getId());

            int resultado = pstmt.executeUpdate();
            
            // Exclui as ações vendidas
            sql = "DELETE FROM carteira "
                + " WHERE usuario = ?"
                + " AND quantidade = 0";
            
            pstmt = ConexaoBD.getInstance().getConnection().prepareStatement(sql);
 
            pstmt.setInt(1, objeto.getUsuario().getId());
            
            resultado = pstmt.executeUpdate();
            
            // Transação
            Transacao t = new Transacao(objeto.getUsuario(), 
                                        objeto.getAcao(), 
                                        objeto.getValor(), 
                                        objeto.getQuantidade(), 
                                        'V');
            String erro = new TransacaoDAO().salvar(t);
            
        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e);
            return e.toString();
        }
        return null;
    }

    @Override
    public String excluir(String cnpj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Carteira> consultarTodos() {
        ArrayList<Carteira> obj = new ArrayList<>();

        try {
            String sql = "SELECT * FROM carteira"
                    + " WHERE usuario = 1";

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                Carteira u = new Carteira();

                u.setId(resultado.getInt("id"));
                Usuario usu = new UsuarioDAO().consultarId(resultado.getInt("usuario"));
                u.setUsuario(usu);
                Acao a = new AcaoDAO().consultarId(resultado.getInt("acao"));
                u.setAcao(a);
                u.setValor(resultado.getFloat("valor"));
                u.setQuantidade(resultado.getInt("quantidade"));

                obj.add(u);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        return obj;
    }

    @Override
    public ArrayList<Carteira> consultar(String criterio) {
        ArrayList<Carteira> obj = new ArrayList<>();

        try {
            String sql = "SELECT acao, valor, quantidade"
                    + " FROM carteira"
                    + " WHERE " + criterio
                    + " ORDER BY acao";

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                Carteira u = new Carteira();

                Acao a = new AcaoDAO().consultarId(resultado.getInt("acao"));
                u.setAcao(a);
                u.setValor(resultado.getFloat("valor"));
                u.setQuantidade(resultado.getInt("quantidade"));

                obj.add(u);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        return obj;
    } 

    @Override
    public Carteira consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
