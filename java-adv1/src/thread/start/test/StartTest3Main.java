package thread.start.test;

import static util.MyLogger.log;

public class StartTest3Main {
    public static void main(String[] args) {
        Thread counter = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                log(i+1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "counter");
        counter.start();
    }

}
