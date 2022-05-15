package com.dominiksymonowicz.transportmanager.validators;

import com.dominiksymonowicz.transportmanager.exceptions.SomethingWentWrongException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.dominiksymonowicz.transportmanager.common.Utils.printArray;
import static org.assertj.core.api.Assertions.assertThat;

class StationLineValidatorTest {

    @Test
    public void validateAcceptanceTest() {
        // when
        final var result = StationLineValidator.validate("Amersham;;V;;2021-04-25;;2021-04-25;;2021-04-25");

        // debug
        printArray(result);

        // then
        assertThat(result[0]).isEqualTo("Amersham");
        assertThat(result[1]).isEqualTo("V");
        assertThat(result[2]).isEqualTo("2021-04-25");
        assertThat(result[3]).isEqualTo("2021-04-25");
        assertThat(result[4]).isEqualTo("2021-04-25");
    }

    @Test
    public void validateThrowsExceptiomIfStationLineIsNull() {
        // expect
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StationLineValidator.validate(null);
        });
    }

    @Test
    public void validateThrowsExceptiomIfNumberOfColumnIsIncorrect() {
        // expect
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StationLineValidator.validate("Amersham;;V;;2021-04-25;;2021-04-25;;2021-04-25;;WHOOPS");
        });
    }

    //TODO all tests
}

