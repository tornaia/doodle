package com.github.tornaia.doodle.poll;

import com.github.tornaia.doodle.poll.api.ListPollsByTitleRestRequest;
import com.github.tornaia.doodle.poll.api.PollDTO;
import com.github.tornaia.doodle.poll.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/poll/v1")
public class PollRestController {

    private final PollService pollService;

    @Autowired
    public PollRestController(PollService pollService) {
        this.pollService = pollService;
    }

    @GetMapping("/list/initiator/{userid}")
    public ResponseEntity<List<PollDTO>> listPollsByInitiator(@PathVariable("userid") long userid) {
        List<PollDTO> result = pollService.listPollsByInitiator(userid);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/list/title")
    public ResponseEntity<List<PollDTO>> listPollsByTitle(@RequestBody ListPollsByTitleRestRequest request) {
        List<PollDTO> result = pollService.listPollsByTitle(request.getText());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/list/initiated/{timestamp}")
    public ResponseEntity<List<PollDTO>> listPollsByInitiatedGreaterThan(@PathVariable long timestamp) {
        List<PollDTO> result = pollService.listPollsByInitiatedGreaterThan(timestamp);
        return ResponseEntity.ok(result);
    }
}
