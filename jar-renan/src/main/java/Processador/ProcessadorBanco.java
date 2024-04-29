package Processador;

import Banco.BancoConexao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProcessadorBanco {

    public void cadastrarDados(Processador metodoProcessador) throws SQLException {

        String sql = "INSERT INTO Processador (nomeCPU, frequencia, threads, tempoAtividade) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = BancoConexao.getbancoConexao().prepareStatement(sql);
            ps.setString(1, metodoProcessador.getModelo());
            ps.setString(2, metodoProcessador.getFabricante());
            ps.setString(3, metodoProcessador.getNucleosFisicos());
            ps.setString(4, metodoProcessador.getNucleosLogicos());
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}