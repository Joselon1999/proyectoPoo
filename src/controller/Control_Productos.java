package controller;

import view.ConsultarProductos;
import dao.CerrarConexiones;
import dao.ConexionConBaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * En esta clase se exponen todos los métodos para ejercer control sobre los
 * datos que van desde y hacia la tabla clientes. En esta clase se hace la
 * validación y organizacion de los datos.
 *
 * @author Jose
 */


public class Control_Productos {

    DefaultTableModel modelo;
    String[] titulosColumnas = {"CÓDIGO", "NOMBRE", " PRECIOS"};
    String[][] info = {};
    
     public void agregarProductos(String cedula, String nombre, String apellido, String direccion, String telefono) {
    
    }

    /**
     * Metodo para listar todos los registros de la tabla
     * de clientes, los muestra en un jtable.
     */
    public void listarTodosProductos() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ConsultarProductos.jTableListarCliente.setModel(modelo);
        ejecutarConsultaTodaTabla();
    }
    
     /**
     * Metodo para consultar todos los regsitros de la base de datos de clientes
     * y luego ser mostrados en una tabla.
     */
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultado = null;
    PreparedStatement ps = null;

    public void ejecutarConsultaTodaTabla() {

        try {
            conexion = ConexionConBaseDatos.getConexion();

            sentencia = conexion.createStatement();
            String consultaSQL = "SELECT * FROM table_productos ORDER BY idProductos ASC";
            resultado = sentencia.executeQuery(consultaSQL);
            while (resultado.next()) {


                String codigo = resultado.getString("idProductos");
                String nombre = resultado.getString("nombreProductos");
                String precio = resultado.getString("preciosProductos");
                Object[] info = {codigo, nombre, precio};
                modelo.addRow(info);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL:\n" + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            conexion = null;
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }
    }
    
  
    public void buscarProductos(String parametroBusqueda) {
            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            ConsultarProductos.jTableListarCliente.setModel(modelo);
            buscarRegistroProductos(parametroBusqueda);
    }

    public void buscarRegistroProductos(String parametroBusqueda) {

        try {

            conexion = ConexionConBaseDatos.getConexion();
            String selectSQL = "SELECT * FROM table_Productos WHERE nombreProductos LIKE ? ORDER BY idProductos ASC";
            resultado = null;       
            ps = conexion.prepareStatement(selectSQL);
            ps.setString(1, "%" + parametroBusqueda + "%");
            resultado = ps.executeQuery();

            while (resultado.next()) {
                String codigo = resultado.getString("idProductos");
                String nombre = resultado.getString("nombreProductos");
                String precio = resultado.getString("preciosProductos");
                Object[] info = {codigo,nombre, precio};
                modelo.addRow(info);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error\n Por la Causa" + e);
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }
    }
    
    /**
     * Método para validar la entrada del usuario
     * que ingresa para eliminar un cliente
     */
    public void EliminarProductos(String code) {

        try {            
            Connection conexion = ConexionConBaseDatos.getConexion();
            Statement comando = conexion.createStatement();
            int cantidad = comando.executeUpdate("delete from table_Productos where idProductos=" + code);
            if (cantidad == 1) {
                JOptionPane.showMessageDialog(null,"Eliminado");
            } else {
                JOptionPane.showMessageDialog(null,"No existe Producto de Codigo "+code);
            }
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error "+ex);
        }
    }
    /**
     * Método para validar y modificar la 
     * información de un cliente.
     */
    public void ModificarProductos(String code,String cod,String nombre,String precios) {
  
        try {
            Connection conexion = ConexionConBaseDatos.getConexion();
            Statement comando = conexion.createStatement();
            int cantidad = comando.executeUpdate("update table_Productos set nombreProductos ='" + nombre + "', "
                + " preciosProductos ='" + precios + "', idProductos ='" + cod + "' where idProductos=" + code);
            if (cantidad == 1) {
                JOptionPane.showMessageDialog(null," Modifico con Exito");
            } else {
                JOptionPane.showMessageDialog(null,"No existe Vendedor de un codigo "+code);
            }
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," Error -->"+ex);
        }
    }

    public void buscarProductosparaVentas(String parametroBusqueda) {

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            //Ventas.SeleccionarProductos.setModel(modelo);
            buscarRegistroProductoss(parametroBusqueda);
    }
    
    public void buscarRegistroProductoss(String parametroBusqueda) {

        try {
            conexion = ConexionConBaseDatos.getConexion();
            String selectSQL = "SELECT * FROM table_Productos WHERE nombreProductos LIKE ? ORDER BY idProductos ASC";
            resultado = null;
            ps = conexion.prepareStatement(selectSQL);
            ps.setString(1, "%" + parametroBusqueda + "%");
            resultado = ps.executeQuery();
            while (resultado.next()) {
                String codigo = resultado.getString("idProductos");
                String nombre = resultado.getString("nombreProductos");
                String precio = resultado.getString("preciosProductos");
                Object[] info = {codigo,nombre, precio};
                modelo.addRow(info);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error\n Por la Causa" + e);
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }
    }
}
