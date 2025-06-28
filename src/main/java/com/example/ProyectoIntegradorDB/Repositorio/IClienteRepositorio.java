package com.example.ProyectoIntegradorDB.Repositorio;

import com.example.ProyectoIntegradorDB.Modelos.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IClienteRepositorio extends JpaRepository<Cliente, Integer> {
}
