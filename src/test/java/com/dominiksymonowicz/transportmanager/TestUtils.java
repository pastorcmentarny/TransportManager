package com.dominiksymonowicz.transportmanager;

import com.dominiksymonowicz.transportmanager.domain.stations.Station;
import com.dominiksymonowicz.transportmanager.domain.stations.StationName;
import com.dominiksymonowicz.transportmanager.domain.stations.StationType;
import com.dominiksymonowicz.transportmanager.domain.stations.Stations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.dominiksymonowicz.transportmanager.domain.stations.Status.VISITED;

public class TestUtils {
    public static List<Station> getAllStationsAsNotVisited(){
        List<Station> stations = new ArrayList<>();

        for(StationName name : StationName.values()){
            if(StationType.isTubeType(name.getStationType())){
                stations.add(Station.notVisited(name.getStationName()));
            }
        }
        return stations;
    }

    public static Station testStation() {
        var today = LocalDate.now();
        return new Station("Test",VISITED,today,today,today);
    }

    public static Stations generateStations() {
        var stationList = List.of(Station.passed("Amersham", LocalDate.now().minusDays(1)),
                Station.passed("Bank", LocalDate.now().minusDays(2)),
                Station.notVisited("Chesham"),
                Station.notVisited("Debden"),
                Station.notVisited("Epping"),
                Station.notVisited("Finchley Road"),
                Station.visited("Great Portland Street", LocalDate.now().minusYears(2)),
                Station.visitedThisYear("Hammersmith", LocalDate.now().minusYears(1), LocalDate.now()),
                Station.visitedThisYear("Ickenham", LocalDate.now().minusYears(1), LocalDate.now()),
                Station.visitedThisYear("Kilburn", LocalDate.now().minusYears(1), LocalDate.now()));
        return new Stations(stationList);
    }
}
