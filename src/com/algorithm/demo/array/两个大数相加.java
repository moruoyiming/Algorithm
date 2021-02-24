package com.algorithm.demo.array;
import java.lang.Integer;
import java.lang.StringBuffer;
import java.lang.Math;
public class 两个大数相加 {


    public static void main(String[] args) {
               String numA = "5135156864146198510515713546981304";
        String numB = "14105283157813257031975091759832782750923";
        String what = addStrings(numA, numB);
        System.out.println(what);
        System.out.println(numB);
    }

    public static String addStrings(String numA, String numB) {
        char[] charsA = numA.toCharArray();
        char[] charsB = numB.toCharArray();
        int[] charsC = new int[Math.max(charsA.length, charsB.length)];
        int temp = 0;
        int pA = charsA.length - 1;
        int pB = charsB.length - 1;
        StringBuffer sb = new StringBuffer();
        int i = 0;
        for (i = charsC.length - 1; i >= 0; i--) {
            if (pA >= 0 && pB >= 0) {
                 charsC[i] = Integer.parseInt(numA.charAt(pA) + "") + Integer.parseInt(numB.charAt(pB) + "")+ temp;
                 if (charsC[i] >= 10) {
                    charsC[i] = charsC[i] - 10;
                    temp = 1;
                } else {
                    temp = 0;
                }
                System.out.println(" " + charsC[i] + "  charsA[pA] " + Integer.parseInt(numA.charAt(pA) + "")+ " charsB[pB] " + Integer.parseInt(numB.charAt(pB) + ""));
                sb.append(charsC[i]);
                pA--;
                pB--;
            } else {
                break;
            }

        }
        while (pA >= 0 && i >= 0) {
            System.out.println(" " + charsC[i] + "  charsA[pA] " + charsA[pA]);
            sb.append(charsA[pA]);
            pA--;
            i--;
        }
        while (pB >= 0 && i >= 0) {
            System.out.println(" " + charsC[i] + " charsB[pB] " + charsB[pB]);
            sb.append(charsB[pB]);
            pB--;
            i--;
        }
        return sb.reverse().toString();
    }
}
