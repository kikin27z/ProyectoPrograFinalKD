package interfazUsuario;

import control.Control;
import control.Tabla;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Diego Valenzuela Parra
 */
public class FrmBiblioteca extends javax.swing.JFrame {

    /**
     * Creates new form FrmBiblioteca
     */
    public FrmBiblioteca() {
        initComponents();
        centraVentana();
    }

    /**
     * Este método centra la ventana de la aplicación sobre la pantalla
     */
    private void centraVentana() {
        //Obtiene el tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Obtiene el tamaño de la ventana de la aplicación
        Dimension frameSize = getSize();

        // Se asegura que el tamaño de la ventana de la aplicación
        // no exceda el tamaño de la pantalla
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }

        // Centra la ventana de la aplicación sobre la pantalla
        setLocation((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
    }

    /**
     * Este método crea un objeto del tipo JTable dentro de un panel con barras
     * de deslizamiento y la despliega.
     *
     * @param tabla objeto TableModel con los datos de una tabla
     */
    public void despliegaTabla(Tabla tabla) {
        // Crea la tabla a partir del modelo de la tabla con los valores
        // de los titulos de las columnas y los valores de las celdas
        jtabla = new javax.swing.JTable(tabla.getModeloTabla());
        // Establece el título de la tabla
        tituloTabla.setText(tabla.getTitulo());
        // Hace que el control del tamaño de la tabla y la porción visible
        // lo tenga la barra de deslizamiento y no la tabla
        jtabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtabla.setAutoscrolls(false);
        // Hace visible la tabla dentro del panel con barras de
        // deslizamiento
        jScrollPane1.setViewportView(jtabla);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloTabla = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menuBar = new javax.swing.JMenuBar();
        menuCatalogos = new javax.swing.JMenu();
        menuCatalogoLibros = new javax.swing.JMenu();
        opcionMenuAgregarLibro = new javax.swing.JMenuItem();
        opcionMenuActualizarLibro = new javax.swing.JMenuItem();
        opcionMenuEliminarLibro = new javax.swing.JMenuItem();
        menuCatalogoUsuarios = new javax.swing.JMenu();
        opcionMenuAgregarUsuario = new javax.swing.JMenuItem();
        opcionMenuActualizarUsuario = new javax.swing.JMenuItem();
        opcionMenuEliminarUsuario = new javax.swing.JMenuItem();
        separador = new javax.swing.JPopupMenu.Separator();
        opcionMenuSalir = new javax.swing.JMenuItem();
        menuInventarios = new javax.swing.JMenu();
        menuInventarioLibros = new javax.swing.JMenu();
        opcionMenuInventariarLibro = new javax.swing.JMenuItem();
        opcionMenuDesinventariarLibro = new javax.swing.JMenuItem();
        menuPrestamos = new javax.swing.JMenu();
        menuPrestamosLibros = new javax.swing.JMenu();
        opcionMenuPrestarLibro = new javax.swing.JMenuItem();
        opcionMenuDevolverLibro = new javax.swing.JMenuItem();
        menuConsultas = new javax.swing.JMenu();
        menuConsultaLibros = new javax.swing.JMenu();
        opcionMenuConsultaLibros = new javax.swing.JMenuItem();
        opcionMenuConsultaLibrosAutor = new javax.swing.JMenuItem();
        opcionMenuConsultaLibrosClasificacion = new javax.swing.JMenuItem();
        opcionMenuConsultaLibrosEditorial = new javax.swing.JMenuItem();
        opcionMenuConsultaUsuarios = new javax.swing.JMenuItem();
        menuConsultaInventarioLibros = new javax.swing.JMenu();
        opcionMenuConsultaInventarioLibros = new javax.swing.JMenuItem();
        opcionMenuConsultaInventarioLibrosPrestados = new javax.swing.JMenuItem();
        opcionMenuConsultaInventarioLibrosDisponibles = new javax.swing.JMenuItem();
        menuConsultaPrestamosLibros = new javax.swing.JMenu();
        opcionMenuConsultaPrestamosLibros = new javax.swing.JMenuItem();
        opcionMenuConsultaPrestamosLibrosUsuario = new javax.swing.JMenuItem();
        opcionMenuConsultaPrestamosLibro = new javax.swing.JMenuItem();
        opcionMenuConsultaPrestamosLibrosPeriodo = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();
        opcionMenuAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de Biblioteca");

        tituloTabla.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jScrollPane1.setBorder(null);

        menuCatalogos.setMnemonic('f');
        menuCatalogos.setText("Catálogos");

        menuCatalogoLibros.setText("Libros");
        menuCatalogoLibros.setToolTipText("");

        opcionMenuAgregarLibro.setText("Agregar");
        opcionMenuAgregarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionMenuAgregarLibroActionPerformed(evt);
            }
        });
        menuCatalogoLibros.add(opcionMenuAgregarLibro);

        opcionMenuActualizarLibro.setText("Actualizar");
        opcionMenuActualizarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionMenuActualizarLibroActionPerformed(evt);
            }
        });
        menuCatalogoLibros.add(opcionMenuActualizarLibro);

        opcionMenuEliminarLibro.setText("Eliminar");
        opcionMenuEliminarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionMenuEliminarLibroActionPerformed(evt);
            }
        });
        menuCatalogoLibros.add(opcionMenuEliminarLibro);

        menuCatalogos.add(menuCatalogoLibros);

        menuCatalogoUsuarios.setText("Usuarios");

        opcionMenuAgregarUsuario.setText("Agregar");
        opcionMenuAgregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionMenuAgregarUsuarioActionPerformed(evt);
            }
        });
        menuCatalogoUsuarios.add(opcionMenuAgregarUsuario);

        opcionMenuActualizarUsuario.setText("Actualizar");
        opcionMenuActualizarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionMenuActualizarUsuarioActionPerformed(evt);
            }
        });
        menuCatalogoUsuarios.add(opcionMenuActualizarUsuario);

        opcionMenuEliminarUsuario.setText("Eliminar");
        opcionMenuEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionMenuEliminarUsuarioActionPerformed(evt);
            }
        });
        menuCatalogoUsuarios.add(opcionMenuEliminarUsuario);

        menuCatalogos.add(menuCatalogoUsuarios);
        menuCatalogos.add(separador);

        opcionMenuSalir.setMnemonic('x');
        opcionMenuSalir.setText("Salir");
        opcionMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionMenuSalirActionPerformed(evt);
            }
        });
        menuCatalogos.add(opcionMenuSalir);

        menuBar.add(menuCatalogos);

        menuInventarios.setText("Inventarios");

        menuInventarioLibros.setText("Libros");

        opcionMenuInventariarLibro.setText("Inventariar");
        opcionMenuInventariarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionMenuInventariarLibroActionPerformed(evt);
            }
        });
        menuInventarioLibros.add(opcionMenuInventariarLibro);

        opcionMenuDesinventariarLibro.setText("Desinventariar");
        opcionMenuDesinventariarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionMenuDesinventariarLibroActionPerformed(evt);
            }
        });
        menuInventarioLibros.add(opcionMenuDesinventariarLibro);

        menuInventarios.add(menuInventarioLibros);

        menuBar.add(menuInventarios);

        menuPrestamos.setText("Préstamos");

        menuPrestamosLibros.setText("Libros");

        opcionMenuPrestarLibro.setText("Prestar");
        opcionMenuPrestarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionMenuPrestarLibroActionPerformed(evt);
            }
        });
        menuPrestamosLibros.add(opcionMenuPrestarLibro);

        opcionMenuDevolverLibro.setText("Devolver");
        opcionMenuDevolverLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionMenuDevolverLibroActionPerformed(evt);
            }
        });
        menuPrestamosLibros.add(opcionMenuDevolverLibro);

        menuPrestamos.add(menuPrestamosLibros);

        menuBar.add(menuPrestamos);

        menuConsultas.setText("Consultas");

        menuConsultaLibros.setText("Libros");

        opcionMenuConsultaLibros.setText("Todos");
        opcionMenuConsultaLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionMenuConsultaLibrosActionPerformed(evt);
            }
        });
        menuConsultaLibros.add(opcionMenuConsultaLibros);

        opcionMenuConsultaLibrosAutor.setText("Por autor");
        opcionMenuConsultaLibrosAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionMenuConsultaLibrosAutorActionPerformed(evt);
            }
        });
        menuConsultaLibros.add(opcionMenuConsultaLibrosAutor);

        opcionMenuConsultaLibrosClasificacion.setText("Por Clasificación");
        opcionMenuConsultaLibrosClasificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionMenuConsultaLibrosClasificacionActionPerformed(evt);
            }
        });
        menuConsultaLibros.add(opcionMenuConsultaLibrosClasificacion);

        opcionMenuConsultaLibrosEditorial.setText("Por Editorial");
        opcionMenuConsultaLibrosEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionMenuConsultaLibrosEditorialActionPerformed(evt);
            }
        });
        menuConsultaLibros.add(opcionMenuConsultaLibrosEditorial);

        menuConsultas.add(menuConsultaLibros);

        opcionMenuConsultaUsuarios.setText("Usuarios");
        opcionMenuConsultaUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionMenuConsultaUsuariosActionPerformed(evt);
            }
        });
        menuConsultas.add(opcionMenuConsultaUsuarios);

        menuConsultaInventarioLibros.setText("Inventario Libros");

        opcionMenuConsultaInventarioLibros.setText("Todos");
        opcionMenuConsultaInventarioLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionMenuConsultaInventarioLibrosActionPerformed(evt);
            }
        });
        menuConsultaInventarioLibros.add(opcionMenuConsultaInventarioLibros);

        opcionMenuConsultaInventarioLibrosPrestados.setText("Prestados");
        opcionMenuConsultaInventarioLibrosPrestados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionMenuConsultaInventarioLibrosPrestadosActionPerformed(evt);
            }
        });
        menuConsultaInventarioLibros.add(opcionMenuConsultaInventarioLibrosPrestados);

        opcionMenuConsultaInventarioLibrosDisponibles.setText("Disponibles");
        opcionMenuConsultaInventarioLibrosDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionMenuConsultaInventarioLibrosDisponiblesActionPerformed(evt);
            }
        });
        menuConsultaInventarioLibros.add(opcionMenuConsultaInventarioLibrosDisponibles);

        menuConsultas.add(menuConsultaInventarioLibros);

        menuConsultaPrestamosLibros.setText("Préstamos Libros");

        opcionMenuConsultaPrestamosLibros.setText("Todos");
        opcionMenuConsultaPrestamosLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionMenuConsultaPrestamosLibrosActionPerformed(evt);
            }
        });
        menuConsultaPrestamosLibros.add(opcionMenuConsultaPrestamosLibros);

        opcionMenuConsultaPrestamosLibrosUsuario.setText("Por Usuario");
        opcionMenuConsultaPrestamosLibrosUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionMenuConsultaPrestamosLibrosUsuarioActionPerformed(evt);
            }
        });
        menuConsultaPrestamosLibros.add(opcionMenuConsultaPrestamosLibrosUsuario);

        opcionMenuConsultaPrestamosLibro.setText("Por Libro");
        opcionMenuConsultaPrestamosLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionMenuConsultaPrestamosLibroActionPerformed(evt);
            }
        });
        menuConsultaPrestamosLibros.add(opcionMenuConsultaPrestamosLibro);

        opcionMenuConsultaPrestamosLibrosPeriodo.setText("Por Periodo");
        opcionMenuConsultaPrestamosLibrosPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionMenuConsultaPrestamosLibrosPeriodoActionPerformed(evt);
            }
        });
        menuConsultaPrestamosLibros.add(opcionMenuConsultaPrestamosLibrosPeriodo);

        menuConsultas.add(menuConsultaPrestamosLibros);

        menuBar.add(menuConsultas);

        menuAyuda.setMnemonic('h');
        menuAyuda.setText("Ayuda");

        opcionMenuAcercaDe.setText("Acerca de");
        menuAyuda.add(opcionMenuAcercaDe);

        menuBar.add(menuAyuda);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloTabla)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(tituloTabla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        jScrollPane1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método oyente que cierra el programa si el usuario da clic en salir.
     * @param evt Evento al que escucha
     */
    private void opcionMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionMenuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_opcionMenuSalirActionPerformed

    /**
     * Método oyente que agrega un libro al catálogo de libros
     * @param evt Evento al que escucha
     */
    private void opcionMenuAgregarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionMenuAgregarLibroActionPerformed
        // Agrega el nuevo libro
        if (control.agregaLibro(this)) {
            // Obtiene la lista de libros
            Tabla tablaLibros = control.getTablaLibros(this);
            // Despliega la lista de libros
            despliegaTabla(tablaLibros);
        }
    }//GEN-LAST:event_opcionMenuAgregarLibroActionPerformed

    /**
     * Método oyente que actualiza un libro del catálogo de libros
     * @param evt Evento al que escucha
     */
    private void opcionMenuActualizarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionMenuActualizarLibroActionPerformed
        // Actualiza el libro
        if (control.actualizaLibro(this)) {
            // Obtiene la lista de libros
            Tabla tablaLibros = control.getTablaLibros(this);
            // Despliega la lista de libros
            despliegaTabla(tablaLibros);
        }
    }//GEN-LAST:event_opcionMenuActualizarLibroActionPerformed

    /**
     * Método oyente que elimina un libro del catálogo de libros
     * @param evt Evento al que escucha
     */
    private void opcionMenuEliminarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionMenuEliminarLibroActionPerformed
        if (control.eliminaLibro(this)) {
            // Obtiene la lista de libros
            Tabla tablaLibros = control.getTablaLibros(this);
            // Despliega la lista de libros
            despliegaTabla(tablaLibros);
        }
    }//GEN-LAST:event_opcionMenuEliminarLibroActionPerformed

     /**
     * Método oyente que agrega un usuario al catálogo de usuarios
     * @param evt Evento al que escucha
     */
    private void opcionMenuAgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionMenuAgregarUsuarioActionPerformed
        // Agrega el nuevo usuario
        if (control.agregaUsuario(this)) {
            // Obtiene la lista de usuarios
            Tabla tablaUsuarios = control.getTablaUsuarios(this);
            // Despliega la lista de libros
            despliegaTabla(tablaUsuarios);
        }
    }//GEN-LAST:event_opcionMenuAgregarUsuarioActionPerformed

    /**
     * Método oyente que actualiza un usuario del catálogo de usuarios
     * @param evt Evento al que escucha
     */
    private void opcionMenuActualizarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionMenuActualizarUsuarioActionPerformed
        // Actualiza el usuario
        if (control.actualizarUsuario(this)) {
            // Obtiene la lista de usuarios
            Tabla tablaUsuarios = control.getTablaUsuarios(this);
            // Despliega la lista de libros
            despliegaTabla(tablaUsuarios);
        }
    }//GEN-LAST:event_opcionMenuActualizarUsuarioActionPerformed

    /**
     * Método oyente que elimina un usuario del catálogo de usuarios
     * @param evt Evento al que escucha
     */
    private void opcionMenuEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionMenuEliminarUsuarioActionPerformed
        if (control.eliminaUsuario(this)) {
            // Obtiene la lista de usuarios
            Tabla tablaUsuarios = control.getTablaUsuarios(this);
            // Despliega la lista de libros
            despliegaTabla(tablaUsuarios);
        }
    }//GEN-LAST:event_opcionMenuEliminarUsuarioActionPerformed
    
    /**
     * Método oyente que inventaría un libro en el inventario
     * @param evt Evento al que escucha
     */
    private void opcionMenuInventariarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionMenuInventariarLibroActionPerformed
        // Inventaría el nuevo libro
        if (control.inventariaLibro(this)) {
            // Obtiene la lista del inventario
            Tabla tablaInventario = control.getTablaInventario(this);
            // Despliega la lista del inventario
            despliegaTabla(tablaInventario);
        }
    }//GEN-LAST:event_opcionMenuInventariarLibroActionPerformed

    private void opcionMenuDesinventariarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionMenuDesinventariarLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionMenuDesinventariarLibroActionPerformed

    private void opcionMenuPrestarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionMenuPrestarLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionMenuPrestarLibroActionPerformed

    private void opcionMenuDevolverLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionMenuDevolverLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionMenuDevolverLibroActionPerformed

    /**
     * Método oyente que obtiene y despliega la lista de libros
     * @param evt Evento al que escucha
     */
    private void opcionMenuConsultaLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionMenuConsultaLibrosActionPerformed
        // Obtiene la lista de libros
        Tabla tablaLibros = control.getTablaLibros(this);
        // Despliega la lista de libros
        if (tablaLibros != null) {
            despliegaTabla(tablaLibros);
        }
    }//GEN-LAST:event_opcionMenuConsultaLibrosActionPerformed

    private void opcionMenuConsultaLibrosAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionMenuConsultaLibrosAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionMenuConsultaLibrosAutorActionPerformed

    private void opcionMenuConsultaLibrosClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionMenuConsultaLibrosClasificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionMenuConsultaLibrosClasificacionActionPerformed

    private void opcionMenuConsultaLibrosEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionMenuConsultaLibrosEditorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionMenuConsultaLibrosEditorialActionPerformed

    private void opcionMenuConsultaInventarioLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionMenuConsultaInventarioLibrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionMenuConsultaInventarioLibrosActionPerformed

    private void opcionMenuConsultaUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionMenuConsultaUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionMenuConsultaUsuariosActionPerformed

    private void opcionMenuConsultaInventarioLibrosPrestadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionMenuConsultaInventarioLibrosPrestadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionMenuConsultaInventarioLibrosPrestadosActionPerformed

    private void opcionMenuConsultaInventarioLibrosDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionMenuConsultaInventarioLibrosDisponiblesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionMenuConsultaInventarioLibrosDisponiblesActionPerformed

    private void opcionMenuConsultaPrestamosLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionMenuConsultaPrestamosLibrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionMenuConsultaPrestamosLibrosActionPerformed

    private void opcionMenuConsultaPrestamosLibrosUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionMenuConsultaPrestamosLibrosUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionMenuConsultaPrestamosLibrosUsuarioActionPerformed

    private void opcionMenuConsultaPrestamosLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionMenuConsultaPrestamosLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionMenuConsultaPrestamosLibroActionPerformed

    private void opcionMenuConsultaPrestamosLibrosPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionMenuConsultaPrestamosLibrosPeriodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionMenuConsultaPrestamosLibrosPeriodoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBiblioteca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuCatalogoLibros;
    private javax.swing.JMenu menuCatalogoUsuarios;
    private javax.swing.JMenu menuCatalogos;
    private javax.swing.JMenu menuConsultaInventarioLibros;
    private javax.swing.JMenu menuConsultaLibros;
    private javax.swing.JMenu menuConsultaPrestamosLibros;
    private javax.swing.JMenu menuConsultas;
    private javax.swing.JMenu menuInventarioLibros;
    private javax.swing.JMenu menuInventarios;
    private javax.swing.JMenu menuPrestamos;
    private javax.swing.JMenu menuPrestamosLibros;
    private javax.swing.JMenuItem opcionMenuAcercaDe;
    private javax.swing.JMenuItem opcionMenuActualizarLibro;
    private javax.swing.JMenuItem opcionMenuActualizarUsuario;
    private javax.swing.JMenuItem opcionMenuAgregarLibro;
    private javax.swing.JMenuItem opcionMenuAgregarUsuario;
    private javax.swing.JMenuItem opcionMenuConsultaInventarioLibros;
    private javax.swing.JMenuItem opcionMenuConsultaInventarioLibrosDisponibles;
    private javax.swing.JMenuItem opcionMenuConsultaInventarioLibrosPrestados;
    private javax.swing.JMenuItem opcionMenuConsultaLibros;
    private javax.swing.JMenuItem opcionMenuConsultaLibrosAutor;
    private javax.swing.JMenuItem opcionMenuConsultaLibrosClasificacion;
    private javax.swing.JMenuItem opcionMenuConsultaLibrosEditorial;
    private javax.swing.JMenuItem opcionMenuConsultaPrestamosLibro;
    private javax.swing.JMenuItem opcionMenuConsultaPrestamosLibros;
    private javax.swing.JMenuItem opcionMenuConsultaPrestamosLibrosPeriodo;
    private javax.swing.JMenuItem opcionMenuConsultaPrestamosLibrosUsuario;
    private javax.swing.JMenuItem opcionMenuConsultaUsuarios;
    private javax.swing.JMenuItem opcionMenuDesinventariarLibro;
    private javax.swing.JMenuItem opcionMenuDevolverLibro;
    private javax.swing.JMenuItem opcionMenuEliminarLibro;
    private javax.swing.JMenuItem opcionMenuEliminarUsuario;
    private javax.swing.JMenuItem opcionMenuInventariarLibro;
    private javax.swing.JMenuItem opcionMenuPrestarLibro;
    private javax.swing.JMenuItem opcionMenuSalir;
    private javax.swing.JPopupMenu.Separator separador;
    private javax.swing.JLabel tituloTabla;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JTable jtabla;
    Control control = new Control();
}
