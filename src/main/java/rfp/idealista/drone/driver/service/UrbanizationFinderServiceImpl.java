package rfp.idealista.drone.driver.service;

import lombok.Builder;
import lombok.Data;
import rfp.idealista.drone.driver.model.CartesianCoordinate;
import rfp.idealista.drone.driver.model.Urbanization;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author antonio.saco
 */
@Data
public class UrbanizationFinderServiceImpl implements UrbanizationFinderService {
    final private UrbanizationArea urbanizationArea;
    final private RangeVerifier rangeVerifier;

    @Builder
    public UrbanizationFinderServiceImpl(final Set<Urbanization> urbanizationArea, final RangeVerifier rangeVerifier) {
        this.urbanizationArea = UrbanizationAreaImpl.builder().urbanizationArea(urbanizationArea).build();
        this.rangeVerifier = rangeVerifier;
    }

    @Override
    public List<Integer> obtenerUrbanizaciones(final double coordenadaX, double coordenadaY, final int rango) {
        setVerifierOrigin(coordenadaX, coordenadaY);

        final Set<Integer> result = new TreeSet<>();
        urbanizationArea.getUrbanizationAreas().forEach(urbanization -> {
            if (rangeVerifier.isInsideRange(urbanization, rango)) {
                result.add(urbanizationArea.obtenerIdentificadorUrbanizacion(urbanization.getCartesianCoordinate()));
            }
        });

        return new ArrayList<>(result);
    }

    private void setVerifierOrigin(final double coordenadaX, final double coordenadaY) {
        final CartesianCoordinate originCoordinate = CartesianCoordinate.builder().x(coordenadaX).y(coordenadaY)
                .build();
        rangeVerifier.setOrigin(originCoordinate);
    }

}
