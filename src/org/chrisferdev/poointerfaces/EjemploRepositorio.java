package org.chrisferdev.poointerfaces;

import org.chrisferdev.poointerfaces.modelo.Cliente;
import org.chrisferdev.poointerfaces.repositorio.Direccion;
import org.chrisferdev.poointerfaces.repositorio.OrdenablePaginableCrudRepositorio;
import org.chrisferdev.poointerfaces.repositorio.exepciones.AccesoDatoException;
import org.chrisferdev.poointerfaces.repositorio.exepciones.EscrituraAccesoDatoException;
import org.chrisferdev.poointerfaces.repositorio.exepciones.LecturaAccesoDatoException;
import org.chrisferdev.poointerfaces.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args){

        try {
            OrdenablePaginableCrudRepositorio<Cliente> repo = new ClienteListRepositorio();
            repo.crear(new Cliente("Jano", "Perez"));
            repo.crear(new Cliente("Bea", "González"));
            repo.crear(new Cliente("Luci", "Martínez"));
            repo.crear(new Cliente("Andrés", "Guzmán"));

            repo.crear(null);

            List<Cliente> clientes = repo.listar();
            clientes.forEach(System.out::println);
            System.out.println("====== paginable ======");
            List<Cliente> paginable = repo.listar(1, 4);
            paginable.forEach(System.out::println);

            System.out.println("===== ordenar ======");
            List<Cliente> clientesOrdenAsc = repo.listar("apellido", Direccion.ASC);
            for (Cliente c : clientesOrdenAsc) {
                System.out.println(c);
            }

            System.out.println("===== editar =====");
            Cliente beaActualizar = new Cliente("Bea", "Mena");
            beaActualizar.setId(2);
            repo.editar(beaActualizar);
            Cliente bea = repo.porId(10);
            System.out.println(bea);
            System.out.println("===========");
            repo.listar("nombre", Direccion.ASC).forEach(System.out::println);
            System.out.println("==== eliminar =====");
            repo.eliminar(2);
            repo.listar().forEach(System.out::println);
            System.out.println("===== total ======");
            System.out.println("Total registros: " + repo.total());
        } catch (LecturaAccesoDatoException e){
            System.out.println("Lectura: " + e.getMessage());
            e.printStackTrace();
        } catch(EscrituraAccesoDatoException e){
            System.out.println("Escritura: " + e.getMessage());
            e.printStackTrace();
        }
        catch (AccesoDatoException e){
            System.out.println("Generica: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
