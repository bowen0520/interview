package com.zbw.hwod;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: interview
 * @package: com.zbw.hwod
 * @filename: Solution10.java
 * @create: 2022/02/14 20:38
 * @author: 29314
 * @description: ..
 **/

public class Solution10 {
    /*
    给定R*W的矩阵，元素为0或1，计算其中连通区域的个数。
连通区域定义为：若某个元素为1，则其上下左右四个方向若有1 ，则定义为一个连通区域
例如：
1 1 1 0
0 1 0 1
1 1 1 0
0 0 0 1 有三个连通区域
     */
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,1,1,0},
                {0,1,0,1},
                {1,1,1,0},
                {0,0,0,1}
        };
        Arrays.fill(new int[5], Integer.MAX_VALUE);
        /* 上下左右
        idx                deq
        1,1               0,1  2,1
        2,1               0,1 2,0 2,2
        2,2                 0,1 2,0
         */
        System.out.println(checkAreas(grid));
    }

    public static int checkAreas(int[][] grid){
        int an = 0;
        boolean[][] mark = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!mark[i][j] && grid[i][j] == 1){
                    putColor(grid,mark,i,j);
                    an++;
                }
            }
        }
        return an;
    }
    public static void putColor(int[][] grid, boolean[][] mark, int x, int y){
        int[][] dir = new int[][]{{1,0},{-1, 0},{0, 1},{0, -1}};
        Queue<int[]> que = new LinkedList();
        que.offer(new int[]{x, y});
        mark[x][y] = true;
        while(!que.isEmpty()){
            int[] node = que.poll();
            for(int i = 0; i < dir.length; i++){
                int newX = node[0] + dir[i][0];
                int newY = node[1] + dir[i][1];
                if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 1 && !mark[newX][newY]){
                    que.offer(new int[]{newX, newY});
                    mark[newX][newY] = true;
                }
            }
        }
    }

}
