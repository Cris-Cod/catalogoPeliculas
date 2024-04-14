package ca.peliculas.presentacion;


import ca.peliculas.negocio.CatalogosPeliculasImpl;
import ca.peliculas.negocio.ICatalogoPeliculas;

import java.util.Scanner;

public class CatalogoPeliculasPresentacion {
    public static void main(String[] args) {
        var opcion = -1;
        var sc = new Scanner(System.in);
        ICatalogoPeliculas catalogoPeliculas = new CatalogosPeliculasImpl();

        while (opcion != 0){
            System.out.println("Elige una opcion: \n "
            + "1. Iniciar catalogo de pelicuals\n"
                  +  "2. Agregar pelicula\n"
            + "3. Listar peliculas\n"
            + "4. Buscar peliculas\n"
                    + "0. Salir");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion){
                case 1:
                    catalogoPeliculas.inciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la pelicula");
                    var nombrePelicula = sc.nextLine();
                    catalogoPeliculas.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogoPeliculas.listar();
                    break;
                case 4:
                    System.out.println("Introduce una pelicula a buscar");
                    var peliculaBuscar = sc.nextLine();
                    catalogoPeliculas.buscar(peliculaBuscar);
                    break;
                case 0:
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("Opcion no reconocida");
            }
        }
    }
}
