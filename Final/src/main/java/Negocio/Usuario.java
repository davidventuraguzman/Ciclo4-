/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author LENOVO
 */
import java.util.ArrayList;
public class Usuario {
    private String id;
    private String nombre;
    private String apellido;
    private String carrera;
    private String ciclo;

    public Usuario() {
    }
   
    public Usuario(String nombre, String apellido, String carrera, String ciclo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
        this.ciclo = ciclo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }


    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", apellido=" + apellido + ", carrera=" + carrera + ", ciclo=" + ciclo + '}';
    }

  

}
