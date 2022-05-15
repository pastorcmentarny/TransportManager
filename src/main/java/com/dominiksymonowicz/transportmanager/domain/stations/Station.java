package com.dominiksymonowicz.transportmanager.domain.stations;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Objects;

import static com.dominiksymonowicz.transportmanager.common.Utils.EMPTY_STRING;
import static com.dominiksymonowicz.transportmanager.domain.stations.Status.*;


@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@ToString
@EqualsAndHashCode
@Slf4j
public class Station {

    private String name;
    private Status status = UNKNOWN;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate passedDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate visitedDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate visitedThisYearDate;
    //LocalDateTime lastUpdatedOn;


    public static Station notVisited(String name) {
        return new Station(name, NOT_VISITED, null, null, null);
    }

    public static Station passed(String name, LocalDate passedDate) {
        return new Station(name, PASSED, passedDate, null, null);
    }

    public static Station noStation() {
        return new Station(EMPTY_STRING, Status.UNKNOWN, null, null, null);
    }

    public static Station visited(String stationName, LocalDate dateVisited) {
        return new Station(stationName, VISITED, dateVisited, dateVisited, null);
    }

    public static Station visitedThisYear(String stationName, LocalDate dateVisited, LocalDate visitedThisYearDate) {
        return new Station(stationName, VISITED, dateVisited, dateVisited, visitedThisYearDate);
    }


    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPassedDate(LocalDate date) {
        this.passedDate = date;
        setStatus(PASSED);
    }

    public void setPassedDateToNow() {
        passedDate = LocalDate.now();
    }

    public void setVisitedDateToNow() {
        status = VISITED;
        visitedDate = LocalDate.now();
    }

    public void setVisitedStationThisYearToNow() {
        visitedThisYearDate = LocalDate.now();
    }

    @JsonIgnore
    public String getStatusAsValue() {
        if (Objects.isNull(status)){
            return UNKNOWN.asName();
        }
        return status.value();
    }

    @JsonIgnore
    public boolean isNotAStation() {
        return Objects.isNull(name) || name.isEmpty() || status == UNKNOWN;
    }

    @JsonIgnore
    public boolean isPassedAlready() {
        return status != NOT_VISITED && status != UNKNOWN;
    }

    @JsonIgnore
    public boolean isInPassedStatus() {
        return status == PASSED;
    }

    @JsonIgnore
    public boolean isInVisitedStatus() {
        return status == VISITED;
    }

    @JsonIgnore
    public boolean isInVisitedThisYearStatus() {
        if (Objects.isNull(visitedThisYearDate)) {
            return false;
        }
        return isInVisitedStatus() && visitedThisYearDate.getYear() == LocalDate.now().getYear();
    }

    @JsonIgnore
    public boolean isVisitedThisYearAlready() {
        if (status != VISITED) {
            return false;
        } else if (Objects.isNull(visitedThisYearDate)) {
            return false;
        } else {
            return visitedThisYearDate.getYear() == LocalDate.now().getYear();
        }
    }

    @JsonIgnore
    public boolean isVisitedAlready() {
        return status == VISITED;
    }

    @JsonIgnore
    public void updateStationToVisited() {
        if (isVisitedThisYearAlready()) {
            return;
        }
        if (status == NOT_VISITED) {
            setPassedDateToNow();
        }

        setVisitedDateToNow();
        setVisitedStationThisYearToNow();
    }
}