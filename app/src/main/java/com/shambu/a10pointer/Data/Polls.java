package com.shambu.a10pointer.Data;

public class Polls {
    private String pollHeading, activeStatus, pollOpt1, pollOpt2;

    public Polls() {
    }

    public Polls(String poll_heading, String active_status, String poll_opt_1, String poll_opt_2) {
        this.pollHeading = poll_heading;
        this.activeStatus = active_status;
        this.pollOpt1 = poll_opt_1;
        this.pollOpt2 = poll_opt_2;
    }

    public String getPollHeading() {
        return pollHeading;
    }

    public void setPollHeading(String pollHeading) {
        this.pollHeading = pollHeading;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    public String getPollOpt1() {
        return pollOpt1;
    }

    public void setPollOpt1(String pollOpt1) {
        this.pollOpt1 = pollOpt1;
    }

    public String getPollOpt2() {
        return pollOpt2;
    }

    public void setPollOpt2(String pollOpt2) {
        this.pollOpt2 = pollOpt2;
    }
}
