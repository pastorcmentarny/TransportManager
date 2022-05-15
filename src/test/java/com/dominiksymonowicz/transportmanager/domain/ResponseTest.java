package com.dominiksymonowicz.transportmanager.domain;

import com.dominiksymonowicz.transportmanager.TestUtils;
import com.dominiksymonowicz.transportmanager.domain.stations.Station;
import com.dominiksymonowicz.transportmanager.domain.stations.Status;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class ResponseTest {

    private static final String STATION_NAME = "Test";
    private static final String STATION_TEST_WAS_FOUND = "Station test was found";

    @Test
    void notFoundAcceptanceTest() {
        // given
        var expectedResult = new Response("NOT_FOUND","Test not found",null);

        // when
        final Response result = Response.notFound(STATION_NAME);

        // then
        assertThat(result).isEqualTo(expectedResult);


    }

    @Test
    void errorAcceptanceTest() {
        // given
        var message = "WHOOPS";
        var expectedResult = new Response("ERROR","Unable to read response due to : " + message, Station.noStation());

        // when
        final Response result = Response.error(message);

        // then
        assertThat(result).isEqualTo(expectedResult);

    }

    @Test
    void okAcceptanceTest() {
        // given
        var testStation = TestUtils.testStation();
        var expectedResult = new Response("OK","Station Test was found.",testStation);
        // when
        final Response result = Response.ok(testStation);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void isOK() {
        // given
        final Response response = getOKResponse();

        // when
        final boolean result = response.isOK();

        // then
        assertThat(result).isTrue();

    }

    @Test
    void updateToPassedAcceptanceTest() {
        // given
        final Station test = Station.notVisited(STATION_NAME);
        final LocalDate today = LocalDate.now();
        final Station expectedResult = new Station(STATION_NAME, Status.PASSED, today, null, null);

        // when
        test.setPassedDate(today);

        // then
        assertThat(test).isEqualTo(expectedResult);

    }

    @Test
    void toErrorAcceptanceTest() {
        // given

        // when

        // then


    }

    @Test
    void isNotOKAcceptanceTest() {
        // given

        // when

        // then


    }

    @Test
    void toWarningAcceptanceTest() {
        // given

        // when

        // then


    }

    @Test
    void toInfoAcceptanceTest() {
        // given

        // when

        // then


    }

    @Test
    void updateToVisitedThisYearAcceptanceTest() {
        // given

        // when

        // then


    }

    @Test
    void updateToVisitedAcceptanceTest() {
        // given

        // when

        // then


    }




    @Test
    void testGetOKResponseAcceptanceTest(){
        // when
        final Response result = getOKResponse();

        // then
        assertThat(result.getResult()).isEqualTo("OK");
        assertThat(result.getDescription()).isEqualTo(STATION_TEST_WAS_FOUND);
        assertThat(result.getStation()).isNotNull();
    }

    private Response getOKResponse(){
        return new Response("OK", STATION_TEST_WAS_FOUND, TestUtils.testStation());
    }

}