package com.github.tornaia.doodle;

import com.github.tornaia.doodle.poll.api.PollDTO;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DoodleApplicationIntTest extends AbstractIntTest {

    @Test
    public void listPollsByInitiatorWithoutPoll() {
        createUser("test0@email.com", "John Doe");

        ResponseEntity<List<PollDTO>> response = pollRestController.listPollsByInitiator(getUseridByEmail("test0@email.com"));
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().isEmpty());
    }

    @Test
    public void listPollsByInitiatorWithOnePoll() {
        createUser("test1@email.com", "John Doe");
        createPoll("test1@email.com", "Poll Title");

        ResponseEntity<List<PollDTO>> response = pollRestController.listPollsByInitiator(getUseridByEmail("test1@email.com"));
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertThat(response.getBody(), Matchers.hasSize(1));
    }

    @Test
    public void listPollsByInitiatorWithTwoPolls() {
        createUser("test2@email.com", "John Doe");
        createPoll("test2@email.com", "Poll Title");
        createPoll("test2@email.com", "Poll Title2");

        ResponseEntity<List<PollDTO>> response = pollRestController.listPollsByInitiator(getUseridByEmail("test2@email.com"));
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertThat(response.getBody(), Matchers.hasSize(2));
    }
}
