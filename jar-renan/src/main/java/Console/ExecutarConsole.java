package Console;

import java.io.IOException;

public class ExecutarConsole {
    public class ExecutarClasseEmConsole {
        public static void main(String[] args) {
            try {
                // Comando para abrir um novo console no Windows
//            String comandoWindows = "cmd /c start java -jar Security-Wings-Looca.jar";
                ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/Kx", "start", "cmd", "/k", "java", "-jar", "");
                // Executa o comando para abrir a outra classe em um novo console
                Process process = builder.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
