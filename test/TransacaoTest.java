/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.AcaoDAO;
import dao.TransacaoDAO;
import dao.UsuarioDAO;
import entidade.Acao;
import entidade.Transacao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author morgana
 */
public class TransacaoTest {
    
    public TransacaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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
     public void validaTipoInvalido() {
        TransacaoDAO tdao = new TransacaoDAO();
        
        Transacao t = new Transacao(new UsuarioDAO().consultarId(2), 
                                    new Acao(), 
                                    12, 
                                    1, 
                                    'B');
        
        assertNotEquals(null, tdao.salvar(t));
     }
     
     @Test
     public void validaTipoCompra() {
        TransacaoDAO tdao = new TransacaoDAO();
        
        Transacao t = new Transacao(new UsuarioDAO().consultarId(2), 
                                    new AcaoDAO().consultarId(2), 
                                    12, 
                                    1, 
                                    'C');
        
        assertEquals(null, tdao.salvar(t));
     }
     
     @Test
     public void validaTipoVenda() {
        TransacaoDAO tdao = new TransacaoDAO();
        
        Transacao t = new Transacao(new UsuarioDAO().consultarId(2), 
                                    new AcaoDAO().consultarId(2), 
                                    12, 
                                    1, 
                                    'V');
        
        assertEquals(null, tdao.salvar(t));
     }
     
     @Test
     public void validaAcaoNula() {
        TransacaoDAO tdao = new TransacaoDAO();
        
        Transacao t = new Transacao(new UsuarioDAO().consultarId(2), 
                                    null, 
                                    12, 
                                    1, 
                                    'C');
        
        assertNotEquals(null, tdao.salvar(t));
     }
     
     @Test
     public void validaAcaoValida() {
        TransacaoDAO tdao = new TransacaoDAO();
        
        Transacao t = new Transacao(new UsuarioDAO().consultarId(2), 
                                    new AcaoDAO().consultarId(2), 
                                    12, 
                                    1, 
                                    'C');
        
        assertEquals(null, tdao.salvar(t));
     }
}
