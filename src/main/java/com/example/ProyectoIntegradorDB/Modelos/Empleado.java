package com.example.ProyectoIntegradorDB.Modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import com.example.ProyectoIntegradorDB.Ayudas.TipoEmpleado;

import java.util.List;

@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpleado;
    @Column(name = "nombre" )
    private String nombre;
    private String telefono;
    private String correo;
    private TipoEmpleado tipoEmpleado;

    @OneToMany(mappedBy = "empleado")
    @JsonManagedReference("empleado-pedido")
    private List<Pedido> pedidos;

    public Empleado() {}

    public Empleado(Integer idEmpleado, String nombre, String correo, String telefono, TipoEmpleado tipoEmpleado) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.tipoEmpleado = tipoEmpleado;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }
    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }
}
