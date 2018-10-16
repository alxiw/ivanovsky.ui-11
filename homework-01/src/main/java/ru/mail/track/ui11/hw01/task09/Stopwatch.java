package ru.mail.track.ui11.hw01.task09;

import java.time.Duration;
import java.time.LocalTime;

import static java.lang.Thread.sleep;

public class Stopwatch implements Runnable {

    private long duration;

    public Stopwatch(long duration) {
        this.duration = duration;
    }

    @Override
    public void run() {
        LocalTime today = LocalTime.now();
        try {
            while (!Thread.currentThread().isInterrupted()) {
                sleep(duration);
                printTimeDuration(today);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception in secondary thread: " + e.getMessage());
        }
    }

    /*
     * Вывод данных о времени, прошедшем с запуска
     */
    private void printTimeDuration(LocalTime today) {
        Duration p = Duration.between(today, LocalTime.now());
        long hours = p.getSeconds() / (60*60);
        long minutes = p.getSeconds() / 60;
        long seconds = p.getSeconds() % 60;

        String h = (hours == 1) ? "час" : (hours >= 2 && hours <= 4) ? "час" : "часов";
        String m = (minutes == 1) ? "минута" : (minutes >= 2 && minutes <= 4) ? "минуты" : "минут";
        String s = (seconds == 1) ? "секунда" : (seconds >= 2 && seconds <= 4) ? "секунды" : "секунд";

        String string = "Прошло %d " + h + ", %d " + m + ", %d " + s;

        String line = String.format(string, hours , minutes , seconds);
        System.out.println(line);
    }
}
