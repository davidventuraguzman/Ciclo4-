/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Conexion;

import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface Repositorio<T> {
  void create(T t);
    List<T> read();
    void update(String id,T t);
    void delete(String id);
    T buscarPorId(String id);
}
