package com.github.tornaia.doodle.poll;

import com.github.tornaia.doodle.poll.api.PollDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/poll/v1")
public class PollRestController {

    @GetMapping("/list/initiator/{userid}")
    public ResponseEntity<List<PollDTO>> listPollsByInitiator(@PathVariable("userid") long userid) {
        throw new IllegalStateException("Not implemented yet");
    }

    @GetMapping("/list/title")
    public ResponseEntity<List<PollDTO>> listPollsByTitle(@RequestParam String text) {
        throw new IllegalStateException("Not implemented yet");
    }

    @GetMapping("/list/initiated/{timestamp}")
    public ResponseEntity<List<PollDTO>> listPollsByInitiatedGreaterThan(@PathVariable long timestamp) {
        throw new IllegalStateException("Not implemented yet");
    }
}
