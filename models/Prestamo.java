package models;

import java.util.Date;

public class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private Date fechaPrestamo;

    public Prestamo(Libro libro, Usuario usuario, Date fechaPrestamo) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
    }

    public Prestamo() {

    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "libro=" + libro +
                ", usuario=" + usuario +
                ", fechaPrestamo=" + fechaPrestamo +
                '}';
    }
}




