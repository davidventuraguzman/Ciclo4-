/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;
import Negocio.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class UsuarioRepertorio implements Repositorio<Usuario>{
    private Connection getConexion() throws SQLException {
        return BaseDatos.getConnection();
    }
    public List<Usuario> buscarLibroPorTitulo(String id) {
    int cod=Integer.parseInt(id);
        String sql = "SELECT * FROM Usuarios WHERE UPPER(id) LIKE UPPER(?)";
    List<Usuario> usuariosEncontrados = new ArrayList<>();
    
    try (Connection conn = BaseDatos.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, "%" + cod + "%");
        
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setId(Integer.toString(rs.getInt("id")));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setCarrera(rs.getString("carrera"));
                user.setCiclo(rs.getString("ciclo"));
            usuariosEncontrados.add(user);
            }
        }
    } catch (Exception e) {
        System.out.println("Error al buscar libros: " + e.getMessage());
    }

    return usuariosEncontrados;
}
    public static boolean existeUsuario(int idUsuario) {
        String sql = "SELECT COUNT(*) FROM Usuarios WHERE id = ?";
        try (Connection conn = BaseDatos.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

        // Establecer el valor del parámetro antes de ejecutar la consulta
            pstmt.setInt(1, idUsuario);
        
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next() && rs.getInt(1) > 0) {
                return true;  // El usuario existe
            } else {
                return false; // El usuario no existe
            }
        }
        } catch (Exception e) {
        System.out.println("Error al buscar usuario: " + e.getMessage());
        return false;
        } 
    }
    public static boolean existeLibro(String idLibro) {
    String sql = "SELECT COUNT(*) FROM Documentos WHERE codigo = ?";
    try (Connection conn = BaseDatos.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        // Establecer el valor del parámetro antes de ejecutar la consulta
        pstmt.setString(1, idLibro);
        
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next() && rs.getInt(1) > 0) {
                return true;  // El libro existe
            } else {
                return false; // El libro no existe
            }
        }
    } catch (Exception e) {
        System.out.println("Error al buscar libro: " + e.getMessage());
        return false;
    }
}

    @Override
    public void create(Usuario user) {
       String sql = "INSERT INTO Usuarios (nombre, apellido, carrera, ciclo) VALUES (?, ?, ?, ?)";
        try (Connection conn = BaseDatos.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getNombre());
            pstmt.setString(2, user.getApellido());
            pstmt.setString(3, user.getCarrera());
            pstmt.setString(4, user.getCiclo());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario buscarPorId(String id) {
        Usuario user=null;
        String sql = "SELECT * FROM Usuarios WHERE id= " + id;
        try (Statement sta = getConexion().createStatement();
             ResultSet rs = sta.executeQuery(sql)) {

            if (rs.next()) {

                String nombre=rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String carrera = rs.getString("carrera");
                String ciclo =rs.getString("ciclo");
                user = new Usuario(nombre, apellido, carrera, ciclo); 
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejar la excepción adecuadamente
        }
        return user;
    }

    @Override
    public List<Usuario> read() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Usuarios";
        try (Connection conn = BaseDatos.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setId(Integer.toString(rs.getInt("id")));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setCarrera(rs.getString("carrera"));
                user.setCiclo(rs.getString("ciclo"));
                usuarios.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public void update(String id,Usuario user) {
       String sql = "UPDATE Usuarios SET nombre = ?, apellido = ?, carrera = ?, ciclo = ? WHERE id = ?";
        try (Connection conn = BaseDatos.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, user.getNombre());
                pstmt.setString(2, user.getApellido());
                pstmt.setString(3, user.getCarrera());
                pstmt.setString(4, user.getCiclo());
                pstmt.setString(5, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        int cod=Integer.parseInt(id);
        String sql = "DELETE FROM Usuarios WHERE id = ?";
        try (Connection conn = BaseDatos.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cod);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
   
    
}
