package control;

import interfaces.IPersistencia;
import interfazUsuario.*;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import objetosNegocio.Libro;
import persistencia.PersistenciaListas;

/**
 * Esta clase implementa los casos de uso de la aplicación Biblioteca.
 *
 * @author Diego Valenzuela Parra y José Karim Franco Valencia
 */
public class Control {

    // Acceso a los objetos del negocio 
    IPersistencia persistencia;
    Conversiones conversiones;

    /**
     * Constructor.
     */
    public Control() {
        // Crea un objeto del tipo persistencia y otro de tipo conversiones
        persistencia = new PersistenciaListas();
        conversiones = new Conversiones();
    }

    /**
     * Agrega un libro al catálogo de libros
     *
     * @param frame Ventana sobre la que se despliega el cuadro de dialogo para
     * capturar los datos del libro
     * @return Regresa true si se pudo agregar el libro, false en caso contrario
     */
    public boolean agregaLibro(JFrame frame) {
        Libro libro, bLibro;
        StringBuffer respuesta = new StringBuffer("");
        DlgLibro dlgLibro;
        List<Libro> listaLibros;
        DefaultComboBoxModel<Libro> todosLibrosComboBoxModel;
        // Captura el ISBN del libro
        String isbn = JOptionPane.showInputDialog(frame, "ISBN del libro:",
                "Agrega Libro",
                JOptionPane.QUESTION_MESSAGE);
        // Si el usuario presionó el botón Cancelar
        if (isbn == null) {
            return false;
        }
        // Crea un objeto Libro con solo el ISBN
        libro = new Libro(isbn);
        try {
            // Obten el libro del catálogo de libros
            bLibro = persistencia.obten(libro);

            // Obtiene la lista de libros
            listaLibros = persistencia.consultarLibros();
        } catch (Exception e) {
            // Si ocurrio un error al leer del catalogo de libros,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        todosLibrosComboBoxModel = conversiones.librosComboBoxModel(listaLibros);
        // Si el libro existe, despliega sus datos
        if (bLibro != null) {
            dlgLibro = new DlgLibro(frame,
                    "El libro ya está en el catalogo",
                    true, bLibro,
                    ConstantesGUI.DESPLEGAR, respuesta);
            return false;
        }
        // Si el libro no existe captura los datos del nuevo libro
        dlgLibro = new DlgLibro(frame, "Captura Datos Libro", true,
                libro, ConstantesGUI.AGREGAR, respuesta);
        // Si el usuario presiono el boton Cancelar
        if (respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) {
            return false;
        }
        // Agrega el nuevo libro al catalogo de libros
        try {
            persistencia.agregar(libro);
        } catch (Exception e) {
            // Si ocurrio un error al escribir al catalogo de libros,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Actualiza un libro del catálogo de libros
     * @param frame Ventana sobre la que se despliega el cuadro de dialogo para
     * editar los datos del libro
     * @return Regresa true si se pudo actualizar el libro, false en caso
     * contrario
     */
    public boolean actualizaLibro(JFrame frame) {
        Libro libro;
        StringBuffer respuesta = new StringBuffer("");
        DlgLibro dlgLibro;
        List<Libro> listaLibros;
        DefaultComboBoxModel<Libro> todosLibrosComboBoxModel;
        // Captura el ISBN del libro
        String isbn = JOptionPane.showInputDialog(frame, "ISBN del libro:",
                "Actualizar libro",
                JOptionPane.QUESTION_MESSAGE);
        // Si el usuario presiono el boton Cancelar
        if (isbn == null) {
            return false;
        }
        // Crea un objeto Libro con solo el ISBN
        libro = new Libro(isbn);
        try {
            // Obten el libro del catalogo de libros
            libro = persistencia.obten(libro);
        } catch (Exception e) {
            // Si ocurrió un error al leer del catálogo de libros,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // Si el libro no existe, despliega un mensaje de error
        if (libro == null) {
            JOptionPane.showMessageDialog(frame,
                    "El libro no existe", "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            // Obtiene la lista de libros
            listaLibros = persistencia.consultarLibros();
        } catch (Exception e) {
            // Si ocurrió un error al obtener la lista de la base de datos,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        todosLibrosComboBoxModel = conversiones.librosComboBoxModel(listaLibros);
        // Si el libro existe, edita los datos del libro
        dlgLibro = new DlgLibro(frame, "Editar Datos Libro", true, libro,
                ConstantesGUI.ACTUALIZAR, respuesta);
        // Si el usuario presionó el boton Cancelar
        if (respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) {
            return false;
        }
        // Actualiza el libro del catálogo de libros
        try {
            persistencia.actualizar(libro);
        } catch (Exception e) {
            // Si ocurrio un error al escribir al catálogo de libros,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Elimina un libro del catálogo de libros
     * @param frame Ventana sobre la que se despliega el cuadro de dialogo para
     * desplegar los datos del libro
     * @return Regresa true si se pudo eliminar el libro, false en caso
     * contrario
     */
    public boolean eliminaLibro(JFrame frame) {
        Libro libro;
        StringBuffer respuesta = new StringBuffer();
        DlgLibro dlgLibro;
        List<Libro> listaLibros;
        DefaultComboBoxModel<Libro> todosLibrosComboBoxModel;
        // Captura el ISBN del libro
        String isbn = JOptionPane.showInputDialog(frame, "ISBN del libro:",
                "Eliminar libro",
                JOptionPane.QUESTION_MESSAGE);
        // Si el usuario presionó el botón Cancelar
        if (isbn == null) {
            return false;
        }
        // Crea un objeto Libro con solo el ISBN
        libro = new Libro(isbn);
        try {
            // Obten el libro del catalogo de libros
            libro = persistencia.obten(libro);
        } catch (Exception e) {
            // Si ocurrio un error al leer del catalogo de libros
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // Si el libro no existe en el catalogo de libros
        if (libro == null) {
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, "El libro no existe",
                    "¡Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            // Obtiene la lista de libros
            listaLibros = persistencia.consultarLibros();
        } catch (Exception e) {
            // Si ocurrió un error al obtener la lista de la base de datos,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        todosLibrosComboBoxModel = conversiones.librosComboBoxModel(listaLibros);
        // Si existe el libro, despliega los datos del libro
        dlgLibro = new DlgLibro(frame, "Libro a borrar", true, libro, ConstantesGUI.ELIMINAR, respuesta);
        // Si el usuario presionó el boton Cancelar
        if (respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) {
            return false;
        }
        try {
            // Elimina el libro del catálogo de libros
            persistencia.eliminar(libro);
        } catch (Exception e) {
            // Si ocurrio un error al borrar del catalogo de libros,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Regresa un objeto Tabla con todos los libros
     * @param frame Ventana sobre la que se despliega el mensaje de error
     * @return Objeto Tabla con todos los libros, null si hay un error
     */
    public Tabla getTablaLibros(JFrame frame) {
        List<Libro> listaLibros;
        try {
            // Obtiene la lista de libros
            listaLibros = persistencia.consultarLibros();
        } catch (Exception e) {
            // Si ocurrio un error al obtener la lista de la base de datos,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
        // Regresa el objeto Tabla con todos los libros
        return new Tabla("Lista de Libros", conversiones.librosTableModel(listaLibros));
    }
}
