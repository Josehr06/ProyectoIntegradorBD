package com.example.ProyectoIntegradorDB.Repositorio;

import com.example.ProyectoIntegradorDB.Modelos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IProductoRepositorio extends JpaRepository<Producto, Integer> {
}
