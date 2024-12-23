/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author LENOVO
 */
public class Revista extends Documento{
    private int volumen;
    private int numero;

    public Revista(int volumen, int numero, String codigo, String tipo, String titulo, String autor, String editorial, int anoPub, boolean prestado) {
        super(codigo, tipo, titulo, autor, editorial, anoPub, prestado);
        this.volumen = volumen;
        this.numero = numero;
    }

    public Revista(int volumen, int numero) {
        this.volumen = volumen;
        this.numero = numero;
    }


    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

 

    @Override
    public String toString() {
        return super.toString()+"volumen"+volumen+"\n"+", Numero"+numero+"\n";
    }
     
}
