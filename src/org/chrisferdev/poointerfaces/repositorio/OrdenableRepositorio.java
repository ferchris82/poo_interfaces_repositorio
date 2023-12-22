package org.chrisferdev.poointerfaces.repositorio;

import org.chrisferdev.poointerfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio<T> {
    List<T> listar(String campo, Direccion dir);
}
