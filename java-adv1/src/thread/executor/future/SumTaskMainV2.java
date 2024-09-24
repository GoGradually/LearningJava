package thread.executor.future;

import java.util.concurrent.*;

public class SumTaskMainV2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);

        FutureTask<Integer> result1 = new FutureTask<>(task1);
        FutureTask<Integer> result2 = new FutureTask<>(task2);
        new Thread(result1).start();
        new Thread(result2).start();
        System.out.println(result1.get() + result2.get());
    }

    static class SumTask implements Callable<Integer>{
        int startValue;
        int endValue;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public Integer call() throws Exception {
            Integer sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            return sum;
        }
    }
}
