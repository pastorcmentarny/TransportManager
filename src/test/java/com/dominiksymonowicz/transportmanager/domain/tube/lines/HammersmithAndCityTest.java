package com.dominiksymonowicz.transportmanager.domain.tube.lines;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 08/06/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class HammersmithAndCityTest {
    private final HammersmithAndCity line = new HammersmithAndCity();

    @Test
    public void getSizeShouldReturn29() {
        assertThat(line.getSize()).isEqualTo(29);
    }
}