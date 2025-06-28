package com.example.ProyectoIntegradorDB.Modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    private LocalDate fechaPedido;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonBackReference("cliente-pedido")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    @JsonBackReference("empleado-pedido")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_mesa")
    @JsonBackReference("mesa-pedido")
    private Mesa mesa;

    @OneToMany(mappedBy = "pedido")
    @JsonManagedReference("pedido-detalle")
    private List<DetallePedido> detalles;

    public Pedido() {}

    public Pedido(Integer idPedido, LocalDate fechaPedido, Cliente cliente, Empleado empleado, Mesa mesa) {
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
        this.cliente = cliente;
        this.empleado = empleado;
        this.mesa = mesa;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<DetallePedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedido> detalles) {
        this.detalles = detalles;
    }
}