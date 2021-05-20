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

    @Before
    public void setUp() throws Exception {
        showResultsService = new ShowResultsService();

        input1 = "5 5\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM";
        result1 = "1 3 N\n5 1 E\n";
    }

    @Test
    public void test_showResults_shouldReturnStringOf_results() throws Exception {
        String result = showResultsService.getResults(input1);

        assertThat(result).isEqualTo(result1);


    }
}



