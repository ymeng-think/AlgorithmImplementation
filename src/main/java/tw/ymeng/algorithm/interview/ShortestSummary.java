package tw.ymeng.algorithm.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * Question (From Amazon)
 *
 * 给定一段产品的英文描述，包含M个英文字母，每个英文单词以空格分隔，无其他标点符号；再给定N个英文单词关键字，请说明思路并编程实现方法
 * String extractSummary(String description,String[] key words)，目标是找出此产品描述中包含N个关键字（每个关键词至少出现一次）
 * 的长度最短的子串，作为产品简介输出。
 *
 * 这道笔试题和编程之美最短摘要生成的方法类似。
 *
 * 先来看看这些序列：
 * w0,w1,w2,w3,q0,w4,w5,q1,w6,w7,w8,q0,w9,q1
 * 问题在于，如何一次把所有的关键词都扫描到，并且不遗漏。扫描肯定是无法避免的，但是如何把两次扫描的结果联系起来呢？这是一个值得考虑的问题。
 * 沿用前面的扫描方法，再来看看。第一次扫描的时候，假设需要包含所有的关键词，从第一个位置w0处将扫描到w6处：
 * [w0,w1,w2,w3,q0,w4,w5,q1,w6,] w7,w8,q0,w9,q1
 * 那么，下次扫描应该怎么办呢？先把第一个被扫描的位置挪到q0处。
 * w0,w1,w2,w3, [q0,w4,w5,q1,w6,w7,w8,q0,w9,q1]
 * 然后把第一个被扫描的位置继续往后面移动一格，这样包含的序列中将减少了关键词q0。那么，我们便可以把第二个扫描位置往后移，这样就可以找到
 * 下一个包含所有关键词的序列。即从w4扫描到w9处，便包含了q1，q0：
 * w0,w1,w2,w3,q0, [w4,w5,q1,w6,w7,w8,q0,w9,] q1
 * 这样，问题就和第一次扫描时碰到的情况一样了。依次扫描下去，在w中找出所有包含q的序列，并且找出其中的最小值，就可得到最终的结果。
 */
public class ShortestSummary {

    private final String[] description;
    private final Map<String,Integer> keywordMap;
    private final int[] keywordHitRecorder;

    public ShortestSummary(String description, String[] keywords) {
        this.description = breakIntoArray(description);
        this.keywordMap = buildKeywordsMap(keywords);
        this.keywordHitRecorder = new int[keywords.length];
    }

    public String extract() {
        StringBuilder summary = new StringBuilder();

        int start = 0, end = 0;
        int summaryStart = 0, summaryEnd = 0;
        int targetLength = description.length + 1;

        while (true) {
            while(!hasIncludedAllKeywords() && end < description.length) {
                if (keywordMapContains(description[end])) {
                    hitKeyword(indexInKeywordMap(description[end]));
                }
                end++;
            }

            while(hasIncludedAllKeywords()) {
                if (end - start < targetLength) {
                    targetLength = end - start;
                    summaryStart = start;
                    summaryEnd = end - 1;
                }

                if (keywordMapContains(description[start])) {
                    removeHitKeyword(indexInKeywordMap(description[start]));
                }

                start++;
            }

            if (end >= description.length) {
                break;
            }

            appendToSummary(summary, summaryStart, summaryEnd);
        }

        return summary.toString();
    }

    private boolean keywordMapContains(String word) {
        return keywordMap.containsKey(ignoreCase(word));
    }

    private void appendToSummary(StringBuilder summary, int start, int end) {
        for (int i = start; i <= end; i++) {
            summary.append(description[i]);
            if (i < end) {
                summary.append(" ");
            }
        }
    }

    private int indexInKeywordMap(String word) {
        return keywordMap.get(ignoreCase(word));
    }

    private void hitKeyword(int index) {
        keywordHitRecorder[index]++;
    }

    private void removeHitKeyword(int index) {
        keywordHitRecorder[index]--;
    }

    private Map<String, Integer> buildKeywordsMap(String[] keywords) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < keywords.length; i++) {
            map.put(ignoreCase(keywords[i]), i);
        }

        return map;
    }

    private boolean hasIncludedAllKeywords() {
        for (int hitCount : keywordHitRecorder) {
            if (hitCount == 0) {
                return false;
            }
        }

        return true;
    }

    private static String ignoreCase(String word) {
        return word.toLowerCase();
    }

    private static String[] breakIntoArray(String text) {
        return text.split(" ");
    }
}
