package com.algorithm.demo.array;

/**
 * 28. 找出字符串中第一个匹配项的下标
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 */
public class Q74_找出字符串中第一个匹配项的下标 {

    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        for (int i = 0; i + n <= m; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    continue;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

}
