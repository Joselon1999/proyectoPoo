package controller;

import view.ListarCliente;
import view.addCliente;
import dao.CerrarConexiones;
import dao.ConexionConBaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * En esta clase se exponen todos los métodos para ejercer control sobre los
 * datos que van desde y hacia la tabla clientes. En esta clase se hace la
 * validación y organizacion de los datos.
 *
 * @author Jose
 */


public class Control_Cliente {

    DefaultTableModel modelo;
    String[] titulosColumnas = {"CÓDIGO", "NOMBRE", "APELLIDOS", "CEDULA"};
    String[][] info = {};
    ConexionConBaseDatos conectar = new ConexionConBaseDatos();

     /**
     * Metodo para consultar todos los regsitros de la base de datos de clientes
     * y luego ser mostrados en una tabla.
     */
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultado = null;
    PreparedStatement ps = null;

    /**
     * Método para validar la entrada del usuario
     * que ingresa para eliminar un cliente
     */
    public void EliminarCliente(String code) {

        try {            
            Connection conexion = ConexionConBaseDatos.getConexion();
            Statement comando = conexion.createStatement();
            int cantidad = comando.executeUpdate("delete from table_Cliente where idCliente=" + code);
            if (cantidad == 1) {
   
                JOptionPane.showMessageDialog(null,"Eliminado");
            } else {
                JOptionPane.showMessageDialog(null,"No existe Cliente de Codigo "+code);
            }
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error "+ex);
        }

    }//cierra metodo eliminarCliente

    
    
    public void ModificarCliente(String code,String cod,String nombre,String apellido,String cedula) {

    
        try {
            Connection conexion = ConexionConBaseDatos.getConexion();
            Statement comando = conexion.createStatement();

            int cantidad = comando.executeUpdate("update table_Cliente set Nombre_Cliente ='" + nombre + "', "
                + " Apellido_Cliente ='" + apellido + "', Cedula_Cliente ='" + cedula + "', idCliente ='" + cod + "' where idCliente=" + code);
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
}
