package com.zbw.hwod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: intelligenthome_exhibition
 * @package: New
 * @filename: Main.java
 * @create: 2021/07/22 20:33
 * @author: 29314
 * @description: .the second round hw interview
 **/

public class Solution2 {

    public static void main(String[] args) {
        int[] num = {-1, 2, 1, -4, 4, 5, -3, 7};
        //System.out.println(2<<1);
        System.out.println(divide(2147483647 ,2));


        //int[] num = {-1, 2, 1, -4, 4, 5, -3, 7};
        //int target = 3;
        //int clorest = threeSumClosest(num, target);

        //System.out.println(clorest);
    }

    public static int divide(int dividend, int divisor) {
        if(dividend == 0){
            return 0;
        }

        if(divisor == 1){
            return dividend;
        }

        if(divisor == -1){
            long an = dividend;
            int i = -an > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) -an;
            return i;
        }

        boolean book = true;
        if(dividend < 0 != divisor < 0){
            book = false;
        }
        long an = 0;
        int step = 0;
        long sum = 0;
        while(true){
            long temp = 0;
            if(book){
                temp = sum + ((long)divisor<<step);
            }else{
                temp = sum - ((long)divisor<<step);
            }

            if((dividend > 0 && temp > dividend) || (dividend < 0 && dividend > temp)){
                if(step == 0){
                    break;
                }
                step--;
                continue;
            }

            an += 1<<step;
            step++;
            sum = temp;
        }
        int i = an > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) an;

        return book ? i : -i;
    }

    public static int threeSumClosest(int[] num, int target){
        if(num.length <= 3){
            int sum = 0;
            for(int n:num){
                sum += n;
            }
            return sum;
        }

        int closest = num[0] + num[1] + num[2];
        int indexA = 0;
        int indexB = 1;
        int indexC = 2;
        for(int i = 3; i < num.length; i++){
            int sumA = closest - num[indexA] + num[i];
            int sumB = closest - num[indexB] + num[i];
            int sumC = closest - num[indexC] + num[i];

            if(Math.abs(closest - target) > Math.abs(sumA -target)){
                indexA = i;
                closest = sumA;
            }else if(Math.abs(closest - target) > Math.abs(sumB -target)){
                    indexB = i;
                closest = sumB;
            }else if(Math.abs(closest - target) > Math.abs(sumC -target)){
                indexC = i;
                closest = sumC;
            }
        }
        return closest;
    }
    /*
    获取数组中三个数和最接近target的质并返回
     */
    public static int threeSumClosest1(int[] num, int target){
        if(num.length <= 3){
            int sum = 0;
            for(int n:num){
                sum += n;
            }
            return sum;
        }

        int closest = num[0] + num[1] + num[2];
        for(int i = 0; i < num.length; i++){
            int temp = twoSumCloser(getNewArr(num,i), target, num[i]);
            if(Math.abs(temp + num[i] - target) > Math.abs(temp + num[i] - target)){
                System.out.println(closest);
                closest = temp + num[i];
            }
        }

        return closest;
    }

    public static int twoSumCloser(int[] num, int target, int start){
        int closest = num[0] + num[1];
        for(int i = 0; i < num.length; i++){
            int temp = getCloser(getNewArr(num,i), target, num[i]);
            if(Math.abs(temp + num[i] + start- target) > Math.abs(temp + num[i] + start - target)){
                System.out.println(closest);
                closest = temp + num[i] + start;
            }
        }

        return closest;
    }

    public static int getCloser(int[] num, int target, int start){
        int closest = num[0];
        for(int i = 1; i < num.length; i++){
            if(Math.abs(closest + start- target) > Math.abs(num[i] + start - target)){
                closest = num[i] + start;
            }
        }

        return closest;
    }

    public static int[] getNewArr(int[] arr, int index){
        int[] newArr = new int[arr.length - 1];

        for(int i = 0, j = 0; i < arr.length; i++){
            if(i != index){
                newArr[j++] = arr[i];
            }
        }

        return newArr;
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        combinationSum(candidates, target, 0, lists, new ArrayList<>());
        return lists;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target, int index, List<List<Integer>> lists, List<Integer> list)   {

        if(0 == target){
            lists.add(list);
            return lists;
        }

        if(0 > target){
            list.clear();
            list = null;
            return lists;
        }

        if(list.size() >= 150){
            list.clear();
            list = null;
            return lists;
        }

        if(index >= candidates.length){
            list.clear();
            list = null;
            return lists;
        }

        List copy = new ArrayList<Integer>();

        list.forEach((v) -> {copy.add(v);});
        list.add(candidates[index]);
        combinationSum(candidates, target - candidates[index], index, lists, list);
        combinationSum(candidates, target, index++ , lists, copy);

        return lists;
    }
}
