package rfp.idealista.drone.driver.service;

import java.util.List;

public interface UrbanizationFinderService {

    // list of Urbanization identifiers in that range
    List<Integer> obtenerUrbanizaciones(final double coordenadaX, double coordenadaY, final int inRange);

}
