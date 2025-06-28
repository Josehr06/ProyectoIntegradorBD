package com.example.ProyectoIntegradorDB.Repositorio;
import com.example.ProyectoIntegradorDB.Modelos.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IPedidoRepositorio extends JpaRepository<Pedido, Integer>{
}
