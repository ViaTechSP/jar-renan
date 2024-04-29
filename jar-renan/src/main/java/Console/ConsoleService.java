package Console;

import Disco.DiscoColeta;
import Processador.ProcessadorColeta;
import RAM.RamColeta;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class ConsoleService {


    public ConsoleService() {
    }

    public static void main(String[] args) {

        String usuario;
        String senha;
        Scanner in = new Scanner(System.in);
        new Timer();
        System.out.println("""
              BEM VINDO!
                """);

        System.out.println("""
            LOGIN
               
            Nome da Sua Empresa:""");
        usuario = in.nextLine();
        System.out.println("""
                   Senha:""");
        senha = in.nextLine();


        Console console = new Console();
        console.setUser(usuario);
        console.setPassword(senha);
        new ConsoleBanco().selectDeDados(console);

        if (!console.getEntrou()) {
            System.out.println("""
                LOGIN INVÁLIDO! TENTE NOVAMENTE.
                    """);

        } else {
            Boolean executar = true;
            while (executar) {
                System.out.println("""
                                                
                         O que deseja?
                         1-Coletar Dados
                         2-Sair
                            """.formatted(console.getUser()));

                switch (in.nextInt()) {
                    case 1:
                        System.out.println("""
                               O que deseja?
                               1-Iniciar Coleta
                               2-Sair
                                """.formatted(console.getUser()));

                        Scanner escolhaScanner = new Scanner(System.in);
                        Timer timer = new Timer();
                        boolean executar02 = true;

                        while (executar02) {
                            int escolha = escolhaScanner.nextInt();

                            if (escolha == 1) {
                                System.out.println("""
                                      2-Parar
                                      Digite a Opção:
                                      """);
                                TimerTask tarefa = new TimerTask() {
                                    Integer contagem = 0;

                                    public void run() {
                                        contagem++;

                                        System.out.println("Coletando Dados...: " + contagem);

                                        DiscoColeta.coletarDadosDisco();
                                      //  MetricaService.coletaDeTemperatura();
                                        try {
                                            ProcessadorColeta.coletaDeProcessador();
                                        } catch (SQLException var2) {
                                            SQLException ex = var2;
                                            throw new RuntimeException(ex);
                                        }
                                        RamColeta.coletaDeRam();
                                    }
                                };
                                timer.scheduleAtFixedRate(tarefa, 5, 1000L);
                            } else if (escolha == 2) {
                                timer.cancel();
                                executar02 = false;
                                System.out.println("""
                                       Coleta de Dados Cnacelada!
                                        """);
                            }
                        }
                        break;
                    case 2:
                        System.out.println("""
                                Obrigado!
                                """.formatted(console.getUser()));
                        executar = false;
                        break;
                }


            }

        }
    }

}
