package tw.ymeng.algorithm.utils;

public final class StringEx {

    public static String join(String[] strings, String separator) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            text.append(strings[i]);
            if (i < strings.length - 1) {
                text.append(separator);
            }
        }

        return text.toString();
    }

    private StringEx() {
    }
}
