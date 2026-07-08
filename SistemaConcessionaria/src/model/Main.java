package model;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        MarcaDAO dao = new MarcaDAO();

        List<Marca> marcas = dao.listar();

        System.out.println("Lista de marcas:");

        for (Marca m : marcas) {
            System.out.println(m.getIdMarca() + " - " + m.getNome());
        }
    }
}