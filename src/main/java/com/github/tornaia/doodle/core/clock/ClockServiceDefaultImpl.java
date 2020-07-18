package com.github.tornaia.doodle.core.clock;

import org.springframework.stereotype.Component;

@Component
public class ClockServiceDefaultImpl implements ClockService {

    @Override
    public long now() {
        return System.currentTimeMillis();
    }
}
