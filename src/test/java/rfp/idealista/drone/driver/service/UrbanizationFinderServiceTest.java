package rfp.idealista.drone.driver.service;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rfp.idealista.drone.driver.model.CartesianCoordinate;
import rfp.idealista.drone.driver.model.Urbanization;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UrbanizationFinderServiceTest {
    private final Set<Urbanization> urbanizationTotalArea = new TreeSet<>();
    private UrbanizationFinderService urbanizationFinderServiceUsingEuclideanDistance;

    @Before
    public void setUp() throws Exception {

        loadUrbanizationAreaFromFile(urbanizationTotalArea);

        urbanizationFinderServiceUsingEuclideanDistance = UrbanizationFinderServiceImpl.builder()
                .urbanizationArea(urbanizationTotalArea).rangeVerifier(
                        RangeVerifierByDistance.builder().distanceMetric(EuclideanDistanceMetric.builder().build())
                                .build()).build();
    }

    private void loadUrbanizationAreaFromFile(final Set<Urbanization> urbanizationArea) throws FileNotFoundException {
        try (Scanner in = new Scanner(new File("src/test/resources/cartesian.txt"))) {
            int maxUrbanization = in.nextInt();

            IntStream.rangeClosed(1, maxUrbanization).forEach(id -> {
                String readLine = in.next();
                Scanner lineReader = new Scanner(readLine).useDelimiter(",");

                CartesianCoordinate cartesianCoordinate = CartesianCoordinate.builder().x(lineReader.nextDouble())
                        .y(lineReader.nextDouble()).build();
                Urbanization urbanization = Urbanization.builder().identifier(id)
                        .cartesianCoordinate(cartesianCoordinate).build();
                urbanizationArea.add(urbanization);
            });

        }
    }

    @Test
    public void obtenerUrbanizacionesWithRange0() {
        // given
        List<Integer> urbanizationInRange = Collections.singletonList(13);

        // when
        List<Integer> urbanizationInRangeResult = urbanizationFinderServiceUsingEuclideanDistance
                .obtenerUrbanizaciones(38.568890, 40.511107, 0);

        // then
        Assert.assertEquals(urbanizationInRange, urbanizationInRangeResult);

    }

    @Test
    public void obtenerUrbanizacionesWithRange1() {
        // given
        List<Integer> urbanizationInRange = Arrays.asList(7, 8, 9, 12, 13, 14, 17, 18, 19);

        // when
        List<Integer> urbanizationInRangeResult = urbanizationFinderServiceUsingEuclideanDistance
                .obtenerUrbanizaciones(38.568890, 40.511107, 1);

        // then
        Assert.assertEquals(urbanizationInRange, urbanizationInRangeResult);

    }

    @Test
    public void obtenerUrbanizacionesWithRange2() {
        // given
        List<Integer> urbanizationInRange = IntStream.rangeClosed(1, 25).boxed().collect(Collectors.toList());

        // when
        List<Integer> urbanizationInRangeResult = urbanizationFinderServiceUsingEuclideanDistance
                .obtenerUrbanizaciones(38.568890, 40.511107, 2);

        // then
        Assert.assertEquals(urbanizationInRange, urbanizationInRangeResult);

    }
}