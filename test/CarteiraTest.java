/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.AcaoDAO;
import dao.CarteiraDAO;
import entidade.Acao;
import entidade.Carteira;
import entidade.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author morgana
 */
public class CarteiraTest {
    
    static Usuario u;
    
    public CarteiraTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        u = new Usuario();
        u.setId(2);
        u.setCpf("888888999");
        u.setEmail("carteira@carteira.com");
        u.setSenha("123");
        u.setNome("carteira");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void validaQuantidadeNegativa() {
        CarteiraDAO cdao = new CarteiraDAO();
        Carteira c = new Carteira();
        
        c.setUsuario(u);
        c.setAcao(new Acao());
        c.setQuantidade(-2);
        
        assertNotEquals(null, cdao.salvar(c));
     }
     
     @Test
     public void validaValorCompra() {
        CarteiraDAO cdao = new CarteiraDAO();
        Carteira c = new Carteira();
        
        c.setUsuario(u);
        c.setAcao(new Acao());
        c.setQuantidade(1);
        c.setValor(0);
        
        assertNotEquals(null, cdao.salvar(c));
     }
     
     @Test
     public void validaAcaoCadastrada() { 
        CarteiraDAO cdao = new CarteiraDAO();
        Carteira c = new Carteira();
        
        c.setUsuario(u);
        c.setAcao(new AcaoDAO().consultarId(41));
        c.setQuantidade(1);
        c.setValor(10);
        
        assertEquals(null, cdao.salvar(c));
     }
     
}
