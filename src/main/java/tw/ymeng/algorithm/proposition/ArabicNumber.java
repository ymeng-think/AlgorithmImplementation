package tw.ymeng.algorithm.proposition;

public class ArabicNumber {

    private static final String[] chineseDigits = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

    private int number;

    public ArabicNumber(int number) {
        this.number = number;
    }

    public String toChineseWord() {
        return chineseDigits[number];
    }
}
