/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.AcaoDAO;
import entidade.Acao;
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
public class AcaoTest {

    Acao acao;
    AcaoDAO acaodao;

    public AcaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        acao = new Acao();
        acaodao = new AcaoDAO();

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testeValorCorretoAcao() {

        acao.setId(1);
        acao.setNome("TDD");
        acao.setPreco(20);

        assertEquals(null, acaodao.validaDados(acao));

    }

    @Test
    public void testeValorIncorretoAcao() {

        acao.setId(1);
        acao.setNome("TDD");
        acao.setPreco(-5);

        assertEquals("Preço da ação inválido", acaodao.validaDados(acao));

    }

    @Test
    public void testeNomeEmBranco() {

        acao.setId(1);
        acao.setNome("     ");
        acao.setPreco(10);

        assertEquals("Nome da ação invalido", acaodao.validaDados(acao));

    }

    @Test
    public void testeNomeCorreto() {

        acao.setId(1);
        acao.setNome("TDD");
        acao.setPreco(10);

        assertEquals(null, acaodao.validaDados(acao));

    }

}
