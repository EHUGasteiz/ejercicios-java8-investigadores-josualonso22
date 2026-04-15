package investigacion;

import java.util.ArrayList;
import java.util.List;

public class ListaPublicaciones {
    private static final ListaPublicaciones mListaPublicaciones = new ListaPublicaciones();
    private final List<Publicacion> listaPublicaciones;

    private ListaPublicaciones() {
        listaPublicaciones = new ArrayList<>();
    }

    /**
     * Devuelve la instancia única de ListaPublicaciones
     * @return la instancia de ListaPublicaciones
     */
    public static ListaPublicaciones getListaPublicaciones() {
        return mListaPublicaciones;
    }

    /**
     * Añade una nueva publicación a la lista de publicaciones
     * @param pPub - la publicación
     */
    public void addPublicacion(Publicacion pPub) {
        listaPublicaciones.add(pPub);
    }


    /**
     * Devuelve la lista de publicaciones registradas de las que el investigador indicado es autor
     * @param pId - ORCID del autor cuyas publicaciones se quieren obtener
     * @return la lista de publicaciones del autor
     */
    public List<Publicacion> getPublicacionesInvestigador(String pId) {
        // TODO: Ejercicio 1
        return listaPublicaciones
                .stream()
                .filter(p-> p.esAutor(pId))
                .toList();
    }

    /**
     * Elimina las publicaciones de la lista de publicaciones
     */
    public void eliminarPublicaciones() {
        listaPublicaciones.clear();
    }

}

