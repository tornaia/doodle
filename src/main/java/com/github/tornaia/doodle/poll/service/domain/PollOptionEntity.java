package com.github.tornaia.doodle.poll.service.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "POLL_OPTION")
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"POLL_ID", "TEXT"})
})
public class PollOptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "POLL_ID")
    private long pollId;

    @Column(name = "TEXT")
    private String text;

    public PollOptionEntity() {
    }

    public PollOptionEntity(long pollId, String text) {
        this.pollId = pollId;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public long getPollId() {
        return pollId;
    }

    public void setPollId(long pollId) {
        this.pollId = pollId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}