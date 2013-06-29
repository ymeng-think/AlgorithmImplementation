package tw.ymeng.algorithm.proposition;

import java.math.BigInteger;

public final class MathEx {

    public static BigInteger pow(int x, int n) {
        if (n == 0) {
            return BigInteger.valueOf(1);
        }

        if (isEven(n)) {
            return pow(x * x, n / 2);
        } else {
            return pow(x * x, n / 2).multiply(BigInteger.valueOf(x));
        }
    }

    private static boolean isEven(int x) {
        return x % 2 == 0;
    }

    private MathEx() {
    }
}
