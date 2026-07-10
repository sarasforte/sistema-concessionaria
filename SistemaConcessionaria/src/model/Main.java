package model;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        ClienteDAO dao = new ClienteDAO();

        // TESTE DE ATUALIZAÇÃO
        Cliente c = new Cliente();

        c.setCpfCliente("555.888.111-66");
        c.setStatusCliente("ATIVO");
        c.setTelefone("(84) 99999-9999");
        c.setNome("Daniel Nogueira");
        c.setEndereco("Endereço Atualizado");

        dao.atualizar(c);
        //dao.deletar("555.888.111-66");

        // LISTAR
        List<Cliente> clientes = dao.listar();

        for (Cliente cli : clientes) {
            System.out.println(
                cli.getCpfCliente() + " - " +
                cli.getNome() + " - " +
                cli.getStatusCliente()
            );
        }

        // TESTE DE EXCLUSÃO
        // dao.deletar("555.888.111-66");
    }
}