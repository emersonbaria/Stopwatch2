package au.edu.jcu.cp3406.stopwatch2;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class StopwatchTest {
    @Test
    public void testTicker() {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.tick();
        assertEquals("00:00:01", stopwatch.toString());

        for (int i = 0; i < 59; ++i) {
            stopwatch.tick();
        }
        assertEquals("00:01:00", stopwatch.toString());

        for (int i = 0; i < 59 * 60; ++i) {
            stopwatch.tick();
        }
        assertEquals("01:00:00", stopwatch.toString());
    }
}
