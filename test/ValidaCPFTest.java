/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import apoio.Validacao;
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
public class ValidaCPFTest {
    
    Validacao validacao; 
    
    public ValidaCPFTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {  
        validacao = new Validacao();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void validaCPFcorreto(){
        
        String  cpf = "03248678089"; 
        
        assertTrue(validacao.validarCPF(cpf));
       
        
    }
    
    @Test
    public void invalidaCPFincorreto(){
        
        String  cpf = "03248678050"; 
        
        assertFalse(validacao.validarCPF(cpf));
       
        
    }

}
