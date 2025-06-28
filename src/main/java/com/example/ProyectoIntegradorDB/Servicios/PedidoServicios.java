package com.example.ProyectoIntegradorDB.Servicios;

import com.example.ProyectoIntegradorDB.Ayudas.MensajesAPI;
import com.example.ProyectoIntegradorDB.Modelos.Pedido;
import com.example.ProyectoIntegradorDB.Repositorio.IPedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServicios {

    @Autowired
    IPedidoRepositorio pedidoRepositorio;


    public Pedido guardarPedido(Pedido pedido) throws Exception {
        try {
            return this.pedidoRepositorio.save(pedido);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public Pedido actualizarPedido(Integer id, Pedido nuevoPedido) throws Exception {
        Optional<Pedido> pedidoExistente = this.pedidoRepositorio.findById(id);
        try {
            if (pedidoExistente.isPresent()) {
                pedidoExistente.get().setFechaPedido(nuevoPedido.getFechaPedido());
                pedidoExistente.get().setCliente(nuevoPedido.getCliente());
                pedidoExistente.get().setEmpleado(nuevoPedido.getEmpleado());
                pedidoExistente.get().setMesa(nuevoPedido.getMesa());
                return this.pedidoRepositorio.save(pedidoExistente.get());
            } else {
                throw new Exception(MensajesAPI.PEDIDO_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public Pedido buscarPorId(Integer id) throws Exception {
        try {
            Optional<Pedido> pedido = this.pedidoRepositorio.findById(id);
            if (pedido.isPresent()) {
                return pedido.get();
            } else {
                throw new Exception(MensajesAPI.PEDIDO_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public List<Pedido> obtenerTodos() throws Exception {
        try {
            return this.pedidoRepositorio.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public boolean eliminarPedido(Integer id) throws Exception {
        try {
            Optional<Pedido> pedido = this.pedidoRepositorio.findById(id);
            if (pedido.isPresent()) {
                this.pedidoRepositorio.deleteById(id);
                return true;
            } else {
                throw new Exception(MensajesAPI.PEDIDO_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
