package interfazUsuario;

import java.awt.Dimension;
import java.awt.Point;
import objetosNegocio.Libro;

/**
 *
 * @author Diego Valenzuela Parra y José Karim Franco Valencia
 */
public class DlgLibro extends javax.swing.JDialog {

    /**
     * Constructor que establece las características del cuadro de diálogo y la
     * operación a realizar con él
     *
     * @param parent Ventana sobre la que aparecerá el cuadro de diálogo
     * @param title Título del cuadro de diálogo
     * @param modal true si permite acceder fuera de los límites del cuadro de
     * diálogo, false en caso contrario
     * @param libro Libro a capturar, editar o desplegar
     * @param operacion Operación a realizar en el cuadro de diálogo: AGREGAR =
     * 0, ACTUALIZAR = 1, ELIMINAR = 2, DESPLEGAR = 3;
     * @param respuesta Boton presionado al salir de los cuadros de * diálogos:
     * ACEPTAR = "Aceptar", CANCELAR = "Cancelar".
     */
    public DlgLibro(java.awt.Frame parent, String title, boolean modal, Libro libro, int operacion, StringBuffer respuesta) {
        super(parent, title, modal);
        this.libro = libro;
        this.operacion = operacion;
        this.respuesta = respuesta;
        initComponents();      
        

        // Modifica el título del botón botonAceptar y establece si los
        // botones botonRestaurar y botonCancelar estarán habilitados.
        // Si la operación es agregar
        if (operacion == ConstantesGUI.AGREGAR) {
            botonAceptar.setText("Guardar");
        } // Si la operación es actualizar
        else if (operacion == ConstantesGUI.ACTUALIZAR) {
            botonAceptar.setText("Actualizar");
        } // Si la operación es eliminar
        else if (operacion == ConstantesGUI.ELIMINAR) {
            botonAceptar.setText("Eliminar");
            botonRestaurar.setEnabled(false);
        } // Si la operación es desplegar
        else if (operacion == ConstantesGUI.DESPLEGAR) {
            botonAceptar.setText("Continuar");
            botonRestaurar.setEnabled(false);
            botonCancelar.setEnabled(false);
        }

        // Despliega el ISBN del libro
        campoTextoISBN.setText(libro.getIsbn());

        // Si la operación es de actualizar, eliminar o desplegar,
        if ((operacion == ConstantesGUI.ELIMINAR) || (operacion == ConstantesGUI.ACTUALIZAR) || (operacion == ConstantesGUI.DESPLEGAR)) {
            // despliega el resto de los datos de la canción
            campoTextoTitulo.setText(libro.getTitulo());
            campoTextoAutor.setText(libro.getAutor());
            campoTextoEditorial.setText(libro.getEditorial());
            campoTextoEdicion.setText(libro.getEdicion());
            campoTextoClasificacion.setText(libro.getClasificacion());
        }

        // Si la operación es de eliminar o desplegar
        if ((operacion == ConstantesGUI.ELIMINAR) || (operacion == ConstantesGUI.DESPLEGAR)) {
            // hace los campos de texto de sólo lectura
            campoTextoTitulo.setEditable(false);
            campoTextoAutor.setEditable(false);
            campoTextoEditorial.setEditable(false);
            campoTextoEdicion.setEditable(false);
            campoTextoClasificacion.setEditable(false);
        }

        // Establece el valor por omisión para respuesta, por si se cierra el
        // cuadro de diálogo presionando el botón cerrar o el botón cancelar
        respuesta.append(ConstantesGUI.CANCELAR);
        // centra el cuadro de dialogo sobre la ventana de la aplicación
        centraCuadroDialogo(parent);

        // Muestra el cuadro de diálogo
        setVisible(true);
    }

