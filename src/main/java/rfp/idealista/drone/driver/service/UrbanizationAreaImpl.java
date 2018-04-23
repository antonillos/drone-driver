package rfp.idealista.drone.driver.service;

import lombok.Builder;
import lombok.Data;
import rfp.idealista.drone.driver.model.CartesianCoordinate;
import rfp.idealista.drone.driver.model.Urbanization;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author antonio.saco
 */
@Data
public class UrbanizationAreaImpl implements UrbanizationArea {
    public final Set<Urbanization> urbanizationAreas = new TreeSet<>();

    @Builder
    public UrbanizationAreaImpl(final Set<Urbanization> urbanizationArea) {
        this.urbanizationAreas.addAll(urbanizationArea);
    }

    @Override
    public Integer obtenerIdentificadorUrbanizacion(final CartesianCoordinate cartesianCoordinate)
            throws IllegalStateException {

        return urbanizationAreas.parallelStream().filter(urbanization ->
                urbanization.getCartesianCoordinate().getX().equals(cartesianCoordinate.getX()) &&
                        urbanization.getCartesianCoordinate().getY().equals(cartesianCoordinate.getY())).findFirst()
                .orElseThrow(IllegalStateException::new).getIdentifier();
    }

}
