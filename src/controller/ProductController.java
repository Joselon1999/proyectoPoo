/*
 * Este criterio depende de una competencia de aprendizaje
Patrón MVC, DAO y JDBC.
 */
package controller;

import java.util.List;
import dao.impl.ProductRepositoryImpl;
import model.Producto;

/**
 *
 * @author josel
 */

public class ProductController {
    
    private ProductRepositoryImpl repository = new ProductRepositoryImpl();
    
    
    public void agregarProducto(Producto producto){
        System.out.println("controller ->"+producto.getId());
        repository.crearProducto(producto);
        System.out.println("Cliente creado");
    }
    
    public List<Producto> listarclientes() {
        return repository.listarProductos();
    }
}
