package com.example.nandosnasa;

import com.example.nandosnasa.entity.RoverDirection;
import com.example.nandosnasa.entity.RoverPos;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    private final List<RoverPos> roverPositions = new ArrayList<>();

    public void setup() {
        roverPositions.add(new RoverPos(1, 2, RoverDirection.N));
    }

    @Test
    public void test_roverPosition_shouldReturn_RoverPosition() throws Exception {
    }


}
