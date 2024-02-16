package models;

import java.util.ArrayList;

public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String domicilio;
    private int numeroTelefonico;
    private ArrayList<Prestamo> prestamos = new ArrayList<>();

    public Usuario(String nombre, String apellido, String domicilio, int numeroTelefonico,int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.numeroTelefonico = numeroTelefonico;
        this.id =id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario() {

    }

    public String getNombre() {
        return nombre;
    }


    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", numeroTelefonico=" + numeroTelefonico +
                '}';
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setNumeroTelefonico(int numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public int getId() {
        return id;
    }
}
