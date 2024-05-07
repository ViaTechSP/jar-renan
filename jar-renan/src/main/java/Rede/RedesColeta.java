package Rede;

import RAM.RAM;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.util.Conversor;

public class RedesColeta {


    public static void coletaDeRedes() throws ClassNotFoundException{
        Looca looca = new Looca();

        String nomeDominio = looca.getRede().getParametros().getNomeDeDominio();
        String ip = looca.getRede().getGrupoDeInterfaces().getInterfaces().get(3).getEnderecoIpv4().toString();
        String enderecoMac = looca.getRede().getGrupoDeInterfaces().getInterfaces().get(3).getEnderecoMac();
        String bytesEnviados = Conversor.formatarBytes(looca.getRede().getGrupoDeInterfaces().getInterfaces().get(3).getBytesEnviados());

        Redes metodoRedes = new Redes();
        metodoRedes.setNomeDominio(nomeDominio);
        metodoRedes.setIp(ip);
        metodoRedes.setEnderecoMac(enderecoMac);
        metodoRedes.setEnderecoMac(bytesEnviados);
        new RedesBanco().cadastrarDados(metodoRedes);

    }

}