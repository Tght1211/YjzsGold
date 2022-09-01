package com.yjzs.gold.main;

public class Solution {

    public static int i = 0;

    public boolean isValid(String s) {
        if (s.length() < 2) {
            return false;
        }
        String[] arr = {"[]", "()", "{}"};
        for (; i < s.length(); i++) {
            for (int j = 0; j < 3; j++) {
                s = charBack(s, arr[j]);
            }
            if ("".equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static String charBack(String s, String str) {
        String s1 = str.substring(0, 1);
        String s2 = str.substring(1);

        if (s2.equals(s.charAt(i) + "")) {
            if (s1.equals(s.charAt(i - 1) + "")) {
                s = s.replace(str, "");
                i = 0;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        boolean valid = so.isValid("{[]}");
        System.out.println(valid);
    }
}

