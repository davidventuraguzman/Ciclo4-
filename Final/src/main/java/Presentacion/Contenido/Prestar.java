
package Presentacion.Contenido;

import Conexion.DocumentosRepertorio;
import Conexion.PrestamosRepertorio;
import Conexion.UsuarioRepertorio;
import Datos.Biblioteca;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JOptionPane;
import Negocio.Prestamos;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Prestar extends javax.swing.JPanel {
    PrestamosRepertorio prestamosrepertorio=new PrestamosRepertorio();
    private String fechaActual;
    /**
     * Creates new form NewJPanel
     */
    public Prestar() {
        initComponents(); 
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaEnString = fechaActual.format(formato);
        this.fechaActual=fechaEnString;
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        folioLbl = new javax.swing.JLabel();
        idUser = new javax.swing.JTextField();
        libroIdLbl = new javax.swing.JLabel();
        idLibro = new javax.swing.JTextField();
        prestar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        folioLbl1 = new javax.swing.JLabel();
        comMes = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDia = new javax.swing.JTextField();
        txtAños = new javax.swing.JTextField();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(750, 390));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prestamo.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, -1));

        folioLbl.setText("Fecha de Entrega");
        jPanel2.add(folioLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, -1, 29));

        idUser.setToolTipText("");
        jPanel2.add(idUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 170, 40));

        libroIdLbl.setText("Libro ID");
        jPanel2.add(libroIdLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 45, 29));
        jPanel2.add(idLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 170, 40));

        prestar.setBackground(new java.awt.Color(204, 0, 0));
        prestar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        prestar.setForeground(new java.awt.Color(255, 255, 255));
        prestar.setText("Prestar");
        prestar.setBorderPainted(false);
        prestar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        prestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prestarActionPerformed(evt);
            }
        });
        jPanel2.add(prestar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 240, 50));

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 10));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 10, 320));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("NUEVO PRESTAMO");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, -1, -1));

        folioLbl1.setText("Usuario ID");
        jPanel2.add(folioLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, 29));

        comMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jPanel2.add(comMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 100, 30));

        jLabel3.setText("Día:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, -1, -1));

        jLabel4.setText("Mes:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, -1, -1));

        jLabel5.setText("Año:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, -1, -1));
        jPanel2.add(txtDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 80, 30));
        jPanel2.add(txtAños, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 80, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void prestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prestarActionPerformed
       String idUser=this.idUser.getText();
       int id=Integer.parseInt(idUser);
       String idLibro=this.idLibro.getText();
       String dia=this.txtDia.getText();
       String año=this.txtAños.getText();
       String opDoc=Integer.toString(comMes.getSelectedIndex());
       String fecha=dia+"-"+opDoc+"-"+año;
       if (UsuarioRepertorio.existeLibro(idLibro)){
           if(UsuarioRepertorio.existeUsuario(id)){
            if(!DocumentosRepertorio.verificarDiponibilidad(idLibro)){
            Prestamos pres=new Prestamos(id, idLibro, fechaActual, fecha,false);
            prestamosrepertorio.create(pres);
            JOptionPane.showMessageDialog(null, "Prestamo con exito");
            DocumentosRepertorio.actulizatEstadoNO(idLibro);
            }else {
            JOptionPane.showMessageDialog(null, "El libro no se encuentra disponible");
            }
            ;
           }else {
           JOptionPane.showMessageDialog(null, "El usuario no existe");
           limpiarCampos();
           }
       }else{
       JOptionPane.showMessageDialog(null, "El libro no existe");
       }
       
    }//GEN-LAST:event_prestarActionPerformed
    private void limpiarCampos(){
        idLibro.setText("");
        idUser.setText("");
        txtAños.setText("");
        txtDia.setText("");
    }
    private static boolean fechaVer(){
         boolean b = false;
    
        if (txtDia.getText().isEmpty() || txtAños.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Verifique que todos los campos de fecha estén llenos");
            return false;
     }

    try {
        int dia = Integer.parseInt(txtDia.getText());
        int año = Integer.parseInt(txtAños.getText());
        
        if (dia > 0 && dia < 32) {
            if (año > 2023 && año < 3000) {
                b = true;
            } else {
                JOptionPane.showMessageDialog(null, "Verifique la fecha");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Verifique la fecha");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Ingrese valores numéricos válidos en los campos de fecha");
    }
    
    return b;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comMes;
    private javax.swing.JLabel folioLbl;
    private javax.swing.JLabel folioLbl1;
    private javax.swing.JTextField idLibro;
    private javax.swing.JTextField idUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel libroIdLbl;
    private javax.swing.JButton prestar;
    private static javax.swing.JTextField txtAños;
    private static javax.swing.JTextField txtDia;
    // End of variables declaration//GEN-END:variables
}
