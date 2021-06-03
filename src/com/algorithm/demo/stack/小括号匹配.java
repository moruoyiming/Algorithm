package com.algorithm.demo.stack;

public class 小括号匹配 {

    public static void main(String[] args) {
        boolean result = matchParentheses("()");
        System.out.println("result=" + result);
    }

    /**
     * @param string: A string
     * @return: whether the string is a valid parentheses
     */
    public static boolean matchParentheses(String string) {
        int matched = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                matched++;
            }
            if (string.charAt(i) == ')') {
                matched--;
            }
            if (matched < 0) {
                return false;
            }
        }
        return matched == 0;
    }
}
