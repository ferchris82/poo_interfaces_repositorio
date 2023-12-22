package org.chrisferdev.poointerfaces.repositorio;

import org.chrisferdev.poointerfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio<T> {
    List<T> listar(int desde, int hasta);
}
