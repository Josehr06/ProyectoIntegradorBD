package com.example.ProyectoIntegradorDB.Servicios;

import com.example.ProyectoIntegradorDB.Ayudas.MensajesAPI;
import com.example.ProyectoIntegradorDB.Modelos.Producto;
import com.example.ProyectoIntegradorDB.Repositorio.IProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicios {

    @Autowired
    IProductoRepositorio productoRepositorio;


    public Producto guardarProducto(Producto producto) throws Exception {
        try {
            return this.productoRepositorio.save(producto);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public Producto actualizarProducto(Integer id, Producto nuevoProducto) throws Exception {
        Optional<Producto> productoExistente = this.productoRepositorio.findById(id);
        try {
            if (productoExistente.isPresent()) {
                productoExistente.get().setNombre(nuevoProducto.getNombre());
                productoExistente.get().setPrecio(nuevoProducto.getPrecio());
                return this.productoRepositorio.save(productoExistente.get());
            } else {
                throw new Exception(MensajesAPI.PRODUCTO_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public Producto buscarPorId(Integer id) throws Exception {
        try {
            Optional<Producto> producto = this.productoRepositorio.findById(id);
            if (producto.isPresent()) {
                return producto.get();
            } else {
                throw new Exception(MensajesAPI.PRODUCTO_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public List<Producto> obtenerTodos() throws Exception {
        try {
            return this.productoRepositorio.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean eliminarProducto(Integer id) throws Exception {
        try {
            Optional<Producto> producto = this.productoRepositorio.findById(id);
            if (producto.isPresent()) {
                this.productoRepositorio.deleteById(id);
                return true;
            } else {
                throw new Exception(MensajesAPI.PRODUCTO_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
