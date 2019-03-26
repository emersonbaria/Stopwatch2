package au.edu.jcu.cp3406.stopwatch2;

import java.util.logging.Handler;

public class Stopwatch {
    private int seconds,hours,minutes,secs;
    private String time;

    public Stopwatch() {
    }

    public void tick() {
        ++seconds;
        hours=seconds/3600;
        minutes=(seconds%3600)/60;
        secs=seconds%60;
    }

    public String toString() {
        time=String.format("%02d:%02d:%02d", hours, minutes, secs);
        return time;
    }

    public void reset() {
        seconds=0;

    }
}
