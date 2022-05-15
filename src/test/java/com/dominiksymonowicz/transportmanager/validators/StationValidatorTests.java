package com.dominiksymonowicz.transportmanager.validators;

import com.dominiksymonowicz.transportmanager.domain.stations.Station;
import com.dominiksymonowicz.transportmanager.domain.stations.Status;
import com.dominiksymonowicz.transportmanager.exceptions.SomethingWentWrongException;
import com.dominiksymonowicz.transportmanager.exceptions.ValidationFailedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class StationValidatorTests {

    private static final String STATION_NAME = "TestStationName";
    private static final LocalDate TODAY_DATE = LocalDate.now();

    @Test
    public void validateAcceptanceTest() {
        // given
        Station station = new Station("Hungry Dom", Status.VISITED, LocalDate.of(2019, 1, 1), LocalDate.of(2020, 2, 2), LocalDate.of(2021, 3, 3));
        // when
        new StationValidator().validate(station);
    }

    @Test
    public void noStationIsValidStationTest() {
        // given
        Station station = Station.noStation();

        // when
        new StationValidator().validate(station);

        // then no exception is thrown
    }

    @Test
    public void shouldValidateForPassedTest() {
        // given
        Station station = Station.passed(STATION_NAME, LocalDate.now());

        // when
        new StationValidator().validate(station);

        // then no exception is thrown
    }

    @Test
    public void validateThrowsExceptionIfStationNameNullTest() {
        // given
        Station station = new Station(null,Status.UNKNOWN,null,null,null);
        // expect
        final ValidationFailedException result = Assertions.assertThrows(ValidationFailedException.class, () -> {
            new StationValidator().validate(station);
        });

        // then
        assertThat(result.getMessage()).isEqualTo("Validation failed due to Station name is null. Station data: Station(name=, status=UNKNOWN, passedDate=null, visitedDate=null, visitedThisYearDate=null)");
    }

    @Test
    public void validateThrowsExceptionIfStationStatusNullTest() {
        // given
        Station station = new Station(STATION_NAME,null,null,null,null);
        // expect
        final ValidationFailedException result = Assertions.assertThrows(ValidationFailedException.class, () -> {
            new StationValidator().validate(station);
        });

        // then
        assertThat(result.getMessage()).isEqualTo("Validation failed due to Station status is null. Station data: Station(name=, status=UNKNOWN, passedDate=null, visitedDate=null, visitedThisYearDate=null)");
    }


    @Test
    public void validateThrowsExceptionIfNullAcceptanceTest() {
        // expect
        Assertions.assertThrows(ValidationFailedException.class, () -> {
            new StationValidator().validate(null);
        });
    }

    @Test
    public void validateIfNotVisitedHasPassedDateAcceptanceTest() {
        // given
        final Station station = new Station(STATION_NAME, Status.NOT_VISITED, LocalDate.now(), null, null);
        // expect
        final ValidationFailedException result = Assertions.assertThrows(ValidationFailedException.class, () -> {
            new StationValidator().validate(station);
        });

        assertThat(result.getMessage()).isEqualTo("Validation failed due to %s has status not visited but it has passed,visited and/or visitedThisDate date. Station data: Station(name=TestStationName, status=NOT_VISITED, passedDate=2022-05-15, visitedDate=null, visitedThisYearDate=null)".formatted(STATION_NAME));
    }

    @Test
    public void validateIfNotVisitedHasVisitedDateAcceptanceTest() {
        // given
        final Station station = new Station(STATION_NAME, Status.NOT_VISITED, null, LocalDate.now(), null);
        // expect
        final ValidationFailedException result = Assertions.assertThrows(ValidationFailedException.class, () -> {
            new StationValidator().validate(station);
        });

        assertThat(result.getMessage()).startsWith("Validation failed due to %s has status not visited but it has passed,visited and/or visitedThisDate date. Station data:".formatted(STATION_NAME));
    }

    @Test
    public void validateIfNotVisitedHasVisitedDateThisYearAcceptanceTest() {
        // given
        final Station station = new Station(STATION_NAME, Status.NOT_VISITED, null, null, LocalDate.now());
        // expect
        final ValidationFailedException result = Assertions.assertThrows(ValidationFailedException.class, () -> {
            new StationValidator().validate(station);
        });

        assertThat(result.getMessage()).startsWith("Validation failed due to %s has status not visited but it has passed,visited and/or visitedThisDate date. Station data:".formatted(STATION_NAME));
    }

    @Test
    public void validateShouldThrowExceptionIfPassedHasVisitedYearDateTest() {
        // given
        final Station station = new Station(STATION_NAME, Status.PASSED, LocalDate.now(), LocalDate.now(), null);
        // expect
        final ValidationFailedException result = Assertions.assertThrows(ValidationFailedException.class, () -> {
            new StationValidator().validate(station);
        });

        assertThat(result.getMessage()).startsWith("Validation failed due to %s has status passed but it has visited and/or visitedThisDate date (and/or passing date is missing). Station data:".formatted(STATION_NAME));
    }


    @Test
    public void validateShouldThrowExceptionIfPassedHasVisitedThisYearDateTest() {
        // given
        final Station station = new Station(STATION_NAME, Status.PASSED, LocalDate.now(), null, LocalDate.now());
        // expect
        final ValidationFailedException result = Assertions.assertThrows(ValidationFailedException.class, () -> {
            new StationValidator().validate(station);
        });

        assertThat(result.getMessage()).startsWith("Validation failed due to %s has status passed but it has visited and/or visitedThisDate date (and/or passing date is missing). Station data:".formatted(STATION_NAME));
    }

    @Test
    public void  validateShouldThrowExceptionIfPassedHasNotPassedDateTest() {
        // given
        final Station station = new Station(STATION_NAME, Status.PASSED, null, null, null);
        // expect
        final ValidationFailedException result = Assertions.assertThrows(ValidationFailedException.class, () -> {
            new StationValidator().validate(station);
        });

        assertThat(result.getMessage()).startsWith("Validation failed due to %s has status passed but it has visited and/or visitedThisDate date (and/or passing date is missing). Station data:".formatted(STATION_NAME));
    }

    @Test
    public void  validateShouldThrowExceptionIfVisitedHasNotPassedDateTest() {
        // given
        final Station station = new Station(STATION_NAME, Status.VISITED, null, LocalDate.now(), null);
        // expect
        final ValidationFailedException result = Assertions.assertThrows(ValidationFailedException.class, () -> {
            new StationValidator().validate(station);
        });

        assertThat(result.getMessage()).startsWith("Validation failed due to %s has status visited but passed and/or visited date is missing). Station data:".formatted(STATION_NAME));
    }

    @Test
    public void  validateShouldThrowExceptionIfVisitedHasNotVisitedDateTest() {
        // given
        final Station station = new Station(STATION_NAME, Status.VISITED, LocalDate.now(), null, LocalDate.now());
        // expect
        final ValidationFailedException result = Assertions.assertThrows(ValidationFailedException.class, () -> {
            new StationValidator().validate(station);
        });

        assertThat(result.getMessage()).startsWith("Validation failed due to %s has status visited but passed and/or visited date is missing). Station data:".formatted(STATION_NAME));
    }


}
