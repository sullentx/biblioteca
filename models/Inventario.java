package models;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Libro> listaLibros = new ArrayList<>();

    public boolean addLibro(Libro libro) {
        return listaLibros.add(libro);
    }

    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public void mostrarLibros() {
        for (Libro libro : listaLibros) {
            System.out.println(libro.toString());
        }
    }
}



