package com.dominiksymonowicz.transportmanager.exceptions;

import com.dominiksymonowicz.transportmanager.domain.stations.Station;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.dominiksymonowicz.transportmanager.common.Utils.generateString;
import static org.junit.jupiter.api.Assertions.*;

class ValidationFailedExceptionTest {

    @Test // best test award
    public void shouldThrowSomethingWentWrongExceptionTest() {

        // expect
        Assertions.assertThrows(ValidationFailedException.class, () -> {
            throw new ValidationFailedException("test", Station.noStation());
        });

    }

}