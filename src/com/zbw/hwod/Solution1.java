package com.zbw.hwod;

import java.util.*;

/**
 * @program: interview
 * @package: com.zbw.hwod
 * @filename: Solution3.java
 * @create: 2021/07/20 12:59
 * @author: 29314
 * @description: .the first round hw interview
 **/

public class Solution1{
    public static void main(String[] args) {
        long i = 2147483646;
        long an = i + 2 << 30;
        System.out.println(an);
        System.out.println('A'-0);
    }

    public int titleToNumber(String columnTitle) {
        int an = 0;
        int step = 1;
        char[] chars = columnTitle.toCharArray();
        for(int i = chars.length-1; i >= 0; i--){
            an += (chars[i] - 64) * step;
            step *= 26;
        }
        return an;
    }

    public static void main1(String[] args){
        //Scanner sc = new Scanner(System.in);

        //String[] map = sc.nextLine().split(",");
        //String str = "1,0,1,0,0,0,1,0,1";
        //String str = "1,1,1,1,1,1,1,1,1";
        String str = "0,0,0,0,0,0,0,0,0";
        String[] map = str.split(",");
        boolean flag = true;
        for(int i = 0; i < map.length; i++){
            if("1".equals(map[i])){
                flag = false;
                break;
            }
        }
        if(flag){
            System.out.print(-1);
            return;
        }

        int[] book = new int[map.length];
        boolean[] mark = new boolean[map.length];
        int n = (int) Math.sqrt(map.length);
        Arrays.fill(book, -1);
        int max = 0;
        for(int i = 0; i < map.length; i++){
            if(book[i] != -1){
                max = Math.max(max, book[i]);
            }else{
                mark[i] = true;
                getDate(map, book, mark, i, n);
                mark[i] = false;
            }
        }
        System.out.print(max == 0 ? -1 : max);
    }

    public static int getDate(String[] map, int[] book, boolean[] mark, int i, int n){
        int date = Integer.MAX_VALUE;
        if("1".equals(map[i])){
            date = Math.min(0, date);
        }else{
            if(i - n >= 0 && !mark[i - n]){
                if("1".equals(map[i - n])){
                    date = Math.min(1, date);
                }else if(book[i - n] != -1){
                    date = Math.min(book[i - n] + 1, date);
                }else {
                    mark[i - n] = true;
                    date = Math.min(getDate(map, book, mark, i - n, n) + 1, date);
                    mark[i - n] = false;
                }
            }

            if(i + n < map.length && !mark[i + n]){
                if("1".equals(map[i + n])){
                    date = Math.min(1, date);
                }else if(book[i + n] != -1){
                    date = Math.min(book[i + n] + 1, date);
                }else {
                    mark[i + n] = true;
                    date = Math.min(getDate(map, book, mark, i + n, n) + 1, date);
                    mark[i + n] = false;
                }
            }


            if(i - 1 >= 0 && !mark[i - 1]){
                if("1".equals(map[i - 1])){
                    date = Math.min(1, date);
                }else if(book[i - 1] != -1){
                    date = Math.min(book[i - 1] + 1, date);
                }else {
                    mark[i - 1] = true;
                    date = Math.min(getDate(map, book, mark, i - 1, n) + 1, date);
                    mark[i - 1] = false;
                }
            }

            if(i + 1 < map.length && !mark[i + 1]){
                if("1".equals(map[i + 1])){
                    date = Math.min(1, date);
                }else if(book[i + 1] != -1){
                    date = Math.min(book[i + 1] + 1, date);
                }else {
                    mark[i + 1] = true;
                    date = Math.min(getDate(map, book, mark, i + 1, n) + 1, date);
                    mark[i + 1] = false;
                }
            }
        }

        book[i] = date;
        return date;
    }
}
