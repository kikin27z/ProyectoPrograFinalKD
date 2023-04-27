package control;

import interfaces.IPersistencia;
import interfazUsuario.*;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import objetosNegocio.Libro;
import objetosNegocio.PublicacionED;
import objetosNegocio.Usuario;
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

        // Captura el ISBN del libro
        String isbn = JOptionPane.showInputDialog(frame, "ISBN del libro:", "Agrega Libro", JOptionPane.QUESTION_MESSAGE);
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
     * Agrega un usuario al catálogo de usuarios
     *
     * @param frame Ventana sobre la que se despliega el cuadro de dialogo para
     * capturar los datos del usuario
     * @return Regresa true si se pudo agregar el usuario, false en caso
     * contrario
     */
    public boolean agregaUsuario(JFrame frame) {
        Usuario usuario, bUsuario;
        StringBuffer respuesta = new StringBuffer("");
        DlgUsuario dlgUsuario;
        List<Usuario> listaUsuarios;
        DefaultComboBoxModel<Usuario> todosUsuariosComboBoxModel;
        // Captura el Num Credencial del usuario
        String numCredencial = JOptionPane.showInputDialog(frame, "Num Credencial del usuario:",
                "Agrega Usuario",
                JOptionPane.QUESTION_MESSAGE);
        // Si el usuario presionó el botón Cancelar
        if (numCredencial == null) {
            return false;
        }
        // Crea un objeto Usuario con solo el num de credencial
        usuario = new Usuario(numCredencial);
        try {
            // Obten el usuario del catálogo de usuarios
            bUsuario = persistencia.obten(usuario);

            // Obtiene la lista de usuarios
            listaUsuarios = persistencia.consultarUsuarios();
        } catch (Exception e) {
            // Si ocurrio un error al leer del catalogo de usuarios,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        todosUsuariosComboBoxModel = conversiones.usuariosComboBoxModel(listaUsuarios);
        // Si el usuario existe, despliega sus datos
        if (bUsuario != null) {
            dlgUsuario = new DlgUsuario(frame,
                    "El Usuario ya está en el catalogo",
                    true, bUsuario,
                    ConstantesGUI.DESPLEGAR, respuesta);
            return false;
        }
        // Si el usuario no existe captura los datos del nuevo usuario
        dlgUsuario = new DlgUsuario(frame, "Captura Datos Usuario", true,
                usuario, ConstantesGUI.AGREGAR, respuesta);
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
     * Actualiza un libro del catálogo de libros
     *
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
        DefaultComboBoxModel<Usuario> todosUsuariosComboBoxModel;
        // Captura el Num de Credencial del usuario
        String numCredencial = JOptionPane.showInputDialog(frame, "Num Credencial del usuario:",
                "Actualizar usuario",
                JOptionPane.QUESTION_MESSAGE);
        // Si el usuario presiono el boton Cancelar
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
            JOptionPane.showMessageDialog(frame,
                    "El usuario no existe", "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            // Obtiene la lista de usuarios
            listaUsuarios = persistencia.consultarUsuarios();
        } catch (Exception e) {
            // Si ocurrió un error al obtener la lista de la base de datos,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        todosUsuariosComboBoxModel = conversiones.usuariosComboBoxModel(listaUsuarios);
        // Si el usuario existe, edita los datos del libro
        dlgUsuario = new DlgUsuario(frame, "Editar Datos Usuario", true, usuario,
                ConstantesGUI.ACTUALIZAR, respuesta);
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
     * Elimina un libro del catálogo de libros
     *
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
     * Elimina un usuario del catálogo de usuarios
     *
     * @param frame Ventana sobre la que se despliega el cuadro de dialogo para
     * desplegar los datos del usuario
     * @return Regresa true si se pudo eliminar el usuario, false en caso
     * contrario
     */
    public boolean eliminaUsuario(JFrame frame) {
        Usuario usuario;
        StringBuffer respuesta = new StringBuffer("");
        DlgUsuario dlgUsuario;
        List<Usuario> listaUsuarios;
        DefaultComboBoxModel<Usuario> todosUsuariosComboBoxModel;
        // Captura el Num de Credencial del usuario
        String numCredencial = JOptionPane.showInputDialog(frame, "Num Credencial del usuario:",
                "Eliminar usuario",
                JOptionPane.QUESTION_MESSAGE);
        // Si el usuario presiono el boton Cancelar
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
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // Si el usuario no existe en el catalogo de usuarios
        if (usuario == null) {
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, "El usuario no existe",
                    "¡Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            // Obtiene la lista de usurios
            listaUsuarios = persistencia.consultarUsuarios();
        } catch (Exception e) {
            // Si ocurrió un error al obtener la lista de la base de datos,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        todosUsuariosComboBoxModel = conversiones.usuariosComboBoxModel(listaUsuarios);
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
        Libro libro, bLibro;
        PublicacionED publicacionED = null;
        StringBuffer respuesta = new StringBuffer("");
        DlgInventario dlgInventario;
        List<Libro> listaLibros;
        DefaultComboBoxModel<Libro> todosLibrosComboBoxModel;

//        // Captura el ISBN del libro
//        String isbn = JOptionPane.showInputDialog(frame, "ISBN del libro:", "Agrega Libro", JOptionPane.QUESTION_MESSAGE);
//        // Si el usuario presionó el botón Cancelar
//        if (isbn == null) {
//            return false;
//        }
//        // Crea un objeto Libro con solo el ISBN
//        libro = new Libro(isbn);
        try {
            // Obten el libro del catálogo de libros
//            bLibro = persistencia.obten(libro);

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
//        // Si el libro existe, despliega sus datos
//        if (bLibro != null) {
//            dlgLibro = new DlgLibro(frame, "El libro ya está en el catalogo", true, bLibro, ConstantesGUI.DESPLEGAR, respuesta);
//            return false;
//        }
        // Si el libro no existe captura los datos del nuevo libro
        
        libro = new Libro("");
        publicacionED = new PublicacionED(libro);
        
        dlgInventario = new DlgInventario(frame, "Inventaria Libro", true, publicacionED, todosLibrosComboBoxModel, ConstantesGUI.AGREGAR, respuesta);
        libro = dlgInventario.getCajaCombinadaLibrosSelectedItem();
        int cantidad = dlgInventario.getCantidad();

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
        // Regresa el objeto Tabla con todos los libros
        return new Tabla("Lista de Libros", conversiones.librosTableModel(listaLibros));
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
        // Regresa el objeto Tabla con todos los libros
        return new Tabla("Lista de Usuarios", conversiones.usuariosTableModel(listaUsuarios));
    }

    /**
     * Regresa un objeto Tabla con todos los libros
     *
     * @param frame Ventana sobre la que se despliega el mensaje de error
     * @return Objeto Tabla con todos los libros, null si hay un error
     */
    public Tabla getTablaInventario(JFrame frame) {
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
        // Regresa el objeto Tabla con todos los libros
        return new Tabla("Lista del Inventario", conversiones.inventarioTableModel(listaInventario));
    }
}
