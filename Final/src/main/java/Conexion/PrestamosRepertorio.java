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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
/**
 *
 * @author LENOVO
 */
public class PrestamosRepertorio implements Repositorio<Prestamos>{
private Connection getConexion() throws SQLException {
        return BaseDatos.getConnection();
    }
    @Override
    public void create(Prestamos prestamos) {
       String sql = "INSERT INTO Prestamos (id_user, id_documento, fecha_prestamo, fecha_devolucion, Entregado) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = BaseDatos.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, prestamos.getId_user());
            pstmt.setString(2, prestamos.getId_libro());
            pstmt.setString(3, prestamos.getFecha_prestamo());
            pstmt.setString(4, prestamos.getFecha_devolucion());
            pstmt.setString(5, "n"); 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Prestamos buscarPorId(String user) {
        Prestamos pres=null;
        return pres;

    }
    public Prestamos buscarPrestamo(String user, String lib){
        Prestamos pres = null;
        int use = Integer.parseInt(user);
        String sql = "SELECT * FROM Prestamos WHERE id_user = " + use + " AND id_documento = '" + lib + "'";
    try (Statement sta = getConexion().createStatement();
         ResultSet rs = sta.executeQuery(sql)) {

        if (rs.next()) {
            int id_pres = rs.getInt("id_prestamo");
            int id_use = rs.getInt("id_user");
            String id_docu = rs.getString("id_documento");
            String fecha_prestado = rs.getString("fecha_prestamo");
            String fecha_devolucion = rs.getString("fecha_devolucion");
            String dipo = rs.getString("Entregado");
            pres = new Prestamos(id_pres, id_use, id_docu, fecha_prestado, fecha_devolucion, dipo.equals("s"));
        }
        } catch (SQLException e) {
        e.printStackTrace(); 
        }
        if (pres == null) {
           javax.swing.JOptionPane.showMessageDialog(null, "Los datos ingresados no coinciden.\n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    return pres;
    }

    @Override
    public List<Prestamos> read() {
        List<Prestamos> prestamo = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Prestamos";
        try (Connection conn = BaseDatos.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Prestamos presta = new Prestamos();
                presta.setId_prestamo(rs.getInt("id_prestamo"));
                presta.setId_user(rs.getInt("id_user"));
                presta.setId_libro(rs.getString("id_documento"));
                presta.setFecha_prestamo(rs.getString("fecha_prestamo"));
                presta.setFecha_devolucion(rs.getString("fecha_devolucion"));
                presta.setEstado((rs.getString("Entregado")).equals("s"));
                prestamo.add(presta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prestamo;
    }

    @Override
    public void update(String id,Prestamos pre) {
        int cod=Integer.parseInt(id);
        String sql = "UPDATE Prestamos SET Entregado = ? WHERE id_prestamo ="+cod;
        try (Connection conn = BaseDatos.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1,"s");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM Prestamos  WHERE id_prestamo = ?";
        try (Connection conn = BaseDatos.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
