package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private String url = "jdbc:mysql://localhost:3306/concessionaria";
    private String user = "root";
    private String password = "123456";
    
    public void inserir(Cliente c) throws SQLException {

        String sql = "INSERT INTO cliente(cpf_cliente, status_cliente, telefone, nome, endereco) VALUES(?,?,?,?,?)";

        Connection conn = DriverManager.getConnection(url, user, password);

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, c.getCpfCliente());
        stmt.setString(2, c.getStatusCliente());
        stmt.setString(3, c.getTelefone());
        stmt.setString(4, c.getNome());
        stmt.setString(5, c.getEndereco());

        stmt.executeUpdate();

        System.out.println("Cliente inserido!");
    }
    
    public List<Cliente> listar() throws SQLException {

        List<Cliente> lista = new ArrayList<>();

        String sql = "SELECT * FROM cliente";

        Connection conn = DriverManager.getConnection(url, user, password);

        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Cliente c = new Cliente();

            c.setCpfCliente(rs.getString("cpf_cliente"));
            c.setStatusCliente(rs.getString("status_cliente"));
            c.setTelefone(rs.getString("telefone"));
            c.setNome(rs.getString("nome"));
            c.setEndereco(rs.getString("endereco"));

            lista.add(c);
        }

        return lista;
    }
    public void atualizar(Cliente c) throws SQLException {

        String sql = "UPDATE cliente SET status_cliente=?, telefone=?, nome=?, endereco=? WHERE cpf_cliente=?";

        Connection conn = DriverManager.getConnection(url, user, password);

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, c.getStatusCliente());
        stmt.setString(2, c.getTelefone());
        stmt.setString(3, c.getNome());
        stmt.setString(4, c.getEndereco());
        stmt.setString(5, c.getCpfCliente());

        stmt.executeUpdate();

        System.out.println("Cliente atualizado!");
    }
   public void deletar(String cpf) throws SQLException {

        String sql = "DELETE FROM cliente WHERE cpf_cliente=?";

        Connection conn = DriverManager.getConnection(url, user, password);

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, cpf);

        stmt.executeUpdate();

        System.out.println("Cliente removido!");
    }
}