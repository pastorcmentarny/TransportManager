package com.dominiksymonowicz.transportmanager.domain.stations;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static com.dominiksymonowicz.transportmanager.TestUtils.generateStations;
import static org.assertj.core.api.Assertions.assertThat;

class StationsTest {

    @Test
    void getStationsShouldReturnAllEightStationsTest() {
        // given
        Stations stations = generateStations();
        // when
        final List<Station> allStations = stations.getStations();
        // then
        assertThat(allStations.size()).isEqualTo(10);
    }

    @Test
    void countStationPassedShouldReturnSixForStationsPassedTest() {
        // given
        Stations stations = generateStations();
        // when
        final int result = stations.countStationPassed();
        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void countStationVisitedShouldReturnFourTest() {
        // given
        Stations stations = generateStations();
        // when
        final int result = stations.countStationVisited();
        // then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void countStationVisitedThisYearShouldReturnThreeTest() {
        // given
        Stations stations = generateStations();
        // when
        final int result = stations.countStationVisitedThisYear();
        // then
        assertThat(result).isEqualTo(3);
    }





}