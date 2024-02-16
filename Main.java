import models.Bibliotecario;
import models.Libro;
import models.Prestamo;
import models.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Usuario newUsuario=new Usuario();
        Scanner teclado = new Scanner(System.in);
        boolean flagOne = true;
        Bibliotecario bibliotecario = new Bibliotecario(); // Usamos la clase Bibliotecario
        String titulo, autor, fechaPublicacion, editorial, categoria;
        int cantidadDisponible;
        int menu;
        do {
            try {System.out.println("--------------------");
            System.out.println("Ingrese una opción:");
            System.out.println("1. Dar de alta a libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Libros prestados");
            System.out.println("4. Prestamo");
            System.out.println("5. Devolver libro");
            System.out.println("6. Agregar usuario");
            System.out.println("7.Cerrar Biblioteca");
            menu = teclado.nextInt();
            switch (menu) {
                case 1:
                    boolean flagTwo = true;
                    do {
                        System.out.println("Ingrese título de libro:");
                        titulo = teclado.next();
                        System.out.println("Ingrese autor del libro:");
                        autor = teclado.next();
                        System.out.println("Ingrese fecha de publicación:");
                        fechaPublicacion = teclado.next();
                        System.out.println("Ingrese Editorial:");
                        editorial = teclado.next();
                        System.out.println("Ingrese categoría del libro:");
                        categoria = teclado.next();
                        System.out.println("Cantidad de libros:");
                        cantidadDisponible = teclado.nextInt();
                        System.out.println("Ingrese la ID del libro:");
                        int id = teclado.nextInt();
                        Libro nuevoLibro = new Libro(titulo, autor, fechaPublicacion, editorial, categoria, cantidadDisponible);
                        nuevoLibro.setId(id); // Asignamos la ID al libro
                        bibliotecario.agregarLibro(nuevoLibro); // Agregamos el nuevo libro al inventario
                        bibliotecario.obtenerInventario().size();
                        System.out.println("Desea agregar otro libro? S/N");
                        String continuar = teclado.next();
                        if (continuar.equalsIgnoreCase("n")) {
                            flagTwo = false;
                        }
                    } while (flagTwo);
                    break;
                case 2:
                    boolean eliminar = true;
                    do {
                        boolean libroEncontrado = false;
                        for (Libro libro : bibliotecario.obtenerInventario()) {
                            System.out.println(libro.toString());
                        }
                        System.out.println("Ingrese número de libro a eliminar");
                        int c = teclado.nextInt();
                        for (Libro libro : bibliotecario.obtenerInventario()) {
                            if (c == libro.getId()) {
                                System.out.println(libro.toString());
                                libroEncontrado = true;
                                System.out.println("¿El libro es correcto? S/N");
                                String correcto = teclado.next();
                                if (correcto.equalsIgnoreCase("S")) {
                                    bibliotecario.eliminarLibro(libro); // Eliminamos el libro del inventario
                                    System.out.println("Libro borrado con éxito");
                                    break;
                                }
                            }
                        }
                        if (!libroEncontrado) {
                            System.out.println("No hay registros del libro");
                        }
                        System.out.println("Desea eliminar otro libro? S/N");
                        String delete = teclado.next();
                        eliminar = delete.equalsIgnoreCase("s");
                    } while (eliminar);
                    break;
                case 3:
                    ArrayList<Prestamo> prestamos = bibliotecario.obtenerPrestamos();

                    if (prestamos.isEmpty()) {
                        System.out.println("No hay libros prestados en este momento.");
                    } else {
                        System.out.println("Libros Prestados:");
                        for (Prestamo prestamo : prestamos) {
                            System.out.println(prestamo.toString());
                        }
                    }
                    break;

                case 4:
                    for (Libro libro : bibliotecario.obtenerInventario()) {
                        System.out.println(libro.toString());
                    }
                    System.out.println("Ingrese ID de libro para prestar: ");
                    int idPrestamo = teclado.nextInt();
                    for (Libro libro : bibliotecario.obtenerInventario()) {
                        if (idPrestamo == libro.getId() && libro.getCantidadDisponible() > 0) {
                            System.out.println("Ingrese ID de usuario: ");
                            int idUsuario = teclado.nextInt();
                            if (idUsuario == newUsuario.getId()) {
                                libro.prestarLibro();
                                Prestamo prestamo = new Prestamo(libro, newUsuario, new Date());
                                bibliotecario.agregarPrestamo(prestamo);
                                newUsuario.agregarPrestamo(prestamo);
                                System.out.println("Libro prestado con éxito a " + newUsuario.getNombre());
                            } else {
                                System.out.println("Usuario no encontrado.");
                            }
                        } else {
                            System.out.println("Libro no encontrado o no disponible");
                        }
                    }
                    break;
                case 5:
                    for (Prestamo prestamo : bibliotecario.obtenerPrestamos()) {
                        System.out.println(prestamo.toString());
                    }
                    System.out.println("Ingrese ID de libro prestado para devolver: ");
                    int idDevolucion = teclado.nextInt();
                    for (Prestamo prestamo : bibliotecario.obtenerPrestamos()) {
                        if (idDevolucion == prestamo.getLibro().getId()) {
                            prestamo.getLibro().devolverLibro();
                            bibliotecario.eliminarPrestamo(prestamo);
                            prestamo.getUsuario().getPrestamos().remove(prestamo);
                            System.out.println("Libro devuelto con éxito");
                        }else {
                            System.out.println("No se pudo devolver");
                        }
                    }
                    break;
                case 6:
                    System.out.println("Ingrese nombre");
                    String nombre = teclado.next();
                    System.out.println("Ingrese apellido");
                    String apellido = teclado.next();
                    System.out.println("Ingrese domicilio");
                    String domicilio = teclado.next();
                    System.out.println("Ingrese numero de telefono");
                    int numeroTelefono = teclado.nextInt();
                    System.out.println("Ingrese su ID");
                    int id = teclado.nextInt();
                    newUsuario.setNombre(nombre);
                    newUsuario.setApellido(apellido);
                    newUsuario.setDomicilio(domicilio);
                    newUsuario.setNumeroTelefonico(numeroTelefono);
                    newUsuario.setId(id);
                    bibliotecario.agregarUsuario(newUsuario);
                    System.out.println("Usuario agregado, Recuerda tu ID");
                    break;
                case 7:
                    System.out.println("Saliendo del programa");
                    flagOne=false;
                    break;
            }
            }catch (Exception e){
                    System.out.println("Error, ingrese numero valido ");
                    teclado.nextLine(); // Consume the remaining newline character
            }


        } while (flagOne);


    }
    
}
