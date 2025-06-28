package com.example.ProyectoIntegradorDB.Servicios;

import com.example.ProyectoIntegradorDB.Ayudas.MensajesAPI;
import com.example.ProyectoIntegradorDB.Modelos.Cliente;
import com.example.ProyectoIntegradorDB.Repositorio.IClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicios {

    @Autowired
    IClienteRepositorio clienteRepositorio;


    public Cliente guardarCliente(Cliente cliente) throws Exception {
        try {
            return this.clienteRepositorio.save(cliente);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public Cliente actualizarCliente(Integer id, Cliente nuevoCliente) throws Exception {
        Optional<Cliente> clienteExistente = this.clienteRepositorio.findById(id);
        try {
            if (clienteExistente.isPresent()) {
                clienteExistente.get().setNombre(nuevoCliente.getNombre());
                clienteExistente.get().setTelefono(nuevoCliente.getTelefono());
                clienteExistente.get().setCorreo(nuevoCliente.getCorreo());
                return this.clienteRepositorio.save(clienteExistente.get());
            } else {
                throw new Exception(MensajesAPI.CLIENTE_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public Cliente buscarPorId(Integer id) throws Exception {
        try {
            Optional<Cliente> cliente = this.clienteRepositorio.findById(id);
            if (cliente.isPresent()) {
                return cliente.get();
            } else {
                throw new Exception(MensajesAPI.CLIENTE_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public List<Cliente> obtenerTodos() throws Exception {
        try {
            return this.clienteRepositorio.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public boolean eliminarCliente(Integer id) throws Exception {
        try {
            Optional<Cliente> cliente = this.clienteRepositorio.findById(id);
            if (cliente.isPresent()) {
                this.clienteRepositorio.deleteById(id);
                return true;
            } else {
                throw new Exception(MensajesAPI.CLIENTE_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
