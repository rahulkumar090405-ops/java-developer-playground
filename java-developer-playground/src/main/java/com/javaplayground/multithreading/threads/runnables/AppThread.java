package com.javaplayground.multithreading.threads.runnables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppThread extends Thread {

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(new File("c:\\Users\\Yashika Verma\\Downloads\\java_developer_practice_syllabus.txt")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.err.println(Thread.currentThread().getName()+" Reading The Line "+line);
            }
        } catch (FileNotFoundException e) {
           Logger.getLogger(AppThread.class.getName()).log(Level.SEVERE,null,e);
        } catch (IOException ex) {
            System.getLogger(AppThread.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

}
