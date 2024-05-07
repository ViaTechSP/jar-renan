package Rede;

import Banco.BancoConexao;
import RAM.RAM;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RedesBanco {

    public void cadastrarDados(Redes metodoRedes) throws ClassNotFoundException{

        String sql = "INSERT INTO rede (nomeDominio, ip , enderecoMac , bytesEnviados) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = BancoConexao.getbancoConexao().prepareStatement(sql);
            ps.setString(1, metodoRedes.getNomeDominio());
            ps.setString(2, metodoRedes.getIp());
            ps.setString(3, metodoRedes.getEnderecoMac());
            ps.setString(4, metodoRedes.getBytesEnviados());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
