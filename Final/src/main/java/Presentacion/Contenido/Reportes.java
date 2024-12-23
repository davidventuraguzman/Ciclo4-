/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentacion.Contenido;

import Conexion.PrestamosRepertorio;
import javax.swing.table.DefaultTableModel;
import Presentacion.Menu;
import Negocio.*;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author LENOVO
 */
public class Reportes extends javax.swing.JPanel {
  PrestamosRepertorio prestamorepertorio=new PrestamosRepertorio();
  DefaultTableModel modelo;
    public Reportes() {
        initComponents();
        modelo= (DefaultTableModel) tablaReportes.getModel();
         for (Prestamos pres :prestamorepertorio.read()) {
            System.out.println("dd"+pres);
            Object[] fila = new Object[]{
            pres.getId_prestamo(),
            pres.getId_libro(),                 
            pres.getId_user(),              
            pres.getFecha_prestamo(),    
            pres.getFecha_devolucion(),
            pres.isEstado(),
        };
           modelo.addRow(fila);   
        }
         DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
        centrar.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tablaReportes.getColumnCount(); i++) {
            // Evitar aplicar el renderer en la columna de booleanos (índice 8)
            if (tablaReportes.getColumnClass(i) != Boolean.class) {
                tablaReportes.getColumnModel().getColumn(i).setCellRenderer(centrar);
            }
        }
    }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaReportes = new javax.swing.JTable();
        actulizar = new javax.swing.JButton();
        imprimir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        borrar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(750, 390));

        tablaReportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID-Reporte", "ID-Libro", "ID-User", "Fecha Salida", "Fecha Entrega", "Entregado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaReportes);

        actulizar.setBackground(new java.awt.Color(204, 0, 0));
        actulizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        actulizar.setForeground(new java.awt.Color(255, 255, 255));
        actulizar.setText("Actulizar");
        actulizar.setBorderPainted(false);
        actulizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        actulizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actulizarActionPerformed(evt);
            }
        });

        imprimir.setBackground(new java.awt.Color(204, 0, 0));
        imprimir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        imprimir.setForeground(new java.awt.Color(255, 255, 255));
        imprimir.setText("Imprimir");
        imprimir.setBorderPainted(false);
        imprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirActionPerformed(evt);
            }
        });

        jLabel1.setText("Reportes");

        borrar.setBackground(new java.awt.Color(204, 0, 0));
        borrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        borrar.setForeground(new java.awt.Color(255, 255, 255));
        borrar.setText("Borrar");
        borrar.setBorderPainted(false);
        borrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(actulizar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imprimir)
                    .addComponent(actulizar)
                    .addComponent(borrar)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void actulizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actulizarActionPerformed

    }//GEN-LAST:event_actulizarActionPerformed

    private void imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirActionPerformed
   int seleccion=tablaReportes.getSelectedRow();
        if (seleccion!= -1) { // Si hay una fila seleccionada
            // Obtener los valores de la fila seleccionada
            int nombre = (int)modelo.getValueAt(seleccion, 0);
            String libroid = (String) modelo.getValueAt(seleccion, 1);
            int userid = (int) modelo.getValueAt(seleccion, 2);
            String fechaSalida = (String) modelo.getValueAt(seleccion, 3);
            String fechaEntrada= (String) modelo.getValueAt(seleccion, 4);
              int conta = 0;
       
        for (int i = 0; i < 10; i++) {
            Reportes archivo = new Reportes();
            boolean check = archivo.crearArchivodeTexto(conta);
            archivo.escribirArchivo(nombre,libroid, userid, fechaSalida, fechaEntrada);
            conta = conta + 1;
            
            if(check){
                return;
            }
           
            
        }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Por favor, Seleccione la Reporte",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
    }  
    }//GEN-LAST:event_imprimirActionPerformed
    
    
    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
    int seleccion=tablaReportes.getSelectedRow();
        if (tablaReportes.getSelectedRow() > -1) {
            try {
                int Id = (int)tablaReportes.getValueAt(tablaReportes.getSelectedRow(), 0);
                String cod=Integer.toString(Id);
                prestamorepertorio.delete(cod);
                Menu.mostrar(new Reportes());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Debes seleccionar un reporte.\n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_borrarActionPerformed
    File archivo;

    private boolean crearArchivodeTexto(int a) {
        boolean check  = false;
        try {
            archivo = new File("C:\\Users\\LENOVO\\Desktop\\Reportes\\"+a+"archivo.txt");
            
            if (archivo.createNewFile()) {
                System.out.println("Se ha creado el archivo");
                JOptionPane.showMessageDialog(this, "Reporte creado correctamente");
            check  = true;    
            } else {
                System.out.println("No se a podido crear el archivo");
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return check;
    }
    private void eliminarArchivo() {
        if (archivo.delete()) {
            System.out.println("se elimino el archivo");
        } else {
            System.out.println("No se a eliminado el archivo");
        }
    }
    private void escribirArchivo (int nombre,String libroid, int userid, String fechaSalida, String fechaEntrada){
        try{
           FileWriter escribir = new FileWriter(archivo);
           escribir.write(String.format("%s%n", "+-------------------------------+"));
            escribir.write(String.format("|     REPORTE DE PRESTAMO       |%n"));
            escribir.write(String.format("|     %s     |%n", "-------------------------------"));
            escribir.write(String.format("+-------------------------------+%n"));
            
            // Detalles del préstamo
            escribir.write(String.format("| %-30s%-10s |%n", "Id Libro:", libroid));
            escribir.write(String.format("| %-30s%-10s |%n", "Nombre Libro:", nombre));
            escribir.write(String.format("| %-30s%-10s |%n", "Id Usuario:", userid));
            escribir.write(String.format("| %-30s%-10s |%n", "Fecha de Salida:", fechaSalida));
            escribir.write(String.format("| %-30s%-10s |%n", "Fecha de Entrada:", fechaEntrada));
            
            // Línea final
            escribir.write(String.format("+-------------------------------+%n"));
            
            // Línea de separación
            escribir.write(String.format("%s%n", "=============================="));
            escribir.write(String.format("%s%n", "¡Gracias por usar nuestro servicio!"));
            escribir.write(String.format("%s%n", "=============================="));
            
           escribir.close();
        }catch(IOException e){
             e.printStackTrace(System.out);
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actulizar;
    private javax.swing.JButton borrar;
    private javax.swing.JButton imprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaReportes;
    // End of variables declaration//GEN-END:variables
}
