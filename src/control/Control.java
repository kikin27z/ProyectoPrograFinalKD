package control;

//import interfaces.IPersistencia;
//import interfazUsuario.*;
//import java.util.List;
//import javax.swing.DefaultComboBoxModel;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import objetosNegocio.Libro;
//import persistencia.PersistenciaListas;

/**
 * Esta clase implementa los casos de uso de la aplicacion Biblioteca.
 *
 * @author Diego Valenzuela Parra y José Karim Franco Valencia
 */
public class Control {
//
//    // Acceso a los objetos del negocio
//    IPersistencia persistencia;
//    Conversiones conversiones;
//
//    /**
//     * Constructor.
//     */
//    public Control() {
//        // Crea un objeto del tipo persistencia
//        persistencia = new PersistenciaListas();
//        conversiones = new Conversiones();
//    }
//
//    /**
//     * Agrega un libro al catalogo de libros
//     *
//     * @param frame Ventana sobre la que se despliega el cuadro de dialogo para
//     * capturar los datos del libro
//     * @return Regresa true si se pudo agregar el libro, false en caso
//     * contrario
//     */
//    public boolean agregaLibro(JFrame frame) {
//        Libro libro, bLibro;
//        StringBuffer respuesta = new StringBuffer("");
//        DlgLibro dlgLibro;
//        List<Libro> listaLibros;
//        DefaultComboBoxModel<Libro> librosComboBoxModel;
//        // Captura el isbn del libro
//        String isbn = JOptionPane.showInputDialog(frame, "ISBN del libro:",
//                "Agregar libro",
//                JOptionPane.QUESTION_MESSAGE);
//        // Si el usuario presionó el boton Cancelar
//        if (isbn == null) {
//            return false;
//        }
//        // Crea un objeto Libro con solo el isbn
//        libro = new Libro(isbn);
//        try {
//            // Obten el libro del catalogo de libros
//            bLibro = persistencia.obten(libro);
//
//            // Obtiene la lista de libros
//            listaLibros = persistencia.consultarLibros();
//        } catch (Exception e) {
//            // Si ocurrio un error al leer del catalogo de libros,
//            // despliega mensaje de error
//            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",
//                    JOptionPane.ERROR_MESSAGE);
//            return false;
//        }
//
//        librosComboBoxModel = conversiones.
//                librosComboBoxModel(listaLibros);
//        // Si el libro existe, despliega sus datos
//        if (bLibro != null) {
//            dlgLibro = new DlgLibro(frame,
//                    "El libro ya está en el catalogo",
//                    true, bLibro,
//                    librosComboBoxModel,
//                    ConstantesGUI.DESPLEGAR, respuesta);
//
//            return false;
//        }
//        // Si la cancion no existe captura los datos de la nueva cancion
//        dlgCancion = new DlgCancion(frame, "Captura Datos Cancion", true,
//                cancion, generosCancionesComboBoxModel,
//                ConstantesGUI.AGREGAR, respuesta);
//        // Si el usuario presiono el boton Cancelar
//        if (respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) {
//            return false;
//        }
//        // Agrega la nueva cancion al catalogo de canciones
//        try {
//            persistencia.agrega(cancion);
//        } catch (Exception e) {
//            // Si ocurrio un error al escribir al catalogo de canciones,
//            // despliega mensaje de error
//            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",
//                    JOptionPane.ERROR_MESSAGE);
//            return false;
//        }
//        return true;
//    }
//
//    /**
//     * Regresa un objeto Tabla con todas las canciones
//     *
//     * @param frame Ventana sobre la que se despliega el mensaje de error
//     * @return Objeto Tabla con todas las canciones, null si hay un error
//     */
//    public Tabla getTablaCanciones(JFrame frame) {
//        List<Cancion> listaCanciones;
//        try {
//            // Obtiene la lista de canciones
//            listaCanciones = persistencia.consultaCanciones();
//        } catch (Exception e) {
//            // Si ocurrio un error al obtener la lista de la base de datos,
//            // despliega mensaje de error
//            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",
//                    JOptionPane.ERROR_MESSAGE);
//            return null;
//        }
//        // Regresa el objeto Tabla con todas las canciones
//        return new Tabla("Lista de Canciones",
//                conversiones.cancionesTableModel(listaCanciones));
//    }

}
