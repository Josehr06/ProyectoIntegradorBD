package com.example.ProyectoIntegradorDB.Servicios;

import com.example.ProyectoIntegradorDB.Ayudas.MensajesAPI;
import com.example.ProyectoIntegradorDB.Modelos.Mesa;
import com.example.ProyectoIntegradorDB.Repositorio.IMesaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesaServicios {

    @Autowired
    IMesaRepositorio mesaRepositorio;


    public Mesa guardarMesa(Mesa mesa) throws Exception {
        try {
            return this.mesaRepositorio.save(mesa);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public Mesa actualizarMesa(Integer id, Mesa nuevaMesa) throws Exception {
        Optional<Mesa> mesaExistente = this.mesaRepositorio.findById(id);
        try {
            if (mesaExistente.isPresent()) {
                mesaExistente.get().setCapacidad(nuevaMesa.getCapacidad());
                return this.mesaRepositorio.save(mesaExistente.get());
            } else {
                throw new Exception(MensajesAPI.MESA_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public Mesa buscarPorId(Integer id) throws Exception {
        try {
            Optional<Mesa> mesa = this.mesaRepositorio.findById(id);
            if (mesa.isPresent()) {
                return mesa.get();
            } else {
                throw new Exception(MensajesAPI.MESA_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public List<Mesa> obtenerTodas() throws Exception {
        try {
            return this.mesaRepositorio.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public boolean eliminarMesa(Integer id) throws Exception {
        try {
            Optional<Mesa> mesa = this.mesaRepositorio.findById(id);
            if (mesa.isPresent()) {
                this.mesaRepositorio.deleteById(id);
                return true;
            } else {
                throw new Exception(MensajesAPI.MESA_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
