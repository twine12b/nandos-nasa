/**
 * @Author Richard Renaud
 * <p>
 * ** NOTE **
 * - The 'input' text for testing needs to have a 'NEW LINE' (\n) at the end of the string.
 * - The 'input' is NOT case sensitive.
 * - Exceptions are thrown to indicate errors
 * - Navigation is not performed if an error is detected.
 * - Assume more that 1 rover can occupy same co-ordinate
 */
package com.example.nandosnasa.service;

import com.example.nandosnasa.util.exception.ILLegalPositionException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class ShowResultsServiceTest {

    private ShowResultsService showResultsService;

    private String input1;
    private String result1;
    private String input2;
    private String result2;
    private String input3;
    private String result3;
    private String input4;
    private String result4;
    private String errInput;
    private String errResult;
    private String errInput2;
    private String errResult2;

    @Before
    public void setUp() throws Exception {
        showResultsService = new ShowResultsService();

        input1 = "5 5\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM";
        result1 = "1 3 N\n5 1 E\n";

        input2 = "5 5\n2 4 W\nLMMRM\n";
        result2 = "1 2 W\n";

        input3 = "8 5\n7 4 S\nLM\n2 2 N\nMRMLmM\n";
        result3 = "8 4 E\n3 5 N\n";

        input4 = "8 5\n7 4 S\nLM\n2 2 N\nMRMLmM\n2 4 W\nLRRRMMMM\n";
        result4 = "8 4 E\n3 5 N\n6 4 E\n";

        errInput = "5 5\n2 4 W\nLRRRMMMM\n";
        errResult = "1 2 N\n";

        errInput2 = "5 5\n2 2 S\nMmMMM\n";
        errResult2 = "1 2 N\n";
    }

    @Test
    public void test_showResults_shouldReturnStringOf_results() throws Exception {
        String local_result1 = showResultsService.getResults(input1);
        assertThat(local_result1).isEqualTo(result1);

        String local_result2 = showResultsService.getResults(input2);
        assertThat(local_result2).isEqualTo(result2);

        String local_result3 = showResultsService.getResults(input3);
        assertThat(local_result3).isEqualTo(result3);

        String local_result4 = showResultsService.getResults(input4);
        assertThat(local_result4).isEqualTo(result4);

    }

    @Test
    public void test_position_of_rover_withinBoundaries_of_plateau_throw_IllegalPositionException()
            throws ILLegalPositionException {

        Throwable exception = assertThrows(ILLegalPositionException.class, () -> {
            showResultsService.getResults(errInput);
        });
        assertEquals("Rover (x)cord out of bounds", exception.getMessage());

        Throwable exception2 = assertThrows(ILLegalPositionException.class, () -> {
            showResultsService.getResults(errInput2);
        });
        assertEquals("Illegal start position", exception2.getMessage());

    }
}



