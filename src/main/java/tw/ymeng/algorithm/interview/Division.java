package tw.ymeng.algorithm.interview;

/**
 * 利用+，-，移位 来实现除法
 * */
public final class Division {

    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor should not be 0.");
        }

        int res = 0;
        while ((dividend -= divisor) >= 0)
            ++res;

        return res;
    }

    private Division() {
    }
}
