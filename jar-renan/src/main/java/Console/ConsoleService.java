package Console;

import Disco.Disco;
import Disco.DiscoColeta;
import Processador.ProcessadorColeta;
import Processador.Processadores;
import RAM.RAM;
import RAM.RamColeta;
import Rede.Redes;
import Rede.RedesColeta;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ConsoleService {

    private static final Logger logger = Logger.getLogger(ConsoleService.class.getName());

    static {
        try {
            // Cria o diretório logs se não existir
            Files.createDirectories(Paths.get("logs"));
            // Configure o logger com um FileHandler e um SimpleFormatter
            FileHandler fileHandler = new FileHandler("logs/console_service.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL); // Logar todos os níveis
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Erro ao configurar o arquivo de log", e);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        RAM ram = new RAM();
        Disco disco = new Disco();
        Processadores processadores = new Processadores();
        Redes redes = new Redes();

        String usuario;
        String senha;
        Scanner in = new Scanner(System.in);
        new Timer();

        logger.log(Level.INFO, """
        
        Programa iniciado.
        
        """);

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

        logger.log(Level.INFO, """
                
                Mensagem de boas-vindas exibida. 
                 
                 """);


        System.out.println("""
                 █   ▄▀▄ ▄▀  █ █▄ █
                 █▄▄ ▀▄▀ ▀▄█ █ █ ▀█
                   
                Nome da Sua Empresa:""");
        usuario = in.nextLine();

        logger.log(Level.INFO, """
        
        Nome da empresa: {0}
        
        """, usuario);

        System.out.println("""
                
                
                ──▄▀▀▀▄───────────────
                ──█───█───────────────
                ─███████─────────▄▀▀▄─
                ░██─▀─██░░█▀█▀▀▀▀█░░█░
                ░███▄███░░▀░▀░░░░░▀▀░░
                
                Senha:""");
        senha = in.nextLine();

        logger.log(Level.INFO, """
        
        Senha recebida.
        
        """);

        Console console = new Console();
        console.setUser(usuario);
        console.setPassword(senha);
        new ConsoleBanco().selectDeDados(console);

        if (!console.getEntrou()) {
            System.out.println("""
                    LOGIN INVÁLIDO! TENTE NOVAMENTE.
                        """);
            logger.log(Level.WARNING, """
        
        Login inválido para o usuário: {0}
        
        """, usuario);

        } else {
            logger.log(Level.INFO, """
            
            Login bem-sucedido para o usuário: {0}
            
            """, usuario);

            Boolean executar = true;
            while (executar) {
                System.out.println("""
                        O que deseja?
                        1-Coletar Dados 
                        2-Sair
                           """);

                switch (in.nextInt()) {
                    case 1:
                        System.out.println("""
                                O que deseja?
                                1-Iniciar Coleta
                                2-Sair
                                 """);

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
                                        String coletaDados = """
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
                                                 Memória RAM Disponível: %s               
                                                                                        
                                                 Disco Rígido info:                     
                                                 Velocidade de Leitura: %s              
                                                 Espaço Disponível: %s                   
                                                 Espaço Total: %s                       
                                                                                        
                                                 Processador info:                      
                                                 Frequência: %sGHz                     
                                                 Tempo de Atividade: %s                 
                                                 ----------------------------------------
                                                """.formatted(contagem, redes.getNomeDominio(), redes.getIp(), redes.getEnderecoMac(), redes.getBytesEnviados(), ram.getMemoriaUtilizada(), ram.getMemoriaTotal(), ram.getDisponivel(), disco.getVelocidadeLeitura(), disco.getEspacoDisponivel(), disco.getEspacoTotal(), processadores.getFrequencia(), processadores.getTempoAtividade());

                                        logger.log(Level.INFO, coletaDados);

                                        DiscoColeta.coletarDadosDisco();
                                        try {
                                            ProcessadorColeta.coletaDeProcessador();
                                        } catch (ClassNotFoundException e) {
                                            logger.log(Level.SEVERE, "Erro ao coletar dados do processador", e);
                                            throw new RuntimeException(e);
                                        }

                                        try {
                                            RamColeta.coletaDeRam();
                                        } catch (ClassNotFoundException e) {
                                            logger.log(Level.SEVERE, "Erro ao coletar dados da RAM", e);
                                            throw new RuntimeException(e);
                                        }

                                        try {
                                            RedesColeta.coletaDeRedes();
                                        } catch (ClassNotFoundException e) {
                                            logger.log(Level.SEVERE, "Erro ao coletar dados da rede", e);
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
                                logger.log(Level.INFO, """
                            
                            Coleta de dados cancelada.
                            
                            """);
                            }
                        }
                        break;
                    case 2:
                        System.out.println("""
                                Obrigado!
                                """);
                        executar = false;
                        logger.log(Level.INFO, """
                        
                        Programa encerrado pelo usuário: {0}
                        
                        """, console.getUser());
                        break;
                }
            }
        }
    }
}