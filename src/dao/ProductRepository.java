/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.Cliente;
import model.Producto;

/**
 *
 * @author josel
 */
public interface ProductRepository {
    void crearProducto(Producto producto);

    List<Producto> listarProductos();

    void actualizarProducto(Producto producto);

    void eliminarProducto(String idProducto);
}
