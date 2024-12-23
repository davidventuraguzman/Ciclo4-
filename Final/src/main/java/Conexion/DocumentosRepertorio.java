/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.SQLException;
import Negocio.Documento;
import Negocio.Libro;
import Negocio.Revista;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author LENOVO
 */
public class DocumentosRepertorio implements Repositorio<Documento>{
    private Connection getConexion() throws SQLException {
        return BaseDatos.getConnection();
    }
    public List<Documento> buscarLibroPorTitulo(String titulo) {
    String sql = "SELECT * FROM Documentos WHERE UPPER(titulo) LIKE UPPER(?)";
    List<Documento> documentosEncontrados = new ArrayList<>();
    
    try (Connection conn = BaseDatos.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        // Usar '%' para permitir búsquedas parciales, por ejemplo, "%titulo%"
        pstmt.setString(1, "%" + titulo + "%");
        
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                // Extraer datos del ResultSet y agregar a la lista
                String tipoDocumento = rs.getString("tipo"); // Suponiendo que existe una columna "TipoDocumento"
            Documento doc;

            if (tipoDocumento.equals("Revista")) {
                int numero= rs.getInt("Numero");
                int volumen= rs.getInt("Volumen");
                String codigo= rs.getString("codigo");
                String tipo= rs.getString("tipo");
                String autor=rs.getString("autor");
                String editorial=rs.getString("editorial");
                String titu=rs.getString("titulo");
                int año = rs.getInt("Año_Publiacion");
                String disponibilidad = rs.getString("disponibilidad");
                Revista revista = new Revista(volumen, numero, codigo, tipo, titu, autor, editorial, año, disponibilidad.equals("s"));
                doc = revista;  // Guardar como tipo Documento
            } else if (tipoDocumento.equals("Libro")) {
                String codigo= rs.getString("codigo");
                String tipo= rs.getString("tipo");
                String autor=rs.getString("autor");
                String editorial=rs.getString("editorial");
                String titu=rs.getString("titulo");
                int año = rs.getInt("Año_Publiacion");
                String disponibilidad = rs.getString("disponibilidad");
                Libro libro = new Libro(codigo, tipo, titu, autor, editorial, año, disponibilidad.equals("s"));
                doc = libro;  // Guardar como tipo Documento
            } else {
                // Si es otro tipo de documento o hay algún error
                continue;
            }
            documentosEncontrados.add(doc);
            }
        }
    } catch (Exception e) {
        System.out.println("Error al buscar libros: " + e.getMessage());
    }

    return documentosEncontrados;
}

    public static void actulizatEstadoNO(String id){
    String sql = "UPDATE Documentos SET Disponibilidad = ? WHERE codigo = ?";
        try (Connection conn = BaseDatos.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1,"s");
                pstmt.setString(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void actulizatEstadoSI(String id){
    String sql = "UPDATE Documentos SET Disponibilidad = ? WHERE codigo = ?";
        try (Connection conn = BaseDatos.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1,"n");
                pstmt.setString(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static boolean verificarDiponibilidad(String codigo){
      boolean estado=false;  
        String sql = "SELECT Disponibilidad FROM Documentos WHERE codigo = ?";

        try (Connection conn = BaseDatos.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, codigo); // Establece el valor del título en la consulta
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                if(rs.getString("Disponibilidad").equals("s")){
                estado=true;
                } // Asume que el campo en la tabla se llama "estado"
            } else {
                System.out.println("Libro no encontrado.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return estado;
    }
    
    @Override
    public void create(Documento doc) {
       String sql = "INSERT INTO Documentos (codigo, tipo, titulo, autor, editorial, Año_Publiacion, disponibilidad";

    // Si es un libro, no agregamos las columnas de volumen y número de revista
    if (doc instanceof Revista) {
        sql += ", volumen, numero) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    } else if (doc instanceof Libro) {
        sql += ") VALUES (?, ?, ?, ?, ?, ?, ?)";
    }

    try (Connection conn = BaseDatos.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        // Asignar los valores comunes a todos los documentos
        pstmt.setString(1, doc.getCodigo());
        pstmt.setString(2, doc.getTipo());
        pstmt.setString(3, doc.getTitulo());
        pstmt.setString(4, doc.getAutor());
        pstmt.setString(5, doc.getEditorial());
        pstmt.setInt(6, doc.getAnoPub());
        pstmt.setString(7, doc.isPrestado()? "s" : "n");

        // Si es una revista, asignar valores adicionales
        if (doc instanceof Revista) {
            Revista revista = (Revista) doc;
            pstmt.setInt(8, revista.getVolumen());
            pstmt.setInt(9, revista.getNumero());
        }

        // Ejecutar la inserción
        pstmt.executeUpdate();
        System.out.println("Documento insertado correctamente.");

    } catch (SQLException e) {
        System.out.println("Error al insertar el documento: " + e.getMessage());
        e.printStackTrace();
    }
    }

    @Override
    public List<Documento> read() {
        List<Documento> docu = new ArrayList<>();
        String sql = "SELECT * FROM Documentos";
        try (Connection conn = BaseDatos.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
        System.out.println("Consulta ejecutada correctamente");
            while (rs.next()) {
                String tipoDocumento = rs.getString("tipo"); // Suponiendo que existe una columna "TipoDocumento"
            Documento doc;

            if (tipoDocumento.equals("Revista")) {
                int numero= rs.getInt("Numero");
                int volumen= rs.getInt("Volumen");
                String codigo= rs.getString("codigo");
                String tipo= rs.getString("tipo");
                String autor=rs.getString("autor");
                String editorial=rs.getString("editorial");
                String titulo=rs.getString("titulo");
                int año = rs.getInt("Año_Publiacion");
                String disponibilidad = rs.getString("disponibilidad");
                Revista revista = new Revista(volumen, numero, codigo, tipo, titulo, autor, editorial, año, disponibilidad.equals("s"));
                doc = revista;  // Guardar como tipo Documento
            } else if (tipoDocumento.equals("Libro")) {
                String codigo= rs.getString("codigo");
                String tipo= rs.getString("tipo");
                String autor=rs.getString("autor");
                String editorial=rs.getString("editorial");
                String titulo=rs.getString("titulo");
                int año = rs.getInt("Año_Publiacion");
                String disponibilidad = rs.getString("disponibilidad");
                Libro libro = new Libro(codigo, tipo, titulo, autor, editorial, año, disponibilidad.equals("s"));
                doc = libro;  // Guardar como tipo Documento
            } else {
                // Si es otro tipo de documento o hay algún error
                continue;
            }

 
                docu.add(doc);
            }
        } catch (SQLException e) {
             System.out.println("Error en la consulta SQL: " + e.getMessage());
        e.printStackTrace();
        }
        return docu;
    }

    @Override
    public void update(String id, Documento docu) {
        String sql = "UPDATE Documentos SET tipo= ?, titulo = ?, autor = ?, editorial = ?, Año_Publiacion = ?, Volumen= ?, Numero= ?, Disponibilidad = ? WHERE codigo = ?";
    
    try (Connection conn = BaseDatos.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        // Determinar el tipo de documento
        if (docu instanceof Revista) {
            Revista revi = (Revista) docu;
            pstmt.setString(1, revi.getTipo());
            pstmt.setString(2, revi.getTitulo());
            pstmt.setString(3, revi.getAutor());
            pstmt.setString(4, revi.getEditorial());
            pstmt.setInt(5, revi.getAnoPub());
            pstmt.setInt(6, revi.getVolumen());
            pstmt.setInt(7, revi.getNumero());
            
            // Disponibilidad
            String disponibilidad = revi.isPrestado() ? "s" : "n";
            pstmt.setString(8, disponibilidad);
            pstmt.setString(9, id); // Código (ID) del documento

        } else if (docu instanceof Libro) {
            Libro lib = (Libro) docu;
            pstmt.setString(1, lib.getTipo());
            pstmt.setString(2, lib.getTitulo());
            pstmt.setString(3, lib.getAutor());
            pstmt.setString(4, lib.getEditorial());
            pstmt.setInt(5, lib.getAnoPub());
            
            // Los campos "Volumen" y "Numero" no aplican a libros
            pstmt.setNull(6, java.sql.Types.INTEGER);
            pstmt.setNull(7, java.sql.Types.INTEGER);
            
            // Disponibilidad
            String disponibilidad = lib.isPrestado() ? "s" : "n";
            pstmt.setString(8, disponibilidad);
            pstmt.setString(9, id); // Código (ID) del documento
        }

        // Ejecutar la actualización
        pstmt.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM Documentos WHERE codigo = ?";
        try (Connection conn = BaseDatos.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
    }
    }
    @Override
    public Documento buscarPorId(String id) {
    Documento docu = null;
    String sql = "SELECT * FROM Documentos WHERE codigo = ?";
    
    try (PreparedStatement pstmt = getConexion().prepareStatement(sql)) {
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            String tipoDocumento = rs.getString("tipo"); // Suponiendo que existe una columna "tipo"
            System.out.println("TipoDocumento: " + tipoDocumento);

            if (tipoDocumento.equals("Revista")) {
                int numero = rs.getInt("Numero");
                int volumen = rs.getInt("Volumen");
                String codigo = rs.getString("codigo");
                String tipo = rs.getString("tipo");
                String autor = rs.getString("autor");
                String editorial = rs.getString("editorial");
                String titulo = rs.getString("titulo");
                int año = rs.getInt("Año_Publiacion"); // Corrige el nombre de la columna
                String disponibilidad = rs.getString("disponibilidad");

                // Crear la instancia de Revista
                Revista revista = new Revista(volumen, numero, codigo, tipo, titulo, autor, editorial, año, disponibilidad.equals("s"));
                docu = revista;  // Asignar la revista a docu
            } else if (tipoDocumento.equals("Libro")) {
                String codigo = rs.getString("codigo");
                String tipo = rs.getString("tipo");
                String autor = rs.getString("autor");
                String editorial = rs.getString("editorial");
                String titulo = rs.getString("titulo");
                int año = rs.getInt("Año_Publiacion"); // Corrige el nombre de la columna
                String disponibilidad = rs.getString("disponibilidad");

                // Crear la instancia de Libro
                Libro libro = new Libro(codigo, tipo, titulo, autor, editorial, año, disponibilidad.equals("s"));
                docu = libro;  // Asignar el libro a docu
            }
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Manejar la excepción adecuadamente
    }

    return docu; // Retorna el objeto encontrado (Revista o Libro)

    }
    
    
    
}
