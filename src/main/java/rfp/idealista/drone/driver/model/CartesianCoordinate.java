package rfp.idealista.drone.driver.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Objects;

@Data
@Builder
@ToString
public class CartesianCoordinate {

    private Double x;
    private Double y;

    public int hashCode() {
        return Objects.hash(x, y);
    }

}
