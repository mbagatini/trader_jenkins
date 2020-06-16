/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import entidade.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author morgana
 */
public class UsuarioDAO {

    public Usuario consultarId(int id) {
        Usuario obj = new Usuario();

        try {
            String sql = "SELECT * FROM usuario"
                    + " WHERE id = " + id;

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                obj.setId(resultado.getInt("id"));
                obj.setNome(resultado.getString("nome"));
                obj.setCpf(resultado.getString("cpf"));
                obj.setEmail(resultado.getString("email"));
                obj.setSenha(resultado.getString("senha"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        return obj;
    }

    public String salvar(Usuario objeto) {
        try {
            String sql = "INSERT INTO usuario VALUES (DEFAULT, ?,?,?,?)";

            PreparedStatement prst = ConexaoBD.getInstance().getConnection().prepareStatement(sql);
            prst.setString(1, objeto.getNome());
            prst.setString(2, objeto.getEmail());
            prst.setString(3, objeto.getSenha());
            prst.setString(4, objeto.getCpf());
            prst.execute();
            prst.close();

        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e);
            return e.toString();
        }

        return null;
    }

    public Usuario autenticarUsuario(String nome, String senha) {

        Usuario c = new Usuario();

        try {

            String sql = "SELECT * FROM usuario WHERE nome = ? and senha = ?";

            PreparedStatement prst = ConexaoBD.getInstance().getConnection().prepareStatement(sql);

            prst.setString(1, nome);
            prst.setString(2, senha);

            ResultSet resultado = prst.executeQuery();
            if (resultado.next()) {
                c.setId(resultado.getInt("id"));
                c.setNome(resultado.getString("nome"));
                c.setCpf(resultado.getString("cpf"));
                c.setEmail(resultado.getString("email"));
                c.setSenha(resultado.getString("senha"));
            } else {
                c = null;
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        return c;

    }

    public String atualizar(Usuario objeto) {
        try {

            String sql = "update usuario set nome = ?, email = ?, cpf = ?, senha = ? where id = ?";

            PreparedStatement prst = ConexaoBD.getInstance().getConnection().prepareStatement(sql);
            prst.setString(1, objeto.getNome());
            prst.setString(2, objeto.getEmail());
            prst.setString(3, objeto.getCpf());
            prst.setString(4, objeto.getSenha());
            prst.setInt(5, objeto.getId());
            prst.executeUpdate();
            prst.close();

        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e);
            return e.toString();
        }

        return null;
    }

    public String validaSenha(String senha) {

        String numeros = "0123456789";

        //Verificar o tamanho da senha
        if (senha.trim().length() <= 7) {

            return "Senha deve ter no mínimo 8 caracteres";

        }

        //Verificar se a senha tem números 
        boolean temNumero = false;
        for (int i = 0; i < senha.length(); i++) {
            for (int x = 0; x < numeros.length(); x++) {
                if (senha.substring(i,i+1).equals(numeros.substring(x,x+1))) {
                    temNumero = true;
                    i = senha.length();
                    x = numeros.length();
                }
            }
        }
        
        System.out.println(temNumero);
        
        if (!temNumero) {
            return "Senha precisa ter pelo menos um número";
        }

        return "ok";

    }

}
