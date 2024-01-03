package org.chrisferdev.poointerfaces.repositorio;

import org.chrisferdev.poointerfaces.repositorio.exepciones.AccesoDatoException;
import org.chrisferdev.poointerfaces.repositorio.exepciones.LecturaAccesoDatoException;

import java.util.List;

public interface CrudRepositorio<T> {
    List<T> listar();
    T porId(Integer id) throws AccesoDatoException;
    void crear(T t) throws AccesoDatoException;
    void editar(T t) throws AccesoDatoException;
    void eliminar(Integer id) throws AccesoDatoException;
}
