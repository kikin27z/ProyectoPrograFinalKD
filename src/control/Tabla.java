package control;

import javax.swing.table.DefaultTableModel;

/**
 * Esta clase encapsula el titulo de una tabla y un objeto TableModel con los
 * datos de una tabla que seran desplegados en una tabla del tipo JTable
 * @author Diego Valenzuela Parra
 */
public class Tabla {
    private String titulo;
    private DefaultTableModel modeloTabla;

    /**
     * Constructor sin parametros
     */
    public Tabla() {
    }

    /**
     * Constructor que inicializa los atributos de la clase
     * @param titulo Titulo de la tabla
     * @param modeloTabla Objeto TableModel con los datos de la tabla.
     */
    public Tabla(String titulo, DefaultTableModel modeloTabla) {
        this.titulo = titulo;
        this.modeloTabla = modeloTabla;
    }

    /**
     * Regresa el titulo de la tabla
     * @return El titulo de la tabla
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el titulo de la tabla
     * @param titulo Titulo de la tabla 
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Regresa los datos de la tabla
     * @return Objeto TableModel con los datos de la tabla
     */
    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    /**
     * Establece los datos de la tabla
     * @param modeloTabla Objeto TableModel con los datos de la tabla
     */
    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }
}
