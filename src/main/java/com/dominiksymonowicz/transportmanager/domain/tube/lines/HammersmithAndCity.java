package com.dominiksymonowicz.transportmanager.domain.tube.lines;



import com.dominiksymonowicz.transportmanager.domain.stations.SharedStations;
import com.dominiksymonowicz.transportmanager.domain.stations.StationName;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Dominik Symonowicz
 * Created 08/06/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class HammersmithAndCity extends Line {


    @Override
    public List<StationName> getStations() {
        var stationList = new ArrayList<StationName>();
        stationList.addAll(SharedStations.addHammersmithToEdwareSection());
        stationList.addAll(SharedStations.addBakerStreetToLiverpoolStreet());
        stationList.addAll(SharedStations.addAldgateEastToBarking());
        return stationList;
    }
}
