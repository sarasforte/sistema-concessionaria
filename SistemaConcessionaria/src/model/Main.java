package model;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        int opcao;
        do {
            System.out.println("\n========= CONCESSIONÁRIA =========");
            System.out.println("1 - Clientes");
            System.out.println("2 - Marcas");
            System.out.println("3 - Automóveis");
            System.out.println("4 - Vendedores");
            System.out.println("5 - Vendas");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt(); sc.nextLine();

            switch (opcao) {
                case 1: menuCliente();   break;
                case 2: menuMarca();     break;
                case 3: menuAutomovel(); break;
                case 4: menuVendedor();  break;
                case 5: menuVenda();     break;
                case 0: System.out.println("Saindo..."); break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    static int lerOpcaoCRUD() {
        System.out.println("1-Listar  2-Inserir  3-Atualizar  4-Deletar  0-Voltar");
        System.out.print("Escolha: ");
        int op = sc.nextInt(); sc.nextLine();
        return op;
    }

    // ================== CLIENTE ==================
    static void menuCliente() throws SQLException {
        ClienteDAO dao = new ClienteDAO();
        System.out.println("\n--- CLIENTES ---");
        int op = lerOpcaoCRUD();

        if (op == 1) {
            for (Cliente c : dao.listar()) {
                System.out.println(c.getCpfCliente() + " | " + c.getNome()
                    + " | " + c.getTelefone() + " | " + c.getEndereco()
                    + " | " + c.getStatusCliente());
            }
        } else if (op == 2) {
            Cliente c = new Cliente();
            System.out.print("CPF: ");            c.setCpfCliente(sc.nextLine());
            System.out.print("Nome: ");           c.setNome(sc.nextLine());
            System.out.print("Telefone: ");       c.setTelefone(sc.nextLine());
            System.out.print("Endereço: ");       c.setEndereco(sc.nextLine());
            System.out.print("Status: ");         c.setStatusCliente(sc.nextLine());
            dao.inserir(c);
        } else if (op == 3) {
            Cliente c = new Cliente();
            System.out.print("CPF do cliente: "); c.setCpfCliente(sc.nextLine());
            System.out.print("Novo nome: ");      c.setNome(sc.nextLine());
            System.out.print("Novo telefone: "); c.setTelefone(sc.nextLine());
            System.out.print("Novo endereço: "); c.setEndereco(sc.nextLine());
            System.out.print("Novo status: ");   c.setStatusCliente(sc.nextLine());
            dao.atualizar(c);
        } else if (op == 4) {
            System.out.print("CPF a deletar: ");
            dao.deletar(sc.nextLine());
        }
    }

    // ================== MARCA ==================
    static void menuMarca() throws SQLException {
        MarcaDAO dao = new MarcaDAO();
        System.out.println("\n--- MARCAS ---");
        int op = lerOpcaoCRUD();

        if (op == 1) {
            for (Marca m : dao.listar()) {
                System.out.println(m.getIdMarca() + " | " + m.getNome());
            }
        } else if (op == 2) {
            Marca m = new Marca();
            System.out.print("Nome: "); m.setNome(sc.nextLine());
            dao.inserir(m);
        } else if (op == 3) {
            Marca m = new Marca();
            System.out.print("ID: ");         m.setIdMarca(sc.nextInt()); sc.nextLine();
            System.out.print("Novo nome: "); m.setNome(sc.nextLine());
            dao.atualizar(m);
        } else if (op == 4) {
            System.out.print("ID a deletar: ");
            dao.deletar(sc.nextInt()); sc.nextLine();
        }
    }

    // ================== AUTOMÓVEL ==================
    static void menuAutomovel() throws SQLException {
        AutomovelDAO dao = new AutomovelDAO();
        System.out.println("\n--- AUTOMÓVEIS ---");
        int op = lerOpcaoCRUD();

        if (op == 1) {
            for (Automovel a : dao.listar()) {
                System.out.println(a.getIdAutomovel() + " | " + a.getModelo()
                    + " | " + a.getCor() + " | " + a.getAno()
                    + " | R$" + a.getPreco() + " | " + a.getStatusAutomovel());
            }
        } else if (op == 2) {
            Automovel a = new Automovel();
            System.out.print("ID Marca: ");     a.setIdMarca(sc.nextInt()); sc.nextLine();
            System.out.print("Preço: ");        a.setPreco(sc.nextDouble()); sc.nextLine();
            System.out.print("Ano: ");          a.setAno(sc.nextInt()); sc.nextLine();
            System.out.print("Modelo: ");       a.setModelo(sc.nextLine());
            System.out.print("Cor: ");          a.setCor(sc.nextLine());
            System.out.print("Status: ");       a.setStatusAutomovel(sc.nextLine());
            System.out.print("Data cadastro: "); a.setDataCadastro(sc.nextLine());
            System.out.print("Hora cadastro: "); a.setHoraCadastro(sc.nextLine());
            dao.inserir(a);
        } else if (op == 3) {
            Automovel a = new Automovel();
            System.out.print("ID do automóvel: "); a.setIdAutomovel(sc.nextInt()); sc.nextLine();
            System.out.print("ID Marca: ");     a.setIdMarca(sc.nextInt()); sc.nextLine();
            System.out.print("Preço: ");        a.setPreco(sc.nextDouble()); sc.nextLine();
            System.out.print("Ano: ");          a.setAno(sc.nextInt()); sc.nextLine();
            System.out.print("Modelo: ");       a.setModelo(sc.nextLine());
            System.out.print("Cor: ");          a.setCor(sc.nextLine());
            System.out.print("Status: ");       a.setStatusAutomovel(sc.nextLine());
            System.out.print("Data cadastro: "); a.setDataCadastro(sc.nextLine());
            System.out.print("Hora cadastro: "); a.setHoraCadastro(sc.nextLine());
            dao.atualizar(a);
        } else if (op == 4) {
            System.out.print("ID a deletar: ");
            dao.deletar(sc.nextInt()); sc.nextLine();
        }
    }

    // ================== VENDEDOR ==================
    static void menuVendedor() throws SQLException {
        VendedorDAO dao = new VendedorDAO();
        System.out.println("\n--- VENDEDORES ---");
        int op = lerOpcaoCRUD();

        if (op == 1) {
            for (Vendedor v : dao.listar()) {
                System.out.println(v.getCpfVendedor() + " | " + v.getNome()
                    + " | " + v.getTelefone() + " | comissão: " + v.getComissao());
            }
        } else if (op == 2) {
            Vendedor v = new Vendedor();
            System.out.print("CPF: ");         v.setCpfVendedor(sc.nextLine());
            System.out.print("Nome: ");        v.setNome(sc.nextLine());
            System.out.print("Telefone: ");    v.setTelefone(sc.nextLine());
            System.out.print("Comissão: ");    v.setComissao(sc.nextDouble()); sc.nextLine();
            System.out.print("Data cadastro: "); v.setDataCadastro(sc.nextLine());
            System.out.print("Hora cadastro: "); v.setHoraCadastro(sc.nextLine());
            dao.inserir(v);
        } else if (op == 3) {
            Vendedor v = new Vendedor();
            System.out.print("CPF do vendedor: "); v.setCpfVendedor(sc.nextLine());
            System.out.print("Nome: ");        v.setNome(sc.nextLine());
            System.out.print("Telefone: ");    v.setTelefone(sc.nextLine());
            System.out.print("Comissão: ");    v.setComissao(sc.nextDouble()); sc.nextLine();
            System.out.print("Data cadastro: "); v.setDataCadastro(sc.nextLine());
            System.out.print("Hora cadastro: "); v.setHoraCadastro(sc.nextLine());
            dao.atualizar(v);
        } else if (op == 4) {
            System.out.print("CPF a deletar: ");
            dao.deletar(sc.nextLine());
        }
    }

    // ================== VENDA ==================
    static void menuVenda() throws SQLException {
        VendaDAO dao = new VendaDAO();
        System.out.println("\n--- VENDAS ---");
        int op = lerOpcaoCRUD();

        if (op == 1) {
            for (Venda v : dao.listar()) {
                System.out.println(v.getIdVenda() + " | Cliente: " + v.getCpfCliente()
                    + " | Auto: " + v.getIdAutomovel() + " | Vendedor: " + v.getCpfVendedor()
                    + " | " + v.getDataVenda() + " " + v.getHoraVenda()
                    + " | R$" + v.getPrecoVenda() + " | " + v.getFormaPagamento());
            }
        } else if (op == 2) {
            Venda v = new Venda();
            System.out.print("CPF Cliente: ");    v.setCpfCliente(sc.nextLine());
            System.out.print("ID Automóvel: ");   v.setIdAutomovel(sc.nextInt()); sc.nextLine();
            System.out.print("CPF Vendedor: ");   v.setCpfVendedor(sc.nextLine());
            System.out.print("Data venda: ");     v.setDataVenda(sc.nextLine());
            System.out.print("Hora venda: ");     v.setHoraVenda(sc.nextLine());
            System.out.print("Preço venda: ");    v.setPrecoVenda(sc.nextDouble()); sc.nextLine();
            System.out.print("Forma pagamento: "); v.setFormaPagamento(sc.nextLine());
            dao.inserir(v);
        } else if (op == 3) {
            Venda v = new Venda();
            System.out.print("ID da venda: ");    v.setIdVenda(sc.nextInt()); sc.nextLine();
            System.out.print("CPF Cliente: ");    v.setCpfCliente(sc.nextLine());
            System.out.print("ID Automóvel: ");   v.setIdAutomovel(sc.nextInt()); sc.nextLine();
            System.out.print("CPF Vendedor: ");   v.setCpfVendedor(sc.nextLine());
            System.out.print("Data venda: ");     v.setDataVenda(sc.nextLine());
            System.out.print("Hora venda: ");     v.setHoraVenda(sc.nextLine());
            System.out.print("Preço venda: ");    v.setPrecoVenda(sc.nextDouble()); sc.nextLine();
            System.out.print("Forma pagamento: "); v.setFormaPagamento(sc.nextLine());
            dao.atualizar(v);
        } else if (op == 4) {
            System.out.print("ID a deletar: ");
            dao.deletar(sc.nextInt()); sc.nextLine();
        }
    }
}


