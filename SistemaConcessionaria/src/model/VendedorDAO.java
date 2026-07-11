package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendedorDAO {

    private String url = "jdbc:mysql://localhost:3306/concessionaria";
    private String user = "root";
    private String password = "123456";
  
    public List<Vendedor> listar() throws SQLException {

        List<Vendedor> lista = new ArrayList<>();

        String sql = "SELECT * FROM vendedor";

        Connection conn = DriverManager.getConnection(url, user, password);

        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Vendedor v = new Vendedor();

            v.setCpfVendedor(rs.getString("cpf_vendedor"));
            v.setNome(rs.getString("nome"));
            v.setTelefone(rs.getString("telefone"));
            v.setComissao(rs.getDouble("comissao"));
            v.setDataCadastro(rs.getString("data_cadastro"));
            v.setHoraCadastro(rs.getString("hora_cadastro"));

            lista.add(v);
        }

        return lista;
    }
    
    public void inserir(Vendedor v) throws SQLException {

        String sql = "INSERT INTO vendedor(cpf_vendedor, nome, telefone, comissao, data_cadastro, hora_cadastro) VALUES(?,?,?,?,?,?)";

        Connection conn = DriverManager.getConnection(url, user, password);

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, v.getCpfVendedor());
        stmt.setString(2, v.getNome());
        stmt.setString(3, v.getTelefone());
        stmt.setDouble(4, v.getComissao());
        stmt.setString(5, v.getDataCadastro());
        stmt.setString(6, v.getHoraCadastro());

        stmt.executeUpdate();

        System.out.println("Vendedor inserido!");
    }
    
    public void atualizar(Vendedor v) throws SQLException {

        String sql = "UPDATE vendedor SET nome=?, telefone=?, comissao=?, data_cadastro=?, hora_cadastro=? WHERE cpf_vendedor=?";

        Connection conn = DriverManager.getConnection(url, user, password);

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, v.getNome());
        stmt.setString(2, v.getTelefone());
        stmt.setDouble(3, v.getComissao());
        stmt.setString(4, v.getDataCadastro());
        stmt.setString(5, v.getHoraCadastro());
        stmt.setString(6, v.getCpfVendedor());

        stmt.executeUpdate();

        System.out.println("Vendedor atualizado!");
    }
    
    public void deletar(String cpf) throws SQLException {

        String sql = "DELETE FROM vendedor WHERE cpf_vendedor=?";

        Connection conn = DriverManager.getConnection(url, user, password);

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, cpf);

        stmt.executeUpdate();

        System.out.println("Vendedor removido!");
    }
}