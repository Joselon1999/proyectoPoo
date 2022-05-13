/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.Cliente;

/**
 *
 * @author josel
 */
public interface ClientRepository {

    void crearCliente(Cliente cliente);

    List<Cliente> listarclientes();

    void actualizarCliente(Cliente cliente);

    void eliminarCliente(String idCliente);
}