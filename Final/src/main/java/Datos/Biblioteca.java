/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.HashMap;
import Negocio.*;
import Presentacion.Contenido.Usuarios;


/**
 *
 * @author LENOVO
 */
public class Biblioteca {
  /* private static ArrayList<Documento>listaDocumentos;
    private static HashMap<String, Usuario>listaUsuarios;
    private static ArrayList<Prestamos>listaPrestamos;
            
            
    public Biblioteca() {
        listaDocumentos=new ArrayList<>();
        listaUsuarios=new HashMap<>();
        listaPrestamos=new ArrayList<>();
        cargarLibros();

    }
  

    public static HashMap<String, Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public static ArrayList<Prestamos> getListaPrestamos() {
        return listaPrestamos;
    }
    
    private void cargarLibros(){
    
    }
    

    public static ArrayList<Documento> getListaDocumentos() {
        return listaDocumentos;
    }

    public static void setListaDocumentos(ArrayList<Documento> listaDocumentos) {
        Biblioteca.listaDocumentos = listaDocumentos;
    }
    public static void agragarDoc(Documento doc){
    boolean repetido=false;
        for (Documento d : listaDocumentos) {
            if(d.getCodigo()==doc.getCodigo()){
            repetido=true;
            JOptionPane.showMessageDialog(null, "Codigo ya existente");
            break;
            }
        }
        if(repetido==false){
        listaDocumentos.add(doc);
        JOptionPane.showMessageDialog(null, "Libro agregado correcatamente");
        }
    }
    public static void agragarUser(Usuario user){
        
        
        
    }
    public static boolean verificarIds(String idUs,String idLib){
    boolean resulato;
    boolean a=false; 
    for (Documento Doc : listaDocumentos) {
            if (Doc.getCodigo().equals(idLib)) {
                a=true;
            }
    }
    boolean b=listaUsuarios.containsKey(idUs);
       if(a && b){
           resulato=true;
       }else{
           resulato=false;
       }
       return resulato;
    }
    public static boolean verificarLibro(String idLib){
    boolean a=false;
        for (Documento Doc : listaDocumentos) {
            if (Doc.getCodigo().equals(idLib)) {
                a=Doc.isPrestado();
            }
        }return a;
    }
    
    public static void agregarPrestamo(Prestamos pres,String idLib){
        listaPrestamos.add(pres);
        for (Documento Doc : listaDocumentos) {
            if (Doc.getCodigo().equals(idLib)) {
                Doc.setPrestado(true);
            }
        }
        JOptionPane.showMessageDialog(null, "Libro agregado correcatamente");
    }
    public static void verificarReporte(String idLib){
    for (Prestamos pre: listaPrestamos){
        String a=pre.getId_libro();
        if(a.equals(idLib)){
            pre.setEstado(true);
            }
        }
    }
    public static boolean devolverLibro(String idLib,String idUser){
        boolean a=false;
            for (Documento Doc : listaDocumentos) {
            if (Doc.getCodigo().equals(idLib)) {
                if(Doc.isPrestado()==false){
                    JOptionPane.showMessageDialog(null, "Libro ingresado no se encuentra en prestamo");
                    return false;
                }else{
                Doc.setPrestado(false);
                verificarReporte(idLib);
                JOptionPane.showMessageDialog(null, "Libro devuelto correctamente");
                return true;
                }
            }
        }
        return a;
    }*/
}