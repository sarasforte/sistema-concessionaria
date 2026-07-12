package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    private String url = "jdbc:mysql://localhost:3306/concessionaria";
    private String user = "root";
    private String password = "123456";

    public List<Venda> listar() throws SQLException {

        List<Venda> lista = new ArrayList<>();

        String sql = "SELECT * FROM venda";

        Connection conn = DriverManager.getConnection(url, user, password);

        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Venda v = new Venda();

            v.setIdVenda(rs.getInt("id_venda"));
            v.setCpfCliente(rs.getString("cpf_cliente"));
            v.setIdAutomovel(rs.getInt("id_automovel"));
            v.setCpfVendedor(rs.getString("cpf_vendedor"));
            v.setDataVenda(rs.getString("data_venda"));
            v.setHoraVenda(rs.getString("hora_venda"));
            v.setPrecoVenda(rs.getDouble("preco_venda"));
            v.setFormaPagamento(rs.getString("forma_pagamento"));

            lista.add(v);
        }

        return lista;
    }
    
    public void inserir(Venda v) throws SQLException {

        String sql = "INSERT INTO venda(cpf_cliente, id_automovel, cpf_vendedor, data_venda, hora_venda, preco_venda, forma_pagamento) VALUES(?,?,?,?,?,?,?)";

        Connection conn = DriverManager.getConnection(url, user, password);

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, v.getCpfCliente());
        stmt.setInt(2, v.getIdAutomovel());
        stmt.setString(3, v.getCpfVendedor());
        stmt.setString(4, v.getDataVenda());
        stmt.setString(5, v.getHoraVenda());
        stmt.setDouble(6, v.getPrecoVenda());
        stmt.setString(7, v.getFormaPagamento());

        stmt.executeUpdate();

        System.out.println("Venda inserida!");
    }
    
    public void atualizar(Venda v) throws SQLException {

        String sql = "UPDATE venda SET cpf_cliente=?, id_automovel=?, cpf_vendedor=?, data_venda=?, hora_venda=?, preco_venda=?, forma_pagamento=? WHERE id_venda=?";

        Connection conn = DriverManager.getConnection(url, user, password);

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, v.getCpfCliente());
        stmt.setInt(2, v.getIdAutomovel());
        stmt.setString(3, v.getCpfVendedor());
        stmt.setString(4, v.getDataVenda());
        stmt.setString(5, v.getHoraVenda());
        stmt.setDouble(6, v.getPrecoVenda());
        stmt.setString(7, v.getFormaPagamento());
        stmt.setInt(8, v.getIdVenda());

        stmt.executeUpdate();

        System.out.println("Venda atualizada!");
    }
    
    public void deletar(int id) throws SQLException {

        String sql = "DELETE FROM venda WHERE id_venda=?";

        Connection conn = DriverManager.getConnection(url, user, password);

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.executeUpdate();

        System.out.println("Venda removida!");
    }
}