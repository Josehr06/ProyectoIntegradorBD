package com.example.ProyectoIntegradorDB.Servicios;


import com.example.ProyectoIntegradorDB.Ayudas.MensajesAPI;
import com.example.ProyectoIntegradorDB.Modelos.Reserva;
import com.example.ProyectoIntegradorDB.Repositorio.IReservaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaServicios {

    @Autowired
    IReservaRepositorio reservaRepositorio;


    public Reserva guardarReserva(Reserva reserva) throws Exception {
        try {
            return this.reservaRepositorio.save(reserva);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public Reserva actualizarReserva(Integer id, Reserva nuevaReserva) throws Exception {
        Optional<Reserva> reservaExistente = this.reservaRepositorio.findById(id);
        try {
            if (reservaExistente.isPresent()) {
                reservaExistente.get().setFechaReserva(nuevaReserva.getFechaReserva());
                reservaExistente.get().setCliente(nuevaReserva.getCliente());
                reservaExistente.get().setMesa(nuevaReserva.getMesa());
                reservaExistente.get().setPrecio(nuevaReserva.getPrecio());
                return this.reservaRepositorio.save(reservaExistente.get());
            } else {
                throw new Exception(MensajesAPI.RESERVA_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public Reserva buscarPorId(Integer id) throws Exception {
        try {
            Optional<Reserva> reserva = this.reservaRepositorio.findById(id);
            if (reserva.isPresent()) {
                return reserva.get();
            } else {
                throw new Exception(MensajesAPI.RESERVA_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public List<Reserva> obtenerTodas() throws Exception {
        try {
            return this.reservaRepositorio.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public boolean eliminarReserva(Integer id) throws Exception {
        try {
            Optional<Reserva> reserva = this.reservaRepositorio.findById(id);
            if (reserva.isPresent()) {
                this.reservaRepositorio.deleteById(id);
                return true;
            } else {
                throw new Exception(MensajesAPI.RESERVA_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
