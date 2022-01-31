package com.self.master.codestore;

public class CodeStoreUtility {

    public static String display(int[] arr) {
        int n = arr.length-1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            sb.append(arr[i]);
            if (i != n) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
