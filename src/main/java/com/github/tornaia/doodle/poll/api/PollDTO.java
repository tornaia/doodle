package com.github.tornaia.doodle.poll.api;

import java.util.List;

public class PollDTO {

    private final long id;
    private final String title;
    private final Initiator initiator;
    private final List<Option> options;

    public PollDTO(long id, String title, Initiator initiator, List<Option> options) {
        this.id = id;
        this.title = title;
        this.initiator = initiator;
        this.options = options;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Initiator getInitiator() {
        return initiator;
    }

    public List<Option> getOptions() {
        return options;
    }

    public static class Initiator {

        private final String email;
        private final String name;

        public Initiator(String email, String name) {
            this.email = email;
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public String getName() {
            return name;
        }
    }

    public static class Option {

        private final String text;

        public Option(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}
