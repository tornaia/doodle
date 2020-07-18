package com.github.tornaia.doodle.poll.service;

import com.github.tornaia.doodle.poll.api.PollDTO;
import com.github.tornaia.doodle.poll.api.PollDTO.Initiator;
import com.github.tornaia.doodle.poll.api.PollDTO.Option;
import com.github.tornaia.doodle.poll.service.domain.PollEntity;
import com.github.tornaia.doodle.poll.service.domain.PollOptionEntity;
import com.github.tornaia.doodle.user.service.UserRepository;
import com.github.tornaia.doodle.user.service.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PollService {

    private final PollRepository pollRepository;
    private final PollOptionRepository pollOptionRepository;
    private final UserRepository userRepository;

    @Autowired
    public PollService(PollRepository pollRepository, PollOptionRepository pollOptionRepository, UserRepository userRepository) {
        this.pollRepository = pollRepository;
        this.pollOptionRepository = pollOptionRepository;
        this.userRepository = userRepository;
    }

    public List<PollDTO> listPollsByInitiator(long userid) {
        List<PollEntity> polls = pollRepository.findAllByInitiator(userid);
        return polls
                .stream()
                .map(this::convertToPollDTO)
                .collect(Collectors.toList());
    }

    private PollDTO convertToPollDTO(PollEntity pollEntity) {
        UserEntity user = userRepository.findById(pollEntity.getInitiator()).orElseThrow();
        long id = pollEntity.getId();
        List<PollOptionEntity> pollOptions = pollOptionRepository.findAllByPollId(id);

        String title = pollEntity.getTitle();
        Initiator initiator = new Initiator(user.getEmail(), user.getName());
        List<Option> options = pollOptions
                .stream()
                .map(e -> new Option(e.getText()))
                .collect(Collectors.toList());
        return new PollDTO(id, title, initiator, options);
    }
}
