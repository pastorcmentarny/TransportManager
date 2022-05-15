package com.dominiksymonowicz.transportmanager.services;

import com.dominiksymonowicz.transportmanager.clients.TubeGateway;
import com.dominiksymonowicz.transportmanager.domain.DataResponse;
import com.dominiksymonowicz.transportmanager.domain.Response;
import com.dominiksymonowicz.transportmanager.domain.stations.Station;
import com.dominiksymonowicz.transportmanager.domain.stations.Stations;
import com.dominiksymonowicz.transportmanager.mappers.ToStationConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static com.dominiksymonowicz.transportmanager.domain.stations.Status.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TubeServiceTest {
    private static final String STATION_NAME = "Station Name";
    @Mock
    private TubeGateway tubeGateway;


    @Mock
    private ToStationConverter toStationConverter;


    private final TubeStatisticsService tubeStatisticsService = new TubeStatisticsService();

    @InjectMocks
    private TubeService tubeService = new TubeService(tubeGateway, toStationConverter, tubeStatisticsService);

    @Test
    void setToPassedStatusAcceptanceTest() {
        //given
        Station station = Station.notVisited(STATION_NAME);
        when(tubeGateway.getStation(STATION_NAME)).thenReturn(Response.ok(station));

        // verify
        assertThat(station.getStatus()).isEqualTo(NOT_VISITED);

        // when
        tubeService.setToPassedStatus(STATION_NAME);

        // then
        assertThat(station.getStatus()).isEqualTo(PASSED);
    }

    //TODO FINISH ALL TESTS


    @Test
    void setToVisitedStatusAcceptanceTest() {
        //given
        Station station = Station.notVisited(STATION_NAME);
        when(tubeGateway.getStation(STATION_NAME)).thenReturn(Response.ok(station));

        // verify
        assertThat(station.getStatus()).isEqualTo(NOT_VISITED);

        // when
        tubeService.setToVisitedStatus(STATION_NAME);

        // then
        assertThat(station.getStatus()).isEqualTo(VISITED);
    }


    @Test
    void getStatisticsAcceptanceTest() {
        // given
        var actonTown = new Station("Acton Town", VISITED, LocalDate.of(2017, 6, 10), LocalDate.of(2017, 6, 10), null);
        var aldgate = new Station("Baker Street", VISITED, LocalDate.of(2017, 2, 2), LocalDate.of(2017, 2, 2), LocalDate.of(LocalDate.now().getYear(), 2, 2));
        var woodford = new Station("Woodford", PASSED, LocalDate.of(2019, 1, 19), null, null);
        var woodsidePark = new Station("Woodside Park", NOT_VISITED, null, null, null);
        final Stations stations = Stations.builder().stations(List.of(aldgate, actonTown, woodford, woodsidePark)).build();
        Map<String, String> statisticData = Map.of("allStations", "4", "stationPassedPercentage", "75", "stationVisitedThisYear", "1", "stationVisited", "2", "stationPassed", "3", "stationVisitedPercentage", "50");
        DataResponse expectedResult = new DataResponse("OK", "Statistic generated", statisticData);

        String dataAsJson = """
                {
                  "stations": [
                    {
                      "name": "Acton Town",
                      "passedDate": "2017-06-10",
                      "status": "V",
                      "visitedDate": "2017-06-10",
                      "visitedThisYearDate": null
                    },
                    {
                      "name": "Baker Street",
                      "passedDate": "2017-02-02",
                      "status": "V",
                      "visitedDate": "2017-02-02",
                      "visitedThisYearDate": "2017-02-02"
                    },
                    {
                      "name": "Woodford",
                      "passedDate": "2019-01-19",
                      "status": "P",
                      "visitedDate": null,
                      "visitedThisYearDate": null
                    },
                    {
                      "name": "Woodside Park",
                      "passedDate": null,
                      "status": "X",
                      "visitedDate": null,
                      "visitedThisYearDate": null
                    }
                  ]
                }""";


        when(tubeGateway.getAllStations()).thenReturn(dataAsJson);
        when(toStationConverter.fromStationsAsJson(dataAsJson)).thenReturn(stations);
        // when
        final DataResponse result = tubeService.getStatistics();

        // then
        assertThat(result).isEqualTo(expectedResult);
    }


    @Test
    void getAllStationNames() {
        // given
        final List<String> data = List.of("Aldgate", "Kilburn", "Watford");
        when(tubeGateway.getAllStationsNames()).thenReturn(data);

        // when
        final List<String> result = tubeService.getAllStationNames();

        // then
        assertThat(result).isEqualTo(data);
    }

    @Test
    public void getStationForAcceptanceTest() {
        // given
        Station station = Station.visited(STATION_NAME, LocalDate.now());
        when(tubeGateway.getStation(STATION_NAME)).thenReturn(Response.ok(station));
        final Response expectedResult = new Response("OK", "Station %s was found.".formatted(STATION_NAME), station);

        // when
        final Response result = tubeService.getStationFor(STATION_NAME);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }


}