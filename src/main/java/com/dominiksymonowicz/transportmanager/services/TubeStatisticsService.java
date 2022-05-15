package com.dominiksymonowicz.transportmanager.services;

import com.dominiksymonowicz.transportmanager.domain.stations.Stations;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.dominiksymonowicz.transportmanager.common.Utils.countPercentage;

@Service
public class TubeStatisticsService {
    public Map<String, String> generateStatistics(Stations stations) {
        Map<String, String> stats = new HashMap<>();
        stats.put("allStations", String.valueOf(stations.getStations().size()));
        stats.put("stationPassed", String.valueOf(stations.countStationPassed()));
        stats.put("stationPassedPercentage", String.valueOf(countPercentage(stations.countStationPassed(), stations.getStations().size())));
        stats.put("stationVisited", String.valueOf(stations.countStationVisited()));
        stats.put("stationVisitedPercentage", String.valueOf(countPercentage(stations.countStationVisited(), stations.getStations().size())));
        stats.put("stationVisitedThisYear", String.valueOf(stations.countStationVisitedThisYear()));
        return stats;
    }
}
