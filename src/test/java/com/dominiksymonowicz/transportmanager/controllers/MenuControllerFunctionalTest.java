package com.dominiksymonowicz.transportmanager.controllers;

import com.dominiksymonowicz.transportmanager.AbstractFunctionalTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;


class MenuControllerFunctionalTest extends AbstractFunctionalTest {
    @Autowired
    private MenuController menuController;

    @Test
    public void shouldWiredStationController() {
        // test if controller is set up
        assertThat(menuController).isNotNull();
    }
}