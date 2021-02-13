package com.algorithm.demo.string;

/**
 * 55. 比较字符串
 * 比较两个字符串A和B，确定A中是否包含B中所有的字符。字符串A和B中的字符都是 大写字母
 * <p>
 * 样例
 * 给出 A = "ABCD" B = "ACD"，返回 true
 * <p>
 * 给出 A = "ABCD" B = "AABC"， 返回 false
 * <p>
 * 注意事项
 * The characters of B in A are not necessary continuous or ordered.
 */
public class 比较字符串 {

    public static void main(String[] args) {
        String a = "ABCD";
        String b = "ACD";
        boolean value = compareStrings(a,b);
        System.out.println("  "+value);
    }

    /**
     * @param A: A string
     * @param B: A string
     * @return: if string A contains all of the characters in B return true else return false
     */
    public static boolean compareStrings(String A, String B) {
        // write your code here
        return false;
    }
}
