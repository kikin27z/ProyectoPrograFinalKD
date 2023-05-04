package control;

import interfaces.IPersistencia;
import interfazUsuario.*;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import objetosNegocio.Libro;
import objetosNegocio.Prestamo;
import objetosNegocio.PublicacionED;
import objetosNegocio.Usuario;
import objetosServicio.Fecha;
import objetosServicio.Periodo;
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
    public boolean agregarLibro(JFrame frame) {
        Libro libro, bLibro;
        StringBuffer respuesta = new StringBuffer("");
        DlgLibro dlgLibro;
        String isbn = "";

        // Captura el ISBN del libro
        while (isbn != null && isbn.equals("")) {
            isbn = JOptionPane.showInputDialog(frame, "ISBN del libro:", "Agrega Libro", JOptionPane.QUESTION_MESSAGE);
            if (isbn != null && isbn.equals("")) {
                JOptionPane.showMessageDialog(frame, "Introduzca un ISBN válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Si el usuario presionó el botón Cancelar
        if (isbn == null) {
            return false;
        }

        // Crea un objeto Libro con solo el ISBN
        libro = new Libro(isbn);
        try {
            // Obten el libro del catálogo de libros
            bLibro = persistencia.obten(libro);
        } catch (Exception e) {
            // Si ocurrio un error al leer del catalogo de libros,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Si el libro existe, despliega sus datos
        if (bLibro != null) {
            dlgLibro = new DlgLibro(frame, "El libro ya está en el catalogo", true, bLibro, ConstantesGUI.DESPLEGAR, respuesta);
            return false;
        }

        // Si el libro no existe captura los datos del nuevo libro
        dlgLibro = new DlgLibro(frame, "Captura Datos Libro", true, libro, ConstantesGUI.AGREGAR, respuesta);

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
     *
     * @param frame Ventana sobre la que se despliega el cuadro de dialogo para
     * editar los datos del libro
     * @return Regresa true si se pudo actualizar el libro, false en caso
     * contrario
     */
    public boolean actualizarLibro(JFrame frame) {
        Libro libro;
        StringBuffer respuesta = new StringBuffer("");
        DlgLibro dlgLibro;
        List<Libro> listaLibros;
        String isbn = "";

        try {
            // Obten el libro del catalogo de libros
            listaLibros = persistencia.consultarLibros();
        } catch (Exception e) {
            // Si ocurrió un error al leer del catálogo de libros,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (listaLibros.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No hay líbros en el catálogo.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Captura el ISBN del libro
        while (isbn != null && isbn.equals("")) {
            isbn = JOptionPane.showInputDialog(frame, "ISBN del libro:", "Actualiza Libro", JOptionPane.QUESTION_MESSAGE);
            if (isbn != null && isbn.equals("")) {
                JOptionPane.showMessageDialog(frame, "Introduzca un ISBN válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

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
            // Si ocurrió un error al leer del catálogo de libros,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // Si el libro no existe, despliega un mensaje de error
        if (libro == null) {
            JOptionPane.showMessageDialog(frame, "No se encontró el libro en el catálogo.", "¡Error!", JOptionPane.ERROR_MESSAGE);
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

        // Si el libro existe, edita los datos del libro
        dlgLibro = new DlgLibro(frame, "Editar Datos Libro", true, libro, ConstantesGUI.ACTUALIZAR, respuesta);
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
     *
     * @param frame Ventana sobre la que se despliega el cuadro de dialogo para
     * desplegar los datos del libro
     * @return Regresa true si se pudo eliminar el libro, false en caso
     * contrario
     */
    public boolean eliminarLibro(JFrame frame) {
        Libro libro;
        StringBuffer respuesta = new StringBuffer();
        DlgLibro dlgLibro;
        List<Libro> listaLibros;
        String isbn = "";

        try {
            // Obten el libro del catalogo de libros
            listaLibros = persistencia.consultarLibros();
        } catch (Exception e) {
            // Si ocurrió un error al leer del catálogo de libros,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (listaLibros.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No hay líbros en el catálogo.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Captura el ISBN del libro
        while (isbn != null && isbn.equals("")) {
            isbn = JOptionPane.showInputDialog(frame, "ISBN del libro:", "Elimina Libro", JOptionPane.QUESTION_MESSAGE);
            if (isbn != null && isbn.equals("")) {
                JOptionPane.showMessageDialog(frame, "Introduzca un ISBN válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

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
            JOptionPane.showMessageDialog(frame, "No se encontró el libro en el catálogo.", "¡Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Si existe el libro, despliega los datos del libro
        dlgLibro = new DlgLibro(frame, "Borrar Libro", true, libro, ConstantesGUI.ELIMINAR, respuesta);
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
     * Agrega un usuario al catálogo de usuarios
     *
     * @param frame Ventana sobre la que se despliega el cuadro de dialogo para
     * capturar los datos del usuario
     * @return Regresa true si se pudo agregar el usuario, false en caso
     * contrario
     */
    public boolean agregarUsuario(JFrame frame) {
        Usuario usuario, bUsuario;
        StringBuffer respuesta = new StringBuffer("");
        DlgUsuario dlgUsuario;
        String numCredencial = "";

        // Captura el ISBN del libro
        while (numCredencial != null && numCredencial.equals("")) {
            do {
                numCredencial = JOptionPane.showInputDialog(null, "Número de credencial:", "Agrega Usuario", JOptionPane.QUESTION_MESSAGE);
                if (numCredencial == null) {
                    break;
                }
                if (!numCredencial.matches("\\d+")) {
                    JOptionPane.showMessageDialog(frame, "Introduzca un número de credencial válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } while (!numCredencial.matches("\\d+"));
            if (numCredencial != null && numCredencial.equals("")) {
                JOptionPane.showMessageDialog(frame, "Introduzca un número de credencial válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Si el usuario presionó el botón Cancelar
        if (numCredencial == null) {
            return false;
        }

        // Crea un objeto Usuario con solo el num de credencial
        usuario = new Usuario(numCredencial);
        try {
            // Obten el usuario del catálogo de usuarios
            bUsuario = persistencia.obten(usuario);
        } catch (Exception e) {
            // Si ocurrio un error al leer del catalogo de usuarios,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Si el usuario existe, despliega sus datos
        if (bUsuario != null) {
            dlgUsuario = new DlgUsuario(frame, "El Usuario ya está registrado.", true, bUsuario, ConstantesGUI.DESPLEGAR, respuesta);
            return false;
        }

        // Si el usuario no existe captura los datos del nuevo usuario
        dlgUsuario = new DlgUsuario(frame, "Captura Datos Usuario", true, usuario, ConstantesGUI.AGREGAR, respuesta);
        // Si el usuario presiono el boton Cancelar
        if (respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) {
            return false;
        }
        // Agrega el nuevo usuario al catalogo de usuarios
        try {
            persistencia.agregar(usuario);
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
     * Actualiza un usuario del catálogo de usuarios
     *
     * @param frame Ventana sobre la que se despliega el cuadro de dialogo para
     * editar los datos del usuario
     * @return Regresa true si se pudo actualizar el usuario, false en caso
     * contrario
     */
    public boolean actualizarUsuario(JFrame frame) {
        Usuario usuario;
        StringBuffer respuesta = new StringBuffer("");
        DlgUsuario dlgUsuario;
        List<Usuario> listaUsuarios;
        String numCredencial = "";

        try {
            // Obten el libro del catalogo de libros
            listaUsuarios = persistencia.consultarUsuarios();
        } catch (Exception e) {
            // Si ocurrió un error al leer del catálogo de libros,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (listaUsuarios.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No hay usuarios registrados.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Captura el ISBN del libro
        while (numCredencial != null && numCredencial.equals("")) {
            numCredencial = JOptionPane.showInputDialog(frame, "Número de credencial:", "Actualiza Usuario", JOptionPane.QUESTION_MESSAGE);
            if (numCredencial != null && numCredencial.equals("")) {
                JOptionPane.showMessageDialog(frame, "Introduzca un número de credencial válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Si el usuario presionó el botón Cancelar
        if (numCredencial == null) {
            return false;
        }

        // Crea un objeto Usuario con solo el numero de credencial
        usuario = new Usuario(numCredencial);

        try {
            // Obten el usuario del catalogo de usuarios
            usuario = persistencia.obten(usuario);
        } catch (Exception e) {
            // Si ocurrió un error al leer del catálogo de usuarios,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Si el usuario no existe, despliega un mensaje de error
        if (usuario == null) {
            JOptionPane.showMessageDialog(frame, "El usuario no está registrado.", "¡Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Si el usuario existe, edita los datos del libro
        dlgUsuario = new DlgUsuario(frame, "Editar Datos Usuario", true, usuario, ConstantesGUI.ACTUALIZAR, respuesta);
        // Si el usuario presionó el boton Cancelar
        if (respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) {
            return false;
        }

        // Actualiza el usuario del catálogo de usuarios
        try {
            persistencia.actualizar(usuario);
        } catch (Exception e) {
            // Si ocurrio un error al escribir al catálogo de usuarios,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Elimina un usuario del catálogo de usuarios
     *
     * @param frame Ventana sobre la que se despliega el cuadro de dialogo para
     * desplegar los datos del usuario
     * @return Regresa true si se pudo eliminar el usuario, false en caso
     * contrario
     */
    public boolean eliminarUsuario(JFrame frame) {
        Usuario usuario;
        StringBuffer respuesta = new StringBuffer("");
        DlgUsuario dlgUsuario;
        List<Usuario> listaUsuarios;
        String numCredencial = "";

        try {
            // Obten el libro del catalogo de libros
            listaUsuarios = persistencia.consultarUsuarios();
        } catch (Exception e) {
            // Si ocurrió un error al leer del catálogo de libros,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (listaUsuarios.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No hay usuarios registrados.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Captura el ISBN del libro
        while (numCredencial != null && numCredencial.equals("")) {
            numCredencial = JOptionPane.showInputDialog(frame, "Número de credencial:", "Elimina Usuario", JOptionPane.QUESTION_MESSAGE);
            if (numCredencial != null && numCredencial.equals("")) {
                JOptionPane.showMessageDialog(frame, "Introduzca un número de credencial válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Si el usuario presionó el botón Cancelar
        if (numCredencial == null) {
            return false;
        }

        // Crea un objeto Usuario con solo el numero de credencial
        usuario = new Usuario(numCredencial);
        try {
            // Obten el usuario del catalogo de usuarios
            usuario = persistencia.obten(usuario);
        } catch (Exception e) {
            // Si ocurrio un error al leer del catalogo de usuarios
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // Si el usuario no existe en el catalogo de usuarios
        if (usuario == null) {
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, "El usuario no está registrado.", "¡Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Si existe el usuario, despliega los datos del usuario
        dlgUsuario = new DlgUsuario(frame, "Usuario a borrar", true, usuario, ConstantesGUI.ELIMINAR, respuesta);
        // Si el usuario presionó el boton Cancelar
        if (respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) {
            return false;
        }
        try {
            // Elimina el usuario del catálogo de usuarios
            persistencia.eliminar(usuario);
        } catch (Exception e) {
            // Si ocurrio un error al borrar del catalogo de usuarios,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Agrega un libro al inventario
     *
     * @param frame Ventana sobre la que se despliega el cuadro de dialogo para
     * capturar los datos del libro a inventariar
     * @return Regresa true si se pudo inventariar el libro, false en caso
     * contrario
     */
    public boolean inventariarLibro(JFrame frame) {
        Libro libro;
        PublicacionED publicacionED = new PublicacionED();
        StringBuffer respuesta = new StringBuffer("");
        DlgInventario dlgInventario;
        List<Libro> listaLibros;
        DefaultComboBoxModel<Libro> todosLibrosComboBoxModel;
        int cantidad;

        try {
            // Obtiene la lista de libros
            listaLibros = persistencia.consultarLibros();
        } catch (Exception e) {
            // Si ocurrio un error al leer del catalogo de libros,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Si la lista de libros está vacía, desplegar el mensaje
        if (listaLibros.isEmpty()) {
            // Si ocurrio un error al leer del catalogo de libros,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, "No hay libros en el catálogo.", "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        todosLibrosComboBoxModel = conversiones.librosComboBoxModel(listaLibros);
        // Si el libro no existe captura los datos del nuevo libro
        dlgInventario = new DlgInventario(frame, "Inventariar Libro", true, publicacionED, todosLibrosComboBoxModel, ConstantesGUI.AGREGAR, respuesta);

        libro = (Libro) publicacionED.getPublicacion();
        cantidad = publicacionED.getExistencia();

        // Si el usuario presiono el boton Cancelar
        if (respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) {
            return false;
        }

        // Agrega el nuevo libro al catalogo de libros
        try {
            persistencia.inventariar(libro, cantidad);
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
     * Elimina un libro del inventario
     *
     * @param frame Ventana sobre la que se despliega el cuadro de dialogo para
     * capturar los datos del libro a desinventariar
     * @return Regresa true si se pudo desinventariar el libro, false en caso
     * contrario
     */
    public boolean desinventariarLibro(JFrame frame) {
        Libro libro;
        PublicacionED publicacionED = new PublicacionED();
        StringBuffer respuesta = new StringBuffer("");
        DlgInventario dlgInventario;
        List<PublicacionED> inventarioLibros;
        DefaultComboBoxModel<PublicacionED> inventarioLibrosComboBoxModel;
        int cantidad;

        try {
            // Obtiene la lista de libros
            inventarioLibros = persistencia.consultarInventarioLibros();
        } catch (Exception e) {
            // Si ocurrio un error al leer del catalogo de libros,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (inventarioLibros.isEmpty()) {
            // Si ocurrio un error al leer del catalogo de libros,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, "No hay libros en el inventario.", "¡Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        inventarioLibrosComboBoxModel = conversiones.inventarioComboBoxModel(inventarioLibros);
        dlgInventario = new DlgInventario(frame, "Desinventaria Libro", true, publicacionED, inventarioLibrosComboBoxModel, ConstantesGUI.ELIMINAR, respuesta);

        libro = (Libro) publicacionED.getPublicacion();
        cantidad = publicacionED.getExistencia();

        // Si el usuario presiono el boton Cancelar
        if (respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) {
            return false;
        }

        // Agrega el nuevo libro al catalogo de libros
        try {
            persistencia.desinventariar(libro, cantidad);
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
     * Presta un libro a un usuario
     *
     * @param frame Ventana sobre la que se despliega el cuadro de dialogo para
     * capturar los datos del libro a prestar y el usuario al que se le prestará
     * @return Regresa true si se pudo prestar el libro, false en caso contrario
     */
    public boolean prestarLibro(JFrame frame) {
        Usuario usuario;
        Libro libro;
        Prestamo prestamo = new Prestamo();
        StringBuffer respuesta = new StringBuffer("");
        DlgPrestamo dlgPrestamo;
        List<PublicacionED> librosDisponibles;
        List<Usuario> listaUsuarios;
        DefaultComboBoxModel<PublicacionED> librosDisponiblesComboBoxModel;
        DefaultComboBoxModel<Usuario> todosUsuariosComboBoxModel;
        int tiempo;

        try {
            // Obtiene la lista de libros
            listaUsuarios = persistencia.consultarUsuarios();
            // Obtiene la lista de libros
            librosDisponibles = persistencia.consultarLibrosDisponibles();
        } catch (Exception e) {
            // Si ocurrio un error al leer del catalogo de libros,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Si la lista de libros está vacía, desplegar el mensaje
        if (librosDisponibles.isEmpty() && listaUsuarios.isEmpty()) {
            // Si ocurrio un error al leer del catalogo de libros,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, "No hay libros disponibles ni usuarios registrados.", "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (librosDisponibles.isEmpty()) {
            // Si ocurrio un error al leer del catalogo de libros,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, "No hay ningún libro disponible.", "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (listaUsuarios.isEmpty()) {
            // Si ocurrio un error al leer del catalogo de libros,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, "No hay ningún usuario registrado.", "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        librosDisponiblesComboBoxModel = conversiones.librosDisponiblesComboBoxModel(librosDisponibles);
        todosUsuariosComboBoxModel = conversiones.usuariosComboBoxModel(listaUsuarios);
        // Si el libro no existe captura los datos del nuevo libro
        dlgPrestamo = new DlgPrestamo(frame, "Prestar Libro", true, prestamo, todosUsuariosComboBoxModel, librosDisponiblesComboBoxModel, ConstantesGUI.AGREGAR, respuesta);

        // Si el usuario presiono el boton Cancelar
        if (respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) {
            return false;
        }

        // Agrega el nuevo libro al catalogo de libros
        try {
            persistencia.prestarLibro(prestamo);
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
     * Método que se emplea cuando el usuario devuelve un libro
     *
     * @param frame Ventana sobre la que se despliega el cuadro de dialogo para
     * capturar los datos del libro a prestar y el usuario al que se le prestará
     * @return Regresa true si se pudo prestar el libro, false en caso contrario
     */
    public boolean devolverLibro(JFrame frame) {
        Usuario usuario;
        Libro libro;
        Prestamo prestamo = new Prestamo();
        StringBuffer respuesta = new StringBuffer("");
        DlgPrestamo dlgPrestamo;
        List<PublicacionED> librosPrestados;
        List<Usuario> listaUsuarios;
        DefaultComboBoxModel<PublicacionED> librosPrestadosComboBoxModel;
        DefaultComboBoxModel<Usuario> todosUsuariosComboBoxModel;

        try {
            // Obtiene la lista de libros
            listaUsuarios = persistencia.consultarUsuarios();
            // Obtiene la lista de libros
            librosPrestados = persistencia.consultarLibrosPrestados();
        } catch (Exception e) {
            // Si ocurrio un error al leer del catalogo de libros,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Si la lista de libros está vacía, desplegar el mensaje
        if (librosPrestados.isEmpty() && listaUsuarios.isEmpty()) {
            // Si ocurrio un error al leer del catalogo de libros,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, "No hay libros prestados ni usuarios registrados.", "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (librosPrestados.isEmpty()) {
            // Si ocurrio un error al leer del catalogo de libros,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, "No hay ningún libro prestado.", "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (listaUsuarios.isEmpty()) {
            // Si ocurrio un error al leer del catalogo de libros,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, "No hay ningún usuario registrado.", "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        librosPrestadosComboBoxModel = conversiones.librosPrestadosComboBoxModel(librosPrestados);
        todosUsuariosComboBoxModel = conversiones.usuariosComboBoxModel(listaUsuarios);
        // Si el libro no existe captura los datos del nuevo libro
        dlgPrestamo = new DlgPrestamo(frame, "Devolver Libro", true, prestamo, todosUsuariosComboBoxModel, librosPrestadosComboBoxModel, ConstantesGUI.ELIMINAR, respuesta);

        usuario = prestamo.getUsuario();
        libro = (Libro) prestamo.getPublicacion();
        prestamo = new Prestamo(usuario, libro);

        // Si el usuario presiono el boton Cancelar
        if (respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) {
            return false;
        }

        // Agrega el nuevo libro al catalogo de libros
        try {
            persistencia.devolverLibro(prestamo);
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
     * Regresa un objeto Tabla con todos los libros
     *
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

        if (listaLibros.isEmpty()) {
            return new Tabla("", null);
        }

        // Regresa el objeto Tabla con todos los libros
        return new Tabla("Lista de Libros", conversiones.librosTableModel(listaLibros));
    }

    /**
     * Regresa un objeto Tabla con todos los libros que coinciden con un autor
     *
     * @param frame Ventana sobre la que se despliega el mensaje de error
     * @return Objeto Tabla con los libros que coinciden con el autor, null si
     * hay un error
     */
    public Tabla getTablaLibrosAutor(JFrame frame) {
        List<Libro> listaLibrosAutor, listaLibros;
        String autor = "";

        try {
            // Obtiene la lista de libros por el autor
            listaLibros = persistencia.consultarLibros();
        } catch (Exception e) {
            // Si ocurrio un error al obtener la lista de la base de datos,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (listaLibros.isEmpty()) {
            return new Tabla("", null);
        }

        // Captura el autor del libro
        while (autor != null && autor.equals("")) {
            autor = JOptionPane.showInputDialog(frame, "Autor del libro:",
                    "Libro a buscar por autor:",
                    JOptionPane.QUESTION_MESSAGE);
            if (autor != null && autor.equals("")) {
                JOptionPane.showMessageDialog(frame, "Introduce un autor válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Si el usuario presionó el botón Cancelar
        if (autor == null) {
            return null;
        }

        try {
            // Obtiene la lista de libros por el autor
            listaLibrosAutor = persistencia.consultarLibrosAutor(autor);
        } catch (Exception e) {
            // Si ocurrio un error al obtener la lista de la base de datos,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (listaLibrosAutor.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No hay libros del autor.", "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return new Tabla("noLibrosAutor", null);
        }

        // Regresa el objeto Tabla con todos los libros que coinciden en el autor
        return new Tabla("Lista de Libros por autor:", conversiones.librosTableModel(listaLibrosAutor));
    }

    /**
     * Regresa un objeto Tabla con todos los libros que coinciden con una
     * editorial
     *
     * @param frame Ventana sobre la que se despliega el mensaje de error
     * @return Objeto Tabla con los libros que coinciden con la editorial, null
     * si hay un error
     */
    public Tabla getTablaLibrosEditorial(JFrame frame) {
        List<Libro> listaLibrosEditorial, listaLibros;
        String editorial = "";

        try {
            // Obtiene la lista de libros por el autor
            listaLibros = persistencia.consultarLibros();
        } catch (Exception e) {
            // Si ocurrio un error al obtener la lista de la base de datos,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (listaLibros.isEmpty()) {
            return new Tabla("", null);
        }

        // Captura el autor del libro
        while (editorial != null && editorial.equals("")) {
            editorial = JOptionPane.showInputDialog(frame, "Editorial del libro:",
                    "Libro a buscar por editorial:",
                    JOptionPane.QUESTION_MESSAGE);
            if (editorial != null && editorial.equals("")) {
                JOptionPane.showMessageDialog(frame, "Introduce una editorial válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Si el usuario presionó el botón Cancelar
        if (editorial == null) {
            return null;
        }

        try {
            // Obtiene la lista de libros por el autor
            listaLibrosEditorial = persistencia.consultarLibrosEditorial(editorial);
        } catch (Exception e) {
            // Si ocurrio un error al obtener la lista de la base de datos,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (listaLibrosEditorial.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No hay libros de la editorial.", "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return new Tabla("noLibrosEditorial", null);
        }

        // Regresa el objeto Tabla con todos los libros que coinciden en el autor
        return new Tabla("Lista de Libros por editorial:", conversiones.librosTableModel(listaLibrosEditorial));
    }

    /**
     * Regresa un objeto Tabla con todos los libros que coinciden con una
     * clasificación
     *
     * @param frame Ventana sobre la que se despliega el mensaje de error
     * @return Objeto Tabla con los libros que coinciden con la clasificación,
     * null si hay un error
     */
    public Tabla getTablaLibrosClasificacion(JFrame frame) {
        List<Libro> listaLibrosClasificacion, listaLibros;
        String clasificacion = "";

        try {
            // Obtiene la lista de libros por el autor
            listaLibros = persistencia.consultarLibros();
        } catch (Exception e) {
            // Si ocurrio un error al obtener la lista de la base de datos,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (listaLibros.isEmpty()) {
            return new Tabla("", null);
        }

        // Captura el autor del libro
        while (clasificacion != null && clasificacion.equals("")) {
            clasificacion = JOptionPane.showInputDialog(frame, "Clasificación del libro:",
                    "Libro a buscar por clasificación:",
                    JOptionPane.QUESTION_MESSAGE);
            if (clasificacion != null && clasificacion.equals("")) {
                JOptionPane.showMessageDialog(frame, "Introduce una clasificación válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Si el usuario presionó el botón Cancelar
        if (clasificacion == null) {
            return null;
        }

        try {
            // Obtiene la lista de libros por el autor
            listaLibrosClasificacion = persistencia.consultarLibrosClasificacion(clasificacion);
        } catch (Exception e) {
            // Si ocurrio un error al obtener la lista de la base de datos,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (listaLibrosClasificacion.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No hay libros con esa clasificación.", "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return new Tabla("noLibrosClasificacion", null);
        }

        // Regresa el objeto Tabla con todos los libros que coinciden en el autor
        return new Tabla("Lista de Libros por clasificación:", conversiones.librosTableModel(listaLibrosClasificacion));
    }

    /**
     * Regresa un objeto Tabla con todos los usuarios
     *
     * @param frame Ventana sobre la que se despliega el mensaje de error
     * @return Objeto Tabla con todos los usuarios, null si hay un error
     */
    public Tabla getTablaUsuarios(JFrame frame) {
        List<Usuario> listaUsuarios;
        try {
            // Obtiene la lista de libros
            listaUsuarios = persistencia.consultarUsuarios();
        } catch (Exception e) {
            // Si ocurrio un error al obtener la lista de la base de datos,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (listaUsuarios.isEmpty()) {
            return new Tabla("", null);
        }

        // Regresa el objeto Tabla con todos los libros
        return new Tabla("Lista de Usuarios", conversiones.usuariosTableModel(listaUsuarios));
    }

    /**
     * Regresa un objeto Tabla con todos los libros
     *
     * @param frame Ventana sobre la que se despliega el mensaje de error
     * @return Objeto Tabla con todos los libros, null si hay un error
     */
    public Tabla getTablaInventarioLibros(JFrame frame) {
        List<PublicacionED> listaInventario;
        try {
            // Obtiene la lista de libros
            listaInventario = persistencia.consultarInventarioLibros();
        } catch (Exception e) {
            // Si ocurrio un error al obtener la lista de la base de datos,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (listaInventario.isEmpty()) {
            return new Tabla("", null);
        }

        // Regresa el objeto Tabla con todos los libros
        return new Tabla("Lista del Inventario", conversiones.inventarioLibrosTableModel(listaInventario));
    }

    /**
     * Regresa un objeto Tabla con todos los libros
     *
     * @param frame Ventana sobre la que se despliega el mensaje de error
     * @return Objeto Tabla con todos los libros, null si hay un error
     */
    public Tabla getTablaLibrosPrestados(JFrame frame) {
        List<PublicacionED> librosPrestados;
        try {
            // Obtiene la lista de libros
            librosPrestados = persistencia.consultarLibrosPrestados();
        } catch (Exception e) {
            // Si ocurrio un error al obtener la lista de la base de datos,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (librosPrestados.isEmpty()) {
            return new Tabla("", null);
        }

        // Regresa el objeto Tabla con todos los libros
        return new Tabla("Lista de libros prestados", conversiones.inventarioLibrosTableModel(librosPrestados));
    }

    /**
     * Regresa un objeto Tabla con todos los libros
     *
     * @param frame Ventana sobre la que se despliega el mensaje de error
     * @return Objeto Tabla con todos los libros, null si hay un error
     */
    public Tabla getTablaLibrosDisponibles(JFrame frame) {
        List<PublicacionED> librosDisponibles;
        try {
            // Obtiene la lista de libros
            librosDisponibles = persistencia.consultarLibrosDisponibles();
        } catch (Exception e) {
            // Si ocurrio un error al obtener la lista de la base de datos,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (librosDisponibles.isEmpty()) {
            return new Tabla("", null);
        }

        // Regresa el objeto Tabla con todos los libros
        return new Tabla("Lista de libros disponibles", conversiones.inventarioLibrosTableModel(librosDisponibles));
    }

    /**
     * Regresa un objeto Tabla con todos los libros
     *
     * @param frame Ventana sobre la que se despliega el mensaje de error
     * @return Objeto Tabla con todos los libros, null si hay un error
     */
    public Tabla getTablaPrestamosLibros(JFrame frame) {
        List<Prestamo> listaPrestamos;
        try {
            // Obtiene la lista de libros
            listaPrestamos = persistencia.consultarPrestamosLibros();
        } catch (Exception e) {
            // Si ocurrio un error al obtener la lista de la base de datos,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (listaPrestamos.isEmpty()) {
            return new Tabla("", null);
        }

        // Regresa el objeto Tabla con todos los libros
        return new Tabla("Lista de Préstamos", conversiones.prestamosTableModel(listaPrestamos));
    }

    /**
     * Regresa un objeto Tabla con todos los libros que coinciden con un autor
     *
     * @param frame Ventana sobre la que se despliega el mensaje de error
     * @return Objeto Tabla con los libros que coinciden con el autor, null si
     * hay un error
     */
    public Tabla getTablaPrestamosLibrosUsuario(JFrame frame) {
        List<Prestamo> listaPrestamosUsuario, listaPrestamos;
        Usuario usuario;
        String numCredencial = "";

        try {
            // Obtiene la lista de libros por el autor
            listaPrestamos = persistencia.consultarPrestamosLibros();
        } catch (Exception e) {
            // Si ocurrio un error al obtener la lista de la base de datos,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (listaPrestamos.isEmpty()) {
            return new Tabla("", null);
        }

        // Captura el autor del libro
        while (numCredencial != null && numCredencial.equals("")) {
            numCredencial = JOptionPane.showInputDialog(frame, "Número de credencial:",
                    "Préstamo a buscar por usuario:",
                    JOptionPane.QUESTION_MESSAGE);
            if (numCredencial != null && numCredencial.equals("")) {
                JOptionPane.showMessageDialog(frame, "Introduce un número de credencial válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Si el usuario presionó el botón Cancelar
        if (numCredencial == null) {
            return null;
        }

        // Crea un objeto Usuario con solo el num de credencial
        try {
            // Obten el usuario del catálogo de usuarios
            usuario = persistencia.obten(new Usuario(numCredencial));
        } catch (Exception e) {
            // Si ocurrio un error al leer del catalogo de usuarios,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }

        try {
            // Obtiene la lista de libros por el autor
            listaPrestamosUsuario = persistencia.consultarPrestamosLibros(usuario);
        } catch (Exception e) {
            // Si ocurrio un error al obtener la lista de la base de datos,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (listaPrestamosUsuario.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No hay préstamos de ese usuario.", "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return new Tabla("noPrestamosUsuario", null);
        }

        // Regresa el objeto Tabla con todos los libros que coinciden en el autor
        return new Tabla("Lista de Préstamos por usuario:", conversiones.prestamosTableModel(listaPrestamosUsuario));
    }

    /**
     * Regresa un objeto Tabla con todos los libros que coinciden con un autor
     *
     * @param frame Ventana sobre la que se despliega el mensaje de error
     * @return Objeto Tabla con los libros que coinciden con el autor, null si
     * hay un error
     */
    public Tabla getTablaPrestamosLibro(JFrame frame) {
        List<Prestamo> listaPrestamosLibro, listaPrestamos;
        Libro libro;
        String isbn = "";

        try {
            // Obtiene la lista de libros por el autor
            listaPrestamos = persistencia.consultarPrestamosLibros();
        } catch (Exception e) {
            // Si ocurrio un error al obtener la lista de la base de datos,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (listaPrestamos.isEmpty()) {
            return new Tabla("", null);
        }

        // Captura el autor del libro
        while (isbn != null && isbn.equals("")) {
            isbn = JOptionPane.showInputDialog(frame, "ISBN del libro:",
                    "Préstamo a buscar por libro:",
                    JOptionPane.QUESTION_MESSAGE);
            if (isbn != null && isbn.equals("")) {
                JOptionPane.showMessageDialog(frame, "Introduce un ISBN válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Si el usuario presionó el botón Cancelar
        if (isbn == null) {
            return null;
        }

        // Crea un objeto Usuario con solo el num de credencial
        try {
            // Obten el usuario del catálogo de usuarios
            libro = persistencia.obten(new Libro(isbn));
        } catch (Exception e) {
            // Si ocurrio un error al leer del catalogo de usuarios,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }

        try {
            // Obtiene la lista de libros por el autor
            listaPrestamosLibro = persistencia.consultarPrestamos(libro);
        } catch (Exception e) {
            // Si ocurrio un error al obtener la lista de la base de datos,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (listaPrestamosLibro.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No hay préstamos de ese libro.", "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return new Tabla("noPrestamosLibro", null);
        }

        // Regresa el objeto Tabla con todos los libros que coinciden en el autor
        return new Tabla("Lista de Préstamos por libro:", conversiones.prestamosTableModel(listaPrestamosLibro));
    }

    /**
     * Regresa un objeto Tabla con todos los libros que coinciden con un autor
     *
     * @param frame Ventana sobre la que se despliega el mensaje de error
     * @return Objeto Tabla con los libros que coinciden con el autor, null si
     * hay un error
     */
    public Tabla getTablaPrestamosLibrosPeriodo(JFrame frame) {
        Periodo periodo = new Periodo(new Fecha(), new Fecha());
        DlgPeriodo dlgPeriodo;
        List<Prestamo> listaPrestamosLibroPeriodo, listaPrestamos;

        try {
            // Obtiene la lista de libros por el autor
            listaPrestamos = persistencia.consultarPrestamosLibros();
        } catch (Exception e) {
            // Si ocurrio un error al obtener la lista de la base de datos,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (listaPrestamos.isEmpty()) {
            return new Tabla("", null);
        }

        dlgPeriodo = new DlgPeriodo(frame, "Captura Datos Periodo", true, periodo, ConstantesGUI.AGREGAR);

        try {
            // Obtiene la lista de libros por el autor
            listaPrestamosLibroPeriodo = persistencia.consultarPrestamosLibros(periodo);
        } catch (Exception e) {
            // Si ocurrio un error al obtener la lista de la base de datos,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (listaPrestamosLibroPeriodo.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No hay préstamos dentro del periodo.", "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return new Tabla("noPrestamosPeriodo", null);
        }

        // Regresa el objeto Tabla con todos los libros que coinciden en el autor
        return new Tabla("Lista de Préstamos por periodo:", conversiones.prestamosTableModel(listaPrestamosLibroPeriodo));
    }
}
