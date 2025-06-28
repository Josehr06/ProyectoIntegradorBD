package com.example.ProyectoIntegradorDB.Modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReserva;

    private LocalDate fechaReserva;
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonBackReference("cliente-reserva")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_mesa")
    @JsonBackReference("mesa-reserva")
    private Mesa mesa;

    public Reserva() {}

    public Reserva(Integer idReserva, LocalDate fechaReserva, Double precio, Cliente cliente, Mesa mesa) {
        this.idReserva = idReserva;
        this.fechaReserva = fechaReserva;
        this.precio = precio;
        this.cliente = cliente;
        this.mesa = mesa;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
}