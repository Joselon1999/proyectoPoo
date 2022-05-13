/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Jose
 */
public class Guia_Remision {
    private int id;
    private String serie;
    private String cabecera;
    private String detalle;
    private int numeracion;
    private Stock stock;
    private Producto producto;
    private Usuario usuario;
    private int cantidad;
    private String fechaCreacion;
    private String creadoPor;
    private String fechaActualizacion;
    private String actualizadoPor;
    private String fechaEliminación;
    private String eliminadoPor;
    private Boolean eliminado;

    public Guia_Remision(int id, String serie, int numeracion, Stock stock, Producto producto, Usuario usuario, int cantidad, String fechaCreacion, String creadoPor, String fechaActualizacion, String actualizadoPor, String fechaEliminación, String eliminadoPor, Boolean eliminado) {
        this.id = id;
        this.serie = serie;
        this.numeracion = numeracion;
        this.stock = stock;
        this.producto = producto;
        this.usuario = usuario;
        this.cantidad = cantidad;
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

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(int numeracion) {
        this.numeracion = numeracion;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
