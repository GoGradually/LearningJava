package thread.start.test;

import static util.MyLogger.log;

public class StartTest2Main {
    public static void main(String[] args) {
        Runnable counterRunnable = new CounterRunnable();
        Thread counter = new Thread(counterRunnable, "counter");
        counter.start();
    }

    static class CounterRunnable implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                log(i+1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
