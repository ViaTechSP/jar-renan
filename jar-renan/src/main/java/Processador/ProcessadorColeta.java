package Processador;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;

import java.sql.SQLException;

public class ProcessadorColeta {

    public static void coletaDeProcessador() throws SQLException {
        Looca looca = new Looca();
        Sistema sistema = new Sistema();

        Processador processador = looca.getProcessador();
        String modeloProcessador = processador.getNome();
        String fabricanteProcessador = processador.getFabricante();


        Processador metodoProcessador = new Processador();

       // new ProcessadorBanco().cadastrarDados(metodoProcessador);

    }

}
