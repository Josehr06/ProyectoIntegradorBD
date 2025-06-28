package com.example.ProyectoIntegradorDB.Servicios;

import com.example.ProyectoIntegradorDB.Ayudas.MensajesAPI;
import com.example.ProyectoIntegradorDB.Modelos.Empleado;
import com.example.ProyectoIntegradorDB.Repositorio.IEmpleadorepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServicios {

    @Autowired
    IEmpleadorepositorio empleadoRepositorio;


    public Empleado guardarEmpleado(Empleado empleado) throws Exception {
        try {
            return this.empleadoRepositorio.save(empleado);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public Empleado actualizarEmpleado(Integer id, Empleado nuevoEmpleado) throws Exception {
        Optional<Empleado> empleadoExistente = this.empleadoRepositorio.findById(id);
        try {
            if (empleadoExistente.isPresent()) {
                empleadoExistente.get().setNombre(nuevoEmpleado.getNombre());
                empleadoExistente.get().setTelefono(nuevoEmpleado.getTelefono());
                empleadoExistente.get().setCorreo(nuevoEmpleado.getCorreo());
                empleadoExistente.get().setTipoEmpleado(nuevoEmpleado.getTipoEmpleado());
                return this.empleadoRepositorio.save(empleadoExistente.get());
            } else {
                throw new Exception(MensajesAPI.EMPLEADO_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public Empleado buscarPorId(Integer id) throws Exception {
        try {
            Optional<Empleado> empleado = this.empleadoRepositorio.findById(id);
            if (empleado.isPresent()) {
                return empleado.get();
            } else {
                throw new Exception(MensajesAPI.EMPLEADO_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public List<Empleado> obtenerTodos() throws Exception {
        try {
            return this.empleadoRepositorio.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public boolean eliminarEmpleado(Integer id) throws Exception {
        try {
            Optional<Empleado> empleado = this.empleadoRepositorio.findById(id);
            if (empleado.isPresent()) {
                this.empleadoRepositorio.deleteById(id);
                return true;
            } else {
                throw new Exception(MensajesAPI.EMPLEADO_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
