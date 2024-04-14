package ca.peliculas.datos;

import ca.peliculas.domain.Pelicula;
import ca.peliculas.excepciones.AccesoDatosEx;
import ca.peliculas.excepciones.EscrituraDatosEX;
import ca.peliculas.excepciones.LecturaDatosEx;

import java.util.List;

public interface IAccesoDatos {

    boolean existe(String nombreArchivo) throws AccesoDatosEx;

    public List<Pelicula> listar(String nombre) throws LecturaDatosEx;

    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEX;

    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;

    public void crear(String nombreArchivo)throws AccesoDatosEx;

    public void borrar(String nombreArchivo) throws  AccesoDatosEx;
}
