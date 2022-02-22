package com.zbw.hwod;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: interview
 * @package: com.zbw.hwod
 * @filename: Solution.java
 * @create: 2022/01/20 20:05
 * @author: 29314
 * @description: ..
 **/

public class Solution {
    public static void main(String[] args) {

        System.out.println(checkVolited("{[]}"));
    }
    public static boolean checkVolited(String str){
        Deque<Character> queue = new LinkedList<Character>();

        for(char c: str.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                queue.push(c);
            }
            if(queue.isEmpty()){
                queue.push(c);
                continue;
            }
            if(c == ')' || c == ']' || c == '}' ){
                queue.pop();
            }
        }

        return queue.isEmpty();
    }
}
/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。

示例 1：
输入：s = "()"
输出：true

示例 2：
输入：s = "()[]{}"
输出：true

示例 3：
输入：s = "(]"
输出：false

示例 4：
输入：s = "([)]"
输出：false

示例 5：
输入：s = "{[]}"
输出：true
 */
