package com.zbw.hwod;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: interview
 * @package: com.zbw.hwod
 * @filename: Solution5.java
 * @create: 2022/01/21 20:23
 * @author: 29314
 * @description: ..
 **/

public class Solution5 {

    /*
    给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。



示例 1：

输入：grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
输出 1
     */
    //an = 0;
    //public static int[][] dir = new int[][]{{-1, 0},{1, 0},{0, -1},{0 , 1}};

    public static void main(String[] args) {
        /*int[][] grid = new int[][]{{0,1,1,1,0},
                                    {1,1,0,1,0},
                                    {1,1,0,0,0},
                                    {0,0,0,1,0}};*/

        int[][] grid = new int[][]{{0,1,0,1}};

        System.out.println(getIlands(grid));
    }

    public static int getIlands(int[][] grid){
        int an = 0;
        boolean[][] book = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && !book[i][j]){
                    putColor(grid, book, i, j);
                    an++;
                }
            }
        }
        return an;
    }

    public static void putColor(int[][] grid, boolean[][] book, int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        int[][] dir = new int[][]{{-1, 0},{1, 0},{0, -1},{0 , 1}};
        queue.offer(new int[]{x, y});
        book[x][y] = true;
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            for(int i = 0; i < 4; i++){
                int m = node[0] + dir[i][0];
                int n = node[1] + dir[i][1];

                if(m >= 0 && m < grid.length && n >= 0 && n < grid[0].length && grid[m][n] == 1 && !book[m][n]) {
                    queue.offer(new int[]{m, n});
                    book[m][n] = true;
                }
            }
        }

    }
}
