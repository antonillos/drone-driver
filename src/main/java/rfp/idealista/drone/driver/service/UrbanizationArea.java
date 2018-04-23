package rfp.idealista.drone.driver.service;

import rfp.idealista.drone.driver.model.CartesianCoordinate;
import rfp.idealista.drone.driver.model.Urbanization;

import java.util.Set;

public interface UrbanizationArea {

    Set<Urbanization> getUrbanizationAreas();

    Integer obtenerIdentificadorUrbanizacion(CartesianCoordinate cartesianCoordinate);

}
