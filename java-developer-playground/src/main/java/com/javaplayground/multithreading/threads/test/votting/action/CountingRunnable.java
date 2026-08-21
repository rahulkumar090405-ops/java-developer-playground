package com.javaplayground.multithreading.threads.test.votting.action;

import com.javaplayground.multithreading.threads.test.votting.entity.Design;

public class CountingRunnable implements Runnable {

    private Design design;
    protected boolean doStop = false;

    public CountingRunnable(Design design) {
        this.design = design;
    }

    @Override
    public void run() {
        if (design.getVotes() == null) {
            System.out.println("Votes list is null for the design " + design.getName());
            return;
        }
        System.out.println("Design " + design.getName() + " has total votes " + design.getVotes().size());
    }   

}
