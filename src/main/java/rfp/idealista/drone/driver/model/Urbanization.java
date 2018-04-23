package rfp.idealista.drone.driver.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Comparator;
import java.util.Objects;

@Data
@Builder
@ToString
public class Urbanization implements Comparable<Urbanization> {

    private Integer identifier;
    private CartesianCoordinate cartesianCoordinate;

    @Override
    public int compareTo(final Urbanization otherUrbanization) {
        return Objects.compare(this.identifier, otherUrbanization.identifier, Comparator.naturalOrder());
    }

}
