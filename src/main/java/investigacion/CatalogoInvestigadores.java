package investigacion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * Clase CatalogoInvestigadores
 */
public class CatalogoInvestigadores {
    private static final  CatalogoInvestigadores mCatalogoInvestigadores = new CatalogoInvestigadores();
    private final List<Investigador> listaInvestigadores;

    private CatalogoInvestigadores() {
        listaInvestigadores = new ArrayList<>();
    }

    /**
     * Devuelve la instancia única de CatalogoInvestigadores
     *
     * @return el catálogo de investigadores
     */
    public static CatalogoInvestigadores getCatalogoInvestigadores() {
        return mCatalogoInvestigadores;
    }

    /**
     * Añade un nuevo investigador al catálogo de investigadores
     *
     * @param pInvestigador - el nuevo investigador
     */
    public void addInvestigador(Investigador pInvestigador) {
        listaInvestigadores.add(pInvestigador);
    }

    /**
     * Devuelve la lista de investigadores registrados en el catálogo.
     *
     * @return la lista de investigagores
     */
    public List<Investigador> getListaInvestigadores() {
        return List.copyOf(listaInvestigadores);
    }


    /**
     * Devuelve la lista de investigadores ordenada por publicaciones
     *
     * @return la lista investigadores ordenada por publicaciones
     */
    public List<Investigador> getListaInvestigadoresOrdenadaPorPublicaciones() {
        // TODO: Ejercicio 7
        return listaInvestigadores
                .stream()
                .sorted(comparing(Investigador::getNumeroPublicaciones).reversed())
                .toList();
    }

    /**
     * Devuelve la media de citas por departamento
     *
     * @return la media citas por departamento
     */
    public Map<String, Double> getMediaCitasPorDepartamento() {
        // TODO: Ejercicio 8
        return listaInvestigadores
                .stream()
                .collect(groupingBy(Investigador::getDepartamento
                        ,averagingDouble
                        (Investigador::getNumCitasTotales)));

    }

    /**
     * Devuelve los nombres de los investigadores agrupados por departamento y h-index
     *
     * @return los investigadores agrupados por departamento y h-index
     */
    public Map<String, Map<Integer,List<String>>> getInvestigadoresPorDepYHIndex() {
        // TODO: Ejercicio 10
        return listaInvestigadores
                .stream()
                .collect(groupingBy(Investigador::getDepartamento
                        ,groupingBy(Investigador::getHIndex,mapping
                                (Investigador::getNombre,toList()))
                ));

    }


    /**
     * Devuelve la lista de investigadores ordenada por departamento y h-index
     *
     * @return lista de investigadores ordenada por departamento y h-index
     */
    public List<Investigador> getInvestigadoresOrdenadosPorDepYHIndex() {
        // TODO: Ejercicio 9
        return listaInvestigadores
                .stream()
                .sorted(comparing(Investigador::getDepartamento).reversed()
                        .thenComparing(Investigador::getHIndex).reversed())
                .toList();
    }

    /**
     * Elimina los investigadores del catálogo.
     */
    public void eliminaInvestigadores() {
        listaInvestigadores.clear();
    }
}

