/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.CerrarConexiones;
import dao.ConexionConBaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import dao.ProductRepository;
import model.Producto;

/**
 *
 * @author josel
 */
public class ProductRepositoryImpl implements ProductRepository {

    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultado = null;
    PreparedStatement ps = null;

    @Override
    public void crearProducto(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto> listarProductos() {
        ArrayList listadoProductos = new ArrayList();
        try {
            conexion = ConexionConBaseDatos.getConexion();

            sentencia = conexion.createStatement();
            String consultaSQL = "SELECT * FROM table_productos ORDER BY idProductos ASC";
            resultado = sentencia.executeQuery(consultaSQL);

            while (resultado.next()) {

                int codigo = resultado.getInt("idProductos");
                String nombre = resultado.getString("nombreProductos");
                double precio = resultado.getDouble("preciosProductos");

                listadoProductos.add(new Producto(codigo, nombre, precio));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL:\n" + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            conexion = null;
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }
        return listadoProductos;
    }

    @Override
    public void actualizarProducto(Producto cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarProducto(String idProducto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
