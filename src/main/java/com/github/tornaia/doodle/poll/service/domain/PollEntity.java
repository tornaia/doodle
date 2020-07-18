package com.github.tornaia.doodle.poll.service.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "POLL")
public class PollEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long initiator;

    @Column
    private String title;

    @Column
    private long initiated;

    @Column
    private long latestChange;

    public PollEntity() {
    }

    public PollEntity(long initiator, String title, long initiated, long latestChange) {
        this.initiator = initiator;
        this.title = title;
        this.initiated = initiated;
        this.latestChange = latestChange;
    }

    public long getId() {
        return id;
    }

    public long getInitiator() {
        return initiator;
    }

    public void setInitiator(long initiator) {
        this.initiator = initiator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getInitiated() {
        return initiated;
    }

    public void setInitiated(long initiated) {
        this.initiated = initiated;
    }

    public long getLatestChange() {
        return latestChange;
    }

    public void setLatestChange(long latestChange) {
        this.latestChange = latestChange;
    }
}