package tw.ymeng.algorithm.proposition;

/*
* Euclid Algorithm - Greatest Common Factor
* */
public class GreatestCommonFactor {

    public static int gcd(int m, int n) {
        while (n != 0) {
            int rem = m % n;
            m = n;
            n = rem;
        }

        return m;
    }

    private GreatestCommonFactor() {
    }
}
