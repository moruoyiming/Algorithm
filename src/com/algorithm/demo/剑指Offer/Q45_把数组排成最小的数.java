package com.algorithm.demo.剑指Offer;

/**
 * 输入一个正证书数组，吧数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如：输入数组{3，32，321}，则打印出这3个数字能排成的最小数字321323。
 *
 *  3，5，7
 *  357
 *  375
 *  537
 *  573
 *  735
 *  753
 *  确定一个规则判断m和n哪个应该排在前面。
 *  两个数字m和n能拼接成数字mn和nm。如果mn<nm，打印mn,也就是m应该排在n的前面，定义此时m小于n；
 *  反之，如果nm<mn，则定义n小于m；如果mn=nm，则m等于n。
 *  接下来考虑如何拼接数字，即给出数字m和n，怎么得到数字mn和nm并比较他们的大小。需考虑m和n的取值范围。mn或nm用int型有可能溢出。
 *  3个条件
 *  自反性、对称性和传递性
 *  1:自反性：显然有aa=aa，所以a等于a。
 *  2:对称性：如果a小于b，则ab<ba，所以ba>ab,一次b大于a。
 *  3:传递性：如果a小于b，则ab<ba。假设a和b用十进制表示时分别有l位和m位，于是ab=a x 10^m + b,ba = b x 10^l + a。
 *
 */
public class Q45_把数组排成最小的数 {
}
