package com.dominiksymonowicz.transportmanager.services;

import com.dominiksymonowicz.transportmanager.clients.TubeGateway;
import com.dominiksymonowicz.transportmanager.domain.DataResponse;
import com.dominiksymonowicz.transportmanager.domain.Response;
import com.dominiksymonowicz.transportmanager.domain.stations.Station;
import com.dominiksymonowicz.transportmanager.domain.stations.Stations;
import com.dominiksymonowicz.transportmanager.mappers.ToStationConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class TubeService {
    private TubeGateway tubeGateway;
    private ToStationConverter toStationConverter;

    private TubeStatisticsService tubeStatisticsService;

    public TubeService(TubeGateway tubeGateway, ToStationConverter toStationConverter, TubeStatisticsService tubeStatisticsService) {
        this.tubeGateway = tubeGateway;
        this.toStationConverter = toStationConverter;
        this.tubeStatisticsService = tubeStatisticsService;
    }

    public Response setToPassedStatus(String stationName) {
        // get station
        final Response stationResponse = tubeGateway.getStation(stationName);
        if (stationResponse.isOK()) {
            updateToPassedIfNotPassedBefore(stationResponse);
            System.out.println(stationResponse);
        }
        return stationResponse;
    }

    public Response setToVisitedStatus(String stationName) {
        final Response stationResponse = tubeGateway.getStation(stationName);
        final Station station = stationResponse.getStation();
        log.info(station.getStatus().asName());
        if (stationResponse.isOK()) {
            if(station.isVisitedThisYearAlready()) {
                stationResponse.toWarning("Station was visited (this year)");
            }else {
                if(station.isVisitedAlready()){
                    stationResponse.toInfo("Station was visited already. Updating for visited this year.");
                    stationResponse.updateToVisitedThisYear();
                } else {
                    stationResponse.updateToVisited();
                }
                tubeGateway.updateStatusFor(station);
            }
        }
        return stationResponse;
    }

    public DataResponse getStatistics() {
        try {
            final String allStations = tubeGateway.getAllStations();
            final Stations stations = toStationConverter.fromStationsAsJson(allStations);
            return new DataResponse("OK","Statistic generated",tubeStatisticsService.generateStatistics(stations));
        } catch (Exception exception) {
            return DataResponse.error("Unable to get statistics due to %s".formatted(exception.getMessage()));
        }
    }

    private void updateToPassedIfNotPassedBefore(Response stationResponse) {
        if (stationResponse.getStation().isPassedAlready()) {
            stationResponse.toError("Already passed this station");
        } else {
            stationResponse.updateToPassed();
            tubeGateway.updateToPassed(stationResponse.getStation().getName());
        }
    }

    public List<String> getAllStationNames() {
        return tubeGateway.getAllStationsNames();
    }

    public Response getStationFor(String stationName) {
        return tubeGateway.getStation(stationName);
    }
}
