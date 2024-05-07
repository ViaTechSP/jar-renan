package Rede;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.util.Conversor;

public class Redes {

    Looca looca = new Looca();

    private String nomeDominio;
    private String ip;
    private String enderecoMac;
    private String bytesEnviados;

    public String getNomeDominio() {
        return nomeDominio = looca.getRede().getParametros().getNomeDeDominio() ;
    }

    public void setNomeDominio(String nomeDominio) {
        this.nomeDominio = nomeDominio;
    }

    public String getIp() {
        return ip = looca.getRede().getGrupoDeInterfaces().getInterfaces().get(3).getEnderecoIpv4().toString();
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getEnderecoMac() {
        return enderecoMac = looca.getRede().getGrupoDeInterfaces().getInterfaces().get(3).getEnderecoMac();
    }

    public void setEnderecoMac(String enderecoMac) {
        this.enderecoMac = enderecoMac;
    }

    public String getBytesEnviados() {
        return bytesEnviados = Conversor.formatarBytes(looca.getRede().getGrupoDeInterfaces().getInterfaces().get(3).getBytesEnviados());
    }

    public void setBytesEnviados(String bytesEnviados) {
        this.bytesEnviados = bytesEnviados;
    }
}
