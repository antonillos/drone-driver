package rfp.idealista.drone.driver.service;

import rfp.idealista.drone.driver.model.CartesianCoordinate;

public interface DistanceMetric {

    double calculateDistance(final CartesianCoordinate origin, final CartesianCoordinate otherCoordinate);

}
