package rfp.idealista.drone.driver.service;

import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import rfp.idealista.drone.driver.model.CartesianCoordinate;
import rfp.idealista.drone.driver.model.Urbanization;

/**
 * @author antonio.saco
 */
@Data
@Log4j2
public class RangeVerifierByDistance implements RangeVerifier {
    private final DistanceMetric distanceMetric;

    private CartesianCoordinate origin;

    @Builder
    public RangeVerifierByDistance(final DistanceMetric distanceMetric) {
        this.distanceMetric = distanceMetric;
    }

    public boolean isInsideRange(final Urbanization urbanization, final int rangeRadius) {

        double distanceFromOrigin = distanceMetric.calculateDistance(origin, urbanization.getCartesianCoordinate());

        log.debug("{} -> {} -> {}", urbanization.getIdentifier(), distanceFromOrigin, Math.round(distanceFromOrigin));

        return Math.round(distanceFromOrigin) <= rangeRadius;
    }

}