    /**
     * Este método centra el cuadro de dialogo sobre la ventana de la
     * aplicación.
     *
     * @param parent Ventana sobre la que aparecerá el cuadro de diálogo
     */
    private void centraCuadroDialogo(java.awt.Frame parent) {
        // Obtiene el tamaño y posición de la ventana de la aplicación
        Dimension frameSize = parent.getSize();
        Point loc = parent.getLocation();
        // Obtiene el tamaño del cuadro de diálogo
        Dimension dlgSize = getPreferredSize();

        // Centra el cuadro de diálogo sobre la ventana padre
        setLocation((frameSize.width - dlgSize.width) / 2 + loc.x,
                (frameSize.height - dlgSize.height) / 2 + loc.y);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoTextoISBN = new javax.swing.JTextField();
        campoTextoTitulo = new javax.swing.JTextField();
        campoTextoAutor = new javax.swing.JTextField();
        campoTextoEditorial = new javax.swing.JTextField();
        campoTextoEdicion = new javax.swing.JTextField();
        campoTextoClasificacion = new javax.swing.JTextField();
        botonAceptar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        botonRestaurar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ISBN");

        jLabel2.setText("Título");
        jLabel2.setToolTipText("");

        jLabel3.setText("Autor");

        jLabel4.setText("Editorial");

        jLabel5.setText("Edición");

        jLabel6.setText("Clasificación");

        campoTextoISBN.setEditable(false);

        campoTextoAutor.setToolTipText("");

        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        botonRestaurar.setText("Restaurar");
        botonRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRestaurarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonAceptar)
                        .addGap(56, 56, 56)
                        .addComponent(botonRestaurar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(botonCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoTextoISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(campoTextoTitulo)
                                .addComponent(campoTextoAutor)
                                .addComponent(campoTextoEditorial)
                                .addComponent(campoTextoEdicion)
                                .addComponent(campoTextoClasificacion)))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoTextoISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoTextoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoTextoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoTextoEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoTextoEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(campoTextoClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAceptar)
                    .addComponent(botonCancelar)
                    .addComponent(botonRestaurar))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método oyente del botón botonAceptar
     *
     * @param evt Evento al que escucha
     */
    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        // Si la operación es Agregar o Actualizar
        if (operacion == ConstantesGUI.AGREGAR || operacion == ConstantesGUI.ACTUALIZAR) {
            // Toma los valores capturados en los campos de texto y en la caja
            // combinada y almacénalos en el parámetro cancion.
            libro.setTitulo(campoTextoTitulo.getText());
            libro.setAutor(campoTextoAutor.getText());
            libro.setEditorial(campoTextoEditorial.getText());
            libro.setEdicion(campoTextoEdicion.getText());
            libro.setClasificacion(campoTextoClasificacion.getText());
        }
        // Borra el contenido de respuesta
        respuesta.delete(0, respuesta.length());
        // Establece que se presionó el botón botonAceptar
        respuesta.append(ConstantesGUI.ACEPTAR);
        // Destruye el cuadro de díalogo
        dispose();
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void botonRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRestaurarActionPerformed
        // Restaura el contenido de los campos de texto a su valor original
        // Si la operación es Agregar
        if (operacion == ConstantesGUI.AGREGAR) {
            campoTextoTitulo.setText("");
            campoTextoAutor.setText("");
            campoTextoEditorial.setText("");
            campoTextoEdicion.setText("");
            campoTextoClasificacion.setText("");
        }

        // Si la operación es Actualizar
        if (operacion == ConstantesGUI.ACTUALIZAR) {
            campoTextoTitulo.setText(libro.getTitulo());
            campoTextoAutor.setText(libro.getAutor());
            campoTextoEditorial.setText(libro.getEditorial());
            campoTextoEdicion.setText(libro.getEdicion());
            campoTextoClasificacion.setText(libro.getClasificacion());
        }
    }//GEN-LAST:event_botonRestaurarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        // Destruye el cuadro de díalogo
        dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonRestaurar;
    private javax.swing.JTextField campoTextoAutor;
    private javax.swing.JTextField campoTextoClasificacion;
    private javax.swing.JTextField campoTextoEdicion;
    private javax.swing.JTextField campoTextoEditorial;
    private javax.swing.JTextField campoTextoISBN;
    private javax.swing.JTextField campoTextoTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
    private Libro libro;
    private int operacion;
    private StringBuffer respuesta;
}
