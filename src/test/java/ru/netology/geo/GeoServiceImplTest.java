package ru.netology.geo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeoServiceImplTest {
    GeoServiceImpl sut;

    @BeforeEach
    public void init() {

        System.out.println("\n test started");
        sut = new GeoServiceImpl();
    }

    @BeforeAll
    public static void started() {

        System.out.println("tests started");
    }

    @AfterEach
    public void finished() {

        System.out.println("\n test completed");
    }

    @AfterAll
    public static void finishedAll() {

        System.out.println("tests completed");
    }

    @ParameterizedTest
    @MethodSource({"Ip"})
    public void testLocationByIp(String ip, Location location) {

        assertEquals(sut.byIp(ip).getCountry(), location.getCountry());

    }

    private static Stream<Arguments> Ip() {
        return Stream.of(Arguments.of("127.0.0.1", new Location(null, null, null, 0)),
                Arguments.of("172.", new Location("Moscow", Country.RUSSIA, null, 0)),
                Arguments.of("96.", new Location("New York", Country.USA, null, 0)),
                Arguments.of("172.0.32.11", new Location("Moscow", Country.RUSSIA, "Lenina", 15)),
                Arguments.of("96.44.183.149", new Location("New York", Country.USA, " 10th Avenue", 32)));
    }
}
