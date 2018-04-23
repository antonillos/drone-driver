package rfp.idealista.drone.driver.service;

import rfp.idealista.drone.driver.model.CartesianCoordinate;
import rfp.idealista.drone.driver.model.Urbanization;

public interface RangeVerifier {

    void setOrigin(CartesianCoordinate origin);

    boolean isInsideRange(final Urbanization urbanization, final int rangeRadius);

}
