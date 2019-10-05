package com.shambu.a10pointer.Data;

public class Polls {

    public String pollHeading;
    public String pollStatus;
    public String pollOpt1;
    public String pollOpt2;

    public Polls() {
    }

    public Polls(String pollHeading, String pollStatus, String pollOpt1, String pollOpt2) {
        this.pollHeading = pollHeading;
        this.pollStatus = pollStatus;
        this.pollOpt1 = pollOpt1;
        this.pollOpt2 = pollOpt2;
    }

    public String getPollHeading() {
        return pollHeading;
    }

    public void setPollHeading(String pollHeading) {
        this.pollHeading = pollHeading;
    }

    public String getPollStatus() {
        return pollStatus;
    }

    public void setPollStatus(String pollStatus) {
        this.pollStatus = pollStatus;
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
