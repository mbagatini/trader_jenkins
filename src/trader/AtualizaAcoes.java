/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trader;

import dao.AcaoDAO;
import entidade.Acao;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author morgana
 */
public class AtualizaAcoes extends Thread {

    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    final Runnable atualizador = () -> {
            AcaoDAO dao = new AcaoDAO();
            ArrayList<Acao> acoes = dao.consultarTodos();

            int max = 3;
            double min = 0.1;
            double range = max - min + 1;

            for (Acao acao : acoes) {
                acao.setPreco((float) (acao.getPreco() * ((Math.random() * range) + min)));

                dao.atualizarGlobal(acao);
            }
            System.out.println("Preços atualizados");
    };

    @Override
    public void run() {
        try {
            Thread.sleep(TimeUnit.MINUTES.toMillis(1L));
            // ( runnable , initialDelay , period , TimeUnit )
            executor.scheduleAtFixedRate(atualizador, 0L, 20L, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
