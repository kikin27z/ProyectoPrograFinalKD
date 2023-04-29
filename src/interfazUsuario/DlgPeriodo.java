package interfazUsuario;

import java.awt.Dimension;
import java.awt.Point;
import objetosServicio.Fecha;
import objetosServicio.Periodo;

/**
 *
 * @author Diego Valenzuela Parra y José Karim Franco Valencia
 */
public class DlgPeriodo extends javax.swing.JDialog {

    /**
     * Constructor que establece las características del cuadro de diálogo y la
     * operación a realizar con él
     *
     * @param parent Ventana sobre la que aparecerá el cuadro de diálogo
     * @param title Título del cuadro de diálogo
     * @param modal true si permite acceder fuera de los límites del cuadro de
     * diálogo, false en caso contrario
     * @param periodo Contiene la información del periodo vinculado a los libros
     * @param operacion Operación a realizar en el cuadro de diálogo: AGREGAR =
     * 0, ACTUALIZAR = 1, ELIMINAR = 2, DESPLEGAR = 3;
     * ACEPTAR = "Aceptar", CANCELAR = "Cancelar".
     */
    public DlgPeriodo(java.awt.Frame parent, String title, boolean modal, Periodo periodo, int operacion) {
        super(parent, title, modal);
        this.periodo = periodo;
        this.operacion = operacion;
//        this.respuesta = respuesta;
        initComponents();

        // Establece el valor por omisión para respuesta, por si se cierra el
        // cuadro de diálogo presionando el botón cerrar o el botón cancelar
//        respuesta.append(ConstantesGUI.CANCELAR);
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
        campoTextoDesde = new javax.swing.JTextField();
        campoTextoHasta = new javax.swing.JTextField();
        botonAceptar = new javax.swing.JButton();
        botonRestaurar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Desde (dd/mm/aaaa):");

        jLabel2.setText("Hasta (dd/mm/aaaa):");

        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        botonRestaurar.setText("Restaurar");
        botonRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRestaurarActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(botonAceptar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoTextoHasta, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                            .addComponent(campoTextoDesde)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(botonRestaurar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonCancelar)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoTextoDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoTextoHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAceptar)
                    .addComponent(botonRestaurar)
                    .addComponent(botonCancelar))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método oyente del botón botonAceptar
     *
     */
    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        // Toma los valores capturados en los campos de texto y en la caja
        // combinada y almacénalos en el parámetro cancion.
        periodo.setDesde(new Fecha(campoTextoDesde.getText()));
        periodo.setHasta(new Fecha(campoTextoHasta.getText()));

//        // Borra el contenido de respuesta
//        respuesta.delete(0, respuesta.length());
//        // Establece que se presionó el botón botonAceptar
//        respuesta.append(ConstantesGUI.ACEPTAR);
        // Destruye el cuadro de díalogo
        dispose();
    }//GEN-LAST:event_botonAceptarActionPerformed
    
    /**
     * Método oyente del botón botonRestaurar
     *
     */
    private void botonRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRestaurarActionPerformed
        // Restaura el contenido de los campos de texto a su valor original
        // Si la operación es Agregar
        campoTextoDesde.setText("");
        campoTextoHasta.setText("");
    }//GEN-LAST:event_botonRestaurarActionPerformed

    /**
     * Método oyente del botón botonAceptar
     *
     */
    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        // Destruye el cuadro de díalogo
        dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonRestaurar;
    private javax.swing.JTextField campoTextoDesde;
    private javax.swing.JTextField campoTextoHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
    private Periodo periodo;
    private int operacion;
}
