package com.example.ProyectoIntegradorDB.Modelos;

import com.example.ProyectoIntegradorDB.Ayudas.EstadoMesa;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMesa;

    private Integer capacidad;

    private EstadoMesa estadoMesa;

    @OneToMany(mappedBy = "mesa")
    @JsonManagedReference("mesa-pedido")
    private List<Pedido> pedidos;

    @OneToMany(mappedBy = "mesa")
    @JsonManagedReference("mesa-reserva")
    private List<Reserva> reservas;

    public Mesa() {}

    public Mesa(Integer idMesa, Integer capacidad, EstadoMesa estadoMesa) {
        this.idMesa = idMesa;
        this.capacidad = capacidad;
        this.estadoMesa = estadoMesa;
    }

    public Integer getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Integer idMesa) {
        this.idMesa = idMesa;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public EstadoMesa getEstadoMesa() {
        return estadoMesa;
    }

    public void setEstadoMesa(EstadoMesa estadoMesa) {
        this.estadoMesa = estadoMesa;
    }
}