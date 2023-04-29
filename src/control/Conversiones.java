/*
 * Conversiones.java
 *
 */
package control;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import objetosNegocio.Libro;
import objetosNegocio.Usuario;
import objetosNegocio.Prestamo;
import objetosNegocio.PublicacionED;

/**
 * Esta clase contiene métodos que generan objetos del tipo DefaultTableModel y
 * DefaultComboBoxModel para crear instancias de Jtable y JComboBox.
 *
 * @author Diego Valenzuela Parra y José Karim Franco Valencia
 */
public class Conversiones {
    // Arreglos con los nombres de las columnas de las tablas

    String nombresColumnasTablasLibros[] = {"ISBN", "Titulo", "Editorial", "Autor", "Edicion", "Clasificacion"};
    String nombresColumnasTablasUsuarios[] = {"Num. Cred.", "Nombre", "Direccion", "Teléfono"};
    String nombresColumnasTablasPrestamos[] = {"Num. Cred.", "Nombre", "Teléfono", "ISBN", "Titulo", "Editorial", "Clasificacion", "Tiempo", "Fecha"};
    String nombresColumnasTablasPublicacionesED[] = {"ISBN", "Titulo", "Editorial", "Clasificacion", "Existencia", "Disponibilidad"};

    /**
     * Genera un objeto de tipo DefaultTableModel a partir de una lista de
     * libros.
     *
     * @param listaLibros Lista de libros a convertir
     * @return Objeto de tipo DefaultTableModel con los atributos de los libros.
     */
    public DefaultTableModel librosTableModel(List<Libro> listaLibros) {
        Object tabla[][];
        if (listaLibros != null) {
            tabla = new Object[listaLibros.size()][6];
            for (int i = 0; i < listaLibros.size(); i++) {
                // Obten un libro de la lista de libros
                Libro libro = listaLibros.get(i);
                // Almacena sus atributos en la fila del arreglo
                tabla[i][0] = libro.getIsbn();
                tabla[i][1] = libro.getTitulo();
                tabla[i][2] = libro.getEditorial();
                tabla[i][3] = libro.getAutor();
                tabla[i][4] = libro.getEdicion();
                tabla[i][5] = libro.getClasificacion();

            }
            return new DefaultTableModel(tabla, nombresColumnasTablasLibros);
        }
        return null;
    }

    /**
     * Genera un objeto de tipo DefaultTableModel a partir de una lista de
     * usuarios.
     *
     * @param listaUsuarios Lista de usuarios a convertir
     * @return Objeto de tipo DefaultTableModel con los atributos de los
     * usuarios.
     */
    public DefaultTableModel usuariosTableModel(List<Usuario> listaUsuarios) {
        Object tabla[][];
        if (listaUsuarios != null) {
            tabla = new Object[listaUsuarios.size()][4];
            for (int i = 0; i < listaUsuarios.size(); i++) {
                // Obten un usuario de la lista de usuarios
                Usuario usuario = listaUsuarios.get(i);
                // Almacena sus atributos en la fila del arreglo
                tabla[i][0] = usuario.getNumCredencial();
                tabla[i][1] = usuario.getNombre();
                tabla[i][2] = usuario.getDireccion();
                tabla[i][3] = usuario.getTelefono();
            }
            return new DefaultTableModel(tabla, nombresColumnasTablasUsuarios);
        }
        return null;
    }

    /**
     * Genera un objeto de tipo DefaultTableModel a partir de la lista de libros
     * del inventario.
     *
     * @param listaInventarioLibros Lista de libros a convertir
     * @return Objeto de tipo DefaultTableModel con los atributos de los libros.
     */
    public DefaultTableModel inventarioLibrosTableModel(List<PublicacionED> listaInventarioLibros) {
        Object tabla[][];
        if (listaInventarioLibros != null) {
            tabla = new Object[listaInventarioLibros.size()][6];
            for (int i = 0; i < listaInventarioLibros.size(); i++) {
                // Obtén un libro de la lista de libros
                PublicacionED publicacionED = listaInventarioLibros.get(i);
                // Almacena sus atributos en la fila del arreglo
                tabla[i][0] = publicacionED.getPublicacion().getIsbn();
                tabla[i][1] = publicacionED.getPublicacion().getTitulo();
                tabla[i][2] = publicacionED.getPublicacion().getEditorial();
                tabla[i][3] = publicacionED.getPublicacion().getClasificacion();
                tabla[i][4] = publicacionED.getExistencia();
                tabla[i][5] = publicacionED.getDisponibilidad();

            }
            return new DefaultTableModel(tabla, nombresColumnasTablasPublicacionesED);
        }
        return null;
    }

