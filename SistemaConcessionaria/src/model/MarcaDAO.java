package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarcaDAO {

    private String url = "jdbc:mysql://localhost:3306/concessionaria";
    private String user = "root";
    private String password = "123456";

    public void inserir(Marca m) throws SQLException {

        String sql = "INSERT INTO marca(nome) VALUES(?)";

        Connection conn = DriverManager.getConnection(url, user, password);

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, m.getNome());

        stmt.executeUpdate();

        System.out.println("Marca inserida!");
    }

    public List<Marca> listar() throws SQLException {

        List<Marca> lista = new ArrayList<>();

        String sql = "SELECT * FROM marca";

        Connection conn = DriverManager.getConnection(url, user, password);

        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Marca m = new Marca();

            m.setIdMarca(rs.getInt("id_marca"));
            m.setNome(rs.getString("nome"));

            lista.add(m);
        }

        return lista;
    }

    public void atualizar(Marca m) throws SQLException {

        String sql = "UPDATE marca SET nome=? WHERE id_marca=?";

        Connection conn = DriverManager.getConnection(url, user, password);

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, m.getNome());
        stmt.setInt(2, m.getIdMarca());

        stmt.executeUpdate();

        System.out.println("Marca atualizada!");
    }

    public void deletar(int id) throws SQLException {

        String sql = "DELETE FROM marca WHERE id_marca=?";

        Connection conn = DriverManager.getConnection(url, user, password);

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.executeUpdate();

        System.out.println("Marca removida!");
    }
}