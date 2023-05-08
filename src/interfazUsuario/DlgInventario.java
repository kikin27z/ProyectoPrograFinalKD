package interfazUsuario;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import objetosNegocio.Publicacion;
import objetosNegocio.PublicacionED;

/**
 *
 * @author Diego Valenzuela Parra y Karim Franco Valencia
 */
public class DlgInventario extends javax.swing.JDialog {

    /**
     * Constructor que establece las características del cuadro de diálogo y la
     * operación a realizar con él
     *
     * @param parent Ventana sobre la que aparecerá el cuadro de diálogo
     * @param title Título del cuadro de diálogo
     * @param modal true si permite acceder fuera de los límites del cuadro de
     * diálogo, false en caso contrario
     * @param publicacionED Contiene la información del libro a agregar o
     * eliminar del inventario de libros
     * @param listaInventario la lista de libros del catálogo de libros
     * @param operacion Operación a realizar en el cuadro de diálogo: AGREGAR =
     * 0, ACTUALIZAR = 1, ELIMINAR = 2, DESPLEGAR = 3;
     * @param respuesta Boton presionado al salir de los cuadros de * diálogos:
     * ACEPTAR = "Aceptar", CANCELAR = "Cancelar".
     */
    public DlgInventario(java.awt.Frame parent, String title, boolean modal, PublicacionED publicacionED, DefaultComboBoxModel listaInventario, int operacion, StringBuffer respuesta) {
        super(parent, title, modal);
        this.publicacionED = publicacionED;
        this.listaInventario = listaInventario;
        this.operacion = operacion;
        this.respuesta = respuesta;
        initComponents();

        // Si la operación es Inventariar
        if (operacion == ConstantesGUI.AGREGAR) {
            botonAceptar.setText("Inventariar");
        } // Si la operación es Desinventariar
        else if (operacion == ConstantesGUI.ELIMINAR) {
            botonAceptar.setText("Desinventariar");
        }
        
        campoTextoCantidad.setTransferHandler(null);

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
        cajaCombinadaLibros = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        campoTextoCantidad = new javax.swing.JTextField();
        botonAceptar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        botonRestaurar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Libro:");

        cajaCombinadaLibros.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cajaCombinadaLibros.setModel(listaInventario);

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel2.setText("Cantidad:");

        campoTextoCantidad.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        campoTextoCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoTextoCantidadKeyTyped(evt);
            }
        });

        botonAceptar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        botonAceptar.setText("Aceptar");
        botonAceptar.setPreferredSize(new java.awt.Dimension(90, 30));
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        botonCancelar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        botonCancelar.setText("Cancelar");
        botonCancelar.setPreferredSize(new java.awt.Dimension(90, 30));
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        botonRestaurar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        botonRestaurar.setText("Restaurar");
        botonRestaurar.setToolTipText("");
        botonRestaurar.setPreferredSize(new java.awt.Dimension(90, 30));
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
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cajaCombinadaLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(campoTextoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addComponent(botonRestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cajaCombinadaLibros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoTextoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonRestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        //Si la opcion es inventariar o desinventariar
        String cantidad = campoTextoCantidad.getText();
        if (!cantidad.equals("")) {
            if (operacion == ConstantesGUI.AGREGAR) {
                publicacionED.setPublicacion((Publicacion) cajaCombinadaLibros.getSelectedItem());
                publicacionED.setExistencia(Integer.parseInt(campoTextoCantidad.getText()));
            } else if (operacion == ConstantesGUI.ELIMINAR) {
                PublicacionED pubEDtmp = (PublicacionED) cajaCombinadaLibros.getSelectedItem();
                publicacionED.setPublicacion(pubEDtmp.getPublicacion());
                publicacionED.setExistencia(Integer.parseInt(campoTextoCantidad.getText()));
            }
            // Borra el contenido de respuesta
            respuesta.delete(0, respuesta.length());
            // Establece que se presionó el botón botonAceptar
            respuesta.append(ConstantesGUI.ACEPTAR);
            // Destruye el cuadro de díalogo
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Introduzca una cantidad válida.", "¡Error!", JOptionPane.ERROR_MESSAGE);
            campoTextoCantidad.setText("");
        }
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void botonRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRestaurarActionPerformed
        if (operacion == ConstantesGUI.AGREGAR || operacion == ConstantesGUI.ELIMINAR) {
            cajaCombinadaLibros.setSelectedIndex(0);
            campoTextoCantidad.setText("");
        }
    }//GEN-LAST:event_botonRestaurarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        // Destruye el cuadro de díalogo
        dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed
    
    /**
    * Evento para prevenir que el usuario ingrese letras en la cantidad.
    * @param evt Evento.
    */
    private void campoTextoCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTextoCantidadKeyTyped
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') ||
           (c == evt.VK_BACK_SPACE) ||
           (c == evt.VK_DELETE))) {
            evt.consume(); // ignorar el evento de tecla
        }
    }//GEN-LAST:event_campoTextoCantidadKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonRestaurar;
    private javax.swing.JComboBox<String> cajaCombinadaLibros;
    private javax.swing.JTextField campoTextoCantidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
    private PublicacionED publicacionED;
    private DefaultComboBoxModel listaInventario;
    private int operacion;
    private StringBuffer respuesta;
}
