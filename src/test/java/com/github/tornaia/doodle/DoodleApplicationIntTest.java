package com.github.tornaia.doodle;

import com.github.tornaia.doodle.poll.api.PollDTO;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DoodleApplicationIntTest extends AbstractIntTest {

    @Test
    public void listPollsByInitiatorWithoutPoll() {
        createUser("test@email.com", "John Doe");

        ResponseEntity<List<PollDTO>> response = pollRestController.listPollsByInitiator(getUseridByEmail("test@email.com"));
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().isEmpty());
    }
}
