/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Jose
 */
public class Categoria_Producto {
    
    int id;
    String descripcion;
    String fechaCreacion;
    String creadoPor;
    String fechaActualizacion;
    String actualizadoPor;
    String fechaEliminación;
    String eliminadoPor;
    Boolean eliminado;

    public Categoria_Producto(int id, String descripcion, String fechaCreacion, String creadoPor, String fechaActualizacion, String actualizadoPor, String fechaEliminación, String eliminadoPor, Boolean eliminado) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.creadoPor = creadoPor;
        this.fechaActualizacion = fechaActualizacion;
        this.actualizadoPor = actualizadoPor;
        this.fechaEliminación = fechaEliminación;
        this.eliminadoPor = eliminadoPor;
        this.eliminado = eliminado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getActualizadoPor() {
        return actualizadoPor;
    }

    public void setActualizadoPor(String actualizadoPor) {
        this.actualizadoPor = actualizadoPor;
    }

    public String getFechaEliminación() {
        return fechaEliminación;
    }

    public void setFechaEliminación(String fechaEliminación) {
        this.fechaEliminación = fechaEliminación;
    }

    public String getEliminadoPor() {
        return eliminadoPor;
    }

    public void setEliminadoPor(String eliminadoPor) {
        this.eliminadoPor = eliminadoPor;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }
    
    
}
