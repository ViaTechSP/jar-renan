package Console;

import Disco.Disco;
import Disco.DiscoColeta;
import Processador.ProcessadorColeta;
import Processador.Processadores;
import RAM.RAM;
import RAM.RamColeta;
import Rede.Redes;
import Rede.RedesColeta;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class ConsoleService {


    public static void main(String[] args) throws ClassNotFoundException {

        RAM ram = new RAM();
        Disco disco = new Disco();
        Processadores processadores = new Processadores();
        Redes redes = new Redes();

        String usuario;
        String senha;
        Scanner in = new Scanner(System.in);
        new Timer();
        System.out.println("""
                  ___                ___ \s
                 (o o)              (o o)\s
                (  V  ) Bem Vindo! (  V  )
                --m-m----------------m-m--
                
                Vamos Observar as informações  atuais do seu PC! 
                                    
                 _______                                     \s
                |       \\                                    \s
                | ▓▓▓▓▓▓▓\\ ______  _______   ______  _______ \s
                | ▓▓__| ▓▓/      \\|       \\ |      \\|       \\\s
                | ▓▓    ▓▓  ▓▓▓▓▓▓\\ ▓▓▓▓▓▓▓\\ \\▓▓▓▓▓▓\\ ▓▓▓▓▓▓▓\\
                | ▓▓▓▓▓▓▓\\ ▓▓    ▓▓ ▓▓  | ▓▓/      ▓▓ ▓▓  | ▓▓
                | ▓▓  | ▓▓ ▓▓▓▓▓▓▓▓ ▓▓  | ▓▓  ▓▓▓▓▓▓▓ ▓▓  | ▓▓
                | ▓▓  | ▓▓\\▓▓     \\ ▓▓  | ▓▓\\▓▓    ▓▓ ▓▓  | ▓▓
                 \\▓▓   \\▓▓ \\▓▓▓▓▓▓▓\\▓▓   \\▓▓ \\▓▓▓▓▓▓▓\\▓▓   \\▓▓
                                                             \s
                                                             \s                                                                                                            
                ---------------------------------------------------------   
                                                        
                  """);

        System.out.println("""
                 █   ▄▀▄ ▄▀  █ █▄ █
                 █▄▄ ▀▄▀ ▀▄█ █ █ ▀█
                   
                Nome da Sua Empresa:""");
        usuario = in.nextLine();
        System.out.println("""
                
                
                ──▄▀▀▀▄───────────────
                ──█───█───────────────
                ─███████─────────▄▀▀▄─
                ░██─▀─██░░█▀█▀▀▀▀█░░█░
                ░███▄███░░▀░▀░░░░░▀▀░░
                
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


                                        System.out.println("""
                                                 ----------------------------------------
                                                 Coletando Dados.. %d
                                                 
                                                 Rede info:
                                                 Nome Usuário: %s
                                                 ip: %s
                                                 MAC address: %s
                                                 Uso de Dados de Redes: %s                  
                                                                                        
                                                 Memória RAM info:                       
                                                 Memória RAM em uso: %s                 
                                                 Memória RAM Total: %s                   
                                                 Memória RAM Diponível: %s               
                                                                                        
                                                 Disco Rígido info:                     
                                                 Velocidade de Leitura: %s              
                                                 Espaço Díponível: %s                   
                                                 Espaço Total: %s                       
                                                                                        
                                                 Processador info:                      
                                                 Frequência: %sGHz                     
                                                 Tempo de Atividade: %s                 
                                                 ----------------------------------------
                                                """.formatted(contagem, redes.getNomeDominio(), redes.getIp(),redes.getEnderecoMac(), redes.getBytesEnviados() ,ram.getMemoriaUtilizada() , ram.getMemoriaTotal()
                                        , ram.getDisponivel(), disco.getVelocidadeLeitura(), disco.getEspacoDisponivel(),
                                                disco.getEspacoTotal(), processadores.getFrequencia(), processadores.getTempoAtividade()));


                                        DiscoColeta.coletarDadosDisco();
                                        // MetricaService.coletaDeTemperatura();
                                        try {
                                            ProcessadorColeta.coletaDeProcessador();
                                        } catch (ClassNotFoundException e) {
                                            throw new RuntimeException(e);
                                        }

                                        try {
                                            RamColeta.coletaDeRam();
                                        } catch (ClassNotFoundException e) {
                                            throw new RuntimeException(e);
                                        }

                                        try {
                                            RedesColeta.coletaDeRedes();
                                        } catch (ClassNotFoundException e) {
                                            throw new RuntimeException(e);
                                        }

                                    }
                                };
                                timer.scheduleAtFixedRate(tarefa, 200, 5000L);
                            } else if (escolha == 2) {
                                timer.cancel();
                                executar02 = false;
                                System.out.println("""
                                        Coleta de Dados Cancelada!
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