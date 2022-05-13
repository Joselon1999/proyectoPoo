/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author josel
 */
public class Cliente {
    private String idCliente;
    private String Nombre_Cliente;
    private String Apellido_Cliente;
    private String Cedula_Cliente;

    public Cliente(String idCliente, String Nombre_Cliente, String Apellido_Cliente, String Cedula_Cliente) {
        this.idCliente = idCliente;
        this.Nombre_Cliente = Nombre_Cliente;
        this.Apellido_Cliente = Apellido_Cliente;
        this.Cedula_Cliente = Cedula_Cliente;
    }

    public Cliente() {
    }



    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre_Cliente() {
        return Nombre_Cliente;
    }

    public void setNombre_Cliente(String Nombre_Cliente) {
        this.Nombre_Cliente = Nombre_Cliente;
    }

    public String getApellido_Cliente() {
        return Apellido_Cliente;
    }

    public void setApellido_Cliente(String Apellido_Cliente) {
        this.Apellido_Cliente = Apellido_Cliente;
    }

    public String getCedula_Cliente() {
        return Cedula_Cliente;
    }

    public void setCedula_Cliente(String Cedula_Cliente) {
        this.Cedula_Cliente = Cedula_Cliente;
    }
    
}
