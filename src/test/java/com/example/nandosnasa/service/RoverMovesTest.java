package com.example.nandosnasa.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class RoverMovesTest {

    private RoverMovesService roverMovesService;


    @Before
    public void setUp() throws Exception {
        roverMovesService = new RoverMovesService();
    }

    @Test
    public void test_valid_roverMoves_shouldReturn_true() throws Exception {
        assertThat(roverMovesService.isValid("LMLMLMLMM")).isTrue();
        assertThat(roverMovesService.isValid("LMLMLMM")).isTrue();
        assertThat(roverMovesService.isValid("RLMMLRM")).isTrue();
    }

    @Test
    public void test_invalid_roverMoves_shouldReturn_false() throws Exception {
        assertThat(roverMovesService.isValid("@LMM")).isFalse();
        assertThat(roverMovesService.isValid("3M")).isFalse();
        assertThat(roverMovesService.isValid("R9J")).isFalse();
    }
}
