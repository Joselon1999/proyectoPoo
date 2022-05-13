/*
 * Este criterio depende de una competencia de aprendizaje
Patrón MVC, DAO y JDBC.
 */
package controller;

import dao.impl.ClientRepositoryImpl;
import java.util.List;
import model.Cliente;
import dao.ClientRepository;

/**
 *
 * @author josel
 */

public class ClientController {
    
    private ClientRepositoryImpl repository = new ClientRepositoryImpl();
    
    
    public void agregarCliente(Cliente cliente){
        System.out.println("controller ->"+cliente.getIdCliente());
        repository.crearCliente(cliente);
        System.out.println("Cliente creado");
    }
    
    public List<Cliente> listarclientes() {
        return repository.listarclientes();
    }
}
