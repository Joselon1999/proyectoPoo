/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
import view.ListarVendedor;
import static view.ListarVendedor.jTableListarVendedor;

import view.SalidaProductos;
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
 *
 * @author Jose
 */

public class Control_Vendedor {
    
    DefaultTableModel modelo;
    String[] titulosColumnas = {"CÓDIGO","NOMBRE Y APELLIDOS"};
    String[][] info = {};
   
    /**
     * Metodo para listar todos los registros de la tabla
     * de clientes, los muestra en un jtable.
     */
    public void listarTodosVendedor() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        ListarVendedor.jTableListarVendedor.setModel(modelo);
         int[] anchos = {80, 200};
        for(int i = 0; i < jTableListarVendedor.getColumnCount(); i++) {
        jTableListarVendedor.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        ejecutarConsultaTodaTabla();
    }
    
    public void CargarListaVendedor() {
        try{
            conexion = ConexionConBaseDatos.getConexion();
            sentencia = conexion.createStatement();
            String consultaSQL = "SELECT CONCAT(NOMBREVENDEDOR, ' [', CAST(IDVENDEDOR AS VARCHAR(10)) , ']' ) AS ListaVendedor FROM table_vendedor ORDER BY nombreVendedor ASC";
            resultado = sentencia.executeQuery(consultaSQL);
            SalidaProductos.jComboBox1.removeAllItems();
            while (resultado.next()) {
                String nombre = resultado.getString("ListaVendedor");
                SalidaProductos.jComboBox1.addItem(nombre);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL:\n" + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error:\n" + e);
            conexion = null;
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }            
    }
    
    
        public void CargarVendedor() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //Ventas.SeleccionarVendedor.setModel(modelo);
        int[] anchos = {80, 200};
        //for(int i = 0; i < SeleccionarVendedor.getColumnCount(); i++) {
        //SeleccionarVendedor.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        //}
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
            String consultaSQL = "SELECT * FROM table_vendedor ORDER BY idVendedor ASC";
            resultado = sentencia.executeQuery(consultaSQL);
            while (resultado.next()) {
                int codigo = resultado.getInt("idVendedor");
                String nombre = resultado.getString("nombreVendedor");
                Object[] info = {codigo, nombre};
                modelo.addRow(info);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL:\n" + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error:\n" + e);
            conexion = null;
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }
    }

    public void EliminarVendedor(String code){
        
        try {            
            Connection conexion = ConexionConBaseDatos.getConexion();
            Statement comando = conexion.createStatement();
            int cantidad = comando.executeUpdate("delete from table_vendedor where idVendedor=" + code);
            if (cantidad == 1) {
                JOptionPane.showMessageDialog(null,"Eliminado");
            } else {
                JOptionPane.showMessageDialog(null,"No existe Vendedor de Codigo "+code);
            }
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error "+ex);
        }
    }
    
    public void ModificarVendedor (String cod, String code, String nombre)
    {
        try {
            Connection conexion = ConexionConBaseDatos.getConexion();
            Statement comando = conexion.createStatement();

            int cantidad = comando.executeUpdate("update table_vendedor set nombreVendedor ='" + nombre + "', "
                + "idVendedor = " + code + " where idVendedor=" + cod);
            if (cantidad == 1) {
                JOptionPane.showMessageDialog(null," Modifico con Exito");
            } else {
                JOptionPane.showMessageDialog(null,"No existe Vendedor de un codigo "+cod);
            }
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," Error -->"+ex);
        }
    }         
}

