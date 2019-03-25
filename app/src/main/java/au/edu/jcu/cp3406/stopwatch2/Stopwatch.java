package au.edu.jcu.cp3406.stopwatch2;

public class Stopwatch {
    int seconds,hours,minutes,secs;

    String time;

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
