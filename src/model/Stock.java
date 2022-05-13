/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Jose
 */
public class Stock {
    int id;
    Producto producto;
    String fechaHoraMovimiento;
    String tipoMovimiento;
    int cantidad;
    double monto;
    String fechaCreacion;
    String creadoPor;
    String fechaActualizacion;
    String actualizadoPor;
    String fechaEliminación;
    String eliminadoPor;
    Boolean eliminado;

    public Stock(int id, Producto producto, String fechaHoraMovimiento, String tipoMovimiento, int cantidad, double monto, String fechaCreacion, String creadoPor, String fechaActualizacion, String actualizadoPor, String fechaEliminación, String eliminadoPor, Boolean eliminado) {
        this.id = id;
        this.producto = producto;
        this.fechaHoraMovimiento = fechaHoraMovimiento;
        this.tipoMovimiento = tipoMovimiento;
        this.cantidad = cantidad;
        this.monto = monto;
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getFechaHoraMovimiento() {
        return fechaHoraMovimiento;
    }

    public void setFechaHoraMovimiento(String fechaHoraMovimiento) {
        this.fechaHoraMovimiento = fechaHoraMovimiento;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
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
