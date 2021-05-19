package com.example.nandosnasa.service;

import com.example.nandosnasa.util.IllegalDirectionException;
import com.example.nandosnasa.util.NoDirectionFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class RoverMovesTest {

    @Mock
    private RoverMovesService roverMovesService;

    @Before
    public void setUp() throws Exception {
        roverMovesService = new RoverMovesService();
    }

    @Test
    public void test_valid_roverMoves_shouldReturn_true() throws NoDirectionFoundException {
        assertThat(roverMovesService.isValid("LMLMLMLMM")).isTrue();
        assertThat(roverMovesService.isValid("RMRMRMM")).isTrue();
        assertThat(roverMovesService.isValid("RlMmLrM")).isTrue();
    }

//    @Test
//    public void test_invalid_roverMoves_shouldReturn_false() throws NoDirectionFoundException {
//        assertThat(roverMovesService.isValid("@LMM")).isFalse();
//        assertThat(roverMovesService.isValid("3M")).isFalse();
//        assertThat(roverMovesService.isValid("R9J")).isFalse();
//    }

    @Test
    public void test_whenNoMoves_sentToRover_should_throw_NoDirectionFoundException() {
        Throwable exception = assertThrows(NoDirectionFoundException.class, () -> {
            roverMovesService.isValid("");
        });
        assertEquals("No Moves Found", exception.getMessage());
    }

    @Test
    public void test_InvalidMove_should_throw_IllegalDirectionException() throws IllegalDirectionException {
        Throwable exception = assertThrows(IllegalDirectionException.class, () -> {
            roverMovesService.isValid("ZDP");
        });
        assertEquals("Illegal instruction", exception.getMessage());

        exception = assertThrows(IllegalDirectionException.class, () -> {
            roverMovesService.isValid("LMRy");
        });
        assertEquals("Illegal instruction", exception.getMessage());
    }

}