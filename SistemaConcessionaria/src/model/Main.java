package model;

public class Main {

    public static void main(String[] args) throws Exception {

        VendedorDAO dao = new VendedorDAO();

        Vendedor v = new Vendedor();

        v.setCpfVendedor("999.888.777-66");
        v.setNome("Pedro Henrique Santos");
        v.setTelefone("(84) 98888-8888");
        v.setComissao(7.5);
        v.setDataCadastro("2026-02-01");
        v.setHoraCadastro("10:00:00");

        dao.atualizar(v);
    }
}