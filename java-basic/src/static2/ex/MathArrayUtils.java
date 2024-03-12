package static2.ex;

public class MathArrayUtils {
    static int sum(int[] array) {
        int ans = 0;
        for (int i : array) {
            ans += i;
        }
        return ans;
    }

    static double average(int[] array) {
        double ans = 0;
        for (int i : array) {
            ans += i;
        }
        ans /= (double) array.length;
        return ans;
    }

    static int min(int[] array) {
        int min = (int) 1e9;
        for (int i : array) {
            min = Math.min(min, i);
        }
        return min;
    }

    static int max(int[] array) {
        int max = (int) 1e9 * -1;
        for (int i : array) {
            max = Math.max(max, i);
        }
        return max;
    }

    MathArrayUtils() {
        System.out.println("객체 생성 불가");
    }
}
