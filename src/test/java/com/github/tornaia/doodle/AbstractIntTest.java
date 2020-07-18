package com.github.tornaia.doodle;

import com.github.tornaia.doodle.poll.PollRestController;
import com.github.tornaia.doodle.poll.service.PollRepository;
import com.github.tornaia.doodle.poll.service.domain.PollEntity;
import com.github.tornaia.doodle.user.service.UserRepository;
import com.github.tornaia.doodle.user.service.domain.UserEntity;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class AbstractIntTest {

    @Autowired
    protected PollRestController pollRestController;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PollRepository pollRepository;

    protected void createUser(String email, String name) {
        userRepository.save(new UserEntity(email, name));
    }

    protected void createPoll(String email, String title) {
        long userid = getUseridByEmail(email);
        long initiated = System.currentTimeMillis();
        pollRepository.save(new PollEntity(userid, title, initiated, initiated));
    }

    protected long getUseridByEmail(String email) {
        return userRepository
                .findAll()
                .stream()
                .filter(e -> e.getEmail().equals(email))
                .map(UserEntity::getId)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No user found for email: " + email));
    }
}
