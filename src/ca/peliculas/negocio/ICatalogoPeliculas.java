package ca.peliculas.negocio;

public interface ICatalogoPeliculas {

    String NOMBRE_ARCHIVO = "peliculas.txt";

    public void agregarPelicula(String nombrePelicula);

    public void listar();

    public void buscar(String buscar);

    public void inciarCatalogoPeliculas();

}
