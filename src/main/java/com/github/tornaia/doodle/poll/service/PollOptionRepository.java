package com.github.tornaia.doodle.poll.service;

import com.github.tornaia.doodle.poll.service.domain.PollOptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PollOptionRepository extends JpaRepository<PollOptionEntity, Long> {

    List<PollOptionEntity> findAllByPollId(long pollId);
}
