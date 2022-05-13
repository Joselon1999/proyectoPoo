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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Cliente;
import view.ListarCliente;
import view.addCliente;
import dao.ClientRepository;

/**
 *
 * @author josel
 */
public class ClientRepositoryImpl implements ClientRepository {

        Connection conexion = null;
        Statement sentencia = null;
        ResultSet resultado = null;
        PreparedStatement ps = null;
    @Override
    public void crearCliente(Cliente cliente) {
        Connection reg = ConexionConBaseDatos.getConexion();

        String sql = "INSERT INTO table_Cliente ( idCliente, Nombre_Cliente, Apellido_Cliente, Cedula_Cliente)VALUES (?,?,?,?)";
        try {

            PreparedStatement pst = reg.prepareStatement(sql);
            pst.setString(1, cliente.getIdCliente());
            pst.setString(2, cliente.getNombre_Cliente());
            pst.setString(3, cliente.getApellido_Cliente());
            pst.setString(4, cliente.getCedula_Cliente());
            int n = pst.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Regristado Exitosamente de Cliente");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error - " + ex);
            Logger.getLogger(addCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Cliente> listarclientes() {
        ArrayList listadoClientes = new ArrayList();
        try {
            conexion = ConexionConBaseDatos.getConexion();

            sentencia = conexion.createStatement();
            String consultaSQL = "SELECT * FROM table_Cliente ORDER BY Nombre_Cliente ASC";
            resultado = sentencia.executeQuery(consultaSQL);

            while (resultado.next()) {

                String codigo = resultado.getString("idCliente");
                String nombre = resultado.getString("Nombre_Cliente");
                String apellido = resultado.getString("Apellido_Cliente");
                String cedula = resultado.getString("Cedula_Cliente");

                listadoClientes.add(new Cliente(codigo, nombre, apellido, cedula));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL:\n" + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            conexion = null;
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }
        return listadoClientes;
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarCliente(String idCliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
