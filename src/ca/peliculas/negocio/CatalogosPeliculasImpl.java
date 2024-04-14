package ca.peliculas.negocio;

import ca.peliculas.datos.AccesoDatosImpl;
import ca.peliculas.datos.IAccesoDatos;
import ca.peliculas.domain.Pelicula;
import ca.peliculas.excepciones.AccesoDatosEx;
import ca.peliculas.excepciones.LecturaDatosEx;

public class CatalogosPeliculasImpl implements ICatalogoPeliculas{

    private  final IAccesoDatos datos;
    public CatalogosPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }


    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_ARCHIVO);
            datos.escribir(pelicula, NOMBRE_ARCHIVO, anexar);
        } catch (AccesoDatosEx e) {
            System.out.println("Error de acceso a datos");
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void listar() {
        try {
            var peliculas = this.datos.listar(NOMBRE_ARCHIVO);
            for (var pelicula: peliculas){
                System.out.println("pelicula = " + pelicula);
            }
        } catch (AccesoDatosEx e) {
            System.out.println("Error de acceso datos");
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void buscar(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_ARCHIVO, buscar);
        } catch (AccesoDatosEx e) {
            System.out.println("Error de acceso datos");
            e.printStackTrace(System.out);
        }
        System.out.println("resultado = " + resultado);
    }

    @Override
    public void inciarCatalogoPeliculas() {
        try {
            if(this.datos.existe(NOMBRE_ARCHIVO)){
                datos.borrar(NOMBRE_ARCHIVO);
                datos.crear(NOMBRE_ARCHIVO);
            }else {
                datos.crear(NOMBRE_ARCHIVO);
            }
        } catch (AccesoDatosEx e) {
            System.out.println("Error al inciar catalogo de peliculas");
            e.printStackTrace(System.out);
        }
    }
}
