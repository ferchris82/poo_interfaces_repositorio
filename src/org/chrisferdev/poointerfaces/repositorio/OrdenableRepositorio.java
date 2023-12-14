package org.chrisferdev.poointerfaces.repositorio;

import org.chrisferdev.poointerfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio {
    List<Cliente> listar(String campo, Direccion dir);
}
