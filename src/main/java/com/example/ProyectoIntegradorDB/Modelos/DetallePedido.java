package com.example.ProyectoIntegradorDB.Modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalle;

    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    @JsonBackReference("pedido-detalle")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    @JsonBackReference("producto-detalle")
    private Producto producto;

    public DetallePedido() {}

    public DetallePedido(Integer idDetalle, Integer cantidad, Pedido pedido, Producto producto) {
        this.idDetalle = idDetalle;
        this.cantidad = cantidad;
        this.pedido = pedido;
        this.producto = producto;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}

