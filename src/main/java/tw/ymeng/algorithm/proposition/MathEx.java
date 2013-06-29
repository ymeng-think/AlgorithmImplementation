package tw.ymeng.algorithm.proposition;

public final class MathEx {

    public static long pow(long x, int n) {
        if (n == 0) {
            return 1;
        }

        if (isEven(n)) {
            return pow(x * x, n / 2);
        } else {
            return pow(x * x, n / 2) * x;
        }
    }

    private static boolean isEven(int x) {
        return x % 2 == 0;
    }

    private MathEx() {
    }
}
