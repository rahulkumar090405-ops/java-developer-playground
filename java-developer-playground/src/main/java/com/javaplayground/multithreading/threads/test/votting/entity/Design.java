package com.javaplayground.multithreading.threads.test.votting.entity;

import java.util.List;

public class Design {

    private int code;
    private String name;
    private List<Integer> votes = new java.util.ArrayList<>();

    public Design(int code, String name, List<Integer> votes) {
        this.code = code;
        this.name = name;
        this.votes = votes != null ? votes : new java.util.ArrayList<>();
    }
     public Design(int code, String name) {
        this.code = code;
        this.name = name;
        this.votes = new java.util.ArrayList<>();
    }

    // Getters and setters
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getVotes() {
        return votes;
    }

    public void setVotes(List<Integer> votes) {
        this.votes = votes;
    }
}
