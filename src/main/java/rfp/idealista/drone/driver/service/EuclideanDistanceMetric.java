package rfp.idealista.drone.driver.service;

import lombok.Builder;
import rfp.idealista.drone.driver.model.CartesianCoordinate;

/**
 * @author antonio.saco
 */
@Builder
public class EuclideanDistanceMetric implements DistanceMetric {

    // Pythagorean theorem:  double distance = Math.hypot(x1-x2, y1-y2);
    public double calculateDistance(final CartesianCoordinate origin, final CartesianCoordinate otherCoordinate) {

        return Math.hypot(origin.getX() - otherCoordinate.getX(), origin.getY() - otherCoordinate.getY());

    }

}
