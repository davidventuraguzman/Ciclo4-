package Presentacion.Contenido;


import Conexion.*;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import Presentacion.Menu;
import Datos.Biblioteca;
import Negocio.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
public class Books extends javax.swing.JPanel {

DefaultTableModel modelo;
DocumentosRepertorio documentorepertorio=new DocumentosRepertorio();
    public Books() {
        initComponents();
        InitStyles();
        cargarlibros();
        DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
        centrar.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tablaLibros.getColumnCount(); i++) {
            if (tablaLibros.getColumnClass(i) != Boolean.class) {
                tablaLibros.getColumnModel().getColumn(i).setCellRenderer(centrar);
            }
        }
    }
    
    private void InitStyles() {
     buscarLibro.putClientProperty("JTextField.placeholderText", "Ingrese el título del libro");
    }
    
    
    private void cargarlibros(){
        modelo= (DefaultTableModel) tablaLibros.getModel();

        for (Documento doc : documentorepertorio.read()) {
            if (doc instanceof Revista){
            System.out.println("dd"+doc);
            Revista revi= (Revista) doc;
            Object[] fila = new Object[]{
            "Revista",
            revi.getCodigo(),                 
            revi.getTitulo(),              
            revi.getAnoPub(),    
            revi.getAutor(),              
            revi.getEditorial(),
            revi.getNumero(),
            revi.getVolumen(),
            revi.isPrestado(),
            };  modelo.addRow(fila);   
            }else if(doc instanceof Libro){
            System.out.println("dd"+doc);
            Libro lib= (Libro) doc;
            Object[] fila = new Object[]{
            "Libro",
            lib.getCodigo(),                 
            lib.getTitulo(),              
            lib.getAnoPub(),    
            lib.getAutor(),              
            lib.getEditorial(),
            "",
            "",
            lib.isPrestado(),
            };       
                modelo.addRow(fila);   
        }
    }
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        buscarLibro = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLibros = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setText("Libros");
        bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 45, -1));
        bg.add(buscarLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 36, 596, 40));

        searchButton.setBackground(new java.awt.Color(204, 0, 0));
        searchButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Buscar");
        searchButton.setBorderPainted(false);
        searchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        bg.add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 36, -1, 40));

        deleteButton.setBackground(new java.awt.Color(204, 0, 0));
        deleteButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Borrar");
        deleteButton.setBorderPainted(false);
        deleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        bg.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, 100, -1));

        editButton.setBackground(new java.awt.Color(204, 0, 0));
        editButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Editar");
        editButton.setBorderPainted(false);
        editButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        bg.add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, 90, -1));

        addButton.setBackground(new java.awt.Color(204, 0, 0));
        addButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Nuevo");
        addButton.setBorderPainted(false);
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        bg.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 100, -1));

        tablaLibros.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tablaLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "ID", "Título", "Fecha de Pub", "Autor", "Editorial", "Volúmen", "Número", "Prestado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaLibros.getTableHeader().setReorderingAllowed(false);
        tablaLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaLibrosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaLibros);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 89, 667, 240));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tablaLibrosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaLibrosMousePressed
        
    }//GEN-LAST:event_tablaLibrosMousePressed

    private void busquedaLibro(List<Documento> docu){
         modelo.setRowCount(0); 
        for (Documento doc : docu) {
            if (doc instanceof Revista){
            System.out.println("dd"+doc);
            Revista revi= (Revista) doc;
            Object[] fila = new Object[]{
            "Revista",
            revi.getCodigo(),                 
            revi.getTitulo(),              
            revi.getAnoPub(),    
            revi.getAutor(),              
            revi.getEditorial(),
            revi.getNumero(),
            revi.getVolumen(),
            revi.isPrestado(),
            };  modelo.addRow(fila);   
            }else if(doc instanceof Libro){
            System.out.println("dd"+doc);
            Libro lib= (Libro) doc;
            Object[] fila = new Object[]{
            "Libro",
            lib.getCodigo(),                 
            lib.getTitulo(),              
            lib.getAnoPub(),    
            lib.getAutor(),              
            lib.getEditorial(),
            "",
            "",
            lib.isPrestado(),
            };       
                modelo.addRow(fila);   
        }
    }
    }
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
            Menu.mostrar(new IngresarLibro());
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int seleccion=tablaLibros.getSelectedRow();
        if (tablaLibros.getSelectedRow() > -1) {
            try {
                String Id = (String)tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 1);

                documentorepertorio.delete(Id);
                Menu.mostrar(new Books());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Debes seleccionar el libro a eliminar.\n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        String titulo= buscarLibro.getText();
         if (titulo.isEmpty()) {
        actulizarLibro();
        return;
         }
        busquedaLibro(documentorepertorio.buscarLibroPorTitulo(titulo));
    }//GEN-LAST:event_searchButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed

        int seleccion=tablaLibros.getSelectedRow();
        if (tablaLibros.getSelectedRow() > -1) {
            try {
                String bookId = (String)tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 1);

                Menu.mostrar(new IngresarLibro(bookId,documentorepertorio.buscarPorId(bookId)));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Debes seleccionar el libro a editar.\n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editButtonActionPerformed
    private void actulizarLibro(){
         modelo.setRowCount(0); 
        modelo= (DefaultTableModel) tablaLibros.getModel();

        for (Documento doc : documentorepertorio.read()) {
            if (doc instanceof Revista){
            System.out.println("dd"+doc);
            Revista revi= (Revista) doc;
            Object[] fila = new Object[]{
            "Revista",
            revi.getCodigo(),                 
            revi.getTitulo(),              
            revi.getAnoPub(),    
            revi.getAutor(),              
            revi.getEditorial(),
            revi.getNumero(),
            revi.getVolumen(),
            revi.isPrestado(),
            };  modelo.addRow(fila);   
            }else if(doc instanceof Libro){
            System.out.println("dd"+doc);
            Libro lib= (Libro) doc;
            Object[] fila = new Object[]{
            "Libro",
            lib.getCodigo(),                 
            lib.getTitulo(),              
            lib.getAnoPub(),    
            lib.getAutor(),              
            lib.getEditorial(),
            "",
            "",
            lib.isPrestado(),
            };       
                modelo.addRow(fila);   
        }
    }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JPanel bg;
    private javax.swing.JTextField buscarLibro;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchButton;
    private javax.swing.JTable tablaLibros;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}