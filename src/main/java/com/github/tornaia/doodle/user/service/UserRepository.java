package com.github.tornaia.doodle.user.service;

import com.github.tornaia.doodle.user.service.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long {
}
