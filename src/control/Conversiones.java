/*
 * Conversiones.java
 *
 */
package control;

import java.util.List;
//import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import objetosNegocio.Libro;
//import objetosNegocio.Usuario;
//import objetosNegocio.PublicacionED;

/**
 * Esta clase contiene métodos que generan objetos del tipo DefaultTableModel y
 * DefaultComboBoxModel para crear instancias de Jtable y JComboBox.
 *
 * @author Diego Valenzuela Parra y José Karim Franco Valencia
 */
public class Conversiones {
    // Arreglos con los nombres de las columnas de las tablas

    String nombresColumnasTablasLibros[] = {"ISBN", "Titulo", "Editorial", "Clasificacion", "Autor", "Edicion"};
    String nombresColumnasTablasUsuarios[] = {"Num. Cred.", "Nombre", "Direccion", "Teléfono"};

    /**
     * Genera un objeto de tipo DefaultTableModel a partir de una lista de
     * libros.
     *
     * @param listaLibros Lista de libros a convertir
     * @return Objeto de tipo DefaultTableModel con los atributos de las
     * canciones.
     */
    public DefaultTableModel cancionesTableModel(List<Libro> listaLibros) {
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
                tabla[i][3] = libro.getClasificacion();
                tabla[i][4] = libro.getAutor();
                tabla[i][5] = libro.getEdicion();

            }
            return new DefaultTableModel(tabla, nombresColumnasTablasLibros);
        }
        return null;
    }

}
