package com.algorithm.demo.剑指Offer;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0~n-1之内。在范围0~n-1内的n个数字中有且只有一个数字不在该数组中，
 * 请找出这个数字。
 * 解法1：先用公式n(n-1)/2求出数字0~n-1的所有数字之和，记为s1.接着求出数组中所有数字的和，记为s2。那个不在数组中的数字就是s1-s2的差。
 * 这种解法需要O(n)的时间求数组中所有数字的和。显然，该解法没有有效利用数组是递增排序的一个特点。
 *
 */
public class 零至n减1中缺失的数字 {
}
