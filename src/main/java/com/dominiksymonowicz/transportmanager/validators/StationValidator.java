package com.dominiksymonowicz.transportmanager.validators;

import com.dominiksymonowicz.transportmanager.common.Utils;
import com.dominiksymonowicz.transportmanager.domain.stations.Station;
import com.dominiksymonowicz.transportmanager.domain.stations.Status;
import com.dominiksymonowicz.transportmanager.exceptions.SomethingWentWrongException;
import com.dominiksymonowicz.transportmanager.exceptions.ValidationFailedException;

import java.util.Objects;

import static com.dominiksymonowicz.transportmanager.domain.stations.Station.noStation;

public class StationValidator {

    public void validate(Station station){
        if(Objects.isNull(station)){
            throw new ValidationFailedException("Station is null", noStation());
        }

        if(Objects.isNull(station.getName())){
            throw new ValidationFailedException("Station name is null", noStation());
        }

        if(Objects.isNull(station.getStatus())){
            throw new ValidationFailedException("Station status is null", noStation());
        }

        if(station.getStatus() == Status.NOT_VISITED){
            if(Utils.isAnyOfPropertiesContainsNull(station.getPassedDate(),station.getVisitedDate(),station.getVisitedThisYearDate())){
                throw new ValidationFailedException("%s has status %s but it has passed,visited and/or visitedThisDate date".formatted(station.getName(),station.getStatus().asName()),station);
            }
        }

        if(station.getStatus() == Status.PASSED) {
            if(Objects.isNull(station.getPassedDate()) || (Objects.nonNull(station.getVisitedDate()) || Objects.nonNull(station.getVisitedThisYearDate()))){
                throw new ValidationFailedException("%s has status %s but it has visited and/or visitedThisDate date (and/or passing date is missing)".formatted(station.getName(),station.getStatus().asName()),station);
            }
        }

        if(station.getStatus() == Status.VISITED) {
            if(Objects.isNull(station.getPassedDate()) || Objects.isNull(station.getVisitedDate())){
                throw new ValidationFailedException("%s has status %s but passed and/or visited date is missing)".formatted(station.getName(),station.getStatus().asName()),station);
            }
        }
    }
}
