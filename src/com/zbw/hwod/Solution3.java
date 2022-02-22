package com.zbw.hwod;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @program: interview
 * @package: com.zbw.hwod
 * @filename: Solution3.java
 * @create: 2021/07/31 12:59
 * @author: 29314
 * @description: .the third round hw interview
 **/

public class Solution3 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> list = new ArrayList<>();

        addToList(list, root, 0, 0);

        list.sort((int[] a, int[] b) -> {
            if(a[0] - b[0] != 0) {
                return a[0] - b[0];
            }else if(a[1] - b[1] != 0){
                return a[1] - b[1];
            }else {
                return a[2] - b[2];
            }
        });

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int in = list.get(0)[0];
        for(int[] v: list){
            if(v[0] == in){
                temp.add(v[3]);
            }else {
                lists.add(temp);
                temp = new ArrayList<>();
                temp.add(v[3]);
            }
        }
        lists.add(temp);
        return lists;
    }

    public void addToList(List<int[]> list, TreeNode node, int x, int y){
        list.add(new int[]{x, y, node.val});
        addToList(list, node.left, x + 1, y - 1);
        addToList(list, node.left, x + 1, y + 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
