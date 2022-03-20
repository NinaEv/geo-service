package ru.netology.i18n;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.entity.Country.BRAZIL;
import static ru.netology.entity.Country.RUSSIA;

public class LocalizationServiceImplTest {
    LocalizationService sut;

    @BeforeEach
    public void init() {

        System.out.println("\n test started");
        sut = new LocalizationServiceImpl();
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
    @MethodSource({"Country"})
    public void locale(Country country, String location) {

        assertEquals(sut.locale(country), location);

    }

    private static Stream<Arguments> Country() {
        return Stream.of(Arguments.of(RUSSIA, "Добро пожаловать"),
                Arguments.of(BRAZIL, "Welcome"));
    }
}
