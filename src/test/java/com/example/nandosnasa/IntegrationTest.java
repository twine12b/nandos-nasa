package com.example.nandosnasa;

import com.example.nandosnasa.entity.RoverDirection;
import com.example.nandosnasa.entity.RoverInstruction;
import com.example.nandosnasa.entity.RoverPos;
import com.example.nandosnasa.entity.RoverRoute;
import com.example.nandosnasa.service.RoverMovesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final List<RoverPos> roverPositions = new ArrayList<>();
    private RoverInstruction roverInstruction;
    private List<RoverRoute> roverRouteList;

    // Test moves - taken from code challenge
    private final String R1moves = "LMLMLMLMM";
    private final String R2moves = "MMRMMRMRRM";
    private RoverMovesService roverMovesService;

    public void setup() {
        roverPositions.add(new RoverPos(1, 2, RoverDirection.N));

        // Sets routes from start position to end location
        RoverRoute rover1 = new RoverRoute(new RoverPos(1, 2, RoverDirection.N), R1moves.toCharArray());
        RoverRoute rover2 = new RoverRoute(new RoverPos(3, 3, RoverDirection.E), R2moves.toCharArray());

        //Add routes to route-list
        roverRouteList.add(rover1);
        roverRouteList.add(rover2);

        //Add route to instructions
        roverInstruction = new RoverInstruction(5, 5, roverRouteList);
    }

    @Test
    public void test_roverPosition_shouldReturn_RoverPosition() throws Exception {
//        ResponseEntity<RoverPos> response = restTemplate.getForEntity("/nandos/nasa/move_rover", RoverPos.class);
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


}
