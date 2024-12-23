/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author LENOVO
 */
public class Documento {
    private String codigo;
    private String tipo;
    private String titulo;
    private String autor;
    private String editorial;
    private int anoPub;
    private boolean prestado;

    public Documento() {
    }

    public Documento(String codigo, String tipo, String titulo, String autor, String editorial, int anoPub, boolean prestado) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.anoPub = anoPub;
        this.prestado = prestado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }



    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnoPub() {
        return anoPub;
    }

    public void setAnoPub(int anoPub) {
        this.anoPub = anoPub;
    }

    @Override
    public String toString() {
        return "Documento{" + "codigo=" + codigo + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", anoPub=" + anoPub + '}';
    }

    
    
    
    
}
