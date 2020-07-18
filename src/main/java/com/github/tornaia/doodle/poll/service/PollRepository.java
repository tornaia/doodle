package com.github.tornaia.doodle.poll.service;

import com.github.tornaia.doodle.poll.service.domain.PollEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PollRepository extends JpaRepository<PollEntity, Long> {
	
	List<PollEntity> findAllByInitiator(long initiator);

}
