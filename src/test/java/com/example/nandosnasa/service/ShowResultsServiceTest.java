package com.example.nandosnasa.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ShowResultsServiceTest {

    private ShowResultsService showResultsService;

    private String input1;
    private String result1;
    private String input2;
    private String result2;
    private String errInput;
    private String errResult;

    @Before
    public void setUp() throws Exception {
        showResultsService = new ShowResultsService();

        input1 = "5 5\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM";
        result1 = "1 3 N\n5 1 E\n";

        input2 = "5 5\n2 4 N\nLMMRM\n";
        result2 = "1 2 W\n";

        errInput = "5 5\n2 4 E\nMMMMM\n";
        errResult = "0 2 W\n";
    }

    @Test
    public void test_showResults_shouldReturnStringOf_results() throws Exception {
        String local_result1 = showResultsService.getResults(input1);
        assertThat(local_result1).isEqualTo(result1);

        String local_result2 = showResultsService.getResults(input2);
        assertThat(local_result2).isEqualTo(result2);

        String local_result3 = showResultsService.getResults(errInput);
        assertThat(local_result3).isEqualTo(errResult);


    }
}



