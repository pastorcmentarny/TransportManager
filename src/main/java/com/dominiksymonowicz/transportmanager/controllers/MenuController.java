package com.dominiksymonowicz.transportmanager.controllers;

import com.dominiksymonowicz.transportmanager.domain.DataResponse;
import com.dominiksymonowicz.transportmanager.domain.Response;
import com.dominiksymonowicz.transportmanager.services.LinesService;
import com.dominiksymonowicz.transportmanager.services.StationsService;
import com.dominiksymonowicz.transportmanager.services.TubeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Slf4j
@Controller
public class MenuController {

    private final TubeService tubeService;
    private final LinesService linesService;

    private final StationsService stationService;

    public MenuController(TubeService tubeService, LinesService linesService, StationsService stationService) {
        this.tubeService = tubeService;
        this.linesService = linesService;
        this.stationService = stationService;
    }

    @GetMapping("/")
    public String greeting() {
        return "menu";
    }

    @GetMapping("/tube/statistics")
    public String displayStatistics(Model model) {
        log.info("Get request to get tube statistics.");
        final DataResponse response = tubeService.getStatistics();
        log.info("Got response " + response.getResult());
        model.addAttribute("status", response.getResult());
        model.addAttribute("description", response.getDescription());
        model.addAttribute("data", response.getData());
        return "statistics";
    }

    @GetMapping("/tube/all-lines-name")
    public String displayAllLines(Model model) {
        model.addAttribute("lines", linesService.getAllTubeLinesName());
        return "lines-name";
    }

    @GetMapping(value = "/tube/line/{lineName}")
    public String displayLineInformationFor(Model model, @PathVariable String lineName) {
        final DataResponse response = linesService.getLineInformationFor(lineName);
        model.addAttribute("status", response.getResult());
        model.addAttribute("description", response.getDescription());
        model.addAttribute("data", response.getData());
        return "line";
    }


    @GetMapping("/tube/all-stations-name")
    public String displayAllStationsInformation(Model model) {
        log.info("Getting all lines names");
        model.addAttribute("stations", tubeService.getAllStationNames());
        return "stations-name";
    }

    @GetMapping(value = "/tube/station/{stationName}")
    public String displayStationsInformationFor(Model model, @PathVariable String stationName) {
        final Response response = tubeService.getStationFor(stationName);
        System.out.println(response);
        model.addAttribute("status", response.getResult());
        model.addAttribute("description", response.getDescription());
        model.addAttribute("station", response.getStation());
        return "station";
    }

    @GetMapping(value = "/tube/set-passed/{stationName}")
    public String setPassedFor(Model model, @PathVariable String stationName) {
        log.info("Get request to set " + stationName + " station to passed if haven't been passed before.");
        final Response response = tubeService.setToPassedStatus(stationName);
        model.addAttribute("status", response.getResult());
        model.addAttribute("description", response.getDescription());
        model.addAttribute("station", response.getStation());
        log.info("Returning response for request " + stationName + " with " + response.getDescription());
        return "station";
    }

    @GetMapping(value = "/tube/set-visited/{stationName}")
    public String setVisitedFor(Model model, @PathVariable String stationName) {
        log.info("Get request to set " + stationName + " to visited if haven't been visited before.");
        final Response response = tubeService.setToVisitedStatus(stationName);
        model.addAttribute("status", response.getResult());
        model.addAttribute("description", response.getDescription());
        model.addAttribute("station", response.getStation());
        log.info("Returning response for request to set " + stationName + " visited with " + response.getResult());
        return "station";
    }


}