    /**
     * Genera un objeto de tipo DefaultTableModel a partir de una lista de
     * prestamos.
     *
     * @param listaPrestamos Lista de prestamos a convertir
     * @return Objeto de tipo DefaultTableModel con los atributos de los
     * prestamos.
     */
    public DefaultTableModel prestamosTableModel(List<Prestamo> listaPrestamos) {
        Object tabla[][];
        if (listaPrestamos != null) {
            tabla = new Object[listaPrestamos.size()][9];
            for (int i = 0; i < listaPrestamos.size(); i++) {
                // Obten un prestamo de la lista de prestamos
                Prestamo prestamo = listaPrestamos.get(i);
                // Almacena sus atributos en la fila del arreglo
                tabla[i][0] = prestamo.getUsuario().getNumCredencial();
                tabla[i][1] = prestamo.getUsuario().getNombre();
                tabla[i][2] = prestamo.getUsuario().getTelefono();
                tabla[i][3] = prestamo.getPublicacion().getIsbn();
                tabla[i][4] = prestamo.getPublicacion().getTitulo();
                tabla[i][5] = prestamo.getPublicacion().getEditorial();
                tabla[i][6] = prestamo.getPublicacion().getClasificacion();
                tabla[i][7] = prestamo.getTiempoPrestamo();
                tabla[i][8] = prestamo.getFechaPrestamo().toString();
            }
            return new DefaultTableModel(tabla, nombresColumnasTablasPrestamos);
        }
        return null;
    }

    /**
     * Genera un objeto de tipo DefaultComboBoxModel a partir de una lista de
     * libros.
     *
     * @param listaLibros Lista de libros
     * @return Regresa el defaultComboBoxModel con los libros agregados o null.
     */
    public DefaultComboBoxModel<Libro> librosComboBoxModel(List<Libro> listaLibros) {
        DefaultComboBoxModel<Libro> defaultComboBoxModel = new DefaultComboBoxModel<>();
        if (listaLibros != null) {
            // Para cada elemento de la Lista
            for (int i = 0; i < listaLibros.size(); i++) {
                // Agregalo a la instancia de la clase DefaultComboBoxModel
                defaultComboBoxModel.addElement(listaLibros.get(i));
            }
            return defaultComboBoxModel;
        }
        return null;
    }

    /**
     * Genera un objeto de tipo DefaultComboBoxModel a partir de una lista de
     * usuarios.
     *
     * @param listaUsuarios Lista de usuarios
     * @return Regresa el defaultComboBoxModel con los usuarios agregados o
     * null.
     */
    public DefaultComboBoxModel<Usuario> usuariosComboBoxModel(List<Usuario> listaUsuarios) {
        DefaultComboBoxModel<Usuario> defaultComboBoxModel = new DefaultComboBoxModel<>();
        if (listaUsuarios != null) {
            // Para cada elemento de la Lista
            for (int i = 0; i < listaUsuarios.size(); i++) {
                // Agregalo a la instancia de la clase DefaultComboBoxModel
                defaultComboBoxModel.addElement(listaUsuarios.get(i));
            }
            return defaultComboBoxModel;
        }
        return null;
    }

    /**
     * Genera un objeto de tipo DefaultComboBoxModel a partir de la lista del
     * inventario.
     *
     * @param listaInventario Lista del inventario
     * @return Regresa el defaultComboBoxModel con los libros del inventario o
     * null.
     */
    public DefaultComboBoxModel<PublicacionED> inventarioComboBoxModel(List<PublicacionED> listaInventario) {
        DefaultComboBoxModel<PublicacionED> defaultComboBoxModel = new DefaultComboBoxModel<>();
        if (listaInventario != null) {
            // Para cada elemento de la Lista
            for (int i = 0; i < listaInventario.size(); i++) {
                // Agregalo a la instancia de la clase DefaultComboBoxModel
                defaultComboBoxModel.addElement(listaInventario.get(i));
            }
            return defaultComboBoxModel;
        }
        return null;
    }

    /**
     * Genera un objeto de tipo DefaultComboBoxModel a partir de la lista del
     * inventario.
     *
     * @param librosDisponibles Lista del inventario
     * @return Regresa el defaultComboBoxModel con los libros del inventario o
     * null.
     */
    public DefaultComboBoxModel<PublicacionED> librosDisponiblesComboBoxModel(List<PublicacionED> librosDisponibles) {
        DefaultComboBoxModel<PublicacionED> defaultComboBoxModel = new DefaultComboBoxModel<>();
        if (librosDisponibles != null) {
            // Para cada elemento de la Lista
            for (int i = 0; i < librosDisponibles.size(); i++) {
                // Agregalo a la instancia de la clase DefaultComboBoxModel
                defaultComboBoxModel.addElement(librosDisponibles.get(i));
            }
            return defaultComboBoxModel;
        }
        return null;
    }
}
