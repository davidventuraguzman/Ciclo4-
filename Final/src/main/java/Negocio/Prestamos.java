/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author LENOVO
 */
public class Prestamos {
    private Integer id_prestamo;
    private int id_user;
    private String id_libro;
    private String fecha_prestamo;
    private String fecha_devolucion;
    private boolean estado;

    public Prestamos() {
    }

    public Prestamos(Integer id_prestamo, int id_user, String id_libro, String fecha_prestamo, String fecha_devolucion, boolean estado) {
        this.id_prestamo = id_prestamo;
        this.id_user = id_user;
        this.id_libro = id_libro;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
        this.estado = estado;
    }

    public Prestamos(int id_user, String id_libro, String fecha_salida, String fecha_entrega,boolean estado) {
        this.id_user = id_user;
        this.id_libro = id_libro;
        this.fecha_prestamo = fecha_salida;
        this.fecha_devolucion = fecha_entrega;
        this.estado=estado;
    }

    public Integer getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(Integer id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getId_libro() {
        return id_libro;
    }

    public void setId_libro(String id_libro) {
        this.id_libro = id_libro;
    }

    public String getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(String fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public String getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(String fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    

    
}
