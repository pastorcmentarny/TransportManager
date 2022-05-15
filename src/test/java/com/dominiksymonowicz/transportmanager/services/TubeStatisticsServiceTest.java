package com.dominiksymonowicz.transportmanager.services;

import com.dominiksymonowicz.transportmanager.domain.stations.Stations;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Map;
import java.util.Scanner;

import static com.dominiksymonowicz.transportmanager.TestUtils.generateStations;
import static org.assertj.core.api.Assertions.assertThat;


class TubeStatisticsServiceTest {
    private final TubeStatisticsService tubeStatisticsService = new TubeStatisticsService();

    @Test
    void generateStatistics() {
        // given
        final Stations stations = generateStations();
        var expectedResult = Map.of("allStations", "10",
                "stationPassedPercentage", "60",
                "stationVisitedThisYear", "3",
                "stationVisited", "4",
                "stationPassed", "6",
                "stationVisitedPercentage", "40"
        );
        // when
        final Map<String, String> result = tubeStatisticsService.generateStatistics(stations);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

}