package Console;

import Banco.BancoConexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsoleBanco {


    public void selectDeDados(Console console) throws ClassNotFoundException{

        String sql = "SELECT * FROM empresa WHERE nomeFantasia = ? and senha = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = BancoConexao.getbancoConexao().prepareStatement(sql);
            ps.setString(1, console.getUser());
            ps.setString(2, console.getPassword());

            rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("Erro ao realizar login");
                console.setEntrou(false);
            } else {
                System.out.println("Login realizado");
                console.setEntrou(true);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao realizar consulta SQL", e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao fechar recursos", e);
            }
        }
    }
}
