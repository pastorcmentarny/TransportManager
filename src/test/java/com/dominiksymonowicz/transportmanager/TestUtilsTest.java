package com.dominiksymonowicz.transportmanager;

import com.dominiksymonowicz.transportmanager.domain.stations.Station;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TestUtilsTest {

    @Test
    void getAllStationsAsNotVisitedAcceptanceTest() {
        // when
        final List<Station> result = TestUtils.getAllStationsAsNotVisited();

        // then
        assertThat(result.size()).isEqualTo(270);
    }
}