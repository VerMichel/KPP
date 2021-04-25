package org.MyWebService.counter;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterDry {

    private static final AtomicInteger hitsCounter = new AtomicInteger();

    public static Integer get() {
        return hitsCounter.get();
    }

    public static void add() {
        hitsCounter.incrementAndGet();
    }
}