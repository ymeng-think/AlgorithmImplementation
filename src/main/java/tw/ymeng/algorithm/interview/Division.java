package tw.ymeng.algorithm.interview;

/**
 * 利用+，-，移位 来实现除法
 * */
public final class Division {

    public static int divide1(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor should not be 0.");
        }

        int res = 0;
        while ((dividend -= divisor) >= 0)
            ++res;

        return res;
    }

    /**
     * divide1 算法每次都以一倍的divisor进行叠加，算法效率并不高，可以改进。
     *
     * 以 100/3 为例。
     * 算法分别比较97, 94, 91, ..., 4,1, -2，最后dividend = -2退出while循环。算法比较了34次。
     * 如果采用每次采用将比较数翻倍的比较方法，算法会得到优化。举例如下：k初始化为0，res = 0；
     * 首先用3与100比，小于； 然后翻倍6，小于； 12, 24, 48, 96, 192， 因为192 > 100，退回到 96。 这里共比较了5次。
     * 每比较一次 k++, res += 1<<k。
     * 100 - 96 = 4 > 除数3。再用4重做上一步。先跟3比较，然后6，6 > 4。这次比较2次。
     * 回到3。4 - 3 = 1 < 除数3，算法停止。总共比较了5 + 2 + 1 = 8次，比原来的34次快了很多。
     * */
    public static int divide2(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor should not be 0.");
        }

        if (dividend < divisor) {
            return 0;
        }

        int k = 0, c = divisor;

        for (; dividend >= c; c <<= 1, k++)
            if (dividend - c < divisor)
                return 1 << k;

        return divide1(dividend - (c >> 1), divisor) + (1 << (k - 1));
    }

    /**
     * divide2 的非递归算法
     * */
    public static int divide2I(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor should not be 0.");
        }

        if (dividend < divisor) {
            return 0;
        }

        int res = 0;
        while (dividend > divisor) {
            int k, c;
            for (k = 0, c = divisor; dividend >= c; c <<= 1, k++) {
                if (dividend - c < divisor) {
                    res += 1 << k;
                    break;
                }
            }
            if (dividend - c < divisor) {
                break;
            }

            res += 1 << (k - 1);
            dividend -= c >> 1;
        }

        return res;
    }

    private Division() {
    }
}
