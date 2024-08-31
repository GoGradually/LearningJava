package thread.control;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStateMain {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable(), "myThread");
        log("myThread.state1 = " + thread.getState());
        log("myThread.start() start");
        thread.start();
        Thread.sleep(1000);
        log("myThread.state3 = " + thread.getState());
        Thread.sleep(4000);
        log("myThread.state5 = " + thread.getState());
        log("end");
    }

    static class MyRunnable implements Runnable{

        @Override
        public void run() {
            log("start");
            log("myThread.state2 = " + Thread.currentThread().getState());
            log("sleep() start");
            sleep(3000);
            log("sleep() end");
            log("myThread.state4 = " + Thread.currentThread().getState());
            log("end");
        }
    }
}
