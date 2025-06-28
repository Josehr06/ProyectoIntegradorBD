package com.example.ProyectoIntegradorDB.Ayudas;

public enum MensajesAPI {


    CLIENTE_NO_ENCONTRADO("El cliente que buscas no se encuentra en la base de datos."),
    CLIENTE_CREADO("Cliente creado correctamente."),
    CLIENTE_ACTUALIZADO("Cliente actualizado correctamente."),
    CLIENTE_ELIMINADO("Cliente eliminado correctamente."),


    EMPLEADO_NO_ENCONTRADO("El empleado que buscas no se encuentra en la base de datos."),
    EMPLEADO_CREADO("Empleado creado correctamente."),
    EMPLEADO_ACTUALIZADO("Empleado actualizado correctamente."),
    EMPLEADO_ELIMINADO("Empleado eliminado correctamente."),


    MESA_NO_ENCONTRADA("La mesa que buscas no se encuentra en la base de datos."),
    MESA_CREADA("Mesa creada correctamente."),
    MESA_ACTUALIZADA("Mesa actualizada correctamente."),
    MESA_ELIMINADA("Mesa eliminada correctamente."),


    PEDIDO_NO_ENCONTRADO("El pedido que buscas no se encuentra en la base de datos."),
    PEDIDO_CREADO("Pedido creado correctamente."),
    PEDIDO_ACTUALIZADO("Pedido actualizado correctamente."),
    PEDIDO_ELIMINADO("Pedido eliminado correctamente."),


    PRODUCTO_NO_ENCONTRADO("El producto que buscas no se encuentra en la base de datos."),
    PRODUCTO_CREADO("Producto creado correctamente."),
    PRODUCTO_ACTUALIZADO("Producto actualizado correctamente."),
    PRODUCTO_ELIMINADO("Producto eliminado correctamente."),


    RESERVA_NO_ENCONTRADA("La reserva que buscas no se encuentra en la base de datos."),
    RESERVA_CREADA("Reserva creada correctamente."),
    RESERVA_ACTUALIZADA("Reserva actualizada correctamente."),
    RESERVA_ELIMINADA("Reserva eliminada correctamente."),


    DETALLE_PEDIDO_NO_ENCONTRADO("El detalle de pedido que buscas no se encuentra en la base de datos."),
    DETALLE_PEDIDO_CREADO("Detalle de pedido creado correctamente."),
    DETALLE_PEDIDO_ACTUALIZADO("Detalle de pedido actualizado correctamente."),
    DETALLE_PEDIDO_ELIMINADO("Detalle de pedido eliminado correctamente.");

    private final String texto;

    MensajesAPI(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}


