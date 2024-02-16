package models;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private String fechaPublicacion;
    private String editorial;
    private String categoria;
    private int cantidadDisponible;

    public Libro(String titulo, String autor, String fechaPublicacion, String editorial, String categoria, int cantidadDisponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.editorial = editorial;
        this.categoria = categoria;
        this.cantidadDisponible = cantidadDisponible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void prestarLibro() {
        if (cantidadDisponible > 0) {
            cantidadDisponible--;
        }
    }

    public void devolverLibro() {
        cantidadDisponible++;
    }

    @Override
    public String toString() {
        return "Libro: " +
                "Id=" + id + ", Titulo=" + titulo + '\'' + ", Autor='" + autor + '\'' + ", FechaPublicacion='" + fechaPublicacion + '\'' + ", Editorial='" + editorial + '\'' + ", Categoria='" + categoria + '\'' + ", CantidadDisponible=" + cantidadDisponible + '}';
    }
}
