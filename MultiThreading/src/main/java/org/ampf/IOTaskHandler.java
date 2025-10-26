package org.ampf;

public class IOTaskHandler {
    private static final int MAX_THREADS = 10;

    public static void main(String[] args) {

        for (int i = 0; i < MAX_THREADS; i++) {
            int j = i;
            Thread thread = Thread.ofPlatform().unstarted(() -> Task.ioIntensiveTask(j));
            thread.start();
        }
        System.out.println("Main thread is exiting");

    }
}
