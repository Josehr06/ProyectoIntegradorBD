package com.example.ProyectoIntegradorDB.Repositorio;
import com.example.ProyectoIntegradorDB.Modelos.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IReservaRepositorio extends JpaRepository<Reserva, Integer>{
}
