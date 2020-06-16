/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.UsuarioDAO;
import entidade.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author renan
 */
public class ValidaSenhaTest {

    Usuario user;
    UsuarioDAO dao;

    public ValidaSenhaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        user = new Usuario();
        dao = new UsuarioDAO();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void senhaSemNumero() {

        user.setSenha("kurtkurt");

        assertEquals("Senha precisa ter pelo menos um número", dao.validaSenha(user.getSenha()));

    }

    @Test
    public void senhaPequena() {

        user.setSenha("kuerku8");

        assertEquals("Senha deve ter no mínimo 8 caracteres", dao.validaSenha(user.getSenha()));

    }

    @Test
    public void validaSenhaCorreta() {

        user.setSenha("19941994");

        assertEquals("ok", dao.validaSenha(user.getSenha()));

    }

}
