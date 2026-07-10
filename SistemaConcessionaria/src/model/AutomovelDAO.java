package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutomovelDAO {

    private String url = "jdbc:mysql://localhost:3306/concessionaria";
    private String user = "root";
    private String password = "123456";

    public List<Automovel> listar() throws SQLException {

        List<Automovel> lista = new ArrayList<>();

        String sql = "SELECT * FROM automovel";

        Connection conn = DriverManager.getConnection(url, user, password);

        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Automovel a = new Automovel();

            a.setIdAutomovel(rs.getInt("id_automovel"));
            a.setIdMarca(rs.getInt("id_marca"));
            a.setPreco(rs.getDouble("preco"));
            a.setAno(rs.getInt("ano"));
            a.setModelo(rs.getString("modelo"));
            a.setCor(rs.getString("cor"));
            a.setStatusAutomovel(rs.getString("status_automovel"));
            a.setDataCadastro(rs.getString("data_cadastro"));
            a.setHoraCadastro(rs.getString("hora_cadastro"));
            
            lista.add(a);
        }

        return lista;
    }
    
    public void inserir(Automovel a) throws SQLException {

        String sql = "INSERT INTO automovel(id_marca, preco, ano, modelo, cor, status_automovel, data_cadastro, hora_cadastro) VALUES(?,?,?,?,?,?,?,?)";

        Connection conn = DriverManager.getConnection(url, user, password);

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, a.getIdMarca());
        stmt.setDouble(2, a.getPreco());
        stmt.setInt(3, a.getAno());
        stmt.setString(4, a.getModelo());
        stmt.setString(5, a.getCor());
        stmt.setString(6, a.getStatusAutomovel());
        stmt.setString(7, a.getDataCadastro());
        stmt.setString(8, a.getHoraCadastro());

        stmt.executeUpdate();

        System.out.println("Automóvel inserido!");
    }
    
    public void atualizar(Automovel a) throws SQLException {

        String sql = "UPDATE automovel SET id_marca=?, preco=?, ano=?, modelo=?, cor=?, status_automovel=?, data_cadastro=?, hora_cadastro=? WHERE id_automovel=?";

        Connection conn = DriverManager.getConnection(url, user, password);

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, a.getIdMarca());
        stmt.setDouble(2, a.getPreco());
        stmt.setInt(3, a.getAno());
        stmt.setString(4, a.getModelo());
        stmt.setString(5, a.getCor());
        stmt.setString(6, a.getStatusAutomovel());
        stmt.setString(7, a.getDataCadastro());
        stmt.setString(8, a.getHoraCadastro());
        stmt.setInt(9, a.getIdAutomovel());

        stmt.executeUpdate();

        System.out.println("Automóvel atualizado!");
    }
    
    public void deletar(int id) throws SQLException {

        String sql = "DELETE FROM automovel WHERE id_automovel=?";

        Connection conn = DriverManager.getConnection(url, user, password);

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.executeUpdate();

        System.out.println("Automóvel removido!");
    }
}