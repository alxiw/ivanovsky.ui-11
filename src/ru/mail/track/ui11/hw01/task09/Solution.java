package ru.mail.track.ui11.hw01.task09;

import java.time.Duration;
import java.time.LocalTime;

import static java.lang.Thread.sleep;

public class Solution {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            LocalTime startTime = LocalTime.now();
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    sleep(2000);
                    Duration duration = Duration.between(startTime, LocalTime.now());
                    System.out.println(duration.getSeconds() + " seconds passed");
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception in secondary thread: " + e.getMessage());
            }
        });
        thread.start();
        try {
            while (!Thread.currentThread().isInterrupted()) {
                sleep(10000);
                System.out.println("Welcome to the Machine!");
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception in main thread: " + e.getMessage());
        }
    }

}
