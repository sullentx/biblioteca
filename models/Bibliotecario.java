package models;
import java.util.ArrayList;

public class Bibliotecario {
    private ArrayList<Libro> inventario = new ArrayList<>();
    private ArrayList<Prestamo> prestamos = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        inventario.add(libro);
    }

    public void eliminarLibro(Libro libro) {
        inventario.remove(libro);
    }

    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    public void eliminarPrestamo(Prestamo prestamo) {
        prestamos.remove(prestamo);
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public ArrayList<Libro> obtenerInventario() {
        return inventario;
    }

    public ArrayList<Prestamo> obtenerPrestamos() {
        return prestamos;
    }

    public ArrayList<Usuario> obtenerUsuarios() {
        return usuarios;
    }

}
