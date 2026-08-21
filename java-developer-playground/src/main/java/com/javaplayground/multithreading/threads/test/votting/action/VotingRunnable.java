package com.javaplayground.multithreading.threads.test.votting.action;

import com.javaplayground.multithreading.threads.test.votting.entity.Design;

public class VotingRunnable implements Runnable {

private Design design;

protected boolean doStop = false; 

public VotingRunnable(Design design) {
    this.design = design;
}

    @Override
    public void run(){
        System.out.println("Voting started for the design "+design.getName());
        if (design.getVotes() == null) {
            design.setVotes(new java.util.ArrayList<>());
        }
        design.getVotes().add(1);
        System.out.println("Vote added for design " + design.getName() + ". Total votes: " + design.getVotes().size());
    }


}
