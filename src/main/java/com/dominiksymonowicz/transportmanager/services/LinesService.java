package com.dominiksymonowicz.transportmanager.services;

import com.dominiksymonowicz.transportmanager.common.Utils;
import com.dominiksymonowicz.transportmanager.domain.DataResponse;
import com.dominiksymonowicz.transportmanager.domain.tube.lines.Line;
import com.dominiksymonowicz.transportmanager.domain.tube.lines.Lines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@Service
public class LinesService {

    public List<String> getAllTubeLinesName() {
        return Lines.getLines().stream().map(Line::name).collect(toList());
    }

    public String getLineStatistics(String lineName) {
        return Utils.EMPTY_STRING;
    }

    public DataResponse getLineInformationFor(String lineName) {
        return DataResponse.error("Not implemented yet");
    }
}
