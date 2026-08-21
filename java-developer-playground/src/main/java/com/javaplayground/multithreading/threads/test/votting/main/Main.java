package com.javaplayground.multithreading.threads.test.votting.main;

import com.javaplayground.multithreading.threads.test.votting.action.CountingRunnable;
import com.javaplayground.multithreading.threads.test.votting.action.VotingRunnable;
import com.javaplayground.multithreading.threads.test.votting.entity.Design;

public class Main {

    public static void main(String[] args) {

    // 1.0 Create the design object
    Design design1 = new Design(1,"D1");

    // 1.2 Object of VotingRunnable and CountingRunnable
    VotingRunnable votingRunnableD1 = new VotingRunnable(design1);
    CountingRunnable countingRunnableD1 = new CountingRunnable(design1);

    // 1.3.0 Thread object of VotingRunnable and CountingRunnable
    Thread votingD1 = new Thread(votingRunnableD1);
    Thread countingD1 = new Thread(countingRunnableD1);

    // 1.4.0 Start the voting thread  for the design 1 & the counting thread for the design 1
    votingD1.start();
    countingD1.start();

    // 1.0 Create the design object
    Design design2 = new Design(2,"D2");

    // 1.2 Object of VotingRunnable and CountingRunnable
    VotingRunnable votingRunnableD2 = new VotingRunnable(design2);
    CountingRunnable countingRunnableD2 = new CountingRunnable(design2);

    // 1.3.0 Thread object of VotingRunnable and CountingRunnable
    Thread votingD2 = new Thread(votingRunnableD2);
    Thread countingD2 = new Thread(countingRunnableD2);

    // 1.4.0 Start the voting thread  for the design 2 & the counting thread for the design 2
    votingD2.start();
    countingD2.start();


    // 1.0 Create the design object
    Design design3 = new Design(3,"D3");

    // 1.2 Object of VotingRunnable and CountingRunnable
    VotingRunnable votingRunnableD3 = new VotingRunnable(design3);
    CountingRunnable countingRunnableD3 = new CountingRunnable(design3);

    // 1.3.0 Thread object of VotingRunnable and CountingRunnable
    Thread votingD3 = new Thread(votingRunnableD3);
    Thread countingD3 = new Thread(countingRunnableD3);

    // 1.4.0 Start the voting thread  for the design 3 & the counting thread for the design 3
    votingD3.start();
    countingD3.start();
    
    }
}
