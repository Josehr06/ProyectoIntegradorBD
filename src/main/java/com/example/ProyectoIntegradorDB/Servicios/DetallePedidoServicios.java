package com.example.ProyectoIntegradorDB.Servicios;

import com.example.ProyectoIntegradorDB.Ayudas.MensajesAPI;
import com.example.ProyectoIntegradorDB.Modelos.Cliente;
import com.example.ProyectoIntegradorDB.Modelos.DetallePedido;
import com.example.ProyectoIntegradorDB.Repositorio.IClienteRepositorio;
import com.example.ProyectoIntegradorDB.Repositorio.IDetallePedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoServicios {

    @Autowired
    IDetallePedidoRepositorio detallePedidoRepositorio;


    public DetallePedido guardarDetalle(DetallePedido detalle) throws Exception {
        try {
            return this.detallePedidoRepositorio.save(detalle);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public DetallePedido actualizarDetalle(Integer id, DetallePedido nuevoDetalle) throws Exception {
        Optional<DetallePedido> detalleExistente = this.detallePedidoRepositorio.findById(id);
        try {
            if (detalleExistente.isPresent()) {
                detalleExistente.get().setCantidad(nuevoDetalle.getCantidad());
                detalleExistente.get().setPedido(nuevoDetalle.getPedido());
                detalleExistente.get().setProducto(nuevoDetalle.getProducto());
                return this.detallePedidoRepositorio.save(detalleExistente.get());
            } else {
                throw new Exception(MensajesAPI.DETALLE_PEDIDO_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public DetallePedido buscarPorId(Integer id) throws Exception {
        try {
            Optional<DetallePedido> detalle = this.detallePedidoRepositorio.findById(id);
            if (detalle.isPresent()) {
                return detalle.get();
            } else {
                throw new Exception(MensajesAPI.DETALLE_PEDIDO_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public List<DetallePedido> obtenerTodos() throws Exception {
        try {
            return this.detallePedidoRepositorio.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public boolean eliminarDetalle(Integer id) throws Exception {
        try {
            Optional<DetallePedido> detalle = this.detallePedidoRepositorio.findById(id);
            if (detalle.isPresent()) {
                this.detallePedidoRepositorio.deleteById(id);
                return true;
            } else {
                throw new Exception(MensajesAPI.DETALLE_PEDIDO_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
