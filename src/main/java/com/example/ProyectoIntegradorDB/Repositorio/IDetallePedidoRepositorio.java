package com.example.ProyectoIntegradorDB.Repositorio;
import com.example.ProyectoIntegradorDB.Modelos.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IDetallePedidoRepositorio extends JpaRepository<DetallePedido, Integer> {
}
